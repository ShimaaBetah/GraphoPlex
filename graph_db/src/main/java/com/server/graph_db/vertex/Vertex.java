package com.server.graph_db.vertex;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@RedisHash("Vertex")

public class Vertex implements Serializable{

    private static final long serialVersionUID = 1762381042002279295L;

    String id;
    String label;
    LinkedList<Edge> outgoingEdges;
    LinkedList<Edge> incomingEdges;
    Map<String,String> properties;

    @JsonCreator
    public Vertex() {
        label = "";
        this.outgoingEdges = new LinkedList<>();
        this.properties = new HashMap<>();
        this.incomingEdges = new LinkedList<>();
    }



    public Vertex( String id) {
        this.id = id;
        label = "";
        this.outgoingEdges = new LinkedList<>();
        this.properties = new HashMap<>();
        this.incomingEdges = new LinkedList<>();
    }
    
    @JsonCreator
    public Vertex(@JsonProperty("id") String id,@JsonProperty("label") String label,  @JsonProperty("outgoingEdges") LinkedList<Edge> outgoingEdges, @JsonProperty("incomingEdges") LinkedList<Edge> incomingEdges, @JsonProperty("properties") HashMap<String, String> properties) {
        this.id = id;
        this.label = label;
        this.outgoingEdges = outgoingEdges;
        this.incomingEdges = incomingEdges;
        this.properties = properties;
    }

    public String getLabel(){
        return label;
    }

    public void setLabel(String label){
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LinkedList<Edge> getOutgoingEdges() {
        return outgoingEdges;
    }

    public void setOutgoingEdges(LinkedList<Edge> outgoingEdges) {
        this.outgoingEdges = outgoingEdges;
    }

    public void addOutgoingEdge(Edge edge) {
        this.outgoingEdges.add(edge);
    }
    
    public LinkedList<Edge> getIncomingEdges() {
        return incomingEdges;
    }

    public void setIncomingEdges(LinkedList<Edge> incomingEdges) {
        this.incomingEdges = incomingEdges;
    }

    public void addIncomingEdge(Edge edge) {
        this.incomingEdges.add(edge);
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public String toString() {
        return "Vertex [id=" + id + ", label=" + label + ", outgoingEdges=" + outgoingEdges + ", incomingEdges=" + incomingEdges + ", properties=" + properties + "]";
    }

    public boolean isPropertyExist (String key) {
        return properties.containsKey(key);
    }

    public String getProperty(String key) {
        return properties.get(key);
    }

    public void setProperty(String key, String value) {
        properties.put(key, value);
    }



}
