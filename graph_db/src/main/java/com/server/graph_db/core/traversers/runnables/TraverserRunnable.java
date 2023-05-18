package com.server.graph_db.core.traversers.runnables;

import com.server.graph_db.core.partition.PartitionManager;
import com.server.graph_db.core.traversers.LocalTraversalManager;
import com.server.graph_db.grpc.clients.TraverserClient;

public class TraverserRunnable {

    int serverId;
    PartitionManager partitionManager;
    LocalTraversalManager localTraversalManager;
    TraverserClient traverserClient;

    public TraverserRunnable(int serverId, PartitionManager partitionManager, LocalTraversalManager localTraversalManager, TraverserClient traverserClient) {
        this.serverId = serverId;
        this.partitionManager = partitionManager;
        this.localTraversalManager = localTraversalManager;
        this.traverserClient = traverserClient;
    }
    
}
