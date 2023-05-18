package com.server.graph_db.datastore.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.Vertex;
import com.server.graph_db.datastore.DataAccesser;
import com.server.graph_db.grpc.vertex.edge;

import io.lettuce.core.dynamic.annotation.Value;

@Component
public class RedisDataAccess implements DataAccesser {
    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisDatabaseConfig redisDatabaseConfig;

    private final String VERTEX_HASH = "Vertex";
    private final String OUTGOING_EDGE_HASH = "OutgoingEdges";
    private final String INCOMING_EDGE_HASH = "IncomingEdges";
    

    

    

    @Override
    public void saveVertex(Vertex vertex) {
        redisTemplate.opsForHash().put(getPrefix(VERTEX_HASH), vertex.getId() , vertex);
    }

    @Override
    public Vertex getVertex(String vertexId) {
        return (Vertex) redisTemplate.opsForHash().get(getPrefix(VERTEX_HASH), vertexId);    
    }

    @Override
    public void deleteAllVertices() {
        redisTemplate.delete(getPrefix(VERTEX_HASH));
    }

    @Override
    public long countVertices() {
        return redisTemplate.opsForHash().size(getPrefix(VERTEX_HASH));
    }

    @Override
    public Iterable<String> getAllVerticesIds() {
        Iterable<String> ids = redisTemplate.opsForHash().keys(getPrefix(VERTEX_HASH)).stream().map(key -> (String) key).collect(Collectors.toList());
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
        redisTemplate.opsForHash().delete(getPrefix(VERTEX_HASH), vertexId);
    }

    @Override
    public boolean isVertexExists(String vertexId) {
        return redisTemplate.opsForHash().hasKey(getPrefix(VERTEX_HASH), vertexId);
    }


    public String getPrefix(String name){
        String databaseName = redisDatabaseConfig.getCurrentDatabase();
        return databaseName + ":"+ name;
    }

   

    @Override
    public Iterable<Edge> getEdges(String vertexId,boolean isOutgoing) {        
        String setKey = isOutgoing ? getPrefix(OUTGOING_EDGE_HASH + ":" + vertexId) : getPrefix(INCOMING_EDGE_HASH + ":" + vertexId);
        Iterable<Edge> edges = redisTemplate.opsForSet().members(setKey).stream().map(edge -> (Edge) edge).collect(Collectors.toList());
        return edges;
    }

    @Override
    public boolean isEdgeExists(String sourceVertexId, String distinationVertexId, String label, boolean isOutgoing) {
        //look for edge in redis list named with associated vertex with in or out 
        //if found return true else return false
        String setKey = isOutgoing ? getPrefix(OUTGOING_EDGE_HASH + ":" + sourceVertexId) : getPrefix(INCOMING_EDGE_HASH + ":" + distinationVertexId);
        Edge edge = new Edge(sourceVertexId, distinationVertexId);
        edge.setLabel(label);
        return redisTemplate.opsForSet().isMember(setKey, edge);
    }

    @Override
    public void saveEdge(Edge edge, boolean isOutgoing) {
        // TODO Auto-generated method stub
        String setKey = isOutgoing ? getPrefix(OUTGOING_EDGE_HASH + ":" + edge.getSourceVertexId()) : getPrefix(INCOMING_EDGE_HASH + ":" + edge.getDestinationVertexId());
        redisTemplate.opsForSet().add(setKey, edge);
    }

    @Override
    public void deleteEdge(String sourceVertexId, String distinationVertexId, String label, boolean isOutgoing) {
        // TODO Auto-generated method stub
        String setKey = isOutgoing ? getPrefix(OUTGOING_EDGE_HASH + ":" + sourceVertexId) : getPrefix(INCOMING_EDGE_HASH + ":" + distinationVertexId);
        Edge edge = new Edge(sourceVertexId, distinationVertexId);
        edge.setLabel(label);
        redisTemplate.opsForSet().remove(setKey, edge);
    }

    @Override
    public Edge getEdge(String sourceVertexId, String distinationVertexId, String label, boolean isOutgoing) {
        // TODO Auto-generated method stub
        String setKey = isOutgoing ? getPrefix(OUTGOING_EDGE_HASH + ":" + sourceVertexId) : getPrefix(INCOMING_EDGE_HASH + ":" + distinationVertexId);
        Edge edge = new Edge(sourceVertexId, distinationVertexId);
        edge.setLabel(label);
        // get an edge with the same source and destination and label
        return (Edge) redisTemplate.opsForSet().members(setKey).stream().filter(e -> e.equals(edge)).findFirst().get();
    }

    public void deleteEdges(String vertexId, boolean isOutgoing) {
        String setKey = isOutgoing ? getPrefix(OUTGOING_EDGE_HASH + ":" + vertexId) : getPrefix(INCOMING_EDGE_HASH + ":" + vertexId);
        redisTemplate.delete(setKey);
    }
    

   

  
    
}
