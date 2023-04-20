package com.server.graph_db.query.crud.crudcommands.edgecommands;

public class DeleteEdgeCommand extends CrudEdgeCommand{

    public DeleteEdgeCommand(String sourceVertexId, String destinationVertexId, String label) {
        super(sourceVertexId, destinationVertexId, label);
    }

    @Override
    public void execute() throws Exception {
        globalVertexService.deleteEdge(sourceVertexId, destinationVertexId, label);
    }

    public static class Builder{
        String sourceVertexId;
        String destinationVertexId;
        String label;

        public Builder(String sourceVertexId, String destinationVertexId, String label) {
            this.sourceVertexId = sourceVertexId;
            this.destinationVertexId = destinationVertexId;
            this.label = label;
        }

        public DeleteEdgeCommand build(){
            return new DeleteEdgeCommand(sourceVertexId, destinationVertexId, label);
        }
    }
    
}
