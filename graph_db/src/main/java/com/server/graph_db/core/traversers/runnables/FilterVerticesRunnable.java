package com.server.graph_db.core.traversers.runnables;

import java.util.List;

import com.server.graph_db.core.partition.PartitionManager;
import com.server.graph_db.core.traversers.LocalTraversalManager;
import com.server.graph_db.core.traversers.bindings.VertexBinding;
import com.server.graph_db.grpc.clients.TraverserClient;

public class FilterVerticesRunnable extends TraverserRunnable implements Runnable {
    List<String> resultSet;
    VertexBinding vertexBinding;
    Iterable<String> verticesToFilter;

    public FilterVerticesRunnable(VertexBinding vertexBinding, int serverId, Iterable<String> verticesToFilter,List<String> resultSet, PartitionManager partitionManager, LocalTraversalManager localTraversalManager, TraverserClient traverserClient) {
        super(serverId, partitionManager, localTraversalManager, traverserClient);
        this.vertexBinding = vertexBinding;
        this.verticesToFilter = verticesToFilter;
        this.resultSet = resultSet;
    }

    @Override
    public void run() {
        if(serverId == partitionManager.getServerId()){
            try {
                resultSet.addAll((List<String>) localTraversalManager.filterVertices(verticesToFilter, vertexBinding));
            } catch (Exception e) {
                resultSet = null;
            }
        }
        else{
            try {
                resultSet.addAll((List<String>) traverserClient.filterVertices(verticesToFilter, vertexBinding,String.valueOf(serverId)));
            } catch (Exception e) {
                resultSet = null;
            }
        }

    }
    
}
