package com.server.graph_db.core.exceptions.database;

public class DatabaseAlreadyExist extends Exception{

    String databaseName;
    
    public DatabaseAlreadyExist(String databaseName){
        super("Database with name: " + databaseName + " already exist");
    }
}
