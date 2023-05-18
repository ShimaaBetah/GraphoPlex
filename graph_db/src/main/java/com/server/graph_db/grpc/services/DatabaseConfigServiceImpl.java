package com.server.graph_db.grpc.services;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.rpc.Status;
import com.server.graph_db.core.database.LocalDatabaseService;
import com.server.graph_db.core.exceptions.database.DatabaseAlreadyExist;
import com.server.graph_db.core.exceptions.database.DatabaseNotFound;
import com.server.graph_db.grpc.database.DatabaseName;
import com.server.graph_db.grpc.database.databaseConfigServiceGrpc;
import com.server.graph_db.grpc.database.emptyResponse;
import com.server.graph_db.grpc.database.reply;

import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class DatabaseConfigServiceImpl extends databaseConfigServiceGrpc.databaseConfigServiceImplBase {

    @Autowired
    LocalDatabaseService databaseService;


    @Override
    public void createDatabase(DatabaseName request,
            io.grpc.stub.StreamObserver<com.server.graph_db.grpc.database.reply> responseObserver) {
        try {
            databaseService.createDatabase(request.getName());
            //build ok status
            Status status = Status.newBuilder().setCode(0).build();
            reply successreply = reply.newBuilder().setStatus(status).build();
            responseObserver.onNext(successreply);
            responseObserver.onCompleted();


        } catch (DatabaseAlreadyExist e) {
            //build already exist status
            Status status = Status.newBuilder().setCode(6).build();
            reply errorreply = reply.newBuilder().setStatus(status).build();
            responseObserver.onNext(errorreply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void deleteDatabase(DatabaseName request,
            io.grpc.stub.StreamObserver<com.server.graph_db.grpc.database.reply> responseObserver) {
        try {
            databaseService.deleteDatabase(request.getName());
            //build ok status
            Status status = Status.newBuilder().setCode(0).build();
            reply successreply = reply.newBuilder().setStatus(status).build();
            responseObserver.onNext(successreply);
            responseObserver.onCompleted();
        }catch(DatabaseNotFound e) {
            //build not found status
            Status status = Status.newBuilder().setCode(5).build();
            reply errorreply = reply.newBuilder().setStatus(status).build();
            responseObserver.onNext(errorreply);
            responseObserver.onCompleted();
        }catch(Exception e) {
            //throw error
            responseObserver.onError(e);
        }
    }

    @Override
    public void dropDatabase(DatabaseName request,
            io.grpc.stub.StreamObserver<com.server.graph_db.grpc.database.reply> responseObserver) {
        try {
            databaseService.dropDatabase(request.getName());
            //build ok status
            Status status = Status.newBuilder().setCode(0).build();
            reply successreply = reply.newBuilder().setStatus(status).build();
            responseObserver.onNext(successreply);
            responseObserver.onCompleted();
        }catch(DatabaseNotFound e) {
            //build not found status
            Status status = Status.newBuilder().setCode(5).build();
            reply errorreply = reply.newBuilder().setStatus(status).build();
            responseObserver.onNext(errorreply);
            responseObserver.onCompleted();
        }catch(Exception e) {
            //throw error
            responseObserver.onError(e);
        }
    }

    @Override
    public void switchDatabase (DatabaseName request,
            io.grpc.stub.StreamObserver<com.server.graph_db.grpc.database.reply> responseObserver) {
        try {
            databaseService.switchDatabase(request.getName());
            //build ok status
            Status status = Status.newBuilder().setCode(0).build();
            reply successreply = reply.newBuilder().setStatus(status).build();
            responseObserver.onNext(successreply);
            responseObserver.onCompleted();
        }catch(DatabaseNotFound e) {
            //build not found status
            Status status = Status.newBuilder().setCode(5).build();
            reply errorreply = reply.newBuilder().setStatus(status).build();
            responseObserver.onNext(errorreply);
            responseObserver.onCompleted();
        }catch(Exception e) {
            //throw error
            responseObserver.onError(e);
        }
    }

    @Override
    public void switchToDefaultDatabase(emptyResponse request,
            io.grpc.stub.StreamObserver<com.server.graph_db.grpc.database.reply> responseObserver) {
        try {
            databaseService.switchToDefaultDatabase();
            //build ok status
            Status status = Status.newBuilder().setCode(0).build();
            reply successreply = reply.newBuilder().setStatus(status).build();
            responseObserver.onNext(successreply);
            responseObserver.onCompleted();
        }catch(Exception e) {
            //throw error
            responseObserver.onError(e);
        }
    }

    @Override
    public void dropDefaultDatabase (emptyResponse request,
            io.grpc.stub.StreamObserver<com.server.graph_db.grpc.database.reply> responseObserver) {
        try {
            databaseService.dropDefaultDatabase();
            //build ok status
            Status status = Status.newBuilder().setCode(0).build();
            reply successreply = reply.newBuilder().setStatus(status).build();
            responseObserver.onNext(successreply);
            responseObserver.onCompleted();
        }catch(Exception e) {
            //throw error
            responseObserver.onError(e);
        }
    }

    @Override
    public void getCurrentDatabase(emptyResponse request,
            io.grpc.stub.StreamObserver<com.server.graph_db.grpc.database.DatabaseName> responseObserver) {
        try {
            String currentDatabase = databaseService.getCurrentDatabase();
            //build ok status
            DatabaseName reply = DatabaseName.newBuilder().setName(currentDatabase).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }catch(Exception e) {
            //build internal error status
            responseObserver.onError(e);
            
        }
    }
    
}
