package com.server.graph_db.core.index;

public interface SecondaryIndexManager {
    
    public void createIndex(String indexName);
    public void deleteIndex(String indexName);
    public void createIndices(Iterable<String> indexNames);
    public void deleteIndices(Iterable<String> indexNames);
}
