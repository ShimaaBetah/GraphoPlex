// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vertex.proto

package com.server.graph_db.grpc.vertex;

/**
 * Protobuf type {@code getIncomingEdgesResponse}
 */
public final class getIncomingEdgesResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:getIncomingEdgesResponse)
    getIncomingEdgesResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use getIncomingEdgesResponse.newBuilder() to construct.
  private getIncomingEdgesResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private getIncomingEdgesResponse() {
    edges_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new getIncomingEdgesResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private getIncomingEdgesResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              edges_ = new java.util.ArrayList<com.server.graph_db.grpc.vertex.edge>();
              mutable_bitField0_ |= 0x00000001;
            }
            edges_.add(
                input.readMessage(com.server.graph_db.grpc.vertex.edge.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        edges_ = java.util.Collections.unmodifiableList(edges_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.server.graph_db.grpc.vertex.Vertex.internal_static_getIncomingEdgesResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.server.graph_db.grpc.vertex.Vertex.internal_static_getIncomingEdgesResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.server.graph_db.grpc.vertex.getIncomingEdgesResponse.class, com.server.graph_db.grpc.vertex.getIncomingEdgesResponse.Builder.class);
  }

  public static final int EDGES_FIELD_NUMBER = 1;
  private java.util.List<com.server.graph_db.grpc.vertex.edge> edges_;
  /**
   * <code>repeated .edge edges = 1;</code>
   */
  @java.lang.Override
  public java.util.List<com.server.graph_db.grpc.vertex.edge> getEdgesList() {
    return edges_;
  }
  /**
   * <code>repeated .edge edges = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.server.graph_db.grpc.vertex.edgeOrBuilder> 
      getEdgesOrBuilderList() {
    return edges_;
  }
  /**
   * <code>repeated .edge edges = 1;</code>
   */
  @java.lang.Override
  public int getEdgesCount() {
    return edges_.size();
  }
  /**
   * <code>repeated .edge edges = 1;</code>
   */
  @java.lang.Override
  public com.server.graph_db.grpc.vertex.edge getEdges(int index) {
    return edges_.get(index);
  }
  /**
   * <code>repeated .edge edges = 1;</code>
   */
  @java.lang.Override
  public com.server.graph_db.grpc.vertex.edgeOrBuilder getEdgesOrBuilder(
      int index) {
    return edges_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < edges_.size(); i++) {
      output.writeMessage(1, edges_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < edges_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, edges_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.server.graph_db.grpc.vertex.getIncomingEdgesResponse)) {
      return super.equals(obj);
    }
    com.server.graph_db.grpc.vertex.getIncomingEdgesResponse other = (com.server.graph_db.grpc.vertex.getIncomingEdgesResponse) obj;

    if (!getEdgesList()
        .equals(other.getEdgesList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getEdgesCount() > 0) {
      hash = (37 * hash) + EDGES_FIELD_NUMBER;
      hash = (53 * hash) + getEdgesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.server.graph_db.grpc.vertex.getIncomingEdgesResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.server.graph_db.grpc.vertex.getIncomingEdgesResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.server.graph_db.grpc.vertex.getIncomingEdgesResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.server.graph_db.grpc.vertex.getIncomingEdgesResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.server.graph_db.grpc.vertex.getIncomingEdgesResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.server.graph_db.grpc.vertex.getIncomingEdgesResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.server.graph_db.grpc.vertex.getIncomingEdgesResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.server.graph_db.grpc.vertex.getIncomingEdgesResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.server.graph_db.grpc.vertex.getIncomingEdgesResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.server.graph_db.grpc.vertex.getIncomingEdgesResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.server.graph_db.grpc.vertex.getIncomingEdgesResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.server.graph_db.grpc.vertex.getIncomingEdgesResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.server.graph_db.grpc.vertex.getIncomingEdgesResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code getIncomingEdgesResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:getIncomingEdgesResponse)
      com.server.graph_db.grpc.vertex.getIncomingEdgesResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.server.graph_db.grpc.vertex.Vertex.internal_static_getIncomingEdgesResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.server.graph_db.grpc.vertex.Vertex.internal_static_getIncomingEdgesResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.server.graph_db.grpc.vertex.getIncomingEdgesResponse.class, com.server.graph_db.grpc.vertex.getIncomingEdgesResponse.Builder.class);
    }

    // Construct using com.server.graph_db.grpc.vertex.getIncomingEdgesResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getEdgesFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (edgesBuilder_ == null) {
        edges_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        edgesBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.server.graph_db.grpc.vertex.Vertex.internal_static_getIncomingEdgesResponse_descriptor;
    }

    @java.lang.Override
    public com.server.graph_db.grpc.vertex.getIncomingEdgesResponse getDefaultInstanceForType() {
      return com.server.graph_db.grpc.vertex.getIncomingEdgesResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.server.graph_db.grpc.vertex.getIncomingEdgesResponse build() {
      com.server.graph_db.grpc.vertex.getIncomingEdgesResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.server.graph_db.grpc.vertex.getIncomingEdgesResponse buildPartial() {
      com.server.graph_db.grpc.vertex.getIncomingEdgesResponse result = new com.server.graph_db.grpc.vertex.getIncomingEdgesResponse(this);
      int from_bitField0_ = bitField0_;
      if (edgesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          edges_ = java.util.Collections.unmodifiableList(edges_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.edges_ = edges_;
      } else {
        result.edges_ = edgesBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.server.graph_db.grpc.vertex.getIncomingEdgesResponse) {
        return mergeFrom((com.server.graph_db.grpc.vertex.getIncomingEdgesResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.server.graph_db.grpc.vertex.getIncomingEdgesResponse other) {
      if (other == com.server.graph_db.grpc.vertex.getIncomingEdgesResponse.getDefaultInstance()) return this;
      if (edgesBuilder_ == null) {
        if (!other.edges_.isEmpty()) {
          if (edges_.isEmpty()) {
            edges_ = other.edges_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureEdgesIsMutable();
            edges_.addAll(other.edges_);
          }
          onChanged();
        }
      } else {
        if (!other.edges_.isEmpty()) {
          if (edgesBuilder_.isEmpty()) {
            edgesBuilder_.dispose();
            edgesBuilder_ = null;
            edges_ = other.edges_;
            bitField0_ = (bitField0_ & ~0x00000001);
            edgesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getEdgesFieldBuilder() : null;
          } else {
            edgesBuilder_.addAllMessages(other.edges_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.server.graph_db.grpc.vertex.getIncomingEdgesResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.server.graph_db.grpc.vertex.getIncomingEdgesResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.server.graph_db.grpc.vertex.edge> edges_ =
      java.util.Collections.emptyList();
    private void ensureEdgesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        edges_ = new java.util.ArrayList<com.server.graph_db.grpc.vertex.edge>(edges_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.server.graph_db.grpc.vertex.edge, com.server.graph_db.grpc.vertex.edge.Builder, com.server.graph_db.grpc.vertex.edgeOrBuilder> edgesBuilder_;

    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public java.util.List<com.server.graph_db.grpc.vertex.edge> getEdgesList() {
      if (edgesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(edges_);
      } else {
        return edgesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public int getEdgesCount() {
      if (edgesBuilder_ == null) {
        return edges_.size();
      } else {
        return edgesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public com.server.graph_db.grpc.vertex.edge getEdges(int index) {
      if (edgesBuilder_ == null) {
        return edges_.get(index);
      } else {
        return edgesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public Builder setEdges(
        int index, com.server.graph_db.grpc.vertex.edge value) {
      if (edgesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureEdgesIsMutable();
        edges_.set(index, value);
        onChanged();
      } else {
        edgesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public Builder setEdges(
        int index, com.server.graph_db.grpc.vertex.edge.Builder builderForValue) {
      if (edgesBuilder_ == null) {
        ensureEdgesIsMutable();
        edges_.set(index, builderForValue.build());
        onChanged();
      } else {
        edgesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public Builder addEdges(com.server.graph_db.grpc.vertex.edge value) {
      if (edgesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureEdgesIsMutable();
        edges_.add(value);
        onChanged();
      } else {
        edgesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public Builder addEdges(
        int index, com.server.graph_db.grpc.vertex.edge value) {
      if (edgesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureEdgesIsMutable();
        edges_.add(index, value);
        onChanged();
      } else {
        edgesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public Builder addEdges(
        com.server.graph_db.grpc.vertex.edge.Builder builderForValue) {
      if (edgesBuilder_ == null) {
        ensureEdgesIsMutable();
        edges_.add(builderForValue.build());
        onChanged();
      } else {
        edgesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public Builder addEdges(
        int index, com.server.graph_db.grpc.vertex.edge.Builder builderForValue) {
      if (edgesBuilder_ == null) {
        ensureEdgesIsMutable();
        edges_.add(index, builderForValue.build());
        onChanged();
      } else {
        edgesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public Builder addAllEdges(
        java.lang.Iterable<? extends com.server.graph_db.grpc.vertex.edge> values) {
      if (edgesBuilder_ == null) {
        ensureEdgesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, edges_);
        onChanged();
      } else {
        edgesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public Builder clearEdges() {
      if (edgesBuilder_ == null) {
        edges_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        edgesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public Builder removeEdges(int index) {
      if (edgesBuilder_ == null) {
        ensureEdgesIsMutable();
        edges_.remove(index);
        onChanged();
      } else {
        edgesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public com.server.graph_db.grpc.vertex.edge.Builder getEdgesBuilder(
        int index) {
      return getEdgesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public com.server.graph_db.grpc.vertex.edgeOrBuilder getEdgesOrBuilder(
        int index) {
      if (edgesBuilder_ == null) {
        return edges_.get(index);  } else {
        return edgesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public java.util.List<? extends com.server.graph_db.grpc.vertex.edgeOrBuilder> 
         getEdgesOrBuilderList() {
      if (edgesBuilder_ != null) {
        return edgesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(edges_);
      }
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public com.server.graph_db.grpc.vertex.edge.Builder addEdgesBuilder() {
      return getEdgesFieldBuilder().addBuilder(
          com.server.graph_db.grpc.vertex.edge.getDefaultInstance());
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public com.server.graph_db.grpc.vertex.edge.Builder addEdgesBuilder(
        int index) {
      return getEdgesFieldBuilder().addBuilder(
          index, com.server.graph_db.grpc.vertex.edge.getDefaultInstance());
    }
    /**
     * <code>repeated .edge edges = 1;</code>
     */
    public java.util.List<com.server.graph_db.grpc.vertex.edge.Builder> 
         getEdgesBuilderList() {
      return getEdgesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.server.graph_db.grpc.vertex.edge, com.server.graph_db.grpc.vertex.edge.Builder, com.server.graph_db.grpc.vertex.edgeOrBuilder> 
        getEdgesFieldBuilder() {
      if (edgesBuilder_ == null) {
        edgesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.server.graph_db.grpc.vertex.edge, com.server.graph_db.grpc.vertex.edge.Builder, com.server.graph_db.grpc.vertex.edgeOrBuilder>(
                edges_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        edges_ = null;
      }
      return edgesBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:getIncomingEdgesResponse)
  }

  // @@protoc_insertion_point(class_scope:getIncomingEdgesResponse)
  private static final com.server.graph_db.grpc.vertex.getIncomingEdgesResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.server.graph_db.grpc.vertex.getIncomingEdgesResponse();
  }

  public static com.server.graph_db.grpc.vertex.getIncomingEdgesResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<getIncomingEdgesResponse>
      PARSER = new com.google.protobuf.AbstractParser<getIncomingEdgesResponse>() {
    @java.lang.Override
    public getIncomingEdgesResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new getIncomingEdgesResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<getIncomingEdgesResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<getIncomingEdgesResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.server.graph_db.grpc.vertex.getIncomingEdgesResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

