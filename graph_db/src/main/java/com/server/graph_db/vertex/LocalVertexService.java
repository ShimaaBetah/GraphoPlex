package com.server.graph_db.vertex;

import java.util.LinkedList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.index.LocalSecondaryIndexManager;



@Component
public class LocalVertexService implements VertexService {
    
    @Autowired
    private VertexRepositoryImpl vertexRepository ;

    @Autowired
    private LocalSecondaryIndexManager localSecondaryIndexManager;


    public LocalVertexService(VertexRepositoryImpl vertexRepository, LocalSecondaryIndexManager localSecondaryIndexManager) {
        this.vertexRepository = vertexRepository;
        this.localSecondaryIndexManager = localSecondaryIndexManager;
    }





    public Vertex getVertex(String id) {
        // if vertex is null return null
       return  vertexRepository.findById(id).orElse(null);

    }

    public Iterable<Vertex> getAllVertices() {
        return vertexRepository.findAll();
    }

    public void addVertex(Vertex vertex) {
        localSecondaryIndexManager.addVertexToIndices(vertex);
        vertexRepository.save(vertex);  
    }

    public void addEdge(String id, Edge edge) {
        edge.setSourceVertexId(id);
        Vertex vertex = vertexRepository.findById(id).get();
        vertex.addOutgoingEdge(edge);
        vertexRepository.save(vertex);
        
    }

    public void deleteAll() {
        vertexRepository.deleteAll();
    }

    public LinkedList<Edge> getEdges(String vertexId) {
        return null;
    }

    public long getVertexCount() {
        return vertexRepository.count();
    }

    public Iterable<String> getAllVerticesIds() {
        return vertexRepository.getAllVerticesIds();
    }

    public Iterable<Vertex> getVerticesByIds(Iterable<String> ids) {
        return vertexRepository.findAllById(ids);
    }

    @Override
    public void deleteVertex(String id) {
        
        vertexRepository.deleteById(id);
    }

    @Override
    public void updateVertex(String id, String label, Map<String, String> properties) {
        vertexRepository.updateVertex(id, label, properties);
    }


    @Override
    public void updateVertex(String id, Map<String, String> properties) {
        vertexRepository.updateVertex(id, properties);
    }
}
