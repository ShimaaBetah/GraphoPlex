package com.server.graph_db.grpc.clients;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.parse.ANTLRParser.exceptionGroup_return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.server.graph_db.core.exceptions.vertex.VertexAlreadyExistsException;
import com.server.graph_db.core.exceptions.vertex.VertexNotFoundException;
import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.EdgeId;
import com.server.graph_db.core.vertex.Vertex;
import com.server.graph_db.grpc.adapter.Adapter;
import com.server.graph_db.grpc.traverser.edgeId;
import com.server.graph_db.grpc.vertex.VertexServiceGrpc;
import com.server.graph_db.grpc.vertex.createEdgeRequest;
import com.server.graph_db.grpc.vertex.createVertexRequest;
import com.server.graph_db.grpc.vertex.deleteEdgeRequest;
import com.server.graph_db.grpc.vertex.deleteVertexRequest;
import com.server.graph_db.grpc.vertex.deleteVertexResponse;
import com.server.graph_db.grpc.vertex.getAllVerticesIdsRequest;
import com.server.graph_db.grpc.vertex.getAllVerticesIdsResponse;
import com.server.graph_db.grpc.vertex.getEdgesRequest;
import com.server.graph_db.grpc.vertex.getEdgesResponse;
import com.server.graph_db.grpc.vertex.getIncomingEdgesForVerticesRequest;
import com.server.graph_db.grpc.vertex.getIncomingEdgesRequest;
import com.server.graph_db.grpc.vertex.getIncomingEdgesResponse;
import com.server.graph_db.grpc.vertex.getOutGoingEdgesForVerticesRequest;
import com.server.graph_db.grpc.vertex.getOutgoingEdgesRequest;
import com.server.graph_db.grpc.vertex.getOutgoingEdgesResponse;
import com.server.graph_db.grpc.vertex.getVertexRequest;
import com.server.graph_db.grpc.vertex.getVertexResponse;
import com.server.graph_db.grpc.vertex.getVerticesRequest;
import com.server.graph_db.grpc.vertex.getVerticesResponse;
import com.server.graph_db.grpc.vertex.updateEdgeRequest;
import com.server.graph_db.grpc.vertex.updateVertexRequest;
import com.server.graph_db.grpc.vertex.updateVertexResponse;

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

    public Vertex getVertex(String vertexId, String serverId) throws VertexNotFoundException {
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        getVertexRequest request = getVertexRequest.newBuilder().setVertexId(vertexId).build();
        getVertexResponse response;
        try {
            response = blockingStub.getVertex(request);
        } catch (Exception e) {
            throw new VertexNotFoundException(vertexId);
        }

        return adapter.vertexResponseToVertex(response);
    }

    public Iterable<Vertex> getVertices(Iterable<String> vertexIds, String serverId) {
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        getVerticesRequest request = getVerticesRequest.newBuilder().addAllVertexIds(vertexIds).build();
        getVerticesResponse response = blockingStub.getVertices(request);
        return adapter.verticesResponseToVertices(response);
    }

    public void createVertex(Vertex vertex, String serverId) throws VertexAlreadyExistsException{
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        createVertexRequest request = adapter.vertexToCreateVertexRequest(vertex);
        try{
            blockingStub.createVertex(request);
        } catch (Exception e) {
            throw new VertexAlreadyExistsException(vertex.getId());
        }
        return;
    }

    public void deleteVertex(String vertexId, String serverId) {
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        deleteVertexRequest request = deleteVertexRequest.newBuilder().setVertexId(vertexId).build();
        deleteVertexResponse response = blockingStub.deleteVertex(request);
        return;
    }

    public void updateVertex(String vertexId, Map<String, String> properties, String serverId) {
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        updateVertexRequest request = updateVertexRequest.newBuilder().setId(vertexId).putAllProperties(properties)
                .build();
        updateVertexResponse response = blockingStub.updateVertex(request);
        System.out.println(response.getSuccess());
        return;
    }

    public void updateVertex(String vertexId, String label, Map<String, String> properties, String serverId) {
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        updateVertexRequest request = updateVertexRequest.newBuilder().setId(vertexId).setLabel(label)
                .putAllProperties(properties).build();
        updateVertexResponse response = blockingStub.updateVertex(request);
        System.out.println(response.getSuccess());
        return;
    }

    public void createEdge(String sourceVertexId, Edge edge,boolean isOutgoing ,String serverId) throws VertexNotFoundException{
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        createEdgeRequest request = adapter.edgeToCreateEdgeRequest(sourceVertexId, edge, isOutgoing);
        
        try {
            blockingStub.createEdge(request);
        } catch (Exception e) {
            if(isOutgoing){

            throw new VertexNotFoundException(sourceVertexId);
            }
            else{
                throw new VertexNotFoundException(edge.getDestinationVertexId());
            }
        }
        return;
    }

    public void deleteEdge(String sourceVertexId, String destinationVertexId, String label,boolean isOutgoing ,String serverId) throws VertexNotFoundException{
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        deleteEdgeRequest request = deleteEdgeRequest.newBuilder().setSourceVertexId(sourceVertexId)
                .setDestinationVertexId(destinationVertexId).setLabel(label).setIsOutGoing(isOutgoing).build();
        try {
            blockingStub.deleteEdge(request);
        } catch (Exception e) {
            throw new VertexNotFoundException(sourceVertexId);
        }
        return;
    }

    public void updateEdge (String sourceVertexId, String destinationVertexId, String label, Map<String, String> properties,boolean isOutgoing ,String serverId) throws VertexNotFoundException{
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        updateEdgeRequest request = updateEdgeRequest.newBuilder().setSourceVertexId(sourceVertexId)
                .setDestinationVertexId(destinationVertexId).setLabel(label).putAllProperties(properties).setIsOutGoing(isOutgoing).build();
        try {
            blockingStub.updateEdge(request);
        } catch (Exception e) {
            throw new VertexNotFoundException(sourceVertexId);
        }
        return;
    }

    public Iterable<Edge> getOutgoingEdges (String sourceVertexId, String serverId) throws Exception{
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        getOutgoingEdgesRequest request = getOutgoingEdgesRequest.newBuilder().setVertexId(sourceVertexId).build();
        getOutgoingEdgesResponse response;
        try {
            response = blockingStub.getOutgoingEdges(request);
        } catch (Exception e) {
            throw new Exception("Internal Server Error");
        }
        return adapter.edgesResponseToEdges(response.getEdgesList());
    }

    public Iterable<Edge> getIncomingEdges (String destinationVertexId, String serverId) throws Exception{
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        getIncomingEdgesRequest request = getIncomingEdgesRequest.newBuilder().setVertexId(destinationVertexId).build();
        getIncomingEdgesResponse response;
        try {
            response = blockingStub.getIncomingEdges(request);
        } catch (Exception e) {
            throw new Exception("Internal Server Error");
        }
        return adapter.edgesResponseToEdges(response.getEdgesList());
    }


    public Iterable<Edge> getEdgesById(Iterable<EdgeId> edgeIds, String serverId) throws Exception{
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        List<edgeId> edgeIdsList = new ArrayList<>();
        for(EdgeId edge : edgeIds){
            edgeId edgeIdGrpc = edgeId.newBuilder().setSourceId(edge.getSourceId()).setDestinationId(edge.getdestinationId()).setLabel(edge.getLabel()).build();
            edgeIdsList.add(edgeIdGrpc);
        }
        getEdgesRequest request = getEdgesRequest.newBuilder().addAllEdgeIds(edgeIdsList).build();
        getEdgesResponse response;
        try {
            response = blockingStub.getEdges(request);
        } catch (Exception e) {
            throw new Exception("Internal Server Error");
        }
        return adapter.edgesResponseToEdges(response.getEdgesList());
    }

    public Iterable<Edge> getOutgoingEdges(Iterable<String> verticesIds, String serverId){
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        getOutGoingEdgesForVerticesRequest request = getOutGoingEdgesForVerticesRequest.newBuilder().addAllVertexIds(verticesIds).build();
        getEdgesResponse response = blockingStub.getOutgoingEdgesForVertices(request);
        return adapter.edgesResponseToEdges(response.getEdgesList());

    }

    public Iterable<Edge> getIncomingEdges(Iterable<String> verticesIds, String serverId){
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        getIncomingEdgesForVerticesRequest request = getIncomingEdgesForVerticesRequest.newBuilder().addAllVertexIds(verticesIds).build();
        getEdgesResponse response = blockingStub.getIncomingEdgesForVertices(request);
        return adapter.edgesResponseToEdges(response.getEdgesList());

    }

    public Iterable<String> getAllVerticesIds(String serverId){
        VertexServiceGrpc.VertexServiceBlockingStub blockingStub = VertexServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        getAllVerticesIdsRequest request = getAllVerticesIdsRequest.newBuilder().build();
        getAllVerticesIdsResponse response = blockingStub.getAllVerticesIds(request);
        return response.getVertexIdsList();

    }

}
