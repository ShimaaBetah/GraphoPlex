package com.server.graph_db.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.graph_db.partition.PartitionManager;
import com.server.graph_db.vertex.Edge;
import com.server.graph_db.vertex.Vertex;
import com.server.graph_db.vertex.VertexService;

@Service
public class BreadthFirstGrouped {
    @Autowired
    PartitionManager partitionManager;

    @Autowired 
    VertexService vertexService;

    int count = 0;
    int maxSize = 0;

    HashSet<Integer> visited;

    public BreadthFirstGrouped(PartitionManager partitionManager) {
        this.partitionManager = partitionManager;
        visited = new HashSet<Integer>();
    }

    public void compute() {
        Iterable<Integer> verticesIds = partitionManager.getVerticesIds();
        for (Integer id : verticesIds) {
            if (!visited.contains(id)) {
                visited.add(id);
                bfs(id);
            }
        }
    }


    public void bfs (Integer id){
        Queue<Integer> currentLevelIds = new LinkedList<Integer>();
        Queue<Vertex> currentLevel = new LinkedList<Vertex>();
        currentLevelIds.add(id);
        currentLevel.add(partitionManager.getVertex(id));
        visited.add(id);
        while(!currentLevel.isEmpty()){
            currentLevel = processAndGetNextLevel(currentLevel);
        }
    }

    private Queue<Vertex> processAndGetNextLevel(Queue<Vertex> currentLevel) {
        System.out.println("currentLevel size: " + currentLevel.size());
        maxSize = Math.max(maxSize, currentLevel.size());
        List<Integer> nextLevel = new LinkedList<Integer>();
        while(!currentLevel.isEmpty()){
            Vertex vertex = currentLevel.poll();
            System.out.println(count);
            count++;
            if(vertex == null){
                continue;
            }
            LinkedList<Edge> edges = vertex.getOutgoingEdges();
            for (Edge edge : edges) {
                if(!visited.contains(edge.getDestinationVertexId())){
                    visited.add(edge.getDestinationVertexId());
                    nextLevel.add(edge.getDestinationVertexId());
                }
                
            }
        }

        Iterable<Vertex> vertices = partitionManager.getVertices(nextLevel);
        Queue<Vertex> nextLevelQueue = new LinkedList<Vertex>();
        for (Vertex vertex : vertices) {
            nextLevelQueue.add(vertex);
        }
        return nextLevelQueue;
    }
    
}
