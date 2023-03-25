package com.server.graph_db.grpc.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.server.graph_db.grpc.adapter.Adapter;
import com.server.graph_db.grpc.vertex.VertexServiceGrpc;
import com.server.graph_db.grpc.vertex.getVertexRequest;
import com.server.graph_db.grpc.vertex.getVertexResponse;
import com.server.graph_db.vertex.Vertex;
import com.server.graph_db.vertex.VertexService;
import com.server.graph_db.grpc.vertex.getVerticesRequest;
import com.server.graph_db.grpc.vertex.getVerticesResponse;


import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class VertexServiceImpl extends VertexServiceGrpc.VertexServiceImplBase {
    @Autowired
    VertexService vertexService;

    @Autowired
    Adapter adapter;

    @Override
    public void getVertex(getVertexRequest request, io.grpc.stub.StreamObserver<getVertexResponse> responseObserver) {
        Vertex vertex = vertexService.getVertex(request.getVertexId());
        if(vertex == null) {
            vertex = new Vertex(request.getVertexId());
        }
        getVertexResponse reply = adapter.vertexToVertexResponse(vertex);
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getVertices( getVerticesRequest request,
            io.grpc.stub.StreamObserver<getVerticesResponse> responseObserver) {
            ArrayList<Vertex> vertices = (ArrayList<Vertex>) vertexService.getVerticesByIds(request.getVertexIdsList());
 
            //delete all null vertices
            vertices.removeIf(vertex -> vertex == null);
        

            getVerticesResponse reply = adapter.verticesToVerticesResponse(vertices);
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
    }
    
}
