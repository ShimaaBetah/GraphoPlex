package com.server.graph_db.query.match.path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.server.graph_db.alghorithms.traversables.BreadthFirstSearchTraversable;
import com.server.graph_db.alghorithms.traversables.BreadthFirstSearchTraversable.AliasedEdge;
import com.server.graph_db.alghorithms.traversables.BreadthFirstSearchTraversable.AliasedVertex;
import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.EdgeId;
import com.server.graph_db.core.vertex.GlobalVertexService;
import com.server.graph_db.core.vertex.Vertex;

public class ReturnClause {

    ArrayList<ReturnedValue> returnedValues;
    List<BreadthFirstSearchTraversable> pathReturned;
    GlobalVertexService globalVertexService;
    Set<String> aliases;
    Set<String> verticesIdsNeeded = new HashSet<>();
    Set<EdgeId> edgesIdsNeeded = new HashSet<>();
    HashMap<String, Vertex> verticesMap = new HashMap<>();
    HashMap<EdgeId, Edge> edgesMap = new HashMap<>();
    
    public ReturnClause() {
        this.returnedValues = new ArrayList<>();
    }

    public void addReturnedValue(ReturnedValue returnedValue) {
        returnedValues.add(returnedValue);
    }

    public ArrayList<ReturnedValue> getReturnedValues() {
        return returnedValues;
    }

    public void setGlobalVertexService(GlobalVertexService globalVertexService) {
        this.globalVertexService = globalVertexService;
    }

    public Set<String> getAliases() {
        Set<String> aliases = new HashSet<>();
        for (ReturnedValue returnedValue : returnedValues) {
            aliases.add(returnedValue.getAlias());
        }
        return aliases;
    }

    public void setPathReturned(List<BreadthFirstSearchTraversable> pathReturned) {
        this.pathReturned = pathReturned;
    }

    public ReturnClause execute() throws Exception {
        aliases = getAliases();
        setVerticesAndEdgesIdsNeeded();
        getNeededVerticesAndEdges();

        return  this;

    }

    public PathResult generatePathResult() {
        ArrayList<String> columns = new ArrayList<>();
        ArrayList<String[]> rows = new ArrayList<>();
        for (ReturnedValue returnedValue : returnedValues) {
            columns.add(returnedValue.toString());
        }

        // loop through path returned
        for (BreadthFirstSearchTraversable traversable : pathReturned) {
            // loop through the aliased vertices
            String[] row = new String[columns.size()];
            for (AliasedVertex aliasedVertex : traversable.aliasedVertices(aliases)) {
                // loop through the returned values
                for (int i = 0; i < returnedValues.size(); i++) {
                    ReturnedValue returnedValue = returnedValues.get(i);
                    if (returnedValue.getAlias().equals(aliasedVertex.getAlias())) {
                        Vertex vertex = verticesMap.get(aliasedVertex.getVertexId());
                        if (returnedValue.fieldName.equals("id")) {
                            row[i] = vertex.getId();
                        } else if (returnedValue.fieldName.equals("label")) {
                            row[i] = vertex.getLabel();
                        } else if (!returnedValue.fieldName.isEmpty()) {
                            row[i] = vertex.getProperty(returnedValue.fieldName);
                        } else {
                            row[i] = vertex.toString();
                        }
                    }
                }

            }

            // loop through the aliased edges
            for (AliasedEdge aliasedEdge : traversable.aliasedEdges(aliases)) {
                // loop through the returned values
                for (int i = 0; i < returnedValues.size(); i++) {
                    ReturnedValue returnedValue = returnedValues.get(i);
                    if (returnedValue.getAlias().equals(aliasedEdge.getAlias())) {
                        Edge edge = edgesMap.get(aliasedEdge.getEdgeId());
                         if (returnedValue.fieldName.equals("label")) {
                            row[i] = edge.getLabel();
                        } else if (!returnedValue.fieldName.isEmpty()) {
                            row[i] = edge.getProperty(returnedValue.fieldName);
                        } else {
                            row[i] = edge.toString();
                        }
                    }
                }
            }

            

            rows.add(row);
        }
        PathResult pathResult = new PathResult(columns, rows);
        return pathResult;
    }

    private void getNeededVerticesAndEdges() throws Exception {
        Iterable<Vertex> vertices = globalVertexService.getVerticesByIds(verticesIdsNeeded);
        Iterable<Edge> edges = globalVertexService.getEdgesById(edgesIdsNeeded);
        for (Vertex vertex : vertices) {
            verticesMap.put(vertex.getId(), vertex);
        }
        for (Edge edge : edges) {
            edgesMap.put(edge.getId(), edge);
        }
    }

    private void setVerticesAndEdgesIdsNeeded() {
        for (BreadthFirstSearchTraversable traversable : pathReturned) {
            // add aliased vertices to verticesIdsNeeded
            Iterable<AliasedVertex> aliasedVertices = traversable.aliasedVertices(aliases);
            
            for (AliasedVertex vertex : aliasedVertices) {
                verticesIdsNeeded.add(vertex.getVertexId());
            }
            // add aliased edges to edgesIdsNeeded
            Iterable<AliasedEdge> aliasedEdges = traversable.aliasedEdges(aliases);
            for (AliasedEdge edge : aliasedEdges) {
                edgesIdsNeeded.add(edge.getEdgeId());
            }
        }

        System.out.println("verticesIdsNeeded: " + verticesIdsNeeded.size());
    }

    public static class ReturnedValue {
        String alias;
        String fieldName="";

        public ReturnedValue(String alias) {
            this.alias = alias;
        }

        public String getAlias() {
            return alias;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String toString() {
            return fieldName.isEmpty() ? alias : alias + "." + fieldName;
        }
    }
}
