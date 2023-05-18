package com.server.graph_db.core.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.core.exceptions.database.DatabaseAlreadyExist;
import com.server.graph_db.core.exceptions.database.DatabaseNotFound;
import com.server.graph_db.datastore.DatabaseConfigurationManager;

@Component
public class LocalDatabaseService implements DatabaseService {

    @Autowired
    private DatabaseConfigurationManager redisDatabaseConfig;

    @Override
    public void switchDatabase(String database) throws DatabaseNotFound {
        if (redisDatabaseConfig.isDatabaseExist(database)) {
            redisDatabaseConfig.switchDatabase(database);
        } else {
            throw new DatabaseNotFound(database);
        }

    }

    

    @Override
    public void createDatabase(String database) throws DatabaseAlreadyExist {
        if (!redisDatabaseConfig.isDatabaseExist(database)) {
            redisDatabaseConfig.createDatabase(database);
        } else {
            throw new DatabaseAlreadyExist(database);
        }
    }

    @Override
    public void deleteDatabase(String database) throws DatabaseNotFound{
        if(redisDatabaseConfig.isDatabaseExist(database)) {
            redisDatabaseConfig.deleteDatabase(database);
        } else {
            throw new DatabaseNotFound(database);
        }
    }

    @Override
    public void dropDatabase(String database) throws DatabaseNotFound{
        if(redisDatabaseConfig.isDatabaseExist(database)) {
            redisDatabaseConfig.dropDatabase(database);
        } else {
            throw new DatabaseNotFound(database);
        }
    }

    @Override
    public String getCurrentDatabase() {
        String currDatabase = redisDatabaseConfig.getCurrentDatabase();
        if (currDatabase == null) {
            currDatabase = redisDatabaseConfig.getDefaultDatabase();
        } else {
            currDatabase = redisDatabaseConfig.getCurrentDatabase();
        }

        return currDatabase;
    }

    @Override
    public void switchToDefaultDatabase() {
        redisDatabaseConfig.switchToDefaultDatabase();
    }

    @Override
    public void dropDefaultDatabase() {
        redisDatabaseConfig.dropDatabase(redisDatabaseConfig.getDefaultDatabase());
    }

}
