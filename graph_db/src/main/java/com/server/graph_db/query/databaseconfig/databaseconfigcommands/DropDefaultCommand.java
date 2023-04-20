package com.server.graph_db.query.databaseconfig.databaseconfigcommands;

import com.server.graph_db.database.GlobalDatabaseService;

public class DropDefaultCommand implements DatabaseConfigCommand{

    GlobalDatabaseService globalDatabaseService;
    
    @Override
    public void execute() throws Exception {
        globalDatabaseService.dropDefaultDatabase();
    }

    @Override
    public void setGlobalDatabaseService(GlobalDatabaseService databaseConfigService) {
        this.globalDatabaseService = databaseConfigService;
    }
    
}
