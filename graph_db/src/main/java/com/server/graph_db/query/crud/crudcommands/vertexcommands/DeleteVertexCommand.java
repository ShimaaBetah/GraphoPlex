package com.server.graph_db.query.crud.crudcommands.vertexcommands;

public class DeleteVertexCommand extends CrudVertexCommand {
    public DeleteVertexCommand(String vertexId) {
        super(vertexId);
    }

    @Override
    public void execute() {
        globalVertexService.deleteVertex(vertexId);
    }

    public static class Builder {
        String vertexId;

        public Builder(String vertexId) {
            this.vertexId = vertexId;
        }

        public DeleteVertexCommand build() {
            return new DeleteVertexCommand(vertexId);
        }
    }
    
}
