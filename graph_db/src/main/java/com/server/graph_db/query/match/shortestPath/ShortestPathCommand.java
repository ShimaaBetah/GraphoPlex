package com.server.graph_db.query.match.shortestPath;

import com.server.graph_db.alghorithms.Dijkstra;
import com.server.graph_db.alghorithms.ShortestPathAlghorithm;
import com.server.graph_db.core.traversers.GlobalTraverserManager;
import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.GlobalVertexService;
import com.server.graph_db.query.match.MatchCommand;

public class ShortestPathCommand extends MatchCommand {
    String sourceVertexId;
    String destinationVertexId;
    String costField;
    GlobalVertexService globalVertexService;
    GlobalTraverserManager globalTraverserManager;
    ShortestPathAlghorithm shortestPathAlghorithm;
    

    public ShortestPathCommand(ShortestPathAlghorithm shortestPathAlghorithm, String sourceVertexId, String destinationVertexId, String costField) {
        this.shortestPathAlghorithm = shortestPathAlghorithm;
        this.sourceVertexId = sourceVertexId;
        this.destinationVertexId = destinationVertexId;
        this.costField = costField;
    }

    public String getSourceVertexId() {
        return sourceVertexId;
    }

    public String getDestinationVertexId() {
        return destinationVertexId;
    }

    public String getCostField() {
        return costField;
    }

    public GlobalVertexService getGlobalVertexService() {
        return globalVertexService;
    }

    public GlobalTraverserManager getGlobalTraverserManager() {
        return globalTraverserManager;
    }

    public ShortestPathAlghorithm getShortestPathAlghorithm() {
        return shortestPathAlghorithm;
    }

    public void setShortestPathAlghorithm(ShortestPathAlghorithm shortestPathAlghorithm) {
        this.shortestPathAlghorithm = shortestPathAlghorithm;
    }

    @Override
    public void setGlobalVertexService(GlobalVertexService globalVertexService) {
        this.globalVertexService = globalVertexService;
        
    }

    @Override
    public void setGlobalTraverserManager(GlobalTraverserManager globalTraverserManager) {
        this.globalTraverserManager = globalTraverserManager;
    }

    @Override
    public void execute() throws Exception {
          shortestPathAlghorithm.compute(sourceVertexId, destinationVertexId, costField);
          long cost = shortestPathAlghorithm.getShortestPath();
          Iterable<Edge> path = shortestPathAlghorithm.getPath();
          ShortestPathResult result = new ShortestPathResult(path, cost);
          setResult(result);
    }

    
}
