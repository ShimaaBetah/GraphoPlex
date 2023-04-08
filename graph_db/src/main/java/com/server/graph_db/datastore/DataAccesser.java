package com.server.graph_db.datastore;

import com.server.graph_db.vertex.Vertex;

public interface DataAccesser {
    
    public void saveVertex(Vertex vertex);
    public Vertex getVertex(String vertexId);
    public void deleteAllVertices();
    public void deleteVertex(String vertexId);
    public long countVertices();
    public Iterable<String> getAllVerticesIds();
    public Iterable<Vertex> getVerticesByIds(Iterable<String> ids);
    public Iterable<Vertex> getAllVertices();
}
