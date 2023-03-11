package com.server.graph_db.vertex;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class VertexRepositoryImpl implements VertexRepository {
    


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    public VertexRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    } 

    @Override
    public long count() {
        // return count of Vertices from redis
        return redisTemplate.opsForHash().size("Vertex");
    }

    @Override
    public void delete(Vertex entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteAll() {
       // delete all keys from redis
        redisTemplate.delete("Vertex");

        
    }

    @Override
    public void deleteAll(Iterable<? extends Vertex> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public boolean existsById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public Iterable<Vertex> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Iterable<Vertex> findAllById(Iterable<Integer> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

    @Override
    public Optional<Vertex> findById(Integer id) {
        // get by id from redis
        Vertex vertex = (Vertex) redisTemplate.opsForHash().get("Vertex", Integer.toString(id));
        return Optional.ofNullable(vertex);
        
    }

    @Override
    public <S extends Vertex> S save(S entity) {
        // save Vertix to redis
        redisTemplate.opsForHash().put("Vertex", Integer.toString(entity.getId()) , entity);
        return entity;
        
    }

    @Override
    public <S extends Vertex> Iterable<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }
    
}
