package com.server.graph_db.core.vertex;

public class EdgeId {
    
    String sourceId;
    String destinationId;
    String label;

    public EdgeId(String sourceId, String targetId, String label) {
        this.sourceId = sourceId;
        this.destinationId = targetId;
        this.label = label;
    }

    public String getSourceId() {
        return sourceId;
    }

    public String getdestinationId() {
        return destinationId;
    }

    public String getLabel() {
        return label;
    }

    public String toString() {
        return "sourceId: " + sourceId + " destinationId: " + destinationId + " label: " + label + "\n";
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof EdgeId) {
            EdgeId edgeId = (EdgeId) o;
            return edgeId.sourceId.equals(sourceId) && edgeId.destinationId.equals(destinationId)
                    && edgeId.label.equals(label);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return sourceId.hashCode() + destinationId.hashCode() + label.hashCode();
    }
}
