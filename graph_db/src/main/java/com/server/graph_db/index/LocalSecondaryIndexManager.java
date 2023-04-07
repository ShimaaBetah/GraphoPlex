package com.server.graph_db.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.datastore.redis.RedisIndexDataManager;
import com.server.graph_db.vertex.LocalVertexService;
import com.server.graph_db.vertex.Vertex;
import com.server.graph_db.vertex.VertexRepositoryImpl;

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



}
