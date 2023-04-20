package com.server.graph_db.query.databaseconfig.databaseconfigcommands;

import com.server.graph_db.database.GlobalDatabaseService;

public class DeleteDatabaseCommand implements DatabaseConfigCommand {
    
        GlobalDatabaseService globalDatabaseService;
        String databaseName;
    
        public DeleteDatabaseCommand(String databaseName){
            this.databaseName = databaseName;
        }
    
        @Override
        public void execute() throws Exception {
            globalDatabaseService.deleteDatabase(databaseName);
        }
    
        @Override
        public void setGlobalDatabaseService(GlobalDatabaseService databaseConfigService) {
            this.globalDatabaseService = databaseConfigService;
        }

       
    
}
