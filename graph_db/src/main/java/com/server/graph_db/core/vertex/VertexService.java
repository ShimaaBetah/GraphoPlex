package com.server.graph_db.core.vertex;

import java.util.LinkedList;
import java.util.Map;

import com.server.graph_db.core.exceptions.vertex.VertexAlreadyExistsException;
import com.server.graph_db.core.exceptions.vertex.VertexNotFoundException;

public interface VertexService {
    
    public Vertex getVertex(String id) throws VertexNotFoundException;
    public void createVertex(Vertex vertex) throws VertexAlreadyExistsException;
   
    public void deleteAll();
    public Iterable<Edge> getOutgoingEdges(String vertexId) throws Exception;
    public Iterable<Edge> getIncomingEdges(String vertexId) throws Exception;
    public long getVertexCount();
    public Iterable<String> getAllVerticesIds();
    public Iterable<Vertex> getVerticesByIds(Iterable<String> ids);
    public void deleteVertex(String id);
    public void updateVertex(String id, String label , Map<String, String> properties);
    public void updateVertex (String id , Map<String, String> properties);
    public Iterable<Edge> getEdgesById(Iterable<EdgeId> edgeIds) throws Exception;
    public Iterable<Edge> getOutgoingEdges(Iterable<String> vertexId) throws Exception;
    public Iterable<Edge> getIncomingEdges(Iterable<String> vertexId)throws Exception;



}
