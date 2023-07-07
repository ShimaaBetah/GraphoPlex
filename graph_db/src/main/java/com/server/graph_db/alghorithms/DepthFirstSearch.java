package com.server.graph_db.alghorithms;

import java.util.HashSet;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.graph_db.core.exceptions.vertex.VertexNotFoundException;
import com.server.graph_db.core.vertex.Edge;
import com.server.graph_db.core.vertex.GlobalVertexService;
import com.server.graph_db.core.vertex.Vertex;

@Service
public class DepthFirstSearch {
    
    @Autowired
    GlobalVertexService globalVertexService;

    int count = 0;

    HashSet<String> visited;
    
    public DepthFirstSearch(GlobalVertexService globalVertexService) {
        this.globalVertexService = globalVertexService;
    }

    public void compute() throws Exception {
        visited = new HashSet<String>();
        Iterable<String> verticesIds = globalVertexService.getAllVerticesIds();
        for (String id : verticesIds) {
            if (!visited.contains(id)) {
                dfs(id);
            }
        }
    }

    //iterative version of dfs using stack
    public void dfs (String id) throws Exception{
        Stack<String> stack = new Stack<String>();
        stack.push(id);
        visited.add(id);
        while(!stack.isEmpty()){
            String vertexId = stack.pop();
                Iterable<Edge> edges = globalVertexService.getOutgoingEdges(vertexId);
                for (Edge edge : edges) {
                    if(!visited.contains(edge.getDestinationVertexId())){
                        stack.push(edge.getDestinationVertexId());
                       visited.add(edge.getDestinationVertexId());
                    }
                }
            
        }
    }
    

}
