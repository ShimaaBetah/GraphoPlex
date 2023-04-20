package com.server.graph_db.query.crud.crudcommands.edgecommands;

import java.util.Map;

public class UpdateEdgeCommand extends CrudEdgeCommand {
    
    Map<String, String> properties;
    public UpdateEdgeCommand(String sourceVertexId, String destinationVertexId, String label, Map<String, String> properties) {
        super(sourceVertexId, destinationVertexId, label);
        this.properties = properties;
    }

    @Override
    public void execute() throws Exception {
        globalVertexService.updateEdge(sourceVertexId, destinationVertexId, label, properties);
    }


    public static class Builder{
        String sourceVertexId;
        String destinationVertexId;
        String label;
        Map<String, String> properties;

        public Builder(String sourceVertexId, String destinationVertexId, String label, Map<String, String> properties) {
            this.sourceVertexId = sourceVertexId;
            this.destinationVertexId = destinationVertexId;
            this.label = label;
            this.properties = properties;
        }

        public UpdateEdgeCommand build(){
            return new UpdateEdgeCommand(sourceVertexId, destinationVertexId, label, properties);
        }
    }

     
    
}
