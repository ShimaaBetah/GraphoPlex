package com.server.graph_db.grpc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.server.graph_db.core.exceptions.vertex.VertexAlreadyExistsException;
import com.server.graph_db.core.exceptions.vertex.VertexNotFoundException;
import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.EdgeId;
import com.server.graph_db.core.vertex.LocalVertexService;
import com.server.graph_db.core.vertex.Vertex;
import com.server.graph_db.grpc.adapter.Adapter;
import com.server.graph_db.grpc.traverser.edgeId;
import com.server.graph_db.grpc.traverser.edgeIds;
import com.server.graph_db.grpc.vertex.VertexServiceGrpc;
import com.server.graph_db.grpc.vertex.createEdgeRequest;
import com.server.graph_db.grpc.vertex.createEdgeResponse;
import com.server.graph_db.grpc.vertex.createVertexRequest;
import com.server.graph_db.grpc.vertex.createVertexResponse;
import com.server.graph_db.grpc.vertex.deleteEdgeRequest;
import com.server.graph_db.grpc.vertex.deleteEdgeResponse;
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
import com.server.graph_db.grpc.vertex.updateEdgeResponse;
import com.server.graph_db.grpc.vertex.updateVertexRequest;
import com.server.graph_db.grpc.vertex.updateVertexResponse;

import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class VertexServiceImpl extends VertexServiceGrpc.VertexServiceImplBase {
    @Autowired
    LocalVertexService vertexService;

    @Autowired
    Adapter adapter;

    @Override
    public void getVertex(getVertexRequest request, io.grpc.stub.StreamObserver<getVertexResponse> responseObserver) {
        Vertex vertex;
        try {
            vertex = vertexService.getVertex(request.getVertexId());
            getVertexResponse reply = adapter.vertexToVertexResponse(vertex);
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (VertexNotFoundException e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void getVertices(getVerticesRequest request,
            io.grpc.stub.StreamObserver<getVerticesResponse> responseObserver) {
        ArrayList<Vertex> vertices = (ArrayList<Vertex>) vertexService.getVerticesByIds(request.getVertexIdsList());

        // delete all null vertices
        vertices.removeIf(vertex -> vertex == null);

        getVerticesResponse reply = adapter.verticesToVerticesResponse(vertices);
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteVertex(deleteVertexRequest request,
            io.grpc.stub.StreamObserver<deleteVertexResponse> responseObserver) {
        vertexService.deleteVertex(request.getVertexId());
        deleteVertexResponse reply = deleteVertexResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void createVertex(createVertexRequest request,
            io.grpc.stub.StreamObserver<createVertexResponse> responseObserver) {
        Vertex createdVertex = adapter.vertexResponseToVertex(request);
        try {
            vertexService.createVertex(createdVertex);
            createVertexResponse reply = createVertexResponse.newBuilder().setSuccess(true).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (VertexAlreadyExistsException e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void updateVertex(updateVertexRequest request,
            io.grpc.stub.StreamObserver<updateVertexResponse> responseObserver) {
        if (request.getLabel().isEmpty()) {
            vertexService.updateVertex(request.getId(), request.getPropertiesMap());
        } else {
            vertexService.updateVertex(request.getId(), request.getLabel(), request.getPropertiesMap());
        }
        updateVertexResponse reply = updateVertexResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void createEdge(createEdgeRequest request,
            io.grpc.stub.StreamObserver<createEdgeResponse> responseObserver) {
        try {
            vertexService.addEdge(request.getSourceVertexId(), adapter.createEdgeRequestToEdge(request),
                    request.getIsOutGoing());
            createEdgeResponse reply = createEdgeResponse.newBuilder().setSuccess(true).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (VertexNotFoundException e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void deleteEdge(deleteEdgeRequest request,
            io.grpc.stub.StreamObserver<deleteEdgeResponse> responseObserver) {
        try {
            vertexService.deleteEdge(request.getSourceVertexId(), request.getDestinationVertexId(), request.getLabel(),
                    request.getIsOutGoing());
            deleteEdgeResponse reply = deleteEdgeResponse.newBuilder().setSuccess(true).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (VertexNotFoundException e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void updateEdge(updateEdgeRequest request,
            io.grpc.stub.StreamObserver<updateEdgeResponse> responseObserver) {
        try {
            vertexService.updateEdge(request.getSourceVertexId(), request.getDestinationVertexId(), request.getLabel(),
                    request.getPropertiesMap(), request.getIsOutGoing());
            updateEdgeResponse reply = updateEdgeResponse.newBuilder().setSuccess(true).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (VertexNotFoundException e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void getOutgoingEdges(getOutgoingEdgesRequest request,
            io.grpc.stub.StreamObserver<getOutgoingEdgesResponse> responseObserver) {

        try {
            Iterable<Edge> edges = vertexService.getOutgoingEdges(request.getVertexId());
            getOutgoingEdgesResponse reply = getOutgoingEdgesResponse.newBuilder()
                    .addAllEdges(adapter.edgesToEdgesResponse(edges)).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void getIncomingEdges(getIncomingEdgesRequest request,
            io.grpc.stub.StreamObserver<getIncomingEdgesResponse> responseObserver) {

        try {
            Iterable<Edge> edges = vertexService.getIncomingEdges(request.getVertexId());
            getIncomingEdgesResponse reply = getIncomingEdgesResponse.newBuilder()
                    .addAllEdges(adapter.edgesToEdgesResponse(edges)).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void getEdges(getEdgesRequest request, io.grpc.stub.StreamObserver<getEdgesResponse> responseObserver) {
        try {
            List<edgeId> edgeIdsGrpc = request.getEdgeIdsList();
            List<EdgeId> edgeIds = new ArrayList<>();
            for (edgeId edgeId : edgeIdsGrpc) {
                edgeIds.add(new EdgeId(edgeId.getSourceId(), edgeId.getDestinationId(), edgeId.getLabel()));
            }
            Iterable<Edge> edges = vertexService.getEdgesById(edgeIds);
            getEdgesResponse reply = getEdgesResponse.newBuilder().addAllEdges(adapter.edgesToEdgesResponse(edges))
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void getOutgoingEdgesForVertices(getOutGoingEdgesForVerticesRequest request,
            io.grpc.stub.StreamObserver<getEdgesResponse> responseObserver) {
        try {
            Iterable<Edge> edges = vertexService.getOutgoingEdges(request.getVertexIdsList());
            getEdgesResponse reply = getEdgesResponse.newBuilder()
                    .addAllEdges(adapter.edgesToEdgesResponse(edges)).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void getIncomingEdgesForVertices(getIncomingEdgesForVerticesRequest request,
            io.grpc.stub.StreamObserver<getEdgesResponse> responseObserver) {
        try {
            Iterable<Edge> edges = vertexService.getIncomingEdges(request.getVertexIdsList());
            getEdgesResponse reply = getEdgesResponse.newBuilder()
                    .addAllEdges(adapter.edgesToEdgesResponse(edges)).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void getAllVerticesIds (getAllVerticesIdsRequest request,
            io.grpc.stub.StreamObserver<getAllVerticesIdsResponse> responseObserver) {
        try {
            Iterable<String> vertexIds = vertexService.getAllVerticesIds();
            getAllVerticesIdsResponse reply = getAllVerticesIdsResponse.newBuilder()
                    .addAllVertexIds(vertexIds).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    

}
