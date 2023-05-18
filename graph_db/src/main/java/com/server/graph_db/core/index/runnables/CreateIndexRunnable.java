package com.server.graph_db.core.index.runnables;


import com.server.graph_db.core.index.LocalSecondaryIndexManager;
import com.server.graph_db.core.partition.PartitionManager;
import com.server.graph_db.grpc.clients.SecondaryIndexClient;

public class CreateIndexRunnable extends IndexOperationRunnable implements Runnable{
    String indexName;

    public CreateIndexRunnable(String indexName, int serverId, SecondaryIndexClient secondaryIndexClient, PartitionManager partitionManager, LocalSecondaryIndexManager localSecondaryIndexManager) {
        super(serverId, secondaryIndexClient, partitionManager, localSecondaryIndexManager);
        this.indexName = indexName;
    }


    @Override
    public void run() {
        if(serverId == partitionManager.getServerId()) {
            localSecondaryIndexManager.createIndex(indexName);
        }
        else{
        secondaryIndexClient.createIndex(indexName, String.valueOf(serverId));
        }
    }
    
}
