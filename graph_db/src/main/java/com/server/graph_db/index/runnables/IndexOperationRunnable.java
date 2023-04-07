package com.server.graph_db.index.runnables;

import com.server.graph_db.grpc.clients.SecondaryIndexClient;
import com.server.graph_db.index.LocalSecondaryIndexManager;
import com.server.graph_db.partition.PartitionManager;

public abstract class IndexOperationRunnable  {
    
    int serverId;

    
    SecondaryIndexClient secondaryIndexClient;

    
    PartitionManager partitionManager;

    
    LocalSecondaryIndexManager localSecondaryIndexManager;

    public IndexOperationRunnable(int serverId, SecondaryIndexClient secondaryIndexClient, PartitionManager partitionManager, LocalSecondaryIndexManager localSecondaryIndexManager) {
        this.serverId = serverId;
        this.secondaryIndexClient = secondaryIndexClient;
        this.partitionManager = partitionManager;
        this.localSecondaryIndexManager = localSecondaryIndexManager;
    }

    public IndexOperationRunnable() {
    }
}
