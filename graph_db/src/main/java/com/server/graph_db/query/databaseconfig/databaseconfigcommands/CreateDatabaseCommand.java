package com.server.graph_db.query.databaseconfig.databaseconfigcommands;

import com.server.graph_db.core.database.GlobalDatabaseService;
import com.server.graph_db.query.databaseconfig.DatabaseResult;

public class CreateDatabaseCommand  extends DatabaseConfigCommand{

    GlobalDatabaseService globalDatabaseService;
    String databaseName;

    public CreateDatabaseCommand(String databaseName){
        this.databaseName = databaseName;
    }

    @Override
    public void execute() throws Exception {
        globalDatabaseService.createDatabase(databaseName);
        String message = "Database " + databaseName + " created";
        DatabaseResult databaseResult = new DatabaseResult();
        databaseResult.setMessage(message);
        setResult(databaseResult);
    }

    @Override
    public void setGlobalDatabaseService(GlobalDatabaseService databaseConfigService) {
        this.globalDatabaseService = databaseConfigService;
    }
    
}
