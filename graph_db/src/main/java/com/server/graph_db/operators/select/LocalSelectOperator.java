package com.server.graph_db.operators.select;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.datastore.redis.RedisIndexDataManager;
import com.server.graph_db.vertex.LocalVertexService;
import com.server.graph_db.vertex.Vertex;

@Component
public class LocalSelectOperator {
    String fieldName;
    String fieldValue;

    @Autowired
    private RedisIndexDataManager redisIndexDataManager;

    @Autowired
    private LocalVertexService vertexService;

    public LocalSelectOperator(RedisIndexDataManager redisIndexDataManager,
            LocalVertexService vertexService) {

        this.redisIndexDataManager = redisIndexDataManager;
        this.vertexService = vertexService;
    }

    public void build (String fieldName, String fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

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
}
