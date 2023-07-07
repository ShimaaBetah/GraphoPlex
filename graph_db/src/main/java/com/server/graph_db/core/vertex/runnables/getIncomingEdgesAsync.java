package com.server.graph_db.core.vertex.runnables;

import java.util.List;

import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.LocalVertexService;
import com.server.graph_db.grpc.clients.VertexClient;

public class getIncomingEdgesAsync implements Runnable {
    LocalVertexService vertexService;
    Iterable<String> verticesIds;
    String serverId;
    VertexClient vertexClient;
    List<Edge> edges;
    int partitionId;

    public getIncomingEdgesAsync(LocalVertexService vertexService, Iterable<String> verticesIds, String serverId,
            VertexClient vertexClient, List<Edge> edges, int partitionId) {
        this.verticesIds = verticesIds;
        this.serverId = serverId;
        this.vertexClient = vertexClient;
        this.edges = edges;
        this.partitionId = partitionId;
        this.vertexService = vertexService;

    }

    @Override
    public void run() {
        if (partitionId == Integer.parseInt(serverId)) {
            Iterable<Edge> edgesFromMyServer;
            try {
                edgesFromMyServer = vertexService.getIncomingEdges(verticesIds);

                for (Edge edge : edgesFromMyServer) {
                    edges.add(edge);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            Iterable<Edge> edgesFromOtherServer = vertexClient.getIncomingEdges(verticesIds,
                    String.valueOf(partitionId));
            for (Edge edge : edgesFromOtherServer) {
                edges.add(edge);
            }
        }
    }

}
