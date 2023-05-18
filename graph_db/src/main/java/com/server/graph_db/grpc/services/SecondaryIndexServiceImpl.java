package com.server.graph_db.grpc.services;

import net.devh.boot.grpc.server.service.GrpcService;

import org.springframework.beans.factory.annotation.Autowired;

import com.server.graph_db.core.index.LocalSecondaryIndexManager;
import com.server.graph_db.grpc.index.createIndexRequest;
import com.server.graph_db.grpc.index.createIndexResponse;
import com.server.graph_db.grpc.index.createIndicesRequest;
import com.server.graph_db.grpc.index.deleteIndexRequest;
import com.server.graph_db.grpc.index.deleteIndicesRequest;
import com.server.graph_db.grpc.index.indexServiceGrpc;

@GrpcService
public class SecondaryIndexServiceImpl extends indexServiceGrpc.indexServiceImplBase {
    
    @Autowired
    LocalSecondaryIndexManager localSecondaryIndexManager;

    @Override
    public void createIndex (createIndexRequest request, io.grpc.stub.StreamObserver<com.server.graph_db.grpc.index.createIndexResponse> responseObserver) {

        localSecondaryIndexManager.createIndex(request.getIndexName());

        createIndexResponse reply = createIndexResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override 
    public void deleteIndex (deleteIndexRequest request, io.grpc.stub.StreamObserver<com.server.graph_db.grpc.index.deleteIndexResponse> responseObserver) {
        localSecondaryIndexManager.deleteIndex(request.getIndexName());

        com.server.graph_db.grpc.index.deleteIndexResponse reply = com.server.graph_db.grpc.index.deleteIndexResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void createIndices (createIndicesRequest request, io.grpc.stub.StreamObserver<com.server.graph_db.grpc.index.createIndicesResponse> responseObserver) {
        localSecondaryIndexManager.createIndices(request.getIndicesNamesList());
        com.server.graph_db.grpc.index.createIndicesResponse reply = com.server.graph_db.grpc.index.createIndicesResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteIndices (deleteIndicesRequest request, io.grpc.stub.StreamObserver<com.server.graph_db.grpc.index.deleteIndicesResponse> responseObserver) {
        localSecondaryIndexManager.deleteIndices(request.getIndicesNamesList());
        com.server.graph_db.grpc.index.deleteIndicesResponse reply = com.server.graph_db.grpc.index.deleteIndicesResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    
    
}
