package com.server.graph_db.datastore.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.server.graph_db.datastore.DataAccesser;
import com.server.graph_db.vertex.Vertex;

@Component
public class RedisDataAccess implements DataAccesser {
    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void saveVertex(Vertex vertex) {
        redisTemplate.opsForHash().put("Vertex", Integer.toString(vertex.getId()) , vertex);
    }

    @Override
    public Vertex getVertex(int vertexId) {
        return (Vertex) redisTemplate.opsForHash().get("Vertex", Integer.toString(vertexId));    
    }

    @Override
    public void deleteAllVertices() {
        redisTemplate.delete("Vertex");
    }

    @Override
    public long countVertices() {
        return redisTemplate.opsForHash().size("Vertex");
    }

    @Override
    public Iterable<Integer> getAllVerticesIds() {
        Iterable<Integer> ids = redisTemplate.opsForHash().keys("Vertex").stream().map(key -> Integer.parseInt((String) key)).collect(Collectors.toList());
        return ids;
    }

    @Override
    public Iterable<Vertex> getVerticesByIds(Iterable<Integer> ids) {
        // get all vertices by ids from redis
        List<Vertex> vertices = new ArrayList<>();
        for (Integer id : ids) {
            vertices.add((Vertex) redisTemplate.opsForHash().get("Vertex", Integer.toString(id)));
        }    
        return vertices;
    
    }
    
}
