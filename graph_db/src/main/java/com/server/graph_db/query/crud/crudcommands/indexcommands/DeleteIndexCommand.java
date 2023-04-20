package com.server.graph_db.query.crud.crudcommands.indexcommands;

public class DeleteIndexCommand extends CrudIndexCommand{

    public DeleteIndexCommand(String indexName) {
        super(indexName);
    }

    @Override
    public void execute() throws Exception {
        globalSecondaryIndexManager.deleteIndex(indexName);
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
