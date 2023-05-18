package com.server.graph_db.query.databaseconfig;

import com.server.graph_db.core.database.GlobalDatabaseService;
import com.server.graph_db.query.Command;
import com.server.graph_db.query.Query;
import com.server.graph_db.query.databaseconfig.databaseconfigcommands.DatabaseConfigCommand;

public class DatabaseConfigQuery extends Query  {

    DatabaseConfigCommand command;

    GlobalDatabaseService globalDatabaseService;

    public DatabaseConfigQuery(GlobalDatabaseService globalDatabaseService){
        this.globalDatabaseService = globalDatabaseService;
    }

    @Override
    public void execute() throws Exception {
        command.setGlobalDatabaseService(globalDatabaseService);
        long startTime = System.currentTimeMillis();
        command.execute();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        command.getResult().setTotalExecutionTime(executionTime);
        
    }

    @Override
    public Command getCommand() {
         return command;
    }

    @Override
    public void setCommand(Command command) {
        this.command = (DatabaseConfigCommand) command;
    }
    
}
