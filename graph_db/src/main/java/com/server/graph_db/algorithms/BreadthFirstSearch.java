package com.server.graph_db.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.graph_db.partition.PartitionManager;
import com.server.graph_db.vertex.Edge;
import com.server.graph_db.vertex.Vertex;
import com.server.graph_db.vertex.VertexService;

@Service
public class BreadthFirstSearch {

    @Autowired
    PartitionManager partitionManager;

    @Autowired 
    VertexService vertexService;

    int count = 0;

    HashSet<Integer> visited;

    public BreadthFirstSearch(PartitionManager partitionManager) {
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
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(id);
        visited.add(id);
        while(!queue.isEmpty()){
            Integer vertexId = queue.poll();
            System.out.println(count);
            count++;
            visited.add(vertexId);
            Vertex vertex = partitionManager.getVertex(vertexId);
            if(vertex == null){
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
