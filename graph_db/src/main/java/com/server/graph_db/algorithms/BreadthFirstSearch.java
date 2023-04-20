package com.server.graph_db.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.graph_db.exceptions.vertex.VertexNotFoundException;
import com.server.graph_db.partition.PartitionManager;
import com.server.graph_db.vertex.Edge;
import com.server.graph_db.vertex.GlobalVertexService;
import com.server.graph_db.vertex.Vertex;
import com.server.graph_db.vertex.LocalVertexService;

@Service
public class BreadthFirstSearch {

    @Autowired
    GlobalVertexService globalVertexService;

    @Autowired 
    LocalVertexService vertexService;

    int count = 0;

    HashSet<String> visited;

    public BreadthFirstSearch(GlobalVertexService globalVertexService) {
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
        Queue<String> queue = new LinkedList<String>();
        queue.add(id);
        visited.add(id);
        while(!queue.isEmpty()){
            String vertexId = queue.poll();
            System.out.println(count);
            count++;
            visited.add(vertexId);
            Vertex vertex;
            try {
                vertex = globalVertexService.getVertex(vertexId);
            } catch (VertexNotFoundException e) {
                continue;
            }
           
            LinkedList<Edge> edges = vertex.getOutgoingEdges();
            for (Edge edge : edges) {
                if(!visited.contains(edge.getDestinationVertexId())){
                    visited.add(edge.getDestinationVertexId());
                    queue.add(edge.getDestinationVertexId());
                }
                
            }
        }
    }

}
