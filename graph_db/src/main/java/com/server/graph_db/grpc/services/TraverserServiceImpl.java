package com.server.graph_db.grpc.services;
import org.springframework.beans.factory.annotation.Autowired;

import com.server.graph_db.core.traversers.LocalTraversalManager;
import com.server.graph_db.core.vertex.EdgeId;
import com.server.graph_db.grpc.adapter.Adapter;
import com.server.graph_db.grpc.traverser.TraverserServiceGrpc;
import com.server.graph_db.grpc.traverser.edgeIds;
import com.server.graph_db.grpc.traverser.filterEdgesRequest;
import com.server.graph_db.grpc.traverser.filterVerticesRequest;
import com.server.graph_db.grpc.traverser.vertexBinding;
import com.server.graph_db.grpc.traverser.verticesIds;

import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class TraverserServiceImpl extends TraverserServiceGrpc.TraverserServiceImplBase{
    
    @Autowired
    LocalTraversalManager localTraversalManager;

    @Autowired
    Adapter adapter;

    
    

    @Override
    public void getVertices (vertexBinding vertexBinding , io.grpc.stub.StreamObserver<verticesIds> responseObserver) {
       Iterable<String> resultSet;
    try {
        resultSet = localTraversalManager.getVertices(adapter.vertexBindingGrpcToCore(vertexBinding));
        verticesIds reply = verticesIds.newBuilder().addAllVerticesIds(resultSet).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    } catch (Exception e) {
        responseObserver.onError(e);
    }
    }

    @Override
    public void filterVertices(filterVerticesRequest request,
            io.grpc.stub.StreamObserver<verticesIds> responseObserver) {
        Iterable<String> resultSet;
        try {
            resultSet = localTraversalManager.filterVertices(request.getVerticesIdsList(), adapter.vertexBindingGrpcToCore(request.getVertexBinding()));
            verticesIds reply = verticesIds.newBuilder().addAllVerticesIds(resultSet).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void filterOutGoingEdges (filterEdgesRequest request, io.grpc.stub.StreamObserver<edgeIds> responseObserver) {
        Iterable<EdgeId> resultSet;
        try {
            resultSet = localTraversalManager.filterOutGoingEdges(request.getVerticesIdsList(), adapter.edgeBindingGrpcToCore(request));
            edgeIds reply = edgeIds.newBuilder().addAllEdgeIds(adapter.edgeIdCoreToEdgeIdGrpc(resultSet)).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void filterInGoingEdges (filterEdgesRequest request, io.grpc.stub.StreamObserver<edgeIds> responseObserver) {
        Iterable<EdgeId> resultSet;
        try {
            resultSet = localTraversalManager.filterIncomingEdges(request.getVerticesIdsList(), adapter.edgeBindingGrpcToCore(request));
            edgeIds reply = edgeIds.newBuilder().addAllEdgeIds(adapter.edgeIdCoreToEdgeIdGrpc(resultSet)).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }


    
    

        
    
}
