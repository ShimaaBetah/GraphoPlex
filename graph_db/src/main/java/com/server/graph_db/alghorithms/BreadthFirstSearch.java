package com.server.graph_db.alghorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.graph_db.core.exceptions.vertex.VertexNotFoundException;
import com.server.graph_db.core.partition.PartitionManager;
import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.GlobalVertexService;
import com.server.graph_db.core.vertex.LocalVertexService;
import com.server.graph_db.core.vertex.Vertex;
import com.server.graph_db.grpc.traverser.edgeIds;

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
        count = 0;
        visited = new HashSet<String>();
        Iterable<String> verticesIds = globalVertexService.getAllVerticesIds();
        for (String id : verticesIds) {
            if (!visited.contains(id)) {
                visited.add(id);
                bfs(id);
            }

        }
        System.out.println(visited.size());

    }


    public void bfs (String id) throws Exception{
        Set<String> currLevel = new HashSet<>();
        currLevel.add(id);
        visited.add(id);
        while(!currLevel.isEmpty()){
            Set<String> nextLevel = new HashSet<String>();
            Iterable<Edge> edges = globalVertexService.getOutgoingEdges(currLevel);
            for (Edge edge : edges) {
                    
                    if (!visited.contains(edge.getDestinationVertexId())) {
                        //System.out.println(edge.getDestinationVertexId());
                        visited.add(edge.getDestinationVertexId());
                        nextLevel.add(edge.getDestinationVertexId());
                    }
                
            }
            currLevel = nextLevel;
        }
    }

}
