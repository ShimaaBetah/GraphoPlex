package com.server.graph_db.query.crud.crudcommands;

import com.server.graph_db.index.GlobalSecondaryIndexManager;
import com.server.graph_db.query.Command;
import com.server.graph_db.vertex.GlobalVertexService;

public abstract class CrudCommand extends Command {
    public abstract void setGlobalVertexService(GlobalVertexService globalVertexService);
    public abstract  void setGlobalSecondaryIndexManager(GlobalSecondaryIndexManager globalSecondaryIndexManager);

}
