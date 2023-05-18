package com.server.graph_db.core.index;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.core.vertex.Vertex;
import com.server.graph_db.core.vertex.VertexRepositoryImpl;
import com.server.graph_db.datastore.redis.RedisIndexDataManager;

@Component
public class LocalSecondaryIndexManager implements SecondaryIndexManager {
    @Autowired
    private RedisIndexDataManager indexDataManager;

    @Autowired
    private VertexRepositoryImpl vertexRepository;


    //should make sure that the index is not already created
    public void createIndex(String indexName) {
        if(indexDataManager.isIndexExist(indexName)) {
            return;
        }
        indexDataManager.createIndex(indexName);
        //loop on all local vertices and add them to the index
        Iterable<Vertex> vertices = vertexRepository.findAll();
        for (Vertex vertex : vertices) {
            if(vertex.isPropertyExist(indexName)) {
                indexDataManager.addVertexToIndex(indexName, vertex.getProperty(indexName), vertex.getId());
            }
        }
    }

    public void deleteIndex (String indexName) {
         if(!indexDataManager.isIndexExist(indexName)) {
            return;
        } 
        indexDataManager.deleteIndex(indexName);
    }

    public void createIndices(Iterable<String> indexNames) {
        Iterable<Vertex> vertices = vertexRepository.findAll();

        //filter indixNames by existance
        indexNames = indexDataManager.filterNotExistingIndices(indexNames);
        for (String indexName : indexNames) {
            indexDataManager.createIndex(indexName);
            //loop on all local vertices and add them to the index
            for (Vertex vertex : vertices) {
                if(vertex.isPropertyExist(indexName)) {
                    indexDataManager.addVertexToIndex(indexName, vertex.getId(), vertex.getProperty(indexName));
                }
            }
        }
    }

    public void deleteIndices(Iterable<String> indexNames) {
        for (String indexName : indexNames) {
            deleteIndex(indexName);
        }
    }

    public void addVertexToIndices(Vertex vertex) {
        //add to default label index
        indexDataManager.addVertexToIndex("label", vertex.getLabel(), vertex.getId());
        Iterable<String> indices = indexDataManager.getAllIndices();
        for (String index : indices) {
            if(vertex.isPropertyExist(index)) {
                indexDataManager.addVertexToIndex(index, vertex.getProperty(index), vertex.getId());
            }
        }
    }

    public void deleteVertexFromIndices(Vertex vertex) {
        Iterable<String> indices = indexDataManager.getAllIndices();
        for (String index : indices) {
            if(vertex.isPropertyExist(index)) {
                indexDataManager.removeVertexFromIndex(index, vertex.getProperty(index), vertex.getId());
            }
        }
    }

    public void updateVertexInIndices(Vertex vertex, Map<String, String> properties) {
        Iterable<String> indices = indexDataManager.getAllIndices();
        for (String index : indices) {
            if(vertex.isPropertyExist(index)) {
                indexDataManager.removeVertexFromIndex(index, vertex.getProperty(index), vertex.getId());
            }
        }
        for (String index : indices) {
            if(properties.containsKey(index)) {
                indexDataManager.addVertexToIndex(index, properties.get(index), vertex.getId());
            }
        }
    }



}
