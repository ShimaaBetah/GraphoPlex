package com.server.graph_db.query.crud.crudcommands.indexcommands;

import com.server.graph_db.query.crud.CrudResult;

public class DeleteIndexCommand extends CrudIndexCommand{

    public DeleteIndexCommand(String indexName) {
        super(indexName);
    }

    @Override
    public void execute() throws Exception {
        globalSecondaryIndexManager.deleteIndex(indexName);
        String message = "Index Deleted on "+indexName;
        CrudResult crudResult = new CrudResult();
        crudResult.setMessage(message);
        setResult(crudResult);
    }

    public static class Builder{
        String indexName;

        public Builder(String indexName) {
            this.indexName = indexName;
        }

        public DeleteIndexCommand build(){
            return new DeleteIndexCommand(indexName);
        }
    }
    
}
