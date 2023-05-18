package com.server.graph_db.query.databaseconfig.databaseconfigcommands;

import com.server.graph_db.core.database.GlobalDatabaseService;
import com.server.graph_db.query.databaseconfig.DatabaseResult;

public class GetCurrentDatabaseCommand  extends DatabaseConfigCommand{

    GlobalDatabaseService databaseConfigService;

    public void execute() throws Exception {
        String currentDatabase = databaseConfigService.getCurrentDatabase();
        String message = "Current database is " + currentDatabase;
        DatabaseResult databaseResult = new DatabaseResult();
        databaseResult.setMessage(message);
        setResult(databaseResult);
    }

    public void setGlobalDatabaseService(GlobalDatabaseService databaseConfigService) {
        this.databaseConfigService = databaseConfigService;
    }
    
}
