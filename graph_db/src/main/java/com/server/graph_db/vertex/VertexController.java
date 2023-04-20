package com.server.graph_db.vertex;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.server.graph_db.exceptions.vertex.VertexAlreadyExistsException;
import com.server.graph_db.exceptions.vertex.VertexNotFoundException;


@RestController
public class VertexController {
    

    @Autowired
    private LocalVertexService vertexService;
    



    public VertexController(LocalVertexService vertexService) {
        this.vertexService = vertexService;
    }
        
    

  @GetMapping("/vertex/{id}")
    public Vertex getVertex(@PathVariable String id) {
        try {
            return vertexService.getVertex(id);
        } catch (VertexNotFoundException e) {
            // TODO Auto-generated catch block
            return null;
        }
    }
     

     @PostMapping("/vertex")

    public void addVertex(@RequestBody Vertex vertex) {
        vertex = new Vertex(vertex.getId());
        try {
            vertexService.addVertex(vertex);
        } catch (VertexAlreadyExistsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } 

    //add edge 
    @PostMapping("/vertex/{id}/edge")
    public void addEdge(@PathVariable String id, @RequestBody Edge edge) {
        edge= new Edge(edge.getDestinationVertexId());
        try {
            vertexService.addEdge(id, edge);
        } catch (VertexNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @GetMapping("/vertex/{id}/edge")
    public LinkedList<Edge> getEdges(@PathVariable String id) {
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

    //get all vertices ids
    @GetMapping("/vertex/ids")
    public Iterable<String> getAllVerticesIds() {
        return vertexService.getAllVerticesIds();
    }
}
