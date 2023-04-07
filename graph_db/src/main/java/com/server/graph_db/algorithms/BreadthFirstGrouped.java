package com.server.graph_db.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.graph_db.vertex.Edge;
import com.server.graph_db.vertex.GlobalVertexService;
import com.server.graph_db.vertex.Vertex;
import com.server.graph_db.vertex.LocalVertexService;

@Service
public class BreadthFirstGrouped {
    @Autowired
    GlobalVertexService globalVertexService;
    

    @Autowired 
    LocalVertexService vertexService;

    int count = 0;
    int maxSize = 0;

    HashSet<String> visited;

    public BreadthFirstGrouped(GlobalVertexService globalVertexService) {
        this.globalVertexService = globalVertexService;
    }
    
    public void compute() {
        visited = new HashSet<String>();
        Iterable<String> verticesIds = globalVertexService.getAllVerticesIds();
        for (String id : verticesIds) {
            if (!visited.contains(id)) {
                visited.add(id);
                bfs(id);
            }
         
        }
    }


    public void bfs (String id){
       
        Queue<String> currentLevelIds = new LinkedList<String>();
        Queue<Vertex> currentLevel = new LinkedList<Vertex>();
        currentLevelIds.add(id);
        currentLevel.add(globalVertexService.getVertex(id));
        visited.add(id);
        while(!currentLevel.isEmpty()){
            currentLevel = processAndGetNextLevel(currentLevel);
        }
       
       
    }

    private Queue<Vertex> processAndGetNextLevel(Queue<Vertex> currentLevel) {
        System.out.println("currentLevel size: " + currentLevel.size());
        maxSize = Math.max(maxSize, currentLevel.size());
        List<String> nextLevel = new LinkedList<String>();
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

        Iterable<Vertex> vertices = globalVertexService.getVerticesByIds(nextLevel);
        Queue<Vertex> nextLevelQueue = new LinkedList<Vertex>();
        for (Vertex vertex : vertices) {
            nextLevelQueue.add(vertex);
        }
        
        return nextLevelQueue;
    }
    
}
