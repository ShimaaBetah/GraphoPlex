package com.server.graph_db.query.crud.crudcommands.edgecommands;

import com.server.graph_db.core.index.GlobalSecondaryIndexManager;
import com.server.graph_db.core.vertex.GlobalVertexService;
import com.server.graph_db.query.crud.crudcommands.CrudCommand;

public class CrudEdgeCommand extends CrudCommand{
    String sourceVertexId;
    String destinationVertexId;
    String label;

    GlobalVertexService globalVertexService;

    public CrudEdgeCommand(String sourceVertexId, String destinationVertexId, String label) {
        this.sourceVertexId = sourceVertexId;
        this.destinationVertexId = destinationVertexId;
        this.label = label;
        
    }

    public String getSourceVertexId() {
        return sourceVertexId;
    }

    public void setSourceVertexId(String sourceVertexId) {
        this.sourceVertexId = sourceVertexId;
    }

    public String getDestinationVertexId() {
        return destinationVertexId;
    }

    public void setDestinationVertexId(String destinationVertexId) {
        this.destinationVertexId = destinationVertexId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public GlobalVertexService getGlobalVertexService() {
        return globalVertexService;
    }

    @Override
    public void execute() throws Exception {
  
    }

    @Override
    public void setGlobalVertexService(GlobalVertexService globalVertexService) {
     this.globalVertexService = globalVertexService;
    }

    @Override
    public void setGlobalSecondaryIndexManager(GlobalSecondaryIndexManager globalSecondaryIndexManager) {
    }

    
    
}
