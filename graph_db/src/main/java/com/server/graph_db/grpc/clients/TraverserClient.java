package com.server.graph_db.grpc.clients;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.server.graph_db.core.traversers.bindings.EdgeBinding;
import com.server.graph_db.core.traversers.bindings.VertexBinding;
import com.server.graph_db.core.vertex.EdgeId;
import com.server.graph_db.grpc.adapter.Adapter;
import com.server.graph_db.grpc.traverser.TraverserServiceGrpc;
import com.server.graph_db.grpc.traverser.edgeIds;
import com.server.graph_db.grpc.traverser.filterEdgesRequest;
import com.server.graph_db.grpc.traverser.filterVerticesRequest;
import com.server.graph_db.grpc.traverser.vertexBinding;
import com.server.graph_db.grpc.traverser.verticesIds;

import io.grpc.ManagedChannel;

@Service
public class TraverserClient {

    @Autowired
    ManagedChannel channel;

    @Autowired
    @Qualifier("grpcChannels")
    Map<String, ManagedChannel> grpcChannels;

    @Autowired
    Adapter adapter;

    public Iterable<String> getVertices(VertexBinding vertexBinding, String serverId) throws Exception{
        TraverserServiceGrpc.TraverserServiceBlockingStub blockingStub = TraverserServiceGrpc.newBlockingStub(grpcChannels.get(serverId));
        vertexBinding request = adapter.vertexBindingCoreToVertexBindingGrpc(vertexBinding);
        try{
        verticesIds response = blockingStub.getVertices(request);
        return response.getVerticesIdsList();
        }catch(Exception e){
            throw new Exception("Internal Server Error");
        }
        
    }

    public Iterable<String> filterVertices (Iterable<String> verticesToFilter, VertexBinding vertexBinding , String ServerId) throws Exception{
        TraverserServiceGrpc.TraverserServiceBlockingStub blockingStub = TraverserServiceGrpc.newBlockingStub(grpcChannels.get(ServerId));
        filterVerticesRequest request = filterVerticesRequest.newBuilder().addAllVerticesIds(verticesToFilter).setVertexBinding(adapter.vertexBindingCoreToVertexBindingGrpc(vertexBinding)).build();

        try{
            verticesIds response = blockingStub.filterVertices(request);
            return response.getVerticesIdsList();
        } catch(Exception e){
            throw new Exception("Internal Server Error");
        }
    }

    public Iterable<EdgeId> filterOutGoingEdges (Iterable<String> verticesIds, EdgeBinding edgeBinding, String ServerId) throws Exception{
        TraverserServiceGrpc.TraverserServiceBlockingStub blockingStub = TraverserServiceGrpc.newBlockingStub(grpcChannels.get(ServerId));
        filterEdgesRequest request = adapter.edgeBindingCoreToEdgeBindingGrpc(verticesIds, edgeBinding);

        try{
            edgeIds response = blockingStub.filterOutGoingEdges(request);
            return adapter.edgeIdsGrpcToEdgeIdsCore(response);
        } catch(Exception e){
            throw new Exception("Internal Server Error");
        }
    }

    public Iterable<EdgeId> filterIncomingEdges (Iterable<String> verticesIds, EdgeBinding edgeBinding, String ServerId) throws Exception{
        TraverserServiceGrpc.TraverserServiceBlockingStub blockingStub = TraverserServiceGrpc.newBlockingStub(grpcChannels.get(ServerId));
        filterEdgesRequest request = adapter.edgeBindingCoreToEdgeBindingGrpc(verticesIds, edgeBinding);

        try{
            edgeIds response = blockingStub.filterInGoingEdges(request);
            return adapter.edgeIdsGrpcToEdgeIdsCore(response);
        } catch(Exception e){
            throw new Exception("Internal Server Error");
        }
    }
    
}
