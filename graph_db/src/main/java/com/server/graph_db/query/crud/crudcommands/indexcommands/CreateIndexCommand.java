package com.server.graph_db.query.crud.crudcommands.indexcommands;

public class CreateIndexCommand extends CrudIndexCommand{

    public CreateIndexCommand(String indexName) {
        super(indexName);
    }

    @Override
    public void execute() throws Exception {
        globalSecondaryIndexManager.createIndex(indexName);
    }

    public static class Builder{
        String indexName;

        public Builder(String indexName) {
            this.indexName = indexName;
        }

        public CreateIndexCommand build(){
            return new CreateIndexCommand(indexName);
        }
    }
    
    
}
