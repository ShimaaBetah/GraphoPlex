package com.server.graph_db.partition;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.server.graph_db.rabbitmq.producer.GetVertexProducer;
import com.server.graph_db.rabbitmq.producer.GetVerticesIdsProducer;
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

    @Autowired
    GetVertexProducer getVertexProducer;

    @Autowired
    GetVerticesIdsProducer getVerticesIdsProducer;

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
        } else {
            // send to the right partition
            // vertexService.addVertex(vertex);
            putVertexProducer.send(vertex, String.valueOf(partitionId));
        }
    }

    public Vertex getVertex(int vertexId) {
        int partitionId = getPartitionId(vertexId);
        if (partitionId == Integer.parseInt(serverId)) {
            // System.out.println("Getting vertex " + vertexId + " from server " +
            // serverId);
            return vertexService.getVertex(vertexId);
        } else {
            // send to the right partition
            // return getVertexProducer.send(vertexId, String.valueOf(partitionId));
            return vertexService.getVertex(vertexId);

        }
    }

    public Iterable<Integer> getVerticesIds() {
        // get vertices Ids from my server and other servers and append them
        List<Integer> verticesIds = new ArrayList<Integer>();
        Iterable<Integer> verticesIdsFromMyserver = vertexService.getAllVerticesIds();

        for (Integer vertexId : verticesIdsFromMyserver) {
            verticesIds.add(vertexId);
        }

        // loop on all servers and get vertices ids from them
        for (int i = 0; i < numOfServers; i++) {
            if (i != Integer.parseInt(serverId)) {
                // send to the right partition
                Iterable<Integer> verticesIdsFromOtherServer = getVerticesIdsProducer.send(String.valueOf(i));

                // append to verticesIds
                for (Integer vertexId : verticesIdsFromOtherServer) {
                    verticesIds.add(vertexId);
                }
            }

        }
        ;

        return verticesIds;
    }

    public Iterable<Vertex> getVertices(Iterable<Integer> verticesIds) {
        List<Vertex> vertices = new ArrayList<Vertex>();
        // group vertices ids by partition id
        List<List<Integer>> verticesIdsByPartitionId = groupVerticesIdsByPartitionId(verticesIds);
        // loop on all partitions and get vertices from them
        for (int i = 0; i < numOfServers; i++) {
            if (i != Integer.parseInt(serverId)) {
                // send to the right partition
                Iterable<Vertex> verticesFromOtherServer = getVertexProducer.send(verticesIdsByPartitionId.get(i),
                        String.valueOf(i));

                // append to vertices
                if(verticesFromOtherServer==null) continue;
                for (Vertex vertex : verticesFromOtherServer) {
                    vertices.add(vertex);
                }
            } else {
                // get vertices from my server
                Iterable<Vertex> verticesFromMyServer = vertexService.getVerticesByIds(verticesIdsByPartitionId.get(i));

                // append to vertices
                for (Vertex vertex : verticesFromMyServer) {
                    vertices.add(vertex);
                }
            }

        }
        

        return vertices;
    }

    public List<List<Integer>> groupVerticesIdsByPartitionId(Iterable<Integer> verticesIds) {
        List<List<Integer>> verticesIdsByPartitionId = new ArrayList<List<Integer>>();
        for (int i = 0; i < numOfServers; i++) {
            verticesIdsByPartitionId.add(new ArrayList<Integer>());
        }

        for (Integer vertexId : verticesIds) {
            int partitionId = getPartitionId(vertexId);
            verticesIdsByPartitionId.get(partitionId).add(vertexId);
        }

        return verticesIdsByPartitionId;
    }

}
