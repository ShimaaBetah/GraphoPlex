package com.server.graph_db.partition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.server.graph_db.rabbitmq.producer.PutVertexProducer;
import com.server.graph_db.vertex.Vertex;
import com.server.graph_db.vertex.VertexService;

@Component
public class PartitionManager {

    @Autowired
    VertexService vertexService;

    @Value("#{@myServerProperties.serverId}")
    private String serverId;

    @Autowired
    PutVertexProducer putVertexProducer;

    @Value("${server.numOfServers}")
    private int numOfServers;

    public int getPartitionId(int vertexId) {
        return vertexId % numOfServers;
    }

    public int getPartitionId(Vertex vertex) {
        return vertex.getId() % numOfServers;
    }

    public void saveVertex(Vertex vertex) {
        int partitionId = getPartitionId(vertex);
        if (partitionId == Integer.parseInt(serverId)) {
            System.out.println("Saving vertex " + vertex.getId() + " in server " + serverId);
            vertexService.addVertex(vertex);
            //putVertexProducer.send(vertex, String.valueOf(partitionId));
        } else{
            //send to the right partition
            putVertexProducer.send(vertex, String.valueOf(partitionId));
        }
    }
}
