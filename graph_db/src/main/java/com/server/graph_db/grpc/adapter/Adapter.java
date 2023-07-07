package com.server.graph_db.grpc.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.core.operators.select.SelectOperator;
import com.server.graph_db.core.operators.select.SelectOperatorFactory;
import com.server.graph_db.core.traversers.bindings.EdgeBinding;
import com.server.graph_db.core.traversers.bindings.VertexBinding;
import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.EdgeId;
import com.server.graph_db.core.vertex.Vertex;
import com.server.graph_db.grpc.traverser.edgeId;
import com.server.graph_db.grpc.traverser.edgeIds;
import com.server.graph_db.grpc.traverser.filterEdgesRequest;
import com.server.graph_db.grpc.traverser.selectOperator;
import com.server.graph_db.grpc.traverser.vertexBinding;
import com.server.graph_db.grpc.vertex.GrpcVertex;
import com.server.graph_db.grpc.vertex.createEdgeRequest;
import com.server.graph_db.grpc.vertex.createVertexRequest;
import com.server.graph_db.grpc.vertex.edge;
import com.server.graph_db.grpc.vertex.getVertexResponse;
import com.server.graph_db.grpc.vertex.getVerticesResponse;

@Component
public class Adapter {

    @Autowired
    SelectOperatorFactory selectOperatorFactory;    

    public getVertexResponse vertexToVertexResponse(Vertex vertex) {
        return getVertexResponse.newBuilder()
                .setId(vertex.getId())
                .setLabel(vertex.getLabel())
                .putAllProperties(vertex.getProperties())
                .build();
    }

    public createVertexRequest vertexToCreateVertexRequest(Vertex vertex) {
        return createVertexRequest.newBuilder()
                .setId(vertex.getId())
                .setLabel(vertex.getLabel())
                .putAllProperties(vertex.getProperties())
                .build();
    }

    public Iterable<edge> edgesToEdgesResponse(Iterable<Edge> edges) {
        ArrayList<edge> edgesResponse = new ArrayList<>();
        for (Edge edgeCore : edges) {
            edge convertedEdge = edge.newBuilder().setDestinationVertexId(edgeCore.getDestinationVertexId())
                    .setLabel(edgeCore.getLabel())
                    .setSourceVertexId(edgeCore.getSourceVertexId())
                    .putAllProperties(edgeCore.getProperties())
                    .build();
            edgesResponse.add(convertedEdge);
        }

        return edgesResponse;
    }


    public Vertex vertexResponseToVertex(GrpcVertex vertexResponse) {
        Vertex vertex = new Vertex(vertexResponse.getId());
        vertex.setProperties(vertexResponse.getPropertiesMap());
        vertex.setLabel(vertexResponse.getLabel());
        return vertex;
    }

    public getVerticesResponse verticesToVerticesResponse(Iterable<Vertex> vertices) {
        getVerticesResponse.Builder builder = getVerticesResponse.newBuilder();
        for (Vertex vertex : vertices) {
            builder.addVertices(vertexToVertexResponse(vertex));
        }
        return builder.build();
    }

    public Iterable<Vertex> verticesResponseToVertices(getVerticesResponse response) {
        ArrayList<Vertex> vertices = new ArrayList<>();
        for (getVertexResponse vertexResponse : response.getVerticesList()) {
            vertices.add(vertexResponseToVertex(vertexResponse));
        }
        return vertices;
    }

    public Edge createEdgeRequestToEdge (createEdgeRequest request) {
        Edge edge = new Edge(request.getSourceVertexId(),request.getDestinationVertexId());
        edge.setProperties(request.getPropertiesMap());
        edge.setLabel(request.getLabel());
        return edge;
    }

    public createEdgeRequest edgeToCreateEdgeRequest (String sourceVertexId, Edge edge, boolean isOutgoing) {
        return createEdgeRequest.newBuilder()
                 .setSourceVertexId(sourceVertexId)
                .setDestinationVertexId(edge.getDestinationVertexId())
                .setLabel(edge.getLabel())
                .putAllProperties(edge.getProperties())
                .setIsOutGoing(isOutgoing)
                .build();
    }

    public Iterable<Edge> edgesResponseToEdges(Iterable<edge> edgesResponse) {
        ArrayList<Edge> edges = new ArrayList<>();
        for (edge edgeResponse : edgesResponse) {
            Edge edge = new Edge(edgeResponse.getSourceVertexId(),edgeResponse.getDestinationVertexId());
            edge.setProperties(edgeResponse.getPropertiesMap());
            edge.setLabel(edgeResponse.getLabel());
            edges.add(edge);
        }
        return edges;
    }



