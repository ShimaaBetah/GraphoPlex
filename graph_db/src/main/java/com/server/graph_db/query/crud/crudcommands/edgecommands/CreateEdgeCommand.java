package com.server.graph_db.query.crud.crudcommands.edgecommands;

import java.util.Map;

import com.server.graph_db.vertex.Edge;

public class CreateEdgeCommand extends CrudEdgeCommand{
    Edge edge;
    public CreateEdgeCommand(String sourceVertexId, String destinationVertexId, String label, Edge edge) {
        super(sourceVertexId, destinationVertexId, label);
        this.edge = edge;
    }



    @Override
    public void execute() throws Exception {
        globalVertexService.addEdge(sourceVertexId, edge);
    }


    public static class Builder{
        String sourceVertexId;
        String destinationVertexId;
        String label;
        Map<String, String> properties;

        public Builder(String sourceVertexId, String destinationVertexId, String label) {
            this.sourceVertexId = sourceVertexId;
            this.destinationVertexId = destinationVertexId;
            this.label = label;
        }

        public Builder setProperties(Map<String, String> properties) {
            this.properties = properties;
            return this;
        }

        public CreateEdgeCommand build(){
            Edge edge = new Edge(destinationVertexId);
            edge.setLabel(label);
            if(properties!=null){
                edge.setProperties(properties);
            }
            return new CreateEdgeCommand(sourceVertexId, destinationVertexId, label, edge);
        }
    }


    
}
