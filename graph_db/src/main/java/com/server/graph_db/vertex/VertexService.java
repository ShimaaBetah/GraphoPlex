package com.server.graph_db.vertex;

import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class VertexService {
    
    @Autowired
    private VertexRepositoryImpl vertexRepository ;


    public VertexService(VertexRepositoryImpl vertexRepository) {
        this.vertexRepository = vertexRepository;
    }





    public Vertex getVertex(int id) {
        return vertexRepository.findById(id).get();
    }

    public void addVertex(Vertex vertex) {
          vertexRepository.save(vertex);  
    }

    public void addEdge(int id, Edge edge) {
        edge.setSourceVertexId(id);
        Vertex vertex = vertexRepository.findById(id).get();
        vertex.addOutgoingEdge(edge);
        vertexRepository.save(vertex);
        
    }

    public LinkedList<Edge> getEdges(int vertixId) {
        return null;
    }
}
