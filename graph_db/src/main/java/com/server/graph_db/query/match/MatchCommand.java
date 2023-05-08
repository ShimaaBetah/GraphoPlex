package com.server.graph_db.query.match;

import com.server.graph_db.query.Command;
import com.server.graph_db.traversers.GlobalTraverserManager;
import com.server.graph_db.vertex.GlobalVertexService;

public abstract class  MatchCommand extends Command{

    public abstract void setGlobalVertexService(GlobalVertexService globalVertexService);
    public abstract void setGlobalTraverserManager(GlobalTraverserManager globalTraverserManager);


}
