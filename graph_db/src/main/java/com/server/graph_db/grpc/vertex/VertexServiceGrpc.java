package com.server.graph_db.grpc.vertex;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.1)",
    comments = "Source: vertex.proto")
public final class VertexServiceGrpc {

  private VertexServiceGrpc() {}

  public static final String SERVICE_NAME = "VertexService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getVertexRequest,
      com.server.graph_db.grpc.vertex.getVertexResponse> getGetVertexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getVertex",
      requestType = com.server.graph_db.grpc.vertex.getVertexRequest.class,
      responseType = com.server.graph_db.grpc.vertex.getVertexResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getVertexRequest,
      com.server.graph_db.grpc.vertex.getVertexResponse> getGetVertexMethod() {
    io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getVertexRequest, com.server.graph_db.grpc.vertex.getVertexResponse> getGetVertexMethod;
    if ((getGetVertexMethod = VertexServiceGrpc.getGetVertexMethod) == null) {
      synchronized (VertexServiceGrpc.class) {
        if ((getGetVertexMethod = VertexServiceGrpc.getGetVertexMethod) == null) {
          VertexServiceGrpc.getGetVertexMethod = getGetVertexMethod =
              io.grpc.MethodDescriptor.<com.server.graph_db.grpc.vertex.getVertexRequest, com.server.graph_db.grpc.vertex.getVertexResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getVertex"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.getVertexRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.getVertexResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VertexServiceMethodDescriptorSupplier("getVertex"))
              .build();
        }
      }
    }
    return getGetVertexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getVerticesRequest,
      com.server.graph_db.grpc.vertex.getVerticesResponse> getGetVerticesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getVertices",
      requestType = com.server.graph_db.grpc.vertex.getVerticesRequest.class,
      responseType = com.server.graph_db.grpc.vertex.getVerticesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getVerticesRequest,
      com.server.graph_db.grpc.vertex.getVerticesResponse> getGetVerticesMethod() {
    io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getVerticesRequest, com.server.graph_db.grpc.vertex.getVerticesResponse> getGetVerticesMethod;
    if ((getGetVerticesMethod = VertexServiceGrpc.getGetVerticesMethod) == null) {
      synchronized (VertexServiceGrpc.class) {
        if ((getGetVerticesMethod = VertexServiceGrpc.getGetVerticesMethod) == null) {
          VertexServiceGrpc.getGetVerticesMethod = getGetVerticesMethod =
              io.grpc.MethodDescriptor.<com.server.graph_db.grpc.vertex.getVerticesRequest, com.server.graph_db.grpc.vertex.getVerticesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getVertices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.getVerticesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.getVerticesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VertexServiceMethodDescriptorSupplier("getVertices"))
              .build();
        }
      }
    }
    return getGetVerticesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VertexServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VertexServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VertexServiceStub>() {
        @java.lang.Override
        public VertexServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VertexServiceStub(channel, callOptions);
        }
      };
    return VertexServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VertexServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VertexServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VertexServiceBlockingStub>() {
        @java.lang.Override
        public VertexServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VertexServiceBlockingStub(channel, callOptions);
        }
      };
    return VertexServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VertexServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VertexServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VertexServiceFutureStub>() {
        @java.lang.Override
        public VertexServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VertexServiceFutureStub(channel, callOptions);
        }
      };
    return VertexServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class VertexServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getVertex(com.server.graph_db.grpc.vertex.getVertexRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getVertexResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVertexMethod(), responseObserver);
    }

    /**
     */
    public void getVertices(com.server.graph_db.grpc.vertex.getVerticesRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getVerticesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVerticesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetVertexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.server.graph_db.grpc.vertex.getVertexRequest,
                com.server.graph_db.grpc.vertex.getVertexResponse>(
                  this, METHODID_GET_VERTEX)))
          .addMethod(
            getGetVerticesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.server.graph_db.grpc.vertex.getVerticesRequest,
                com.server.graph_db.grpc.vertex.getVerticesResponse>(
                  this, METHODID_GET_VERTICES)))
          .build();
    }
  }

  /**
   */
  public static final class VertexServiceStub extends io.grpc.stub.AbstractAsyncStub<VertexServiceStub> {
    private VertexServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VertexServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VertexServiceStub(channel, callOptions);
    }

    /**
     */
    public void getVertex(com.server.graph_db.grpc.vertex.getVertexRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getVertexResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVertexMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getVertices(com.server.graph_db.grpc.vertex.getVerticesRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getVerticesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVerticesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class VertexServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<VertexServiceBlockingStub> {
    private VertexServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VertexServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VertexServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.server.graph_db.grpc.vertex.getVertexResponse getVertex(com.server.graph_db.grpc.vertex.getVertexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVertexMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.server.graph_db.grpc.vertex.getVerticesResponse getVertices(com.server.graph_db.grpc.vertex.getVerticesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVerticesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class VertexServiceFutureStub extends io.grpc.stub.AbstractFutureStub<VertexServiceFutureStub> {
    private VertexServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VertexServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VertexServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.server.graph_db.grpc.vertex.getVertexResponse> getVertex(
        com.server.graph_db.grpc.vertex.getVertexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVertexMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.server.graph_db.grpc.vertex.getVerticesResponse> getVertices(
        com.server.graph_db.grpc.vertex.getVerticesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVerticesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_VERTEX = 0;
  private static final int METHODID_GET_VERTICES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VertexServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VertexServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_VERTEX:
          serviceImpl.getVertex((com.server.graph_db.grpc.vertex.getVertexRequest) request,
              (io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getVertexResponse>) responseObserver);
          break;
        case METHODID_GET_VERTICES:
          serviceImpl.getVertices((com.server.graph_db.grpc.vertex.getVerticesRequest) request,
              (io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getVerticesResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class VertexServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VertexServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.server.graph_db.grpc.vertex.Vertex.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VertexService");
    }
  }

  private static final class VertexServiceFileDescriptorSupplier
      extends VertexServiceBaseDescriptorSupplier {
    VertexServiceFileDescriptorSupplier() {}
  }

  private static final class VertexServiceMethodDescriptorSupplier
      extends VertexServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VertexServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (VertexServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VertexServiceFileDescriptorSupplier())
              .addMethod(getGetVertexMethod())
              .addMethod(getGetVerticesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
