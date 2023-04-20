package com.server.graph_db.datastore.redis;

import org.springframework.stereotype.Component;

import com.server.graph_db.datastore.DatabaseConfigurationManager;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

@Component
public class RedisDatabaseConfig implements DatabaseConfigurationManager {

    
    private String defaultDatabase = "default";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final String CURRENT_DATABASE_KEY = "current_database";
    private final String DATABASES_KEY = "databases";

  

    public String getDefaultDatabase() {
        return defaultDatabase;
    }

    public void switchDatabase(String database) {
        redisTemplate.opsForValue().set(CURRENT_DATABASE_KEY, database);
    }

    public String getCurrentDatabase() {
        //if null return default
        String database = (String) redisTemplate.opsForValue().get(CURRENT_DATABASE_KEY);
        if(database == null){
            return defaultDatabase;
        }

        return database;

    }

    public void createDatabase(String database)  {
        redisTemplate.opsForSet().add(DATABASES_KEY, database);
    }

    public boolean isDatabaseExist(String database) {
        return redisTemplate.opsForSet().isMember(DATABASES_KEY, database);
    }

    public void deleteDatabase(String database)  {
            dropDatabase(database);
            redisTemplate.opsForSet().remove(DATABASES_KEY, database);
            if (database.equals(getCurrentDatabase())) {
                switchToDefaultDatabase();
            }
        
    }

    public void switchToDefaultDatabase() {
        redisTemplate.opsForValue().set(CURRENT_DATABASE_KEY, defaultDatabase);
    }

    public void dropDatabase(String database)  {
        Set<String> keys = redisTemplate.keys(database + "*");
        for (String key : keys) {
            redisTemplate.delete(key);
        }
    }

    public void dropdefaultDatabase() {
        redisTemplate.delete(defaultDatabase + "*");
    }


}
