package com.server.graph_db.grpc.vertex;

import java.util.List;
import java.util.Map;

public interface GrpcVertex {
    public String getId();
    public String getLabel();
    public List<edge> getOutgoingEdgesList();
    public List<edge> getIncomingEdgesList();
    public Map<String, String> getPropertiesMap();
}
