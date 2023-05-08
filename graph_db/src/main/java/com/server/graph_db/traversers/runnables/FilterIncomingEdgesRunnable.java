package com.server.graph_db.traversers.runnables;

import java.util.List;

import com.server.graph_db.grpc.clients.TraverserClient;
import com.server.graph_db.partition.PartitionManager;
import com.server.graph_db.traversers.LocalTraversalManager;
import com.server.graph_db.traversers.bindings.EdgeBinding;
import com.server.graph_db.vertex.EdgeId;

public class FilterIncomingEdgesRunnable extends TraverserRunnable implements Runnable {

    Iterable<String> verticesIds;
    EdgeBinding edgeBinding;
    List<EdgeId> resultSet;

    public FilterIncomingEdgesRunnable (Iterable<String> verticesIds, EdgeBinding edgeBinding, int serverId, List<EdgeId> resultSet, PartitionManager partitionManager, LocalTraversalManager localTraversalManager, TraverserClient traverserClient) {
        super(serverId, partitionManager, localTraversalManager, traverserClient);
        this.verticesIds = verticesIds;
        this.edgeBinding = edgeBinding;
        this.resultSet = resultSet;
    }
    
    @Override
    public void run() {
        if(serverId == partitionManager.getServerId()){
            try {
                resultSet.addAll((List<EdgeId>) localTraversalManager.filterIncomingEdges(verticesIds, edgeBinding));
            } catch (Exception e) {
                resultSet = null;
            }
        }
        else{
            try {
                resultSet.addAll((List<EdgeId>) traverserClient.filterIncomingEdges(verticesIds, edgeBinding,String.valueOf(serverId)));
            } catch (Exception e) {
                resultSet = null;
            }
        }
    }

    
    
}
