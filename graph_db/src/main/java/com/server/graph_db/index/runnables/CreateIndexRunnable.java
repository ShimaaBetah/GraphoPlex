package com.server.graph_db.index.runnables;

import org.springframework.beans.factory.annotation.Autowired;

import com.server.graph_db.grpc.clients.SecondaryIndexClient;
import com.server.graph_db.index.LocalSecondaryIndexManager;
import com.server.graph_db.partition.PartitionManager;

public class CreateIndexRunnable implements Runnable{
    String indexName;
    int serverId;

    
    private SecondaryIndexClient secondaryIndexClient;

    
    private PartitionManager partitionManager;

    
    private LocalSecondaryIndexManager localSecondaryIndexManager;

    public CreateIndexRunnable(String indexName, int serverId, SecondaryIndexClient secondaryIndexClient, PartitionManager partitionManager, LocalSecondaryIndexManager localSecondaryIndexManager) {
        this.indexName = indexName;
        this.serverId = serverId;
        this.secondaryIndexClient = secondaryIndexClient;
        this.partitionManager = partitionManager;
        this.localSecondaryIndexManager = localSecondaryIndexManager;
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
