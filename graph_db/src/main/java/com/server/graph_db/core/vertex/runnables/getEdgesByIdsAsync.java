package com.server.graph_db.core.vertex.runnables;

import java.util.List;

import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.EdgeId;
import com.server.graph_db.core.vertex.LocalVertexService;
import com.server.graph_db.grpc.clients.VertexClient;

public class getEdgesByIdsAsync implements Runnable {

    private LocalVertexService vertexService;
    private Iterable<EdgeId> edgeIds;
    private String serverId;
    private VertexClient vertexClient;
    private List<Edge> edges;
    private int partitionId;
    
    public getEdgesByIdsAsync(LocalVertexService vertexService, Iterable<EdgeId> edgeIds, String serverId,
    VertexClient vertexClient,
    List<Edge> edges, int partitionId) {
        this.edgeIds = edgeIds;
        this.serverId = serverId;
        this.vertexClient = vertexClient;
        this.edges = edges;
        this.partitionId = partitionId;
        this.vertexService = vertexService;

    }

    @Override
    public void run() {
        if (partitionId != Integer.parseInt(serverId)) {
            // send to the right partition
            Iterable<Edge> edgesFromOtherServer ;
            try {
                edgesFromOtherServer = vertexClient.getEdgesById(edgeIds,
                        String.valueOf(partitionId));
                        // append to edges
                        for (Edge edge : edgesFromOtherServer) {
                            edges.add(edge);
                        }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            // get from my server
            Iterable<Edge> edgesFromMyServer = vertexService.getEdgesById(edgeIds);
            // append to edges
            for (Edge edge : edgesFromMyServer) {
                edges.add(edge);
            }
        }
    }

}
