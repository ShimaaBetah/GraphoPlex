package com.server.graph_db.query.databaseconfig.databaseconfigcommands;

import com.server.graph_db.database.GlobalDatabaseService;
import com.server.graph_db.query.databaseconfig.DatabaseResult;

public class DeleteDatabaseCommand extends DatabaseConfigCommand {
    
        GlobalDatabaseService globalDatabaseService;
        String databaseName;
    
        public DeleteDatabaseCommand(String databaseName){
            this.databaseName = databaseName;
        }
    
        @Override
        public void execute() throws Exception {
            globalDatabaseService.deleteDatabase(databaseName);
            String message = "Database " + databaseName + " deleted";
            DatabaseResult databaseResult = new DatabaseResult();
            databaseResult.setMessage(message);
            setResult(databaseResult);
        }
    
        @Override
        public void setGlobalDatabaseService(GlobalDatabaseService databaseConfigService) {
            this.globalDatabaseService = databaseConfigService;
        }

       
    
}
