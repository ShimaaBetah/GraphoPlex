package com.server.graph_db.query.match.shortestPath;

import com.server.graph_db.alghorithms.Dijkstra;
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

    public ShortestPathCommand(String sourceVertexId, String destinationVertexId, String costField) {
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
          Dijkstra dijkstra = new Dijkstra(globalVertexService);
          dijkstra.compute(sourceVertexId, destinationVertexId, costField);
          long cost = dijkstra.getShortestPath();
          Iterable<Edge> path = dijkstra.getPath();
          ShortestPathResult result = new ShortestPathResult(path, cost);
          setResult(result);
    }

    
}
