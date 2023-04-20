package com.server.graph_db.query.databaseconfig;

import com.server.graph_db.database.GlobalDatabaseService;
import com.server.graph_db.query.Command;
import com.server.graph_db.query.Query;
import com.server.graph_db.query.databaseconfig.databaseconfigcommands.DatabaseConfigCommand;

public class DatabaseConfigQuery implements Query  {

    DatabaseConfigCommand command;

    GlobalDatabaseService globalDatabaseService;

    public DatabaseConfigQuery(GlobalDatabaseService globalDatabaseService){
        this.globalDatabaseService = globalDatabaseService;
    }

    @Override
    public void execute() throws Exception {
        command.setGlobalDatabaseService(globalDatabaseService);
        command.execute();
        
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
