package com.server.graph_db.core.operators.select;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.core.traversers.bindings.VertexBinding;
import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.LocalVertexService;
import com.server.graph_db.core.vertex.Vertex;
import com.server.graph_db.datastore.redis.RedisIndexDataManager;


public class EqualSelectOperator extends SelectOperator{
    


    


    private RedisIndexDataManager redisIndexDataManager;

    
    private LocalVertexService vertexService;

    public EqualSelectOperator(String fieldName, String fieldValue, RedisIndexDataManager redisIndexDataManager,
            LocalVertexService vertexService) {

        super(fieldName, fieldValue);
        this.redisIndexDataManager = redisIndexDataManager;
        this.vertexService = vertexService;
    }

    public void build (String fieldName, String fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }


   // return the ids of the vertices that have the property with the given name and value
   public Iterable<String> execute() {

      if(redisIndexDataManager.isIndexExist(fieldName)) {
          return redisIndexDataManager.getVerticesIdsFromIndex(fieldName, fieldValue);
      }

      //get from the all vertices
      List<String> verticesIds = new ArrayList<>();
      Iterable<Vertex> vertices = vertexService.getAllVertices();
      for (Vertex vertex : vertices) {
          if(vertex.isPropertyExist(fieldName) && vertex.getProperty(fieldName).equals(fieldValue)) {
              verticesIds.add(vertex.getId());
          }
      }

        return verticesIds;
        
    }

    
    // return the vertices that have the property with the given name and value
    public Iterable<Vertex> executeWithVertices() {
        if(redisIndexDataManager.isIndexExist(fieldName)) {
            return vertexService.getVerticesByIds(redisIndexDataManager.getVerticesIdsFromIndex(fieldName, fieldValue));
        }
        //get from the all vertices
        List<Vertex> vertices = new ArrayList<>();
        Iterable<Vertex> allVertices = vertexService.getAllVertices();
        for (Vertex vertex : allVertices) {
            if(vertex.isPropertyExist(fieldName) && vertex.getProperty(fieldName).equals(fieldValue)) {
                vertices.add(vertex);
            }
        }

        return vertices;  
    }

    @Override
    public Iterable<String> filterVertices(Iterable<String> verticesIds) throws Exception {

        if(redisIndexDataManager.isIndexExist(fieldName)) {
            List<String> intersection = new ArrayList<>();
            for (String vertexId : verticesIds) {
                if(redisIndexDataManager.isIndexContainsVertex(fieldName, fieldValue, vertexId)) {
                    intersection.add(vertexId);
                }
            }
            return intersection;
        }

        //otherwise get from the all vertices
        List<String> answer = new ArrayList<>();
        Iterable<Vertex> vertices = vertexService.getVerticesByIds(verticesIds);
        for (Vertex vertex : vertices) {
            if(vertex.isPropertyExist(fieldName) && vertex.getProperty(fieldName).equals(fieldValue)) {
                answer.add(vertex.getId());
            }
        }

        return answer;
        
    }

    @Override
    public String getOperator() {
        return "=";
    }

    @Override
    public boolean isVertexValid(Vertex vertex) {
        if(vertex.isPropertyExist(fieldName) && vertex.getProperty(fieldName).equals(fieldValue)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEdgeValid(Edge edge) {
        if(edge.isPropertyExist(fieldName) && edge.getProperty(fieldName).equals(fieldValue)) {
            return true;
        }
        return false;
    }

    
    

    
}
