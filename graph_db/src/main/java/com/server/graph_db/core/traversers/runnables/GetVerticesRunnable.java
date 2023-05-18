package com.server.graph_db.core.traversers.runnables;

import java.util.List;

import com.server.graph_db.core.partition.PartitionManager;
import com.server.graph_db.core.traversers.LocalTraversalManager;
import com.server.graph_db.core.traversers.bindings.VertexBinding;
import com.server.graph_db.grpc.clients.TraverserClient;

public class GetVerticesRunnable extends TraverserRunnable implements Runnable {

    VertexBinding vertexBinding;
    List<String> resultSet;

    public GetVerticesRunnable(VertexBinding vertexBinding , int serverId, List<String> resultSet,PartitionManager partitionManager, LocalTraversalManager localTraversalManager, TraverserClient traverserClient) {
        super(serverId, partitionManager, localTraversalManager, traverserClient);
        this.vertexBinding = vertexBinding;
        this.resultSet = resultSet;
    }


    @Override
    public void run()  {



        if(serverId == partitionManager.getServerId()){
            try {
                resultSet.addAll( (List<String>) localTraversalManager.getVertices(vertexBinding));
            } catch (Exception e) {
                resultSet = null;
            }
        }
        else{
            try {
                resultSet.addAll((List<String>) traverserClient.getVertices(vertexBinding, String.valueOf(serverId)));
            } catch (Exception e) {
                resultSet = null;
            }
        }
        
    }
    
}
