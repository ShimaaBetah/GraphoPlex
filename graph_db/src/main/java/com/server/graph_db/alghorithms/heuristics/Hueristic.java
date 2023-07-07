package com.server.graph_db.alghorithms.heuristics;

import com.server.graph_db.core.vertex.Vertex;

public interface Hueristic {
    public long getHeuristic(Vertex source, Vertex destination);
    
}
