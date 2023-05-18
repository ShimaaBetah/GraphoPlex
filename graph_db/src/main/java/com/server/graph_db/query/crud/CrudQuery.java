package com.server.graph_db.query.crud;

import org.springframework.beans.factory.annotation.Autowired;

import com.server.graph_db.core.index.GlobalSecondaryIndexManager;
import com.server.graph_db.core.vertex.GlobalVertexService;
import com.server.graph_db.query.Command;
import com.server.graph_db.query.Query;
import com.server.graph_db.query.crud.crudcommands.CrudCommand;

public class CrudQuery extends Query {

    CrudCommand command;
    
    @Autowired
    GlobalVertexService globalVertexService;

    @Autowired
    GlobalSecondaryIndexManager globalSecondaryIndexManager;

    public CrudQuery(GlobalVertexService globalVertexService, GlobalSecondaryIndexManager globalSecondaryIndexManager) {
        this.globalVertexService = globalVertexService;
        this.globalSecondaryIndexManager = globalSecondaryIndexManager;
    }
    

    

    @Override
    public void execute() throws Exception {
        command.setGlobalVertexService(globalVertexService);
        command.setGlobalSecondaryIndexManager(globalSecondaryIndexManager);
        long startTime = System.currentTimeMillis();
        command.execute();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        command.getResult().setTotalExecutionTime(executionTime);
    }

    public CrudCommand getCommand() {
        return command;
    }

   

    @Override
    public void setCommand(Command command) {
          this.command = (CrudCommand) command;
    }
    
}
