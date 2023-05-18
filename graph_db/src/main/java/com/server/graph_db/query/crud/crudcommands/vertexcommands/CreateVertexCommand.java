package com.server.graph_db.query.crud.crudcommands.vertexcommands;

import java.util.Map;

import com.server.graph_db.core.exceptions.vertex.VertexAlreadyExistsException;
import com.server.graph_db.core.vertex.Vertex;
import com.server.graph_db.query.crud.CrudResult;

public class CreateVertexCommand extends CrudVertexCommand {
    String label;
    Map<String, String> properties;


   

   
   

    // use builder pattern
    public CreateVertexCommand(String vertexId, String label, Map<String, String> properties) {
        super(vertexId);
        this.label = label;
        this.properties = properties;
    }

    public String getLabel() {
        return label;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }


    @Override
    public void execute() throws VertexAlreadyExistsException{
        Vertex vertex = new Vertex(vertexId);
        if(this.label != null){
            vertex.setLabel(label);
        }
        if(this.properties != null){
            vertex.setProperties(properties);
        }

        globalVertexService.createVertex(vertex);

        String message = "Vertex with id "+vertexId+" created";
        CrudResult crudResult = new CrudResult();
        crudResult.setMessage(message);
        setResult(crudResult);


        
    }

  
    
    public static class Builder {
        String vertexId;
        String label;
        Map<String, String> properties;

        public Builder(String vertexId) {
            this.vertexId = vertexId;
        }

        public Builder setLabel(String label) {
            this.label = label;
            return this;
        }

        public Builder setProperties(Map<String, String> properties) {
            this.properties = properties;
            return this;
        }

        public CreateVertexCommand build() {
            return new CreateVertexCommand(vertexId, label, properties);
        }
    }
    
}
