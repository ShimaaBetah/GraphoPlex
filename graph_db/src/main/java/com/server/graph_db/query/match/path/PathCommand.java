package com.server.graph_db.query.match.path;

import java.util.List;
import java.util.Set;

import com.server.graph_db.query.Command;
import com.server.graph_db.query.Result;
import com.server.graph_db.query.crud.CrudResult;
import com.server.graph_db.query.match.MatchCommand;
import com.server.graph_db.traversers.BreadtFirstSearchGrouped;
import com.server.graph_db.traversers.GlobalTraverserManager;
import com.server.graph_db.traversers.traversables.BreadthFirstSearchTraversable;
import com.server.graph_db.vertex.GlobalVertexService;

public class PathCommand extends MatchCommand{

    Path path;
    ReturnClause returnClause;
    GlobalVertexService globalVertexService;
    GlobalTraverserManager globalTraverserManager;

    public PathCommand(Path path){
        this.path = path;
    }
    @Override
    public void setGlobalVertexService(GlobalVertexService globalVertexService) {
        this.globalVertexService = globalVertexService;
    }

    @Override
    public void setGlobalTraverserManager(GlobalTraverserManager globalTraverserManager) {
        this.globalTraverserManager = globalTraverserManager;
    }

    public void setReturnClause(ReturnClause returnClause) {
        this.returnClause = returnClause;
    }

    public void verify() throws Exception{
        Set<String> pathAliases = path.getAliases();
        Set<String> returnAliases = returnClause.getAliases();
        for(String alias : returnAliases){
            if(!pathAliases.contains(alias)){
                throw new Exception("Cannot Return " + alias + " as it is not found in path");
            }
        }

    }

    @Override
    public void execute() throws Exception {
        verify();
        BreadtFirstSearchGrouped bfs = new BreadtFirstSearchGrouped(globalVertexService, globalTraverserManager, path);
        List<BreadthFirstSearchTraversable> matchedPaths = bfs.compute().getMatchedPaths();
        System.out.println("Matched Paths");
        System.out.println(matchedPaths);
        returnClause.setGlobalVertexService(globalVertexService);
        returnClause.setPathReturned(matchedPaths);
        returnClause.execute();



        setResult(returnClause.generatePathResult());


        
    }
    
}
