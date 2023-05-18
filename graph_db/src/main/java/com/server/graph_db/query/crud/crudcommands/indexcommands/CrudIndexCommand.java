package com.server.graph_db.query.crud.crudcommands.indexcommands;

import com.server.graph_db.core.index.GlobalSecondaryIndexManager;
import com.server.graph_db.core.vertex.GlobalVertexService;
import com.server.graph_db.query.crud.crudcommands.CrudCommand;

public class CrudIndexCommand extends CrudCommand {
    String indexName;
    GlobalSecondaryIndexManager globalSecondaryIndexManager;
    public CrudIndexCommand( String indexName) {
        this.indexName = indexName;
    }


    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }
    @Override
    public void execute() throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void setGlobalVertexService(GlobalVertexService globalVertexService) {
        
    }

    @Override
    public void setGlobalSecondaryIndexManager(GlobalSecondaryIndexManager globalSecondaryIndexManager) {
        this.globalSecondaryIndexManager = globalSecondaryIndexManager;
    }
    
}
