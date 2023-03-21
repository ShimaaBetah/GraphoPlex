package com.server.graph_db.vertex;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@RedisHash("Vertex")
@Data
public class Vertex implements Serializable{

    private static final long serialVersionUID = 1762381042002279295L;

    int id;
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



    public Vertex( int id) {
        this.id = id;
        label = "";
        this.outgoingEdges = new LinkedList<>();
        this.properties = new HashMap<>();
        this.incomingEdges = new LinkedList<>();
    }
    
    @JsonCreator
    public Vertex(@JsonProperty("id") int id,@JsonProperty("label") String label,  @JsonProperty("outgoingEdges") LinkedList<Edge> outgoingEdges, @JsonProperty("incomingEdges") LinkedList<Edge> incomingEdges, @JsonProperty("properties") HashMap<String, String> properties) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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



}
