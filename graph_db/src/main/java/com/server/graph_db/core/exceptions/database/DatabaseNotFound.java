package com.server.graph_db.core.exceptions.database;

public class DatabaseNotFound extends Exception{
    
    String databaseName;

    public DatabaseNotFound(String databaseName){
        super("Database with name: " + databaseName + " not found");
    }
}
