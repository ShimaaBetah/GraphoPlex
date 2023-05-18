package com.server.graph_db.alghorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.graph_db.core.exceptions.vertex.VertexNotFoundException;
import com.server.graph_db.core.partition.PartitionManager;
import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.GlobalVertexService;
import com.server.graph_db.core.vertex.LocalVertexService;
import com.server.graph_db.core.vertex.Vertex;

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

    public void compute() throws Exception {
        visited = new HashSet<String>();
        Iterable<String> verticesIds = globalVertexService.getAllVerticesIds();
        for (String id : verticesIds) {
            if (!visited.contains(id)) {
                visited.add(id);
                bfs(id);
            }
        }
    }


    public void bfs (String id) throws Exception{
        Queue<String> queue = new LinkedList<String>();
        queue.add(id);
        visited.add(id);
        while(!queue.isEmpty()){
            String vertexId = queue.poll();
            count++;
            visited.add(vertexId);
            Vertex vertex;
            try {
                vertex = globalVertexService.getVertex(vertexId);
            } catch (VertexNotFoundException e) {
                continue;
            }
           
            Iterable<Edge> edges = globalVertexService.getOutgoingEdges(vertexId);
            for (Edge edge : edges) {
                if(!visited.contains(edge.getDestinationVertexId())){
                    visited.add(edge.getDestinationVertexId());
                    queue.add(edge.getDestinationVertexId());
                }
                
            }
        }
    }

}
