package com.server.graph_db.exceptions.vertex;

public class VertexNotFoundException extends Exception {
    String vertexId;
    public VertexNotFoundException(String vertexId) {
        super("Vertex with id: " + vertexId + " not found");
   }
}
