package com.server.graph_db.alghorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.server.graph_db.alghorithms.traversables.BreadthFirstSearchTraversable;
import com.server.graph_db.core.traversers.GlobalTraverserManager;
import com.server.graph_db.core.traversers.bindings.Path;
import com.server.graph_db.core.vertex.EdgeId;
import com.server.graph_db.core.vertex.GlobalVertexService;


public class BreadtFirstSearchGrouped {
    
    GlobalVertexService globalVertexService;

    GlobalTraverserManager globalTraverserManager;
    

    Path path;
    List<BreadthFirstSearchTraversable> currLevel ;


    public BreadtFirstSearchGrouped(GlobalVertexService globalVertexService, GlobalTraverserManager globalTraverserManager, Path path) {
        this.globalVertexService = globalVertexService;
        this.globalTraverserManager = globalTraverserManager;
        this.path = path;
        currLevel = new LinkedList<BreadthFirstSearchTraversable>();
    }
    
    public BreadtFirstSearchGrouped compute() throws Exception {

        List<String> verticesIds = new ArrayList<String>();
        if(path.getStartVertexBinding().hasId()){
            try{
                globalVertexService.getVertex(path.getStartVertexBinding().getId());
                verticesIds = new ArrayList<String>();
                verticesIds.add(path.getStartVertexBinding().getId());
            }catch(Exception e){}
                 
        }else{
            verticesIds = (ArrayList<String>) globalTraverserManager.getVertices(path.getStartVertexBinding());
        }

        for(String vertexId : verticesIds){
            BreadthFirstSearchTraversable bfsTraversable = new BreadthFirstSearchTraversable(vertexId);
            if(path.getStartVertexBinding().hasAlias()){
                bfsTraversable.addAliasedVertex(vertexId, path.getStartVertexBinding().getAlias());
            }else{
                bfsTraversable.addAliasedVertex(vertexId);
            }
            currLevel.add(bfsTraversable);
        }

        for (int i = 0;i<path.getLength();i++) {
            currLevel = processAndGetNextLevel(currLevel, i);
        }

        return this;
    
    }

    public List<BreadthFirstSearchTraversable> getMatchedPaths(){
        return currLevel;
    }


    private List<BreadthFirstSearchTraversable> processAndGetNextLevel(List<BreadthFirstSearchTraversable> currLevel, int levelNumber) throws Exception {

        HashMap<String, ArrayList<BreadthFirstSearchTraversable>> pathsGroupedByVertexId = groupPathsByVertexId(currLevel );
        Set <String> currLevelVerticesIds = pathsGroupedByVertexId.keySet();

        Iterable<EdgeId> edgesIds;
        if(path.getEdgeBindings().get(levelNumber).isOutgoing()){
         edgesIds = globalTraverserManager.filterOutgoingEdges(currLevelVerticesIds, path.getEdgeBindings().get(levelNumber));
        }
        else{
            edgesIds = globalTraverserManager.filterIncominEdges(currLevelVerticesIds, path.getEdgeBindings().get(levelNumber));
        }

        Set<String> potentialNextLevelVertices = new HashSet<String>();
        for(EdgeId edgeId : edgesIds){
            if(path.getEdgeBindings().get(levelNumber).isOutgoing()){
                potentialNextLevelVertices.add(edgeId.getdestinationId());
            }
            else{
                potentialNextLevelVertices.add(edgeId.getSourceId());
            }
        }

        Set<String> nextLevelVerticesSet = new HashSet<String>();
        Iterable<String> nextLevelVertices = globalTraverserManager.filterVertices(potentialNextLevelVertices, path.getVertexBindings().get(levelNumber));
        for(String vertexId : nextLevelVertices){
            nextLevelVerticesSet.add(vertexId);
        }

        List<BreadthFirstSearchTraversable> nextLevel = new LinkedList<BreadthFirstSearchTraversable>();

        for(EdgeId edge : edgesIds){
            if(path.getEdgeBindings().get(levelNumber).isOutgoing()){
                if(nextLevelVerticesSet.contains(edge.getdestinationId())){
                    for(BreadthFirstSearchTraversable bfsTraversable : pathsGroupedByVertexId.get(edge.getSourceId())){
                        BreadthFirstSearchTraversable newBfsTraversable = new BreadthFirstSearchTraversable(edge.getdestinationId());
                        newBfsTraversable.setAliasedVertices(bfsTraversable.getAliasedVertices());
                        if(path.getEdgeBindings().get(levelNumber).hasAlias()){
                            newBfsTraversable.addAliasedEdge(path.getEdgeBindings().get(levelNumber).getAlias(), edge);
                        }else{
                            newBfsTraversable.addAliasedEdge(edge);
                        }

                        if(path.getVertexBindings().get(levelNumber).hasAlias()){
                            newBfsTraversable.addAliasedVertex(edge.getdestinationId(), path.getVertexBindings().get(levelNumber).getAlias());
                        }else{
                            newBfsTraversable.addAliasedVertex(edge.getdestinationId());
                        }
                        nextLevel.add(newBfsTraversable);
                    }
                }
            }
            else{
                if(nextLevelVerticesSet.contains(edge.getSourceId())){
                    for(BreadthFirstSearchTraversable bfsTraversable : pathsGroupedByVertexId.get(edge.getdestinationId())){
                        BreadthFirstSearchTraversable newBfsTraversable = new BreadthFirstSearchTraversable(edge.getSourceId());
                        newBfsTraversable.setAliasedVertices(bfsTraversable.getAliasedVertices());
                        if(path.getEdgeBindings().get(levelNumber).hasAlias()){
                            newBfsTraversable.addAliasedEdge(path.getEdgeBindings().get(levelNumber).getAlias(), edge);
                        }else{
                            newBfsTraversable.addAliasedEdge(edge);
                        }

                        if(path.getVertexBindings().get(levelNumber).hasAlias()){
                            newBfsTraversable.addAliasedVertex(edge.getSourceId(), path.getVertexBindings().get(levelNumber).getAlias());
                        }else{
                            newBfsTraversable.addAliasedVertex(edge.getSourceId());
                        }
                        nextLevel.add(newBfsTraversable);
                    }
                }
            }
        }

        return nextLevel;
        
    }

    private HashMap<String, ArrayList<BreadthFirstSearchTraversable>> groupPathsByVertexId(
             List<BreadthFirstSearchTraversable> currLevel) {
          HashMap<String, ArrayList<BreadthFirstSearchTraversable>> pathsGroupedByVertexId = new HashMap<String, ArrayList<BreadthFirstSearchTraversable>>();
            for(BreadthFirstSearchTraversable bfsTraversable : currLevel){
                String vertexId = bfsTraversable.getVertexId();
                if(pathsGroupedByVertexId.containsKey(vertexId)){
                    pathsGroupedByVertexId.get(vertexId).add(bfsTraversable);
                }else{
                    pathsGroupedByVertexId.put(vertexId, new ArrayList<>());
                    pathsGroupedByVertexId.get(vertexId).add(bfsTraversable);
                }
            }

            return pathsGroupedByVertexId;
    }

   
    
}
