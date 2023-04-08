package com.server.graph_db.datastore.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
        redisTemplate.opsForHash().put("Vertex", vertex.getId() , vertex);
    }

    @Override
    public Vertex getVertex(String vertexId) {
        return (Vertex) redisTemplate.opsForHash().get("Vertex", vertexId);    
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
    public Iterable<String> getAllVerticesIds() {
        Iterable<String> ids = redisTemplate.opsForHash().keys("Vertex").stream().map(key -> (String) key).collect(Collectors.toList());
        return ids;
    }

    @Override

    public Iterable<Vertex> getVerticesByIds(Iterable<String> ids) {
        // get all vertices by ids from redis
        List<Vertex> vertices = new ArrayList<>();
        for (String id : ids) {
            vertices.add((Vertex) getVertex(id));
        }    
        return vertices;
    
    }

    @Override
    public Iterable<Vertex> getAllVertices() {
        // get all vertices from redis
        Iterable<String> ids = getAllVerticesIds();
        return getVerticesByIds(ids);
    }

    @Override
    public void deleteVertex(String vertexId) {
        redisTemplate.opsForHash().delete("Vertex", vertexId);
    }
    
}
