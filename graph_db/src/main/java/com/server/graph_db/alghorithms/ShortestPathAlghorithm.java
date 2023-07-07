package com.server.graph_db.alghorithms;

import com.server.graph_db.core.vertex.Edge;

public interface ShortestPathAlghorithm {
    public void compute(String sourceVertexId, String destinationVertexId, String costField) throws Exception;
    public long getShortestPath();
    public Iterable <Edge> getPath() throws Exception;

}
