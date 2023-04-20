package com.server.graph_db.query.crud.crudcommands;

import com.server.graph_db.index.GlobalSecondaryIndexManager;
import com.server.graph_db.query.Command;
import com.server.graph_db.vertex.GlobalVertexService;

public interface CrudCommand extends Command {
    public void setGlobalVertexService(GlobalVertexService globalVertexService);
    public void setGlobalSecondaryIndexManager(GlobalSecondaryIndexManager globalSecondaryIndexManager);
}
