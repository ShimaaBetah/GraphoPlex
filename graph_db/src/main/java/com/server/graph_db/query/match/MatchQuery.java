package com.server.graph_db.query.match;

import org.apache.tomcat.jni.Global;

import com.server.graph_db.core.traversers.GlobalTraverserManager;
import com.server.graph_db.core.vertex.GlobalVertexService;
import com.server.graph_db.query.Command;
import com.server.graph_db.query.Query;

public class MatchQuery extends Query{

    MatchCommand matchCommand;
    GlobalVertexService globalVertexService;
    GlobalTraverserManager globalTraverserManager;

    public MatchQuery(GlobalVertexService globalVertexService, GlobalTraverserManager globalTraverserManager) {
        this.globalVertexService = globalVertexService;
        this.globalTraverserManager = globalTraverserManager;
    }

    @Override
    public void execute() throws Exception {
        matchCommand.setGlobalTraverserManager(globalTraverserManager);
        matchCommand.setGlobalVertexService(globalVertexService);
        long startTime = System.currentTimeMillis();
        matchCommand.execute();
        long endTime = System.currentTimeMillis();
        matchCommand.getResult().setTotalExecutionTime(endTime - startTime);
        
    }

    @Override
    public Command getCommand() {
        return matchCommand;
        
    }

    @Override
    public void setCommand(Command command) {
        this.matchCommand = (MatchCommand) command;
    }
    
}
