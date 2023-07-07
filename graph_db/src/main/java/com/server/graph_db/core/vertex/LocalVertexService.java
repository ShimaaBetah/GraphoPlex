package com.server.graph_db.core.vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.core.exceptions.vertex.VertexAlreadyExistsException;
import com.server.graph_db.core.exceptions.vertex.VertexNotFoundException;
import com.server.graph_db.core.index.LocalSecondaryIndexManager;

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

    public void createVertex(Vertex vertex) throws VertexAlreadyExistsException {
        if (vertexRepository.existsById(vertex.getId())) {
            throw new VertexAlreadyExistsException(vertex.getId());
        }
        localSecondaryIndexManager.addVertexToIndices(vertex);
        vertexRepository.save(vertex);
    }

    public void addEdge(String id, Edge edge, boolean isOutgoing) throws VertexNotFoundException {
        System.out.println("addEdge"+ edge);
        // check that source vertex exists
        if (isOutgoing && vertexRepository.existsById(id)) {
            vertexRepository.addEdge(edge, isOutgoing);
        } else if (!isOutgoing && vertexRepository.existsById(edge.getDestinationVertexId())) {
            vertexRepository.addEdge(edge, isOutgoing);
        } else {
            String vertexId = isOutgoing ? id : edge.getDestinationVertexId();
            throw new VertexNotFoundException(vertexId);
        }

    }

    public void deleteAll() {
        vertexRepository.deleteAll();
    }

    public Iterable<Edge> getOutgoingEdges(String vertexId) {
        return vertexRepository.getEdges(vertexId, true);
    }

    public Iterable<Edge> getIncomingEdges(String vertexId) {
        return vertexRepository.getEdges(vertexId, false);
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
    public void updateVertex(String id, String label, Map<String, String> properties)  {
        Vertex vertex = vertexRepository.findById(id).orElse(null);
        if (vertex == null) {
            return;
        }
        localSecondaryIndexManager.updateVertexInIndices(vertex,properties);
        vertexRepository.updateVertex(id, label, properties);
    }

    @Override
    public void updateVertex(String id, Map<String, String> properties)  {
        Vertex vertex = vertexRepository.findById(id).orElse(null);
        if (vertex == null) {
            return;
        }
        vertexRepository.updateVertex(id, properties);
        localSecondaryIndexManager.updateVertexInIndices(vertex,properties);

    }

    public void deleteEdge(String sourceVertexId, String destinationVertexId, String label, boolean isOutgoing)
            throws VertexNotFoundException {
        // check that source vertex exists
        if (isOutgoing && vertexRepository.existsById(sourceVertexId)) {
            vertexRepository.deleteEdge(sourceVertexId, destinationVertexId, label, isOutgoing);
        } else if (!isOutgoing && vertexRepository.existsById(destinationVertexId)) {
            vertexRepository.deleteEdge(sourceVertexId, destinationVertexId, label, isOutgoing);
        } else {
            
            throw new VertexNotFoundException(sourceVertexId);
        }
    }

    public void updateEdge(String sourceVertexId, String destinationVertexId, String label,
            Map<String, String> properties, boolean isOutgoing) throws VertexNotFoundException {
        // check that source vertex exists
        if (isOutgoing && vertexRepository.existsById(sourceVertexId) ) {
            vertexRepository.updateEdge(sourceVertexId, destinationVertexId, label, properties, isOutgoing);
        } else if (!isOutgoing && vertexRepository.existsById(destinationVertexId)) {
            vertexRepository.updateEdge(sourceVertexId, destinationVertexId, label, properties, isOutgoing);
        } else {
            throw new VertexNotFoundException(sourceVertexId);
        }
    }



    @Override
    public Iterable<Edge> getEdgesById(Iterable<EdgeId> edgeIds) {
        List<Edge> edges = new ArrayList<>();
        for (EdgeId edgeId : edgeIds) {
            Edge edge = vertexRepository.getEdgeById(edgeId.getSourceId(), edgeId.getdestinationId(),
                    edgeId.getLabel());
            edges.add(edge);
        }
        return edges;
        
    }

    @Override
    public Iterable<Edge> getOutgoingEdges(Iterable<String> verticesIds) throws Exception {
          List<Edge> edges = new ArrayList<>();
            for (String vertexId : verticesIds) {
                List<Edge> vertexEdges = (List<Edge>) getOutgoingEdges(vertexId);
                edges.addAll(vertexEdges);
            }

            return edges;
    }

    @Override
    public Iterable<Edge> getIncomingEdges(Iterable<String> verticesIds) throws Exception {
        List<Edge> edges = new ArrayList<>();
        for (String vertexId : verticesIds) {
            List<Edge> vertexEdges = (List<Edge>) getIncomingEdges(vertexId);
            edges.addAll(vertexEdges);
        }

        return edges;
    }

}
