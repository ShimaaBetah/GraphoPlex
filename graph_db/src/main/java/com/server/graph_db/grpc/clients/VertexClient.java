package com.server.graph_db.grpc.clients;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.server.graph_db.grpc.adapter.Adapter;
import com.server.graph_db.grpc.vertex.VertexServiceGrpc;
import com.server.graph_db.grpc.vertex.getVertexRequest;
import com.server.graph_db.grpc.vertex.getVertexResponse;
import com.server.graph_db.grpc.vertex.getVerticesRequest;
import com.server.graph_db.grpc.vertex.getVerticesResponse;
import com.server.graph_db.vertex.Vertex;

import io.grpc.ManagedChannel;

@Service
public class VertexClient {
    
    @Autowired
    ManagedChannel channel;

    @Autowired
    @Qualifier("grpcChannels")
    Map<String, ManagedChannel> grpcChannels;

    @Autowired
    Adapter adapter;

    public Vertex getVertex(int vertexId, String serverId) {
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc.newBlockingStub(grpcChannels.get(serverId));
        getVertexRequest request = getVertexRequest.newBuilder().setVertexId(vertexId).build();
        getVertexResponse response = blockingStub.getVertex(request);

        return adapter.vertexResponseToVertex(response);
    }

    public Iterable<Vertex> getVertices(Iterable<Integer> vertexIds, String serverId) {
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc.newBlockingStub(grpcChannels.get(serverId));
        getVerticesRequest request = getVerticesRequest.newBuilder().addAllVertexIds(vertexIds).build();
        getVerticesResponse response = blockingStub.getVertices(request);
        return adapter.verticesResponseToVertices(response);
    }

}
