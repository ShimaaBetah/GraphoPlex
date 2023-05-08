package com.server.graph_db.query.databaseconfig.databaseconfigcommands;

import com.server.graph_db.database.GlobalDatabaseService;
import com.server.graph_db.query.Command;

public abstract class DatabaseConfigCommand extends Command{

    
    public abstract void setGlobalDatabaseService(GlobalDatabaseService databaseConfigService);

}
