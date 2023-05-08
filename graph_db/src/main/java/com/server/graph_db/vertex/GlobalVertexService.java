package com.server.graph_db.vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.server.graph_db.exceptions.vertex.VertexAlreadyExistsException;
import com.server.graph_db.exceptions.vertex.VertexNotFoundException;
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


    public void addVertex(Vertex vertex) throws VertexAlreadyExistsException {
        int partitionId = partitionManager.getPartitionId(vertex);
        if (partitionId == Integer.parseInt(serverId)) {
            System.out.println("Saving vertex " + vertex.getId() + " in server " + serverId);
            vertexService.addVertex(vertex);
        } else {
            // send to the right partition
            putVertexProducer.send(vertex, String.valueOf(partitionId));
        }
    }

    public Vertex getVertex(String vertexId) throws VertexNotFoundException{
        int partitionId = partitionManager.getPartitionId(vertexId);
        if (partitionId == Integer.parseInt(serverId)) {

            return vertexService.getVertex(vertexId);
        } else {
           
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
        for (int i = 0; i < numOfServers; i++) {
            verticesByPartitionId.add(new ArrayList<Vertex>());
        }
        Thread[] activeThreads = new Thread[numOfServers];
        // group vertices ids by partition id
        List<List<String>> verticesIdsByPartitionId = partitionManager.groupVerticesIdsByPartitionId(verticesIds);
        // loop on all partitions and get vertices from them
        for (int i = 0; i < numOfServers; i++) {
            // execute in parallel
            if (verticesIdsByPartitionId.get(i).size() > 0) {
                activeThreads[i] = new Thread(new getVerticesByIdsAsync(vertexService, verticesIdsByPartitionId.get(i),
                        serverId, vertexClient, verticesByPartitionId.get(i), i));
                activeThreads[i].start();
            }

        }

        // wait till only the threads created in this method are finished

        for (int i = 0; i < numOfServers; i++) {
            try {
                if (activeThreads[i] != null)
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

       

        return vertices;
    }

   

    
    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

   
    @Override
    public long getVertexCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVertexCount'");
    }
    @Override
    public Iterable<Edge> getEdgesById(Iterable<EdgeId> edgeIds) throws Exception {
        List<List<EdgeId>> edgeIdsByPartitionId = partitionManager.groupEdgeIdsByPartitionId(edgeIds);
        List<List<Edge>> edgesByPartitionId = new ArrayList<List<Edge>>();
        // initialize
        for (int i = 0; i < numOfServers; i++) {
            edgesByPartitionId.add(new ArrayList<Edge>());
        }

        Thread[] activeThreads = new Thread[numOfServers];
        // loop on all partitions and get edges from them
        for (int i = 0; i < numOfServers; i++) {
            // execute in parallel
            if (edgeIdsByPartitionId.get(i).size() > 0) {
                activeThreads[i] = new Thread(new getEdgesByIdsAsync(vertexService, edgeIdsByPartitionId.get(i),
                        serverId, vertexClient, edgesByPartitionId.get(i), i));
                activeThreads[i].start();
            }

        }

        // wait till only the threads created in this method are finished
        for (int i = 0; i < numOfServers; i++) {
            try {
                if (activeThreads[i] != null)
                    activeThreads[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        List<Edge> edges = new ArrayList<Edge>();
        // append to edges
        for (int i = 0; i < numOfServers; i++) {
            for (Edge edge : edgesByPartitionId.get(i)) {
                edges.add(edge);
            }
        }

        return edges;
    }

    static class getEdgesByIdsAsync implements Runnable {

        private LocalVertexService vertexService;
        private Iterable<EdgeId> edgeIds;
        private String serverId;
        private VertexClient vertexClient;
        private List<Edge> edges;
        private int partitionId;
        
        public getEdgesByIdsAsync(LocalVertexService vertexService, Iterable<EdgeId> edgeIds, String serverId,
        VertexClient vertexClient,
        List<Edge> edges, int partitionId) {
            this.edgeIds = edgeIds;
            this.serverId = serverId;
            this.vertexClient = vertexClient;
            this.edges = edges;
            this.partitionId = partitionId;
            this.vertexService = vertexService;

        }

        @Override
        public void run() {
            if (partitionId != Integer.parseInt(serverId)) {
                // send to the right partition
                Iterable<Edge> edgesFromOtherServer ;
                try {
                    edgesFromOtherServer = vertexClient.getEdgesById(edgeIds,
                            String.valueOf(partitionId));
                            // append to edges
                            for (Edge edge : edgesFromOtherServer) {
                                edges.add(edge);
                            }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                // get from my server
                Iterable<Edge> edgesFromMyServer = vertexService.getEdgesById(edgeIds);
                // append to edges
                for (Edge edge : edgesFromMyServer) {
                    edges.add(edge);
                }
            }
        }

    }

    static class getVerticesByIdsAsync implements Runnable {

        private LocalVertexService vertexService;
        private Iterable<String> verticesIds;
        private String serverId;
        private VertexClient vertexClient;
        private List<Vertex> vertices;
        private int partitionId;
        
        public getVerticesByIdsAsync(LocalVertexService vertexService, Iterable<String> verticesIds, String serverId,
        VertexClient vertexClient,
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
                if (verticesFromOtherServer == null)
                    return;
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
        if (partitionManager.getPartitionId(id) == Integer.parseInt(serverId)) {
            vertexService.deleteVertex(id);
        } else {
            vertexClient.deleteVertex(id, String.valueOf(partitionManager.getPartitionId(id)));
        }
    }

    @Override
    public void updateVertex(String id, String label, Map<String, String> properties) {
        if(partitionManager.getPartitionId(id) == Integer.parseInt(serverId)) {
            vertexService.updateVertex(id, label, properties);
        } else {
            vertexClient.updateVertex(id, label, properties, String.valueOf(partitionManager.getPartitionId(id)));
        }
    }

    @Override
    public void updateVertex(String id, Map<String, String> properties) {
        if(partitionManager.getPartitionId(id) == Integer.parseInt(serverId)) {
            vertexService.updateVertex(id, properties);
        } else {
            vertexClient.updateVertex(id, properties, String.valueOf(partitionManager.getPartitionId(id)));
        }
    }

    public void createVertex (Vertex vertex) throws VertexAlreadyExistsException{
        if(partitionManager.getPartitionId(vertex.getId()) == Integer.parseInt(serverId)) {
            vertexService.addVertex(vertex);
        } else {
            vertexClient.createVertex(vertex, String.valueOf(partitionManager.getPartitionId(vertex.getId())));
        }
    }
    
    public void addEdge(String sourceId, Edge edge) throws Exception{
        // save outgoing edge with the source vertex
        if(partitionManager.getPartitionId(sourceId) == Integer.parseInt(serverId)) {
            vertexService.addEdge(sourceId, edge, true);
        } else {
            vertexClient.createEdge(sourceId, edge,true ,String.valueOf(partitionManager.getPartitionId(sourceId)));
        }

        // save incoming edge with the destination vertex
        if(partitionManager.getPartitionId(edge.getDestinationVertexId()) == Integer.parseInt(serverId)) {
            vertexService.addEdge(sourceId, edge, false);
        } else {
            vertexClient.createEdge(sourceId, edge, false, String.valueOf(partitionManager.getPartitionId(edge.getDestinationVertexId())));
        }
    }

    
    public void deleteEdge(String sourceId, String destinationVertexId, String label) throws Exception{
        if(partitionManager.getPartitionId(sourceId) == Integer.parseInt(serverId)) {
            vertexService.deleteEdge(sourceId, destinationVertexId, label, true);
        } else {
            vertexClient.deleteEdge(sourceId, destinationVertexId, label, true,String.valueOf(partitionManager.getPartitionId(sourceId)));
        }

        if(partitionManager.getPartitionId(destinationVertexId) == Integer.parseInt(serverId)) {
            vertexService.deleteEdge(sourceId, destinationVertexId, label, false);
        } else {
            vertexClient.deleteEdge(sourceId, destinationVertexId, label, false,String.valueOf(partitionManager.getPartitionId(destinationVertexId)));
        }
    }

    
    public void updateEdge(String sourceId, String destinationVertexId, String label, Map<String, String> properties) throws Exception{
        if(partitionManager.getPartitionId(sourceId) == Integer.parseInt(serverId)) {
            vertexService.updateEdge(sourceId, destinationVertexId, label, properties, true);
        } else {
            vertexClient.updateEdge(sourceId, destinationVertexId, label,properties, true,String.valueOf(partitionManager.getPartitionId(sourceId)));
        }


        if(partitionManager.getPartitionId(destinationVertexId) == Integer.parseInt(serverId)) {
            vertexService.updateEdge( sourceId, destinationVertexId,label, properties, false);
        } else {
            vertexClient.updateEdge(sourceId, destinationVertexId,label,properties, false,String.valueOf(partitionManager.getPartitionId(destinationVertexId)));
        }
    }

    @Override
    public Iterable<Edge> getOutgoingEdges(String vertexId) throws Exception {
        if(partitionManager.getPartitionId(vertexId) == Integer.parseInt(serverId)) {
            return vertexService.getOutgoingEdges(vertexId);
        } else {
            return vertexClient.getOutgoingEdges(vertexId, String.valueOf(partitionManager.getPartitionId(vertexId)));
        }
    }

    @Override
    public Iterable<Edge> getIncomingEdges(String vertexId) throws Exception {
        if(partitionManager.getPartitionId(vertexId) == Integer.parseInt(serverId)) {
            return vertexService.getIncomingEdges(vertexId);
        } else {
            return vertexClient.getIncomingEdges(vertexId, String.valueOf(partitionManager.getPartitionId(vertexId)));
        }

    }


}
