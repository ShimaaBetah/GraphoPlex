package com.server.graph_db.datastore;


public interface DatabaseConfigurationManager {
        
         public void switchDatabase(String database) ;
         public void createDatabase(String database) ;
         public void deleteDatabase(String database) ;
         public void dropDatabase(String database) ;
         public String getCurrentDatabase();
         public boolean isDatabaseExist(String database);
         public String getDefaultDatabase();
         public void switchToDefaultDatabase();
         public void dropdefaultDatabase();
    
}
