package com.server.graph_db.core.index.runnables;

import com.server.graph_db.core.index.LocalSecondaryIndexManager;
import com.server.graph_db.core.partition.PartitionManager;
import com.server.graph_db.grpc.clients.SecondaryIndexClient;

public class DeleteIndexRunnable extends IndexOperationRunnable implements Runnable {
    String indexNameString;

    public DeleteIndexRunnable(String indexNameString, int serverId, SecondaryIndexClient secondaryIndexClient, PartitionManager partitionManager, LocalSecondaryIndexManager localSecondaryIndexManager) {
        super(serverId, secondaryIndexClient, partitionManager, localSecondaryIndexManager);
        this.indexNameString = indexNameString;
    }

    @Override
    public void run() {
        if(serverId == partitionManager.getServerId()) {
            localSecondaryIndexManager.deleteIndex(indexNameString);
        }
        else{
        secondaryIndexClient.deleteIndex(indexNameString, String.valueOf(serverId));
        }
    }
}
