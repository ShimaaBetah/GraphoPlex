package com.server.graph_db.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.grpc.clients.SecondaryIndexClient;
import com.server.graph_db.index.runnables.CreateIndexRunnable;
import com.server.graph_db.partition.PartitionManager;

@Component
public class GlobalSecondaryIndexManager implements SecondaryIndexManager {
    
    @Autowired
    private LocalSecondaryIndexManager localSecondaryIndexManager;

    @Autowired
    private PartitionManager partitionManager;

    @Autowired
    private SecondaryIndexClient secondaryIndexClient;



    

    

    @Override
    public void createIndex(String indexName) {

        Thread [] threads = new Thread[partitionManager.getNumberOfServers()];

        for(int i = 0; i < partitionManager.getNumberOfServers(); i++) {
           threads[i] = new Thread(new CreateIndexRunnable(indexName, i,secondaryIndexClient,partitionManager, localSecondaryIndexManager ));
           threads[i].start();
        }

        for(int i = 0; i < partitionManager.getNumberOfServers(); i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

    @Override
    public void deleteIndex(String indexName) {
        localSecondaryIndexManager.deleteIndex(indexName);
    }

    @Override
    public void createIndices(Iterable<String> indexNames) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createIndices'");
    }

    @Override
    public void deleteIndices(Iterable<String> indexNames) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteIndices'");
    }


}
