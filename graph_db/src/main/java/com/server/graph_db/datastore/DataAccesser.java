package com.server.graph_db.datastore;

import com.server.graph_db.vertex.Vertex;

public interface DataAccesser {
    
    public void saveVertex(Vertex vertex);
    public Vertex getVertex(int vertexId);
    public void deleteAllVertices();
    public long countVertices();
    public Iterable<Integer> getAllVerticesIds();
    public Iterable<Vertex> getVerticesByIds(Iterable<Integer> ids);
}
