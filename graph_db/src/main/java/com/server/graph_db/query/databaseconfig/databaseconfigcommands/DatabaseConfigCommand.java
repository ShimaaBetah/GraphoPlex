package com.server.graph_db.query.databaseconfig.databaseconfigcommands;

import com.server.graph_db.database.GlobalDatabaseService;
import com.server.graph_db.query.Command;

public interface DatabaseConfigCommand extends Command{

    
    public void setGlobalDatabaseService(GlobalDatabaseService databaseConfigService);

}
