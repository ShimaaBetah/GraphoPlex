package com.server.graph_db.alghorithms.traversables;

import com.server.graph_db.core.vertex.Edge;

public class DijkstraTraversable extends TraversableVertex implements Comparable<TraversableVertex> {
     long distance;
     Edge precedingEdge;

    public DijkstraTraversable(String vertexId, long distance, Edge precedingEdge) {
        super(vertexId);
        this.distance = distance;
        this.precedingEdge = precedingEdge;
    }

    public long getDistance(){
        return distance;
    }

    public Edge getPrecedingEdge(){
        return precedingEdge;
    }
    @Override
    public int compareTo(TraversableVertex other) {
        return Long.compare(this.distance, ((DijkstraTraversable)other).distance);
    }

   
    
}
