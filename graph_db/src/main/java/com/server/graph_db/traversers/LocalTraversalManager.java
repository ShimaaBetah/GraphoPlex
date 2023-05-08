package com.server.graph_db.traversers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.datastore.redis.RedisIndexDataManager;
import com.server.graph_db.index.LocalSecondaryIndexManager;
import com.server.graph_db.operators.select.SelectOperator;
import com.server.graph_db.traversers.bindings.EdgeBinding;
import com.server.graph_db.traversers.bindings.VertexBinding;
import com.server.graph_db.vertex.Edge;
import com.server.graph_db.vertex.EdgeId;
import com.server.graph_db.vertex.LocalVertexService;
import com.server.graph_db.vertex.Vertex;

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
                System.out.println("selectOperator: " + selectOperator.getFieldName());
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
                        if (!vertex.isPropertyExist(selectOperator.getFieldName())
                                || !vertex.getProperty(selectOperator.getFieldName())
                                        .equals(selectOperator.getFieldValue())) {
                                            
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
                    if (!vertex.isPropertyExist(selectOperator.getFieldName())
                            || !vertex.getProperty(selectOperator.getFieldName())
                                    .equals(selectOperator.getFieldValue())) {
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

    public Iterable<EdgeId> filterOutGoingEdges(Iterable<String> verticesIds, EdgeBinding edgeBinding) {
        Iterable<Edge> edgesToFilter = localVertexService.getOutGoingEdges(verticesIds);
        List<EdgeId> resultSet = new ArrayList<>();
        for (Edge edge : edgesToFilter) {
            boolean isEdgeValid = true;
            if (edgeBinding.getSelectOperators() != null) {
                for (SelectOperator selectOperator : edgeBinding.getSelectOperators()) {
                    if (!edge.isPropertyExist(selectOperator.getFieldName()) || !edge
                            .getProperty(selectOperator.getFieldName()).equals(selectOperator.getFieldValue())) {
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

    public Iterable<EdgeId> filterIncomingEdges(Iterable<String> verticesIds, EdgeBinding edgeBinding) {
        Iterable<Edge> edgesToFilter = localVertexService.getIncomingEdges(verticesIds);
        List<EdgeId> resultSet = new ArrayList<>();
        for (Edge edge : edgesToFilter) {
            boolean isEdgeValid = true;
            if (edgeBinding.getSelectOperators() != null) {
                for (SelectOperator selectOperator : edgeBinding.getSelectOperators()) {
                    if (!edge.isPropertyExist(selectOperator.getFieldName()) || !edge
                            .getProperty(selectOperator.getFieldName()).equals(selectOperator.getFieldValue())) {
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
        System.out.println("getNotIndexedSelectOperators");
        List<SelectOperator> notIndexedSelectOperators = new ArrayList<>();
        for (SelectOperator selectOperator : vertexBinding.getSelectOperators()) {
            if (!indexDataManager.isIndexExist(selectOperator.getFieldName())) {
                notIndexedSelectOperators.add(selectOperator);
            }
        }
        return notIndexedSelectOperators;
    }
}