    public VertexBinding vertexBindingGrpcToCore (vertexBinding vertexBindingGrpc) {
        VertexBinding.Builder builder = new VertexBinding.Builder();
        if (!vertexBindingGrpc.getId().isEmpty()) {
            builder.setId(vertexBindingGrpc.getId());
        }
        if(!vertexBindingGrpc.getLabel().isEmpty()) {
            builder.setLabel(vertexBindingGrpc.getLabel());
        }
       if(!vertexBindingGrpc.getSelectOperatorsList().isEmpty()) {
        ArrayList<SelectOperator> selectOperators = new ArrayList<>();
        for (selectOperator selectOperator : vertexBindingGrpc.getSelectOperatorsList()) {
            selectOperators.add(selectOperatorFactory.getSelectOperator(selectOperator.getOperator(), selectOperator.getFieldName(), selectOperator.getFieldValue()));
        }

        builder.setSelectOperators(selectOperators);
       }
        return builder.build();
    }

    public EdgeBinding edgeBindingGrpcToCore (filterEdgesRequest edgeBinding){
        EdgeBinding.Builder builder = new EdgeBinding.Builder(false);
        if(!edgeBinding.getEdgeLabel().isEmpty()) {
            builder.setLabel(edgeBinding.getEdgeLabel());
        }
        if(!edgeBinding.getSelectOperatorsList().isEmpty()) {
            ArrayList<SelectOperator> selectOperators = new ArrayList<>();
            for (selectOperator selectOperator : edgeBinding.getSelectOperatorsList()) {
                selectOperators.add(selectOperatorFactory.getSelectOperator(selectOperator.getOperator(), selectOperator.getFieldName(), selectOperator.getFieldValue()));
            }

            builder.setSelectOperators(selectOperators);
        }
        return builder.build();
    }

    public Iterable<edgeId> edgeIdCoreToEdgeIdGrpc(Iterable<EdgeId> edgesIdsCore) {
        ArrayList<edgeId> edgeIds = new ArrayList<>();
        for (EdgeId edge : edgesIdsCore) {
            edgeId edgeIdGrpc = edgeId.newBuilder()
                    .setSourceId(edge.getSourceId())
                    .setDestinationId(edge.getdestinationId())
                    .setLabel(edge.getLabel())
                    .build();
            edgeIds.add(edgeIdGrpc);
        }
        return edgeIds;
    }

    public vertexBinding vertexBindingCoreToVertexBindingGrpc(VertexBinding vertexBindingCore) {
        vertexBinding.Builder builder = vertexBinding.newBuilder();
        if (vertexBindingCore.getId()!=null) {
            builder.setId(vertexBindingCore.getId());
        }
        if(vertexBindingCore.getLabel()!=null) {
            builder.setLabel(vertexBindingCore.getLabel());
        }
        if(vertexBindingCore.getSelectOperators()!=null) {
            ArrayList<selectOperator> selectOperators = new ArrayList<>();
            for (SelectOperator selectOperatorCore : vertexBindingCore.getSelectOperators()) {
                selectOperators.add(selectOperator.newBuilder()
                        .setOperator(selectOperatorCore.getOperator())
                        .setFieldName(selectOperatorCore.getFieldName())
                        .setFieldValue(selectOperatorCore.getFieldValue())
                        .build());
            }

            builder.addAllSelectOperators(selectOperators);
        }
        return builder.build();
    }

    public filterEdgesRequest edgeBindingCoreToEdgeBindingGrpc(Iterable<String> verticesIds, EdgeBinding edgeBinding) {
        filterEdgesRequest.Builder builder = filterEdgesRequest.newBuilder();
        builder.addAllVerticesIds(verticesIds);
        if(edgeBinding.getLabel()!=null) {
            builder.setEdgeLabel(edgeBinding.getLabel());
        }
        if(edgeBinding.getSelectOperators()!=null) {
            ArrayList<selectOperator> selectOperators = new ArrayList<>();
            for (SelectOperator selectOperatorCore : edgeBinding.getSelectOperators()) {
                selectOperators.add(selectOperator.newBuilder()
                        .setOperator(selectOperatorCore.getOperator())
                        .setFieldName(selectOperatorCore.getFieldName())
                        .setFieldValue(selectOperatorCore.getFieldValue())
                        .build());
            }

            builder.addAllSelectOperators(selectOperators);
        } 
        return builder.build();
    }

    public Iterable<EdgeId> edgeIdsGrpcToEdgeIdsCore(edgeIds response) {
        ArrayList<EdgeId> edgeIds = new ArrayList<>();
        for (edgeId edgeIdGrpc : response.getEdgeIdsList()) {
            EdgeId edgeIdCore = new EdgeId(edgeIdGrpc.getSourceId(),edgeIdGrpc.getDestinationId(),edgeIdGrpc.getLabel());
            edgeIds.add(edgeIdCore);
        }
        return edgeIds;
    }



}
