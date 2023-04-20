package com.server.graph_db.vertex;

import java.util.LinkedList;
import java.util.Map;

import com.server.graph_db.exceptions.vertex.VertexAlreadyExistsException;
import com.server.graph_db.exceptions.vertex.VertexNotFoundException;

public interface VertexService {
    
    public Vertex getVertex(String id) throws VertexNotFoundException;
    public void addVertex(Vertex vertex) throws VertexAlreadyExistsException;
    public void addEdge(String id, Edge edge) throws Exception;
    public void deleteEdge (String id, String distinationVertexId, String label)throws Exception;
    public void updateEdge (String id, String distinationVertexId, String label, Map<String, String> properties) throws Exception;
    public void deleteAll();
    public LinkedList<Edge> getEdges(String vertexId);
    public long getVertexCount();
    public Iterable<String> getAllVerticesIds();
    public Iterable<Vertex> getVerticesByIds(Iterable<String> ids);
    public void deleteVertex(String id);
    public void updateVertex(String id, String label , Map<String, String> properties);
    public void updateVertex (String id , Map<String, String> properties);


}
