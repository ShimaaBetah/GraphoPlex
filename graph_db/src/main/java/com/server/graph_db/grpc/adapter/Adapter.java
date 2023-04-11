package com.server.graph_db.grpc.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.server.graph_db.grpc.vertex.GrpcVertex;
import com.server.graph_db.grpc.vertex.createVertexRequest;
import com.server.graph_db.grpc.vertex.edge;
import com.server.graph_db.grpc.vertex.getVertexResponse;
import com.server.graph_db.grpc.vertex.getVerticesResponse;
import com.server.graph_db.vertex.Edge;
import com.server.graph_db.vertex.Vertex;

@Component
public class Adapter {

    public getVertexResponse vertexToVertexResponse(Vertex vertex) {
        return getVertexResponse.newBuilder()
                .setId(vertex.getId())
                .setLabel(vertex.getLabel())
                .putAllProperties(vertex.getProperties())
                .addAllOutgoingEdges(edgesToEdgesResponse(vertex.getOutgoingEdges()))
                .addAllIncomingEdges(edgesToEdgesResponse(vertex.getIncomingEdges()))
                .build();
    }

    public createVertexRequest vertexToCreateVertexRequest(Vertex vertex) {
        return createVertexRequest.newBuilder()
                .setId(vertex.getId())
                .setLabel(vertex.getLabel())
                .putAllProperties(vertex.getProperties())
                .addAllOutgoingEdges(edgesToEdgesResponse(vertex.getOutgoingEdges()))
                .addAllIncomingEdges(edgesToEdgesResponse(vertex.getIncomingEdges()))
                .build();
    }

    public Iterable<edge> edgesToEdgesResponse(Iterable<Edge> edges) {
        ArrayList<edge> edgesResponse = new ArrayList<>();
        for (Edge edgeCore : edges) {
            edge convertedEdge = edge.newBuilder().setDestinationVertexId(edgeCore.getDestinationVertexId())
                    .setLabel("")
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
        for (edge edgeResponse : vertexResponse.getOutgoingEdgesList()) {
            Edge edge = new Edge(edgeResponse.getDestinationVertexId());
            edge.setProperties(edgeResponse.getPropertiesMap());
            edge.setLabel(edgeResponse.getLabel());
            vertex.addOutgoingEdge(edge);
        }
        for (edge edgeResponse : vertexResponse.getIncomingEdgesList()) {
            Edge edge = new Edge(edgeResponse.getDestinationVertexId());
            edge.setProperties(edgeResponse.getPropertiesMap());
            edge.setLabel(edgeResponse.getLabel());
            vertex.addIncomingEdge(edge);
        }
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

}
