package com.server.graph_db.datastore.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.server.graph_db.datastore.IndexDataManager;

@Component
public class RedisIndexDataManager implements IndexDataManager {

    @Autowired 
    private RedisTemplate<String, Object> redisTemplate;

    private final String LIST_SECONDARY_INDEX_NAME = "secondaryIndex";
    
        @Override
        public boolean isIndexExist(String indexName) {
            // check if some value exist in redislist named secondaryIndex 
           
           return (redisTemplate.opsForList().range(LIST_SECONDARY_INDEX_NAME, 0, -1).contains(indexName));

            
        }
    
        @Override
        public void createIndex(String indexName) {
            // push in redis list called secondaryIndex

            redisTemplate.opsForList().leftPush(LIST_SECONDARY_INDEX_NAME, indexName);
        }
    
        @Override
        public void deleteIndex(String indexName) {
            // delete it from redis list called secondaryIndex
            redisTemplate.opsForList().remove(LIST_SECONDARY_INDEX_NAME, 0, indexName);
            Set<String> keys = redisTemplate.keys("*"+indexName + "*");
            for(String key : keys) {
                redisTemplate.delete(key);
            }
        }   
    
        @Override
        public void addVertexToIndex(String fieldName, String fieldValue ,String vertexId) {
            String indexName = fieldName + ":" + fieldValue;
            redisTemplate.opsForList().leftPush(indexName, vertexId);
            
        }
    
        @Override
        public void removeVertexFromIndex(String fieldName,String fieldValue ,String vertexId) {
            String indexName = fieldName + ":" + fieldValue;
            redisTemplate.opsForList().remove(indexName, 0, vertexId);
        }
    
        @Override
        public Iterable<String> getVerticesIdsFromIndex(String indexName, String fieldValue) {
            String index = indexName + ":" + fieldValue;
            return redisTemplate.opsForList().range(index, 0, -1).stream().map(key -> (String) key).collect(Collectors.toList());
        }

        public Iterable<String> filterNotExistingIndices(Iterable<String> indexNames) {
            List<String> existingIndices = redisTemplate.opsForList().range(LIST_SECONDARY_INDEX_NAME, 0, -1).stream().map(key -> (String) key).collect(Collectors.toList());
            List<String > notExistingIndices = new ArrayList<>();
            for (String indexName : indexNames) {
                if(!existingIndices.contains(indexName)) {
                    notExistingIndices.add(indexName);
                }
            }

            return notExistingIndices;
        }
    
}
