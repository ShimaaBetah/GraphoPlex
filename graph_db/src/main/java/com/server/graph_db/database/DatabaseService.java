package com.server.graph_db.database;

import com.server.graph_db.exceptions.database.DatabaseAlreadyExist;
import com.server.graph_db.exceptions.database.DatabaseNotFound;

public interface DatabaseService {
    
     public void switchDatabase(String database) throws Exception;
     public void createDatabase(String database) throws Exception;
     public void deleteDatabase(String database) throws Exception; 
     public void dropDatabase(String database) throws Exception;
     public void switchToDefaultDatabase() throws Exception;
     public void dropDefaultDatabase() throws Exception;
     public String getCurrentDatabase() throws Exception;
}
