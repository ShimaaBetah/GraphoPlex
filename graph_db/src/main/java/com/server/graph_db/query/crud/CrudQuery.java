package com.server.graph_db.query.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.index.GlobalSecondaryIndexManager;
import com.server.graph_db.query.Command;
import com.server.graph_db.query.Query;
import com.server.graph_db.query.crud.crudcommands.CrudCommand;
import com.server.graph_db.vertex.GlobalVertexService;

public class CrudQuery implements Query {

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
        command.execute();
    }

    public CrudCommand getCommand() {
        return command;
    }

   

    @Override
    public void setCommand(Command command) {
          this.command = (CrudCommand) command;
    }
    
}
