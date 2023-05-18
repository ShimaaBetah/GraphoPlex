package com.server.graph_db.core.traversers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.graph_db.core.partition.PartitionManager;
import com.server.graph_db.core.traversers.bindings.EdgeBinding;
import com.server.graph_db.core.traversers.bindings.VertexBinding;
import com.server.graph_db.core.traversers.runnables.FilterIncomingEdgesRunnable;
import com.server.graph_db.core.traversers.runnables.FilterOutGoingEdgesRunnable;
import com.server.graph_db.core.traversers.runnables.FilterVerticesRunnable;
import com.server.graph_db.core.traversers.runnables.GetVerticesRunnable;
import com.server.graph_db.core.vertex.EdgeId;
import com.server.graph_db.grpc.clients.TraverserClient;

@Component
public class GlobalTraverserManager {


    @Autowired 
    TraverserClient traverserClient;

    @Autowired
    LocalTraversalManager localTraversalManager;

    @Autowired
    PartitionManager partitionManager;

    public Iterable<String> getVertices (VertexBinding vertexBinding) throws Exception{
        List<List<String>> results = new ArrayList<>();
        for(int i = 0;i<partitionManager.getNumberOfServers();i++){
            results.add(new ArrayList<>());
        }
        List<Thread> threads = new ArrayList<>();
        for(int i = 0;i<partitionManager.getNumberOfServers();i++){
            Thread thread = new Thread(new GetVerticesRunnable(vertexBinding, i, results.get(i), partitionManager, localTraversalManager, traverserClient));
            thread.start();
            threads.add(thread);
        }
        for(Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (List<String> result : results) {
            if(result == null){
                throw new Exception("Internal Server Error");
            }
        }
        List<String> resultSet = new ArrayList<>();
        for(List<String> result : results){
            resultSet.addAll(result);
        }
        return resultSet;
    }

    public Iterable<String> filterVertices (Iterable<String> verticesToFilter, VertexBinding vertexBinding) throws Exception{
        List<List<String>> verticesGroupedByPartition = partitionManager.groupVerticesIdsByPartitionId(verticesToFilter);
        List<List<String>> results = new ArrayList<>();
        for(int i = 0;i<partitionManager.getNumberOfServers();i++){
            results.add(new ArrayList<>());
        }
        List<Thread> threads = new ArrayList<>();
        for(int i = 0;i<partitionManager.getNumberOfServers();i++){
            Thread thread = new Thread(new FilterVerticesRunnable(vertexBinding, i, verticesGroupedByPartition.get(i), results.get(i), partitionManager, localTraversalManager, traverserClient));
            thread.start();
            threads.add(thread);
        }
        for(Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (List<String> result : results) {
            if(result == null){
                throw new Exception("Internal Server Error");
            }
        }
        List<String> resultSet = new ArrayList<>();
        for(List<String> result : results){
            resultSet.addAll(result);
        }
        return resultSet;
    }

    public Iterable<EdgeId> filterOutgoingEdges (Iterable<String> verticesIds, EdgeBinding edgeBinding ) throws Exception{
        List<List<String>> verticesGroupedByPartition = partitionManager.groupVerticesIdsByPartitionId(verticesIds);
        List<List<EdgeId>> results = new ArrayList<>();
        for(int i = 0;i<partitionManager.getNumberOfServers();i++){
            results.add(new ArrayList<>());
        }
        List<Thread> threads = new ArrayList<>();
        for(int i = 0;i<partitionManager.getNumberOfServers();i++){
            Thread thread = new Thread(new FilterOutGoingEdgesRunnable(verticesGroupedByPartition.get(i),edgeBinding, i,  results.get(i), partitionManager, localTraversalManager, traverserClient));
            thread.start();
            threads.add(thread);
        }

        for(Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (List<EdgeId> result : results) {
            if(result == null){
                throw new Exception("Internal Server Error");
            }
        }

        List<EdgeId> resultSet = new ArrayList<>();
        for(List<EdgeId> result : results){
            resultSet.addAll(result);
        }

        return resultSet;
    }

    public Iterable<EdgeId> filterIncominEdges (Iterable<String> verticesIds, EdgeBinding edgeBinding) throws Exception{
        List<List<String>> verticesGroupedByPartition = partitionManager.groupVerticesIdsByPartitionId(verticesIds);
        List<List<EdgeId>> results = new ArrayList<>();
        for(int i = 0;i<partitionManager.getNumberOfServers();i++){
            results.add(new ArrayList<>());
        }
        List<Thread> threads = new ArrayList<>();
        for(int i = 0;i<partitionManager.getNumberOfServers();i++){
            Thread thread = new Thread(new FilterIncomingEdgesRunnable(verticesGroupedByPartition.get(i),edgeBinding, i,  results.get(i), partitionManager, localTraversalManager, traverserClient));
            thread.start();
            threads.add(thread);
        }

        for(Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (List<EdgeId> result : results) {
            if(result == null){
                throw new Exception("Internal Server Error");
            }
        }

        List<EdgeId> resultSet = new ArrayList<>();
        for(List<EdgeId> result : results){
            resultSet.addAll(result);
        }

        return resultSet;
    }






    


    
}
