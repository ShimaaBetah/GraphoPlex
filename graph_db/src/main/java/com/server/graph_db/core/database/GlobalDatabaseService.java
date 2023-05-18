package com.server.graph_db.core.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.core.partition.PartitionManager;
import com.server.graph_db.grpc.clients.DatabaseConfigClient;

@Component
public class GlobalDatabaseService implements DatabaseService {

    @Autowired
    private DatabaseConfigClient databaseConfigClient;

    @Autowired
    private LocalDatabaseService localDatabaseService;

    @Autowired
    private PartitionManager partitionManager;

    @Override
    public void switchDatabase(String database) throws Exception {
        for(int i = 0; i < partitionManager.getNumberOfServers(); i++) {
            if(i == partitionManager.getServerId()) {
                localDatabaseService.switchDatabase(database);
            } else {
                databaseConfigClient.switchDatabase(database, String.valueOf(i));
            }
        }  
    }

    @Override
    public void createDatabase(String database) throws Exception {
        for(int i = 0; i < partitionManager.getNumberOfServers(); i++) {
            if(i == partitionManager.getServerId()) {
                localDatabaseService.createDatabase(database);
            } else {
                databaseConfigClient.createDatabase(database, String.valueOf(i));
            }
        }  
    }

    @Override
    public void deleteDatabase(String database) throws Exception {
        for(int i = 0; i < partitionManager.getNumberOfServers(); i++) {
            if(i == partitionManager.getServerId()) {
                localDatabaseService.deleteDatabase(database);
            } else {
                databaseConfigClient.deleteDatabase(database, String.valueOf(i));
            }
        }  
    }

    @Override
    public void dropDatabase(String database) throws Exception {
        for(int i = 0; i < partitionManager.getNumberOfServers(); i++) {
            if(i == partitionManager.getServerId()) {
                localDatabaseService.dropDatabase(database);
            } else {
                databaseConfigClient.dropDatabase(database, String.valueOf(i));
            }
        }
    }

    @Override
    public void switchToDefaultDatabase() throws Exception {
        for(int i = 0; i < partitionManager.getNumberOfServers(); i++) {
            if(i == partitionManager.getServerId()) {
                localDatabaseService.switchToDefaultDatabase();
            } else {
                databaseConfigClient.switchToDefaultDatabase(String.valueOf(i));
            }
        }
    }

    @Override
    public void dropDefaultDatabase() throws Exception {
        for(int i = 0; i < partitionManager.getNumberOfServers(); i++) {
            if(i == partitionManager.getServerId()) {
                localDatabaseService.dropDefaultDatabase();
            } else {
                databaseConfigClient.dropDefaultDatabase(String.valueOf(i));
            }
        }
    }

    @Override
    public String getCurrentDatabase() throws Exception {
        //TODO : check if all servers have the same current database
        return localDatabaseService.getCurrentDatabase();
    }
    
}
