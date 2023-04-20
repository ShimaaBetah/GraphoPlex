package com.server.graph_db.query.crud.crudcommands.vertexcommands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.index.GlobalSecondaryIndexManager;
import com.server.graph_db.query.crud.crudcommands.CrudCommand;
import com.server.graph_db.vertex.GlobalVertexService;


public class CrudVertexCommand implements CrudCommand{
    String vertexId;

    
    GlobalVertexService globalVertexService;
   
    
    
    public CrudVertexCommand(String vertexId) {

        this.vertexId = vertexId;
    }

    public String getVertexId() {
        return vertexId;
    }

    public void setVertexId(String vertexId) {
        this.vertexId = vertexId;
    }

    public void setGlobalVertexService(GlobalVertexService globalVertexService) {
        this.globalVertexService = globalVertexService;
    }

    public GlobalVertexService getGlobalVertexService() {
        return globalVertexService;
    }

    @Override
    public void execute() throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void setGlobalSecondaryIndexManager(GlobalSecondaryIndexManager globalSecondaryIndexManager) {
    }


   
}
