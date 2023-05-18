package com.server.graph_db.query.databaseconfig.databaseconfigcommands;


import com.server.graph_db.core.database.GlobalDatabaseService;
import com.server.graph_db.query.databaseconfig.DatabaseResult;

public class SwitchToDefaultCommand extends DatabaseConfigCommand{

    GlobalDatabaseService globalDatabaseService;
    
    @Override
    public void execute() throws Exception {
        globalDatabaseService.switchToDefaultDatabase();
        String message = "Switched to default database";
        DatabaseResult databaseResult = new DatabaseResult();
        databaseResult.setMessage(message);
        setResult(databaseResult);
    }

    @Override
    public void setGlobalDatabaseService(GlobalDatabaseService databaseConfigService) {
        this.globalDatabaseService = databaseConfigService;
    }
    
}
