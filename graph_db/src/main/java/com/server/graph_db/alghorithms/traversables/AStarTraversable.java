package com.server.graph_db.alghorithms.traversables;

import com.server.graph_db.core.vertex.Edge;

public class AStarTraversable extends TraversableVertex implements Comparable<AStarTraversable>{

    long distance;
    Edge getPrecedingEdge;
    long heuristic;

    public AStarTraversable(String vertexId, long distance, Edge precedingEdge, long heuristic) {
        super(vertexId);
        this.distance = distance;
        this.getPrecedingEdge = precedingEdge;
        this.heuristic = heuristic;
    }

    public long getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(long heuristic) {
        this.heuristic = heuristic;
    }
    
    

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public Edge getPrecedingEdge() {
        return getPrecedingEdge;
    }

    public void setPrecedingEdge(Edge precedingEdge) {
        this.getPrecedingEdge = precedingEdge;
    }

   

    @Override
    public int compareTo(AStarTraversable o) {
        return Long.compare(this.distance + this.heuristic, o.distance + o.heuristic);
    }
    
    
    

}
    

