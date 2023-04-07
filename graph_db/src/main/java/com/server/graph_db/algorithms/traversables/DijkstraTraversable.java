package com.server.graph_db.algorithms.traversables;

public class DijkstraTraversable extends TraversableVertex {
     long distance;
     String parentId;

    public DijkstraTraversable(String vertexId, long distance, String parentId) {
        super(vertexId);
        this.distance = distance;
        this.parentId = parentId;
    }

    public long getDistance(){
        return distance;
    }

    public String getParentId(){
        return parentId;
    }

    @Override
    public int compareTo(TraversableVertex other) {
        return Long.compare(this.distance, ((DijkstraTraversable)other).distance);
    }

   
    
}
