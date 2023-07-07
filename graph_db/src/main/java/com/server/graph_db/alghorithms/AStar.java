package com.server.graph_db.alghorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.server.graph_db.alghorithms.heuristics.Hueristic;
import com.server.graph_db.alghorithms.traversables.AStarTraversable;
import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.GlobalVertexService;
import com.server.graph_db.core.vertex.Vertex;


public class AStar implements ShortestPathAlghorithm{

    GlobalVertexService vertexService;



    String sourceVertexId;
    String destinationVertexId;

    Vertex sourceVertex;
    Vertex destinationVertex;

    Hueristic hueristic;
    


    LinkedList<Edge> pathReturned;
    HashMap<String, AStarTraversable> visited;

    
    PriorityQueue<AStarTraversable> queue;
    long shortestPath = 0;

    public AStar(GlobalVertexService vertexService, Hueristic hueristic) {
        this.vertexService = vertexService;
        this.hueristic = hueristic;
    }


    public void compute(String source, String destination, String costField) throws Exception {
        visited = new HashMap<String, AStarTraversable>();
        queue = new PriorityQueue<AStarTraversable>();
        pathReturned = new LinkedList<Edge>();
        sourceVertexId = source;
        destinationVertexId = destination;
        sourceVertex = vertexService.getVertex(sourceVertexId);
        destinationVertex = vertexService.getVertex(destinationVertexId);
        queue.add(new AStarTraversable(source, 0L, null,0L ));
        while (!queue.isEmpty()) {
            AStarTraversable currentVertex = queue.poll();
            if (currentVertex.getVertexId() .equals( destination)) {
                visited.put(currentVertex.getVertexId(), currentVertex);
                shortestPath = currentVertex.getDistance();
                break;
            }

            if(visited.containsKey(currentVertex.getVertexId())){
                continue;
            }
            visited.put(currentVertex.getVertexId(), currentVertex);
           
            Iterable<Edge> neighbours = vertexService.getOutgoingEdges(currentVertex.getVertexId());
            //filter only edhes that has isPropertyExist(costField)
            neighbours = StreamSupport.stream(neighbours.spliterator(), false).filter(edge -> edge.isPropertyExist(costField)).collect(Collectors.toList());

            for (Edge neighbour : neighbours) {
                if(!visited.containsKey(neighbour.getDestinationVertexId())){
                Vertex neighbourVertex = vertexService.getVertex(neighbour.getDestinationVertexId());
                long hueristicValue = hueristic.getHeuristic(neighbourVertex, destinationVertex);
                queue.add(new AStarTraversable(neighbour.getDestinationVertexId(), currentVertex.getDistance() + Long.parseLong(neighbour.getProperties().get(costField)), neighbour, hueristicValue));
                }
            }
        }

        
    }



    public long getShortestPath() {
        return shortestPath;
    }


    public Iterable<Edge> getPath() throws Exception {
        AStarTraversable currentVertex = visited.get(destinationVertexId);
        if(currentVertex == null){
           throw new Exception ("Vertex with id " + destinationVertexId + " is not reachable from vertex with id " + sourceVertexId + "");
        }
        while (currentVertex != null && currentVertex.getPrecedingEdge() != null) {
            pathReturned.addFirst(currentVertex.getPrecedingEdge());
            currentVertex = visited.get(currentVertex.getPrecedingEdge().getSourceVertexId());
        }
        return pathReturned;
    }



    
}
