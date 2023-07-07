package com.server.graph_db.core.vertex;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Edge implements Serializable {

    private static final long serialVersionUID = 2539153322097838755L;
    String sourceVertexId;
    String destinationVertexId;
    String label;
    Map<String, String> properties;

    public Edge(String sourceVertexId, String destinationVertexId) {
        this.destinationVertexId = destinationVertexId;
        this.properties = new HashMap<String, String>();
        label = "";
        this.sourceVertexId = sourceVertexId;

    }

    @JsonCreator
    public Edge(@JsonProperty("destinationVertexId") String destinationVertexId,
            @JsonProperty("properties") HashMap<String, String> properties, @JsonProperty("label") String label,
            @JsonProperty("sourceVertexId") String sourceVertexId) {
        this.destinationVertexId = destinationVertexId;
        this.properties = properties;
        this.label = label;
        this.sourceVertexId = sourceVertexId;
    }

    public String getSourceVertexId() {
        return sourceVertexId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDestinationVertexId() {
        return destinationVertexId;
    }

    public void setDestinationVertexId(String destinationVertexId) {
        this.destinationVertexId = destinationVertexId;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            addProperty(entry.getKey(), entry.getValue());
        }
    }

    public void addProperty(String key, String value) {
        this.properties.put(key, value);
    }

    public void getSourceVertexId(String sourceVertexId) {
        this.sourceVertexId = sourceVertexId;
    }

    public void setSourceVertexId(String sourceVertexId) {
        this.sourceVertexId = sourceVertexId;
    }

    public String toString() {
    return sourceVertexId +" --"+label+"--> "+destinationVertexId+" "+properties.toString();
    }

    // overrid isEquals to be true if same source and destination vertex id and
    // label
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Edge.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Edge other = (Edge) obj;
        if ((this.sourceVertexId == null) ? (other.sourceVertexId != null)
                : !this.sourceVertexId.equals(other.sourceVertexId)) {
            return false;
        }
        if ((this.destinationVertexId == null) ? (other.destinationVertexId != null)
                : !this.destinationVertexId.equals(other.destinationVertexId)) {
            return false;
        }
        if ((this.label == null) ? (other.label != null) : !this.label.equals(other.label)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return sourceVertexId.hashCode() + destinationVertexId.hashCode() + label.hashCode();
    }

    public String getProperty(String fieldName) {
        return properties.get(fieldName);
    }

    public boolean isPropertyExist(String fieldName) {
        return properties.containsKey(fieldName);
    }

    public EdgeId getId() {
        return new EdgeId(sourceVertexId, destinationVertexId, label);
    }

}
