package com.server.graph_db.core.vertex.runnables;

import java.util.List;

import com.server.graph_db.core.vertex.LocalVertexService;
import com.server.graph_db.core.vertex.Vertex;
import com.server.graph_db.grpc.clients.VertexClient;

public class getVerticesByIdsAsync implements Runnable {

    private LocalVertexService vertexService;
    private Iterable<String> verticesIds;
    private String serverId;
    private VertexClient vertexClient;
    private List<Vertex> vertices;
    private int partitionId;
    
    public getVerticesByIdsAsync(LocalVertexService vertexService, Iterable<String> verticesIds, String serverId,
    VertexClient vertexClient,
    List<Vertex> vertices, int partitionId) {
        this.verticesIds = verticesIds;
        this.serverId = serverId;
        this.vertexClient = vertexClient;
        this.vertices = vertices;
        this.partitionId = partitionId;
        this.vertexService = vertexService;

    }

    @Override
    public void run() {
        if (partitionId != Integer.parseInt(serverId)) {
            // send to the right partition
            Iterable<Vertex> verticesFromOtherServer = vertexClient.getVertices(verticesIds,
                    String.valueOf(partitionId));

            // append to vertices
            if (verticesFromOtherServer == null)
                return;
            for (Vertex vertex : verticesFromOtherServer) {
                vertices.add(vertex);
            }
        } else {
            // get vertices from my server
            Iterable<Vertex> verticesFromMyServer = vertexService.getVerticesByIds(verticesIds);
            
            // append to vertices
            for (Vertex vertex : verticesFromMyServer) {
                vertices.add(vertex);
            }
        }

    }

}
