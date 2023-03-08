package com.server.graph_db.vertex;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@RedisHash("Vertex")
public class Vertex implements Serializable{
    int id;
    LinkedList<Edge> outgoingEdges;
    LinkedList<Edge> incomingEdges;
    HashMap<String,String> properties;


    @JsonCreator
    public Vertex( @JsonProperty int id) {
        this.id = id;
        this.outgoingEdges = new LinkedList<>();
        this.properties = new HashMap<>();
        this.incomingEdges = new LinkedList<>();
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

    public HashMap<String, String> getProperties() {
        return properties;
    }


}
