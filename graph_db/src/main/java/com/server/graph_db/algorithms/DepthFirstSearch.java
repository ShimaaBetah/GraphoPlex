package com.server.graph_db.algorithms;

import java.util.HashSet;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.graph_db.exceptions.VertexNotFoundException;
import com.server.graph_db.vertex.Edge;
import com.server.graph_db.vertex.GlobalVertexService;
import com.server.graph_db.vertex.Vertex;

@Service
public class DepthFirstSearch {
    
    @Autowired
    GlobalVertexService globalVertexService;

    int count = 0;

    HashSet<String> visited;
    
    public DepthFirstSearch(GlobalVertexService globalVertexService) {
        this.globalVertexService = globalVertexService;
    }

    public void compute() {
        visited = new HashSet<String>();
        Iterable<String> verticesIds = globalVertexService.getAllVerticesIds();
        for (String id : verticesIds) {
            if (!visited.contains(id)) {
                dfs(id);
            }
        }
    }

    //iterative version of dfs using stack
    public void dfs (String id){
        Stack<String> stack = new Stack<String>();
        stack.push(id);
        while(!stack.isEmpty()){
            String vertexId = stack.pop();
            if(!visited.contains(vertexId)){
                visited.add(vertexId);
                System.out.println(count);
                count++;
                Vertex visitedVertex;
                try {
                    visitedVertex = globalVertexService.getVertex(vertexId);
                } catch (VertexNotFoundException e) {
                    continue;
                }
                if(visitedVertex == null){
                    continue;
                }
                Iterable<Edge> edges = visitedVertex.getOutgoingEdges();
                for (Edge edge : edges) {
                    stack.push(edge.getDestinationVertexId());
                }
            }
        }
    }
    

}
