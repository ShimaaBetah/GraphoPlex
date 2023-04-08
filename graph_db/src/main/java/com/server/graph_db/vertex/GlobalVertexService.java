package com.server.graph_db.vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.server.graph_db.grpc.clients.VertexClient;
import com.server.graph_db.partition.PartitionManager;
import com.server.graph_db.rabbitmq.producer.GetVerticesIdsProducer;
import com.server.graph_db.rabbitmq.producer.PutVertexProducer;

@Component
public class GlobalVertexService implements VertexService {
    
    @Autowired
    private LocalVertexService vertexService;

    @Autowired
    private PartitionManager partitionManager;

    @Autowired
    private PutVertexProducer putVertexProducer;

    @Autowired
    private VertexClient vertexClient;

    @Value("${server.numOfServers}")
    private int numOfServers;

    @Autowired
    private GetVerticesIdsProducer getVerticesIdsProducer;

    

    @Value("#{@myServerProperties.serverId}")
    private String serverId;

    public void addVertex(Vertex vertex) {
        int partitionId = partitionManager.getPartitionId(vertex);
        if (partitionId == Integer.parseInt(serverId)) {
            System.out.println("Saving vertex " + vertex.getId() + " in server " + serverId);
            vertexService.addVertex(vertex);
        } else {
            // send to the right partition
            // vertexService.addVertex(vertex);
            putVertexProducer.send(vertex, String.valueOf(partitionId));
        }
    }

    public Vertex getVertex(String vertexId) {
        int partitionId = partitionManager.getPartitionId(vertexId);
        if (partitionId == Integer.parseInt(serverId)) {
            // System.out.println("Getting vertex " + vertexId + " from server " +
            // serverId);
            return vertexService.getVertex(vertexId);
        } else {
            // send to the right partition
            // return getVertexProducer.send(vertexId, String.valueOf(partitionId));
            //return vertexService.getVertex(vertexId);

            return vertexClient.getVertex(vertexId, String.valueOf(partitionId));

        }
    }

    public Iterable<String> getAllVerticesIds() {
        // get vertices Ids from my server and other servers and append them
        List<String> verticesIds = new ArrayList<String>();
        Iterable<String> verticesIdsFromMyserver = vertexService.getAllVerticesIds();

        for (String vertexId : verticesIdsFromMyserver) {
            verticesIds.add(vertexId);
        }

        // loop on all servers and get vertices ids from them
        for (int i = 0; i < numOfServers; i++) {
            if (i != Integer.parseInt(serverId)) {
                // send to the right partition
                Iterable<String> verticesIdsFromOtherServer = getVerticesIdsProducer.send(String.valueOf(i));

                // append to verticesIds
                for (String vertexId : verticesIdsFromOtherServer) {
                    verticesIds.add(vertexId);
                }
            }

        }
        ;

        return verticesIds;
    }

    public Iterable<Vertex> getVerticesByIds(Iterable<String> verticesIds) {
        List<Vertex> vertices = new ArrayList<Vertex>();
        List<List<Vertex>> verticesByPartitionId = new ArrayList<List<Vertex>>();
        // initialize 
        for(int i = 0; i < numOfServers; i++) {
            verticesByPartitionId.add(new ArrayList<Vertex>());
        }
        Thread [] activeThreads = new Thread[numOfServers];
        // group vertices ids by partition id
        List<List<String>> verticesIdsByPartitionId = groupVerticesIdsByPartitionId(verticesIds);
        // loop on all partitions and get vertices from them
        for (int i = 0; i < numOfServers; i++) {
           // execute in parallel
           if(verticesIdsByPartitionId.get(i).size() > 0) {
               activeThreads[i] = new Thread(new getVerticesByIdsAsync(vertexService, verticesIdsByPartitionId.get(i), serverId, vertexClient, verticesByPartitionId.get(i), i));
               activeThreads[i].start();
              }

        }

        //wait till only the threads created in this method are finished

        for (int i = 0; i < numOfServers; i++) {
            try {
                if(activeThreads[i] != null)
                    activeThreads[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // append to vertices
        for (int i = 0; i < numOfServers; i++) {
            for (Vertex vertex : verticesByPartitionId.get(i)) {
                vertices.add(vertex);
            }
        }


        /* for(int partitionId = 0; partitionId < numOfServers; partitionId++) {
            if (partitionId == Integer.parseInt(serverId)) {
                // System.out.println("Getting vertex " + vertexId + " from server " +
                // serverId);
                Iterable<Vertex> verticesFromMyServer = vertexService.getVerticesByIds(verticesIdsByPartitionId.get(partitionId));
                for (Vertex vertex : verticesFromMyServer) {
                    vertices.add(vertex);
                }
            } else {
                // send to the right partition
                // return getVertexProducer.send(vertexId, String.valueOf(partitionId));
                //return vertexService.getVertex(vertexId);

                Iterable<Vertex> verticesFromOtherServer = vertexClient.getVertices(verticesIdsByPartitionId.get(partitionId), String.valueOf(partitionId));
                for (Vertex vertex : verticesFromOtherServer) {
                    vertices.add(vertex);
                }

            }
        }
 */
        

        return vertices;
    }

    public List<List<String>> groupVerticesIdsByPartitionId(Iterable<String> verticesIds) {
        List<List<String>> verticesIdsByPartitionId = new ArrayList<List<String>>();
        for (int i = 0; i < numOfServers; i++) {
            verticesIdsByPartitionId.add(new ArrayList<String>());
        }

        for (String vertexId : verticesIds) {
            int partitionId = partitionManager.getPartitionId(vertexId);
            verticesIdsByPartitionId.get(partitionId).add(vertexId);
        }

        return verticesIdsByPartitionId;

    }

    @Override
    public void addEdge(String id, Edge edge) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addEdge'");
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public LinkedList<Edge> getEdges(String vertixId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEdges'");
    }

    @Override
    public long getVertexCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVertexCount'");
    }

   static class getVerticesByIdsAsync implements Runnable {
       
        private LocalVertexService vertexService;
        private Iterable<String> verticesIds;
        private String serverId;
        private VertexClient vertexClient;
        private List<Vertex> vertices;
        private int partitionId;

        public getVerticesByIdsAsync(LocalVertexService vertexService, Iterable<String> verticesIds, String serverId, VertexClient vertexClient,
                List<Vertex> vertices, int partitionId) {
            this.verticesIds = verticesIds;
            this.serverId = serverId;
            this.vertexClient = vertexClient;
            this.vertices = vertices;
            this.partitionId = partitionId;
            this.vertexService = vertexService;

        }

        @Override
        public void run() {
            if (partitionId != Integer.parseInt(serverId)) {
                // send to the right partition
                Iterable<Vertex> verticesFromOtherServer = vertexClient.getVertices(verticesIds,
                        String.valueOf(partitionId));

                // append to vertices
                if(verticesFromOtherServer==null) return;
                for (Vertex vertex : verticesFromOtherServer) {
                    vertices.add(vertex);
                }
            } else {
                // get vertices from my server
                Iterable<Vertex> verticesFromMyServer = vertexService.getVerticesByIds(verticesIds);

                // append to vertices
                for (Vertex vertex : verticesFromMyServer) {
                    vertices.add(vertex);
                }
            }


        }

    }

@Override
public void deleteVertex(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteVertex'");
}

}




    

