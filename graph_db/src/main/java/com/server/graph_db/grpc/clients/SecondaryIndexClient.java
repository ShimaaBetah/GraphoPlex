package com.server.graph_db.grpc.clients;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.server.graph_db.grpc.index.createIndexRequest;
import com.server.graph_db.grpc.index.createIndexResponse;
import com.server.graph_db.grpc.index.createIndicesRequest;
import com.server.graph_db.grpc.index.createIndicesResponse;
import com.server.graph_db.grpc.index.deleteIndexRequest;
import com.server.graph_db.grpc.index.deleteIndexResponse;
import com.server.graph_db.grpc.index.deleteIndicesRequest;
import com.server.graph_db.grpc.index.deleteIndicesResponse;
import com.server.graph_db.grpc.index.indexServiceGrpc;

import io.grpc.ManagedChannel;

@Service
public class SecondaryIndexClient {
    
    @Autowired
    ManagedChannel channel;

    @Autowired
    @Qualifier("grpcChannels")
    Map<String, ManagedChannel> grpcChannels;

    public boolean createIndex (String indexName, String serverId) {
        indexServiceGrpc.indexServiceBlockingStub blockingStub = indexServiceGrpc.newBlockingStub(grpcChannels.get(serverId));
        createIndexRequest request = createIndexRequest.newBuilder().setIndexName(indexName).build();
        createIndexResponse response = blockingStub.createIndex(request);
        return response.getSuccess();
    }

    public boolean deleteIndex (String indexName, String serverId) {
        indexServiceGrpc.indexServiceBlockingStub blockingStub = indexServiceGrpc.newBlockingStub(grpcChannels.get(serverId));
        deleteIndexRequest request = deleteIndexRequest.newBuilder().setIndexName(indexName).build();
        deleteIndexResponse response = blockingStub.deleteIndex(request);
        return response.getSuccess();
    }

    public boolean createIndices (Iterable<String> indexNames, String serverId) {
        indexServiceGrpc.indexServiceBlockingStub blockingStub = indexServiceGrpc.newBlockingStub(grpcChannels.get(serverId));
        createIndicesRequest request = createIndicesRequest.newBuilder().addAllIndicesNames(indexNames).build();
        createIndicesResponse response = blockingStub.createIndices(request);
        return response.getSuccess();
    }

    public boolean deleteIndices (Iterable<String> indexNames, String serverId) {
        indexServiceGrpc.indexServiceBlockingStub blockingStub = indexServiceGrpc.newBlockingStub(grpcChannels.get(serverId));
        deleteIndicesRequest request = deleteIndicesRequest.newBuilder().addAllIndicesNames(indexNames).build();
        deleteIndicesResponse response = blockingStub.deleteIndices(request);
        return response.getSuccess();
    }
}
