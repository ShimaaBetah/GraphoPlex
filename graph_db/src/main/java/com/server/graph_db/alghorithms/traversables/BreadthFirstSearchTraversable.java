package com.server.graph_db.alghorithms.traversables;

import java.util.ArrayList;
import java.util.Set;

import com.server.graph_db.core.vertex.EdgeId;

public class BreadthFirstSearchTraversable extends TraversableVertex {
    ArrayList<AliasedVertex> aliasedVertices;
    ArrayList<AliasedEdge> aliasedEdges;

    public BreadthFirstSearchTraversable(String vertexId) {
        super(vertexId);
        aliasedVertices = new ArrayList<>();
        aliasedEdges = new ArrayList<>();
    }

    public void addAliasedVertex(String vertexId, String alias) {
        AliasedVertex aliasedVertex = new AliasedVertex(vertexId);
        aliasedVertex.setAlias(alias);
        aliasedVertices.add(aliasedVertex);

    }

    public void addAliasedVertex(String vertexId) {
        aliasedVertices.add(new AliasedVertex(vertexId));
    }

    public void addAliasedEdge(String alias, EdgeId edgeId) {
        AliasedEdge aliasedEdge = new AliasedEdge(edgeId);
        aliasedEdge.setAlias(alias);
        aliasedEdges.add(aliasedEdge);
    }

    public ArrayList<AliasedVertex> getAliasedVertices() {
        return aliasedVertices;
    }

    public ArrayList<AliasedEdge> getAliasedEdges() {
        return aliasedEdges;
    }

    public void setAliasedVertices(ArrayList<AliasedVertex> aliasedVertices) {
        for (AliasedVertex aliasedVertex : aliasedVertices) {
            this.aliasedVertices.add(aliasedVertex);
        }
    }

    public void setAliasedEdges(ArrayList<AliasedEdge> aliasedEdges) {
        for (AliasedEdge aliasedEdge : aliasedEdges) {
            this.aliasedEdges.add(aliasedEdge);
        }
    }

    public Iterable<AliasedVertex> aliasedVertices(Set<String> aliases) {
        ArrayList<AliasedVertex> result = new ArrayList<>();
        for (AliasedVertex aliasedVertex : aliasedVertices) {

            if (aliases.contains(aliasedVertex.getAlias())) {
                result.add(aliasedVertex);
            }
        }
        return result;
    }

    public Iterable<AliasedEdge> aliasedEdges(Set<String> aliases) {
        ArrayList<AliasedEdge> result = new ArrayList<>();
        for (AliasedEdge aliasedEdge : aliasedEdges) {
            if (aliases.contains(aliasedEdge.getAlias())) {
                result.add(aliasedEdge);
            }
        }
        return result;
    }

    public static class AliasedVertex {
        String vertexId;
        String alias;

        public AliasedVertex(String vertexId) {
            this.vertexId = vertexId;
        }

        public String getVertexId() {
            return vertexId;
        }

        public String getAlias() {
            return alias;
        }

        public void setVertexId(String vertexId) {
            this.vertexId = vertexId;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String toString() {
            return "vertexId: " + vertexId + " alias: " + alias + "\n";
        }

    }

    public static class AliasedEdge {
        String alias;
        EdgeId edgeId;

        public AliasedEdge(EdgeId edgeId) {
            this.edgeId = edgeId;
        }

        public String getAlias() {
            return alias;
        }

        public EdgeId getEdgeId() {
            return edgeId;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public void setEdgeId(EdgeId edgeId) {
            this.edgeId = edgeId;
        }

        public String toString() {
            return "alias: " + alias + " edgeId: " + edgeId + "\n";
        }

    }

    public void addAliasedEdge(EdgeId edge) {
        aliasedEdges.add(new AliasedEdge(edge));
    }

    public String toString() {
        String result = "vertexId: " + vertexId + "\n";
        result += "aliasedVertices: \n";
        for (AliasedVertex aliasedVertex : aliasedVertices) {
            result += aliasedVertex.toString();
        }
        result += "aliasedEdges: \n";
        for (AliasedEdge aliasedEdge : aliasedEdges) {
            result += aliasedEdge.toString();
        }
        return result;
    }

}
