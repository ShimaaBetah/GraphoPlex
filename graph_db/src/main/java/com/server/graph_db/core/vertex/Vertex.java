package com.server.graph_db.core.vertex;

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
    Map<String,String> properties;

    @JsonCreator
    public Vertex() {
        label = "";
        this.properties = new HashMap<>();
    }



    public Vertex( String id) {
        this.id = id;
        label = "";
        this.properties = new HashMap<>();
    }
    
    @JsonCreator
    public Vertex(@JsonProperty("id") String id,@JsonProperty("label") String label, @JsonProperty("properties") HashMap<String, String> properties) {
        this.id = id;
        this.label = label;
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



    
    
    



    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            setProperty(entry.getKey(), entry.getValue());
        }
    }

    public String toString() {
        return "Vertex [id=" + id + ", label=" + label +  ", properties=" + properties + "]";
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
