package com.server.graph_db.query.databaseconfig.databaseconfigcommands;

import com.server.graph_db.core.database.GlobalDatabaseService;
import com.server.graph_db.query.databaseconfig.DatabaseResult;

public class SwitchDatabaseCommand extends DatabaseConfigCommand {
    
        GlobalDatabaseService globalDatabaseService;
        String databaseName;
    
        public SwitchDatabaseCommand(String databaseName){
            this.databaseName = databaseName;
        }
    
        @Override
        public void execute() throws Exception {
            globalDatabaseService.switchDatabase(databaseName);
            String message = "Database switched to " + databaseName;
            DatabaseResult databaseResult = new DatabaseResult();
            databaseResult.setMessage(message);
            setResult(databaseResult);
        }
    
        @Override
        public void setGlobalDatabaseService(GlobalDatabaseService databaseConfigService) {
            this.globalDatabaseService = databaseConfigService;
        }
    
}
