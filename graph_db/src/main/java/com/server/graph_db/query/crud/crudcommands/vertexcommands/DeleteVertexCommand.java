package com.server.graph_db.query.crud.crudcommands.vertexcommands;

import com.server.graph_db.query.crud.CrudResult;

public class DeleteVertexCommand extends CrudVertexCommand {
    public DeleteVertexCommand(String vertexId) {
        super(vertexId);
    }

    @Override
    public void execute() {
        globalVertexService.deleteVertex(vertexId);
        String message = "Vertex with id "+vertexId+" deleted";
        CrudResult crudResult = new CrudResult();
        crudResult.setMessage(message);
        setResult(crudResult);
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
