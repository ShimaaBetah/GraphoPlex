package com.server.graph_db.vertex;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VertexController {
    

    @Autowired
    private VertexService vertexService;
    



    public VertexController(VertexService vertexService) {
        this.vertexService = vertexService;
    }
        
    

  @GetMapping("/vertex/{id}")
    public Vertex getVertex(@PathVariable int id) {
        return vertexService.getVertex(id);
    }
     

     @PostMapping("/vertex")

    public void addVertex(@RequestBody Vertex vertex) {
        vertex = new Vertex(vertex.getId());
        vertexService.addVertex(vertex);
    } 

    //add edge 
    @PostMapping("/vertex/{id}/edge")
    public void addEdge(@PathVariable int id, @RequestBody Edge edge) {
        edge= new Edge(edge.getDestinationVertexId());
        vertexService.addEdge(id, edge);
    }

    @GetMapping("/vertex/{id}/edge")
    public LinkedList<Edge> getEdges(@PathVariable int id) {
        return vertexService.getEdges(id);
    }

    @DeleteMapping("/vertex")
    public void deleteAll() {
        vertexService.deleteAll();
    }

    //get vertex count 
    @GetMapping("/vertex/count")
    public long getVertexCount() {
        return vertexService.getVertexCount();
    }
}
