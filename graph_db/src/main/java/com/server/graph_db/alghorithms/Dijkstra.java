package com.server.graph_db.alghorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


import com.server.graph_db.alghorithms.traversables.DijkstraTraversable;
import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.GlobalVertexService;


public class Dijkstra {

    GlobalVertexService vertexService;



    String sourceVertexId;
    String destinationVertexId;
    


    LinkedList<Edge> pathReturned;
    HashMap<String, DijkstraTraversable> visited;

    
    PriorityQueue<DijkstraTraversable> queue;
    long shortestPath = 0;

    public Dijkstra(GlobalVertexService vertexService) {
        this.vertexService = vertexService;
    }


    public void compute(String source, String destination, String costField) throws Exception {
        visited = new HashMap<String, DijkstraTraversable>();
        queue = new PriorityQueue<DijkstraTraversable>();
        pathReturned = new LinkedList<Edge>();
        sourceVertexId = source;
        destinationVertexId = destination;
        queue.add(new DijkstraTraversable(source, 0L, null ));
        while (!queue.isEmpty()) {
            DijkstraTraversable currentVertex = queue.poll();
            if (currentVertex.getVertexId() .equals( destination)) {
                visited.put(currentVertex.getVertexId(), currentVertex);
                shortestPath = currentVertex.getDistance();
                break;
            }
            if (visited.containsKey(currentVertex.getVertexId())) {
                continue;
            }
            visited.put(currentVertex.getVertexId(), currentVertex);
            
           
            Iterable<Edge> neighbours = vertexService.getOutgoingEdges(currentVertex.getVertexId());
            //filter only edhes that has isPropertyExist(costField)
            neighbours = StreamSupport.stream(neighbours.spliterator(), false).filter(edge -> edge.isPropertyExist(costField)).collect(Collectors.toList());

            for (Edge neighbour : neighbours) {
                queue.add(new DijkstraTraversable(neighbour.getDestinationVertexId(), currentVertex.getDistance() + Long.parseLong(neighbour.getProperties().get(costField)), neighbour));
            }
        }

        
    }



    public long getShortestPath() {
        return shortestPath;
    }


    public Iterable<Edge> getPath() throws Exception {
        DijkstraTraversable currentVertex = visited.get(destinationVertexId);
        if(currentVertex == null){
           throw new Exception ("Vertex with id " + destinationVertexId + " is not reachable from vertex with id " + sourceVertexId + "");
        }
        while (currentVertex != null) {
            pathReturned.addFirst(currentVertex.getPrecedingEdge());
            currentVertex = visited.get(currentVertex.getPrecedingEdge().getSourceVertexId());
        }
        return pathReturned;
    }



    
}
