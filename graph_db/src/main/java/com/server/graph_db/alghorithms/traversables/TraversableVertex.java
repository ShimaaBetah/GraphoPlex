package com.server.graph_db.alghorithms.traversables;

public abstract class TraversableVertex {

    String vertexId;

    public TraversableVertex(String vertexId) {
        this.vertexId = vertexId;
    }

    public String getVertexId() {
        return vertexId;
    }

    public void setVertexId(String vertexId) {
        this.vertexId = vertexId;
    }
    
    
    
}
