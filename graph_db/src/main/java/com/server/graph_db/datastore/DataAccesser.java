package com.server.graph_db.datastore;

import java.util.Map;

import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.Vertex;

public interface DataAccesser {
    
    public void saveVertex(Vertex vertex);
    public Vertex getVertex(String vertexId);
    public void deleteAllVertices();
    public void deleteVertex(String vertexId);
    public long countVertices();
    public Iterable<String> getAllVerticesIds();
    public Iterable<Vertex> getVerticesByIds(Iterable<String> ids);
    public Iterable<Vertex> getAllVertices();
    public boolean isVertexExists(String vertexId);
    public boolean isEdgeExists(String sourceVertexId,String distinationVertexId,String label, boolean isOutgoing);
    public void saveEdge(Edge edge ,boolean isOutgoing);
    public void deleteEdge(String sourceVertexId,String distinationVertexId,String label, boolean isOutgoing);
    public Edge getEdge(String sourceVertexId,String distinationVertexId,String label, boolean isOutgoing);
    public Iterable<Edge> getEdges (String associatedVertex, boolean isOutgoing);
    public void deleteEdges (String associatedVertex, boolean isOutgoing);
}

