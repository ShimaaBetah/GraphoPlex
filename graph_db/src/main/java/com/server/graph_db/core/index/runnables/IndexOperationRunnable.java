package com.server.graph_db.core.index.runnables;

import com.server.graph_db.core.index.LocalSecondaryIndexManager;
import com.server.graph_db.core.partition.PartitionManager;
import com.server.graph_db.grpc.clients.SecondaryIndexClient;

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
