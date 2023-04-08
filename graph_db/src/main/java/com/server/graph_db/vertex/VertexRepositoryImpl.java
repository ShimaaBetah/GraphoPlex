package com.server.graph_db.vertex;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.server.graph_db.datastore.redis.RedisDataAccess;


@Repository
public class VertexRepositoryImpl implements VertexRepository {
    


    @Autowired
    private RedisDataAccess redisDataAccess;
    
    public VertexRepositoryImpl(RedisDataAccess redisDataAccess) {
        this.redisDataAccess = redisDataAccess;
    } 

    @Override
    public long count() {
        return redisDataAccess.countVertices();
    }

    @Override
    public void delete(Vertex entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteAll() {
          redisDataAccess.deleteAllVertices();
    }

    @Override
    public void deleteAll(Iterable<? extends Vertex> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAllById(Iterable<? extends String> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @Override
    public void deleteById(String id) {
            redisDataAccess.deleteVertex(id);
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public Iterable<Vertex> findAll() {
        return redisDataAccess.getAllVertices();
    }

    @Override
    public Iterable<Vertex> findAllById(Iterable<String> ids) {
        // TODO Auto-generated method stub

        return redisDataAccess.getVerticesByIds(ids);
    }

    @Override
    public Optional<Vertex> findById(String id) {
        // get by id from redis
        Vertex vertex = redisDataAccess.getVertex(id);
        return Optional.ofNullable(vertex);
        
    }

    @Override
    public <S extends Vertex> S save(S entity) {
        redisDataAccess.saveVertex(entity);
        return entity;
    }

    @Override
    public <S extends Vertex> Iterable<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    public Iterable<String> getAllVerticesIds() {

        return redisDataAccess.getAllVerticesIds();
    }
    
}
