package com.server.graph_db.vertex;

import java.util.LinkedList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.exceptions.VertexAlreadyExistsException;
import com.server.graph_db.exceptions.VertexNotFoundException;
import com.server.graph_db.index.LocalSecondaryIndexManager;

@Component
public class LocalVertexService implements VertexService {

    @Autowired
    private VertexRepositoryImpl vertexRepository;

    @Autowired
    private LocalSecondaryIndexManager localSecondaryIndexManager;

    public LocalVertexService(VertexRepositoryImpl vertexRepository,
            LocalSecondaryIndexManager localSecondaryIndexManager) {
        this.vertexRepository = vertexRepository;
        this.localSecondaryIndexManager = localSecondaryIndexManager;
    }

    public Vertex getVertex(String id) throws VertexNotFoundException {
        Vertex vertex = vertexRepository.findById(id).orElse(null);
        if (vertex == null) {
            throw new VertexNotFoundException(id);
        }
        return vertex;

    }

    public Iterable<Vertex> getAllVertices() {
        return vertexRepository.findAll();
    }

    public void addVertex(Vertex vertex) throws VertexAlreadyExistsException{
        if (vertexRepository.existsById(vertex.getId())) {
            throw new VertexAlreadyExistsException(vertex.getId());
        }
        localSecondaryIndexManager.addVertexToIndices(vertex);
        vertexRepository.save(vertex);
    }

    public void addEdge(String id, Edge edge) throws VertexNotFoundException {
        // check that source vertex exists
        if (vertexRepository.existsById(id)) {
            vertexRepository.addEdge(id, edge);
        } else {
            throw new VertexNotFoundException(id);
        }

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

    @Override
    public void deleteEdge(String sourceVertexId, String destinationVertexId, String label) throws VertexNotFoundException{
         // check that source vertex exists
        if (vertexRepository.existsById(sourceVertexId)) {
            vertexRepository.deleteEdge(sourceVertexId, destinationVertexId, label);
        } else {
            throw new VertexNotFoundException(sourceVertexId);
        }
    }

    @Override
    public void updateEdge(String sourceVertexId, String destinationVertexId, String label, Map<String, String> properties) throws VertexNotFoundException{
                 // check that source vertex exists
                 if (vertexRepository.existsById(sourceVertexId)) {
                     vertexRepository.updateEdge(sourceVertexId, destinationVertexId, label, properties);
                } else {
                    throw new VertexNotFoundException(sourceVertexId);
                }
    }
}
