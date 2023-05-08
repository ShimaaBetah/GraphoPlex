package com.server.graph_db.datastore;

public interface IndexDataManager {
   
   public boolean isIndexExist(String indexName);
   public void createIndex(String indexName);
   public void deleteIndex(String index);
   public void addVertexToIndex(String fieldName, String fieldValue ,String vertexId);
   public void removeVertexFromIndex(String fieldName,String fieldValue,String vertexId);
   public Iterable<String> getVerticesIdsFromIndex(String indexName, String fieldValue);
   public boolean isIndexContainsVertex(String indexName, String fieldValue, String vertexId);
   


}
