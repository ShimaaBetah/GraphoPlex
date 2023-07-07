package com.server.graph_db.alghorithms.heuristics;

import com.server.graph_db.core.vertex.Vertex;

public class Manhattan implements Hueristic{
    String x;
    String y;

    public Manhattan(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public long getHeuristic(Vertex source, Vertex destination) {
        
        String sourceX = source.getProperty(this.x);
        String sourceY = source.getProperty(this.y);
        String distnationX = destination.getProperty(this.x);
        String distnationY = destination.getProperty(this.y);

        long xDistance = Math.abs(Long.parseLong(sourceX) - Long.parseLong(distnationX));
        long yDistance = Math.abs(Long.parseLong(sourceY) - Long.parseLong(distnationY));
        return xDistance + yDistance;
    }
}
