package com.server.graph_db.grpc.clients;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.server.graph_db.core.exceptions.database.DatabaseAlreadyExist;
import com.server.graph_db.core.exceptions.database.DatabaseNotFound;
import com.server.graph_db.grpc.database.DatabaseName;
import com.server.graph_db.grpc.database.databaseConfigServiceGrpc;
import com.server.graph_db.grpc.database.emptyResponse;
import com.server.graph_db.grpc.database.reply;

import io.grpc.ManagedChannel;


@Service
public class DatabaseConfigClient {
    @Autowired
    ManagedChannel channel;

    @Autowired
    @Qualifier("grpcChannels")
    Map<String, ManagedChannel> grpcChannels;


    public void createDatabase(String database, String serverId) throws Exception {
        databaseConfigServiceGrpc.databaseConfigServiceBlockingStub blockingStub = databaseConfigServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        DatabaseName request = DatabaseName.newBuilder().setName(database).build();
        reply response;
        try{
        response = blockingStub.createDatabase(request);
        }catch(Exception e){
            throw new Exception("Internal server error");
        }

        if(response.getStatus().getCode()==6){
            throw new DatabaseAlreadyExist(database);
        }
    }

    public void deleteDatabase(String database, String serverId) throws Exception {
        databaseConfigServiceGrpc.databaseConfigServiceBlockingStub blockingStub = databaseConfigServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        DatabaseName request = DatabaseName.newBuilder().setName(database).build();
        reply response;
        try{
        response = blockingStub.deleteDatabase(request);
        }catch(Exception e){
            throw new Exception("Internal server error");
        }

        if(response.getStatus().getCode()==5){
            throw new DatabaseNotFound(database);
        }
    }

    public void dropDatabase(String database, String serverId) throws Exception {
        databaseConfigServiceGrpc.databaseConfigServiceBlockingStub blockingStub = databaseConfigServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        DatabaseName request = DatabaseName.newBuilder().setName(database).build();
        reply response;
        try{
        response = blockingStub.dropDatabase(request);
        }catch(Exception e){
            throw new Exception("Internal server error");
        }

        if(response.getStatus().getCode()==5){
            throw new DatabaseNotFound(database);
        }
    }

    public void switchDatabase(String database, String serverId) throws Exception {
        databaseConfigServiceGrpc.databaseConfigServiceBlockingStub blockingStub = databaseConfigServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        DatabaseName request = DatabaseName.newBuilder().setName(database).build();
        reply response;
        try{
        response = blockingStub.switchDatabase(request);
        }catch(Exception e){
            throw new Exception("Internal server error");
        }

        if(response.getStatus().getCode()==5){
            throw new DatabaseNotFound(database);
        }
    }

    public String getCurrentDatabase(String serverId) throws Exception {
        databaseConfigServiceGrpc.databaseConfigServiceBlockingStub blockingStub = databaseConfigServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        emptyResponse request = emptyResponse.newBuilder().build();
        DatabaseName response;
        try{
        response = blockingStub.getCurrentDatabase(request);
        }catch(Exception e){
            throw new Exception("Internal server error");
        }

        return response.getName();
    }

    public void switchToDefaultDatabase(String serverId) throws Exception {
        databaseConfigServiceGrpc.databaseConfigServiceBlockingStub blockingStub = databaseConfigServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        emptyResponse request = emptyResponse.newBuilder().build();
        try{
           blockingStub.switchToDefaultDatabase(request);
        }catch(Exception e){
            throw new Exception("Internal server error");
        }
    }

    public void dropDefaultDatabase(String serverId) throws Exception {
        databaseConfigServiceGrpc.databaseConfigServiceBlockingStub blockingStub = databaseConfigServiceGrpc
                .newBlockingStub(grpcChannels.get(serverId));
        emptyResponse request = emptyResponse.newBuilder().build();
        try{
           blockingStub.dropDefaultDatabase(request);
        }catch(Exception e){
            throw new Exception("Internal server error");
        }
    }
}
