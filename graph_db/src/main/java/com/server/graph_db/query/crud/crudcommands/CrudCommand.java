package com.server.graph_db.query.crud.crudcommands;

import com.server.graph_db.core.index.GlobalSecondaryIndexManager;
import com.server.graph_db.core.vertex.GlobalVertexService;
import com.server.graph_db.query.Command;

public abstract class CrudCommand extends Command {
    public abstract void setGlobalVertexService(GlobalVertexService globalVertexService);
    public abstract  void setGlobalSecondaryIndexManager(GlobalSecondaryIndexManager globalSecondaryIndexManager);

}
