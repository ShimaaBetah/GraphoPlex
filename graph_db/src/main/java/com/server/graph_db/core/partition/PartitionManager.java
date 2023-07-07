package com.server.graph_db.core.partition;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.server.graph_db.core.vertex.EdgeId;
import com.server.graph_db.core.vertex.LocalVertexService;
import com.server.graph_db.core.vertex.Vertex;
import com.server.graph_db.grpc.clients.VertexClient;


@Component
public class PartitionManager {

    @Autowired
    LocalVertexService vertexService;

    @Value("${myserver.serverId}")
    private String serverId;


    @Autowired
    VertexClient vertexClient;



    @Value("${server.numOfServers}")
    private int numOfServers;

    public int getPartitionId(String vertexId) {
        return ((vertexId.hashCode()%numOfServers)+numOfServers)%numOfServers;
    }

    public int getPartitionId(Vertex vertex) {
        return getPartitionId(vertex.getId());
    }

    public int getNumberOfServers() {
        return numOfServers;
    }

    public int getServerId() {
        return Integer.parseInt(serverId);
    }

    public List<List<String>> groupVerticesIdsByPartitionId(Iterable<String> verticesIds) {
        List<List<String>> verticesIdsByPartitionId = new ArrayList<List<String>>();
        for (int i = 0; i < numOfServers; i++) {
            verticesIdsByPartitionId.add(new ArrayList<String>());
        }

        for (String vertexId : verticesIds) {
            int partitionId = getPartitionId(vertexId);
            verticesIdsByPartitionId.get(partitionId).add(vertexId);
        }

        return verticesIdsByPartitionId;

    }

    public List<List<EdgeId>> groupEdgeIdsByPartitionId(Iterable<EdgeId> edgeIds) {
        List<List<EdgeId>> edgeIdsByPartitionId = new ArrayList<List<EdgeId>>();
        for (int i = 0; i < numOfServers; i++) {
            edgeIdsByPartitionId.add(new ArrayList<EdgeId>());
        }

        for (EdgeId edgeId : edgeIds) {
            int partitionId = getPartitionId(edgeId.getSourceId());
            edgeIdsByPartitionId.get(partitionId).add(edgeId);
        }

        return edgeIdsByPartitionId;

    }

}