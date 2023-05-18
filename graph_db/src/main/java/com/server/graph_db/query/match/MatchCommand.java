package com.server.graph_db.query.match;

import com.server.graph_db.core.traversers.GlobalTraverserManager;
import com.server.graph_db.core.vertex.GlobalVertexService;
import com.server.graph_db.query.Command;

public abstract class  MatchCommand extends Command{

    public abstract void setGlobalVertexService(GlobalVertexService globalVertexService);
    public abstract void setGlobalTraverserManager(GlobalTraverserManager globalTraverserManager);


}
