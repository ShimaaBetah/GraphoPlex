package com.server.graph_db.grpc.clients;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.server.graph_db.grpc.adapter.Adapter;
import com.server.graph_db.grpc.vertex.VertexServiceGrpc;
import com.server.graph_db.grpc.vertex.createVertexRequest;
import com.server.graph_db.grpc.vertex.createVertexResponse;
import com.server.graph_db.grpc.vertex.deleteVertexRequest;
import com.server.graph_db.grpc.vertex.deleteVertexResponse;
import com.server.graph_db.grpc.vertex.getVertexRequest;
import com.server.graph_db.grpc.vertex.getVertexResponse;
import com.server.graph_db.grpc.vertex.getVerticesRequest;
import com.server.graph_db.grpc.vertex.getVerticesResponse;
import com.server.graph_db.grpc.vertex.updateVertexRequest;
import com.server.graph_db.grpc.vertex.updateVertexResponse;
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

    public Vertex getVertex(String vertexId, String serverId) {
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc.newBlockingStub(grpcChannels.get(serverId));
        getVertexRequest request = getVertexRequest.newBuilder().setVertexId(vertexId).build();
        getVertexResponse response = blockingStub.getVertex(request);

        return adapter.vertexResponseToVertex(response);
    }

    public Iterable<Vertex> getVertices(Iterable<String> vertexIds, String serverId) {
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc.newBlockingStub(grpcChannels.get(serverId));
        getVerticesRequest request = getVerticesRequest.newBuilder().addAllVertexIds(vertexIds).build();
        getVerticesResponse response = blockingStub.getVertices(request);
        return adapter.verticesResponseToVertices(response);
    }

    public void createVertex (Vertex vertex, String serverId) {
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc.newBlockingStub(grpcChannels.get(serverId));
        createVertexRequest request = adapter.vertexToCreateVertexRequest(vertex);
        createVertexResponse response = blockingStub.createVertex(request);
        System.out.println(response.getSuccess());
        return;
    }

    public void deleteVertex (String vertexId, String serverId) {
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc.newBlockingStub(grpcChannels.get(serverId));
        deleteVertexRequest request = deleteVertexRequest.newBuilder().setVertexId(vertexId).build();
        deleteVertexResponse response = blockingStub.deleteVertex(request);
        System.out.println(response.getSuccess());
        return;
    }

    public void updateVertex (String vertexId, Map<String, String> properties , String serverId) {
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc.newBlockingStub(grpcChannels.get(serverId));
        updateVertexRequest request = updateVertexRequest.newBuilder().setId(vertexId).putAllProperties(properties).build();
        updateVertexResponse response = blockingStub.updateVertex(request);
        System.out.println(response.getSuccess());
        return;
    }

    public void updateVertex (String vertexId, String label , Map<String, String> properties , String serverId) {
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc.newBlockingStub(grpcChannels.get(serverId));
        updateVertexRequest request = updateVertexRequest.newBuilder().setId(vertexId).setLabel(label).putAllProperties(properties).build();
        updateVertexResponse response = blockingStub.updateVertex(request);
        System.out.println(response.getSuccess());
        return;
    }

}
