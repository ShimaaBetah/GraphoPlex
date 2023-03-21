package com.server.graph_db.vertex;
import java.io.Serializable;


import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Edge implements Serializable {


    private static final long serialVersionUID = 2539153322097838755L;
    int sourceVertexId;
    int destinationVertexId;
    String label;
    Map<String,String> properties;

    
    public Edge( int destinationVertexId) {
        this.destinationVertexId = destinationVertexId;
        this.properties = new HashMap<String, String>();
        label ="";

    }
    
    @JsonCreator
    public Edge(@JsonProperty("destinationVertexId")int destinationVertexId, @JsonProperty("properties")HashMap<String, String> properties, @JsonProperty("label")String label) {
        this.destinationVertexId = destinationVertexId;
        this.properties = properties;
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

    public void setLabel(String label){
        this.label = label;
    }

    public int getDestinationVertexId() {
        return destinationVertexId;
    }

    public void setDestinationVertexId(int destinationVertexId) {
        this.destinationVertexId = destinationVertexId;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public void addProperty(String key, String value) {
        this.properties.put(key, value);
    }
    public void getSourceVertexId(int sourceVertexId) {
        this.sourceVertexId = sourceVertexId;
    }
    public void setSourceVertexId(int sourceVertexId) {
        this.sourceVertexId = sourceVertexId;
    }
}
