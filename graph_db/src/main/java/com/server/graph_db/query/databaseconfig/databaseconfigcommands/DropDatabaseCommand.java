package com.server.graph_db.query.databaseconfig.databaseconfigcommands;

import com.server.graph_db.core.database.GlobalDatabaseService;
import com.server.graph_db.query.databaseconfig.DatabaseResult;

public class DropDatabaseCommand extends DatabaseConfigCommand{
        
        GlobalDatabaseService globalDatabaseService;
        String databaseName;
    
        public DropDatabaseCommand(String databaseName){
            this.databaseName = databaseName;
        }
    
        @Override
        public void execute() throws Exception {
            globalDatabaseService.dropDatabase(databaseName);
            String message = "Database " + databaseName + " dropped";
            DatabaseResult result = new DatabaseResult();
            result.setMessage(message);
            setResult(result);
        }
    
        @Override
        public void setGlobalDatabaseService(GlobalDatabaseService databaseConfigService) {
            this.globalDatabaseService = databaseConfigService;
        }
    
}
