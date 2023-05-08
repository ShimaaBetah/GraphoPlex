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
    @Autowired
    private RedisDatabaseConfig redisDatabaseConfig;
    private final String LIST_SECONDARY_INDEX_NAME = "secondaryIndex";

    @Override
    public boolean isIndexExist(String indexName) {
        // check if some value exist in redislist named secondaryIndex

        return (redisTemplate.opsForList().range(getSecondaryIndicesListName(), 0, -1).contains(indexName));

    }

    @Override
    public void createIndex(String indexName) {
        // push in redis list called secondaryIndex
        redisTemplate.opsForList().leftPush(getSecondaryIndicesListName(), indexName);
    }

    @Override
    public void deleteIndex(String indexName) {
        // delete it from redis list called secondaryIndex
        redisTemplate.opsForList().remove(getSecondaryIndicesListName(), 0, indexName);
        Set<String> keys = redisTemplate.keys(getPrefix(indexName) + "*");
        for (String key : keys) {
            redisTemplate.delete(key);
        }
    }

    @Override
    public void addVertexToIndex(String fieldName, String fieldValue, String vertexId) {
        String indexName = fieldName + ":" + fieldValue;
        redisTemplate.opsForSet().add(getPrefix(indexName), vertexId);

    }

    @Override
    public void removeVertexFromIndex(String fieldName, String fieldValue, String vertexId) {
        String indexName = fieldName + ":" + fieldValue;
        redisTemplate.opsForSet().remove(getPrefix(indexName), vertexId);
    }

    @Override
    public Iterable<String> getVerticesIdsFromIndex(String indexName, String fieldValue) {
        String index = indexName + ":" + fieldValue;
        return redisTemplate.opsForSet().members(getPrefix(index)).stream().map(key -> (String) key)
                .collect(Collectors.toList());
    }

    public Iterable<String> filterNotExistingIndices(Iterable<String> indexNames) {
        List<String> existingIndices = redisTemplate.opsForList().range(getSecondaryIndicesListName(), 0, -1).stream()
                .map(key -> (String) key).collect(Collectors.toList());
        List<String> notExistingIndices = new ArrayList<>();
        for (String indexName : indexNames) {
            if (!existingIndices.contains(indexName)) {
                notExistingIndices.add(indexName);
            }
        }

        return notExistingIndices;
    }

    public Iterable<String> getAllIndices() {
        return redisTemplate.opsForList().range(getSecondaryIndicesListName(), 0, -1).stream().map(key -> (String) key)
                .collect(Collectors.toList());
    }

    public String getPrefix(String indexName) {
        return redisDatabaseConfig.getCurrentDatabase() + ":" + indexName;
    }

    public String getSecondaryIndicesListName() {
        return redisDatabaseConfig.getCurrentDatabase() + ":" + LIST_SECONDARY_INDEX_NAME;
    }

    @Override
    public boolean isIndexContainsVertex(String indexName, String fieldValue, String vertexId) {
        String index = indexName + ":" + fieldValue;
        return redisTemplate.opsForSet().isMember(getPrefix(index), vertexId);
    }

}
