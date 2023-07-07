package com.server.graph_db.query.match.shortestPath;

import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.query.Result;

public class ShortestPathResult extends Result {
    Iterable<Edge> path;
    public ShortestPathResult(Iterable<Edge> path, long cost) {
        this.path = path;
        setMessage("Shortest path cost: " + cost);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shortest path: ");
        for (Edge edge : path) {
            sb.append(edge.toString());
            sb.append(",");
        }

        sb.deleteCharAt(sb.length()-1);

        return sb.toString()+"\n\n" +super.toString();
    }
}
