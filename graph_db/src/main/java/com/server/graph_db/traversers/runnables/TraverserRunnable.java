package com.server.graph_db.traversers.runnables;

import com.server.graph_db.grpc.clients.TraverserClient;
import com.server.graph_db.partition.PartitionManager;
import com.server.graph_db.traversers.LocalTraversalManager;

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
