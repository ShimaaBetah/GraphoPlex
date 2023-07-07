package com.server.graph_db.core.traversers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.core.index.LocalSecondaryIndexManager;
import com.server.graph_db.core.operators.select.SelectOperator;
import com.server.graph_db.core.traversers.bindings.EdgeBinding;
import com.server.graph_db.core.traversers.bindings.VertexBinding;
import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.EdgeId;
import com.server.graph_db.core.vertex.LocalVertexService;
import com.server.graph_db.core.vertex.Vertex;
import com.server.graph_db.datastore.redis.RedisIndexDataManager;

@Component
public class LocalTraversalManager {

    @Autowired
    LocalVertexService localVertexService;

    @Autowired
    LocalSecondaryIndexManager localSecondaryIndexManager;

    @Autowired
    RedisIndexDataManager indexDataManager;

    public Iterable<String> getVertices(VertexBinding vertexBinding) throws Exception {
        if (vertexBinding.isAnonymous()) {
            return localVertexService.getAllVerticesIds();
        }
        // if have specific id
        if (vertexBinding.hasId()) {
            List<String> verticesIds = new ArrayList<>();
            try{
                localVertexService.getVertex(vertexBinding.getId());
                verticesIds.add(vertexBinding.getId());
                return verticesIds;
            }catch(Exception e) {
                return verticesIds;
            }
        }

        Iterable<String> verticesIds = null;
        List<String> resultSet = new ArrayList<>();
        if (vertexBinding.getLabel() != null) {
            verticesIds = indexDataManager.getVerticesIdsFromIndex("label", vertexBinding.getLabel());
        }

        if (vertexBinding.getSelectOperators() != null) {
            for (SelectOperator selectOperator : getIndexedSelectOPerators(vertexBinding)) {
                if (verticesIds == null) {
                    verticesIds = selectOperator.execute();
                } else {
                    verticesIds = selectOperator.filterVertices(verticesIds);
                }
            }
            if(verticesIds == null) {
                verticesIds = localVertexService.getAllVerticesIds();
            }
            for (String vertexId : verticesIds) {
                Vertex vertex = localVertexService.getVertex(vertexId);
                boolean isVertexValid = true;
                if (vertexBinding.getSelectOperators() != null) {
                    for (SelectOperator selectOperator : getNotIndexedSelectOperators(vertexBinding)) {
                        if (!selectOperator.isVertexValid(vertex)) {
                                            
                            isVertexValid = false;
                            break;
                        }
                    }
                }
                if (vertexBinding.getLabel() != null && !vertex.getLabel().equals(vertexBinding.getLabel())) {
                    isVertexValid = false;
                }
                if (isVertexValid) {
                    resultSet.add(vertexId);
                }
            }

        }
        return resultSet;
    }

    public Iterable<String> filterVertices(Iterable<String> verticesIds, VertexBinding vertexBinding) throws Exception {

        Iterable<Vertex> verticesToFilter = localVertexService.getVerticesByIds(verticesIds);
        List<String> resultSet = new ArrayList<>();
        for (Vertex vertex : verticesToFilter) {
            boolean isVertexValid = true;
            if (vertexBinding.getSelectOperators() != null) {
                for (SelectOperator selectOperator : vertexBinding.getSelectOperators()) {
                    if (!selectOperator.isVertexValid(vertex)) {
                        isVertexValid = false;
                        break;
                    }
                }
            }
            if (vertexBinding.getLabel() != null && !vertex.getLabel().equals(vertexBinding.getLabel())) {
                isVertexValid = false;
            }
            if(vertexBinding.hasId() && !vertex.getId().equals(vertexBinding.getId())) {
                isVertexValid = false;
            }
            if (isVertexValid) {
                resultSet.add(vertex.getId());
            }
        }
        return resultSet;
    }

    public Iterable<EdgeId> filterOutGoingEdges(Iterable<String> verticesIds, EdgeBinding edgeBinding) throws Exception {
        Iterable<Edge> edgesToFilter = localVertexService.getOutgoingEdges(verticesIds);
        List<EdgeId> resultSet = new ArrayList<>();
        for (Edge edge : edgesToFilter) {
            boolean isEdgeValid = true;
            if (edgeBinding.getSelectOperators() != null) {
                for (SelectOperator selectOperator : edgeBinding.getSelectOperators()) {
                    if (!selectOperator.isEdgeValid(edge)) {
                        isEdgeValid = false;
                        break;
                    }
                }
            }
            if (edgeBinding.getLabel() != null && !edge.getLabel().equals(edgeBinding.getLabel())) {
                isEdgeValid = false;
            }
            if (isEdgeValid) {
                resultSet.add(new EdgeId(edge.getSourceVertexId(), edge.getDestinationVertexId(), edge.getLabel()));
            }
        }
        return resultSet;
    }

    public Iterable<EdgeId> filterIncomingEdges(Iterable<String> verticesIds, EdgeBinding edgeBinding) throws Exception {
        Iterable<Edge> edgesToFilter = localVertexService.getIncomingEdges(verticesIds);
        List<EdgeId> resultSet = new ArrayList<>();
        for (Edge edge : edgesToFilter) {
            boolean isEdgeValid = true;
            if (edgeBinding.getSelectOperators() != null) {
                for (SelectOperator selectOperator : edgeBinding.getSelectOperators()) {
                    if (!selectOperator.isEdgeValid(edge)) {
                        isEdgeValid = false;
                        break;
                    }
                }
            }
            if (edgeBinding.getLabel() != null && !edge.getLabel().equals(edgeBinding.getLabel())) {
                isEdgeValid = false;
            }
            if (isEdgeValid) {
                resultSet.add(new EdgeId(edge.getSourceVertexId(), edge.getDestinationVertexId(), edge.getLabel()));
            }
        }
        return resultSet;
    }

    public boolean isAllIndexed(VertexBinding vertexBinding) {
        for (SelectOperator selectOperator : vertexBinding.getSelectOperators()) {
            if (!indexDataManager.isIndexExist(selectOperator.getFieldName())) {
                return false;
            }
        }
        return true;
    }

    public Iterable<SelectOperator> getIndexedSelectOPerators(VertexBinding vertexBinding) {
        List<SelectOperator> indexedSelectOperators = new ArrayList<>();
        for (SelectOperator selectOperator : vertexBinding.getSelectOperators()) {
            if (indexDataManager.isIndexExist(selectOperator.getFieldName())) {
                indexedSelectOperators.add(selectOperator);
            }
        }
        return indexedSelectOperators;
    }

    public List<SelectOperator> getNotIndexedSelectOperators(VertexBinding vertexBinding) {
        List<SelectOperator> notIndexedSelectOperators = new ArrayList<>();
        for (SelectOperator selectOperator : vertexBinding.getSelectOperators()) {
            if (!indexDataManager.isIndexExist(selectOperator.getFieldName())) {
                notIndexedSelectOperators.add(selectOperator);
            }
        }
        return notIndexedSelectOperators;
    }
}
