// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vertex.proto

package com.server.graph_db.grpc.vertex;

public interface getOutgoingEdgesResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:getOutgoingEdgesResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .edge edges = 1;</code>
   */
  java.util.List<com.server.graph_db.grpc.vertex.edge> 
      getEdgesList();
  /**
   * <code>repeated .edge edges = 1;</code>
   */
  com.server.graph_db.grpc.vertex.edge getEdges(int index);
  /**
   * <code>repeated .edge edges = 1;</code>
   */
  int getEdgesCount();
  /**
   * <code>repeated .edge edges = 1;</code>
   */
  java.util.List<? extends com.server.graph_db.grpc.vertex.edgeOrBuilder> 
      getEdgesOrBuilderList();
  /**
   * <code>repeated .edge edges = 1;</code>
   */
  com.server.graph_db.grpc.vertex.edgeOrBuilder getEdgesOrBuilder(
      int index);
}
