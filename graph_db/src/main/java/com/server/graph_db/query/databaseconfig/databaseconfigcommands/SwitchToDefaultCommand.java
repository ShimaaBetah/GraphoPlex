package com.server.graph_db.query.databaseconfig.databaseconfigcommands;


import com.server.graph_db.database.GlobalDatabaseService;

public class SwitchToDefaultCommand implements DatabaseConfigCommand{

    GlobalDatabaseService globalDatabaseService;
    
    @Override
    public void execute() throws Exception {
        globalDatabaseService.switchToDefaultDatabase();
    }

    @Override
    public void setGlobalDatabaseService(GlobalDatabaseService databaseConfigService) {
        this.globalDatabaseService = databaseConfigService;
    }
    
}
