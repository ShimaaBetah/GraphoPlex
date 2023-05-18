package com.server.graph_db.query.databaseconfig.databaseconfigcommands;

import com.server.graph_db.core.database.GlobalDatabaseService;
import com.server.graph_db.query.databaseconfig.DatabaseResult;

public class DropDefaultCommand extends DatabaseConfigCommand{

    GlobalDatabaseService globalDatabaseService;
    
    @Override
    public void execute() throws Exception {
        globalDatabaseService.dropDefaultDatabase();
        String message = "Default database dropped";
        DatabaseResult result = new DatabaseResult();
        result.setMessage(message);
        setResult(result);
    }

    @Override
    public void setGlobalDatabaseService(GlobalDatabaseService databaseConfigService) {
        this.globalDatabaseService = databaseConfigService;
    }
    
}
