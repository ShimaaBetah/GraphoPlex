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

  private static volatile io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.createVertexRequest,
      com.server.graph_db.grpc.vertex.createVertexResponse> getCreateVertexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createVertex",
      requestType = com.server.graph_db.grpc.vertex.createVertexRequest.class,
      responseType = com.server.graph_db.grpc.vertex.createVertexResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.createVertexRequest,
      com.server.graph_db.grpc.vertex.createVertexResponse> getCreateVertexMethod() {
    io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.createVertexRequest, com.server.graph_db.grpc.vertex.createVertexResponse> getCreateVertexMethod;
    if ((getCreateVertexMethod = VertexServiceGrpc.getCreateVertexMethod) == null) {
      synchronized (VertexServiceGrpc.class) {
        if ((getCreateVertexMethod = VertexServiceGrpc.getCreateVertexMethod) == null) {
          VertexServiceGrpc.getCreateVertexMethod = getCreateVertexMethod =
              io.grpc.MethodDescriptor.<com.server.graph_db.grpc.vertex.createVertexRequest, com.server.graph_db.grpc.vertex.createVertexResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createVertex"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.createVertexRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.createVertexResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VertexServiceMethodDescriptorSupplier("createVertex"))
              .build();
        }
      }
    }
    return getCreateVertexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.deleteVertexRequest,
      com.server.graph_db.grpc.vertex.deleteVertexResponse> getDeleteVertexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteVertex",
      requestType = com.server.graph_db.grpc.vertex.deleteVertexRequest.class,
      responseType = com.server.graph_db.grpc.vertex.deleteVertexResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.deleteVertexRequest,
      com.server.graph_db.grpc.vertex.deleteVertexResponse> getDeleteVertexMethod() {
    io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.deleteVertexRequest, com.server.graph_db.grpc.vertex.deleteVertexResponse> getDeleteVertexMethod;
    if ((getDeleteVertexMethod = VertexServiceGrpc.getDeleteVertexMethod) == null) {
      synchronized (VertexServiceGrpc.class) {
        if ((getDeleteVertexMethod = VertexServiceGrpc.getDeleteVertexMethod) == null) {
          VertexServiceGrpc.getDeleteVertexMethod = getDeleteVertexMethod =
              io.grpc.MethodDescriptor.<com.server.graph_db.grpc.vertex.deleteVertexRequest, com.server.graph_db.grpc.vertex.deleteVertexResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteVertex"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.deleteVertexRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.deleteVertexResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VertexServiceMethodDescriptorSupplier("deleteVertex"))
              .build();
        }
      }
    }
    return getDeleteVertexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.updateVertexRequest,
      com.server.graph_db.grpc.vertex.updateVertexResponse> getUpdateVertexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateVertex",
      requestType = com.server.graph_db.grpc.vertex.updateVertexRequest.class,
      responseType = com.server.graph_db.grpc.vertex.updateVertexResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.updateVertexRequest,
      com.server.graph_db.grpc.vertex.updateVertexResponse> getUpdateVertexMethod() {
    io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.updateVertexRequest, com.server.graph_db.grpc.vertex.updateVertexResponse> getUpdateVertexMethod;
    if ((getUpdateVertexMethod = VertexServiceGrpc.getUpdateVertexMethod) == null) {
      synchronized (VertexServiceGrpc.class) {
        if ((getUpdateVertexMethod = VertexServiceGrpc.getUpdateVertexMethod) == null) {
          VertexServiceGrpc.getUpdateVertexMethod = getUpdateVertexMethod =
              io.grpc.MethodDescriptor.<com.server.graph_db.grpc.vertex.updateVertexRequest, com.server.graph_db.grpc.vertex.updateVertexResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateVertex"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.updateVertexRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.updateVertexResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VertexServiceMethodDescriptorSupplier("updateVertex"))
              .build();
        }
      }
    }
    return getUpdateVertexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.createEdgeRequest,
      com.server.graph_db.grpc.vertex.createEdgeResponse> getCreateEdgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createEdge",
      requestType = com.server.graph_db.grpc.vertex.createEdgeRequest.class,
      responseType = com.server.graph_db.grpc.vertex.createEdgeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.createEdgeRequest,
      com.server.graph_db.grpc.vertex.createEdgeResponse> getCreateEdgeMethod() {
    io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.createEdgeRequest, com.server.graph_db.grpc.vertex.createEdgeResponse> getCreateEdgeMethod;
    if ((getCreateEdgeMethod = VertexServiceGrpc.getCreateEdgeMethod) == null) {
      synchronized (VertexServiceGrpc.class) {
        if ((getCreateEdgeMethod = VertexServiceGrpc.getCreateEdgeMethod) == null) {
          VertexServiceGrpc.getCreateEdgeMethod = getCreateEdgeMethod =
              io.grpc.MethodDescriptor.<com.server.graph_db.grpc.vertex.createEdgeRequest, com.server.graph_db.grpc.vertex.createEdgeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createEdge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.createEdgeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.createEdgeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VertexServiceMethodDescriptorSupplier("createEdge"))
              .build();
        }
      }
    }
    return getCreateEdgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.deleteEdgeRequest,
      com.server.graph_db.grpc.vertex.deleteEdgeResponse> getDeleteEdgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteEdge",
      requestType = com.server.graph_db.grpc.vertex.deleteEdgeRequest.class,
      responseType = com.server.graph_db.grpc.vertex.deleteEdgeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.deleteEdgeRequest,
      com.server.graph_db.grpc.vertex.deleteEdgeResponse> getDeleteEdgeMethod() {
    io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.deleteEdgeRequest, com.server.graph_db.grpc.vertex.deleteEdgeResponse> getDeleteEdgeMethod;
    if ((getDeleteEdgeMethod = VertexServiceGrpc.getDeleteEdgeMethod) == null) {
      synchronized (VertexServiceGrpc.class) {
        if ((getDeleteEdgeMethod = VertexServiceGrpc.getDeleteEdgeMethod) == null) {
          VertexServiceGrpc.getDeleteEdgeMethod = getDeleteEdgeMethod =
              io.grpc.MethodDescriptor.<com.server.graph_db.grpc.vertex.deleteEdgeRequest, com.server.graph_db.grpc.vertex.deleteEdgeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteEdge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.deleteEdgeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.deleteEdgeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VertexServiceMethodDescriptorSupplier("deleteEdge"))
              .build();
        }
      }
    }
    return getDeleteEdgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.updateEdgeRequest,
      com.server.graph_db.grpc.vertex.updateEdgeResponse> getUpdateEdgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateEdge",
      requestType = com.server.graph_db.grpc.vertex.updateEdgeRequest.class,
      responseType = com.server.graph_db.grpc.vertex.updateEdgeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.updateEdgeRequest,
      com.server.graph_db.grpc.vertex.updateEdgeResponse> getUpdateEdgeMethod() {
    io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.updateEdgeRequest, com.server.graph_db.grpc.vertex.updateEdgeResponse> getUpdateEdgeMethod;
    if ((getUpdateEdgeMethod = VertexServiceGrpc.getUpdateEdgeMethod) == null) {
      synchronized (VertexServiceGrpc.class) {
        if ((getUpdateEdgeMethod = VertexServiceGrpc.getUpdateEdgeMethod) == null) {
          VertexServiceGrpc.getUpdateEdgeMethod = getUpdateEdgeMethod =
              io.grpc.MethodDescriptor.<com.server.graph_db.grpc.vertex.updateEdgeRequest, com.server.graph_db.grpc.vertex.updateEdgeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateEdge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.updateEdgeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.updateEdgeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VertexServiceMethodDescriptorSupplier("updateEdge"))
              .build();
        }
      }
    }
    return getUpdateEdgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getOutgoingEdgesRequest,
      com.server.graph_db.grpc.vertex.getOutgoingEdgesResponse> getGetOutgoingEdgesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getOutgoingEdges",
      requestType = com.server.graph_db.grpc.vertex.getOutgoingEdgesRequest.class,
      responseType = com.server.graph_db.grpc.vertex.getOutgoingEdgesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getOutgoingEdgesRequest,
      com.server.graph_db.grpc.vertex.getOutgoingEdgesResponse> getGetOutgoingEdgesMethod() {
    io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getOutgoingEdgesRequest, com.server.graph_db.grpc.vertex.getOutgoingEdgesResponse> getGetOutgoingEdgesMethod;
    if ((getGetOutgoingEdgesMethod = VertexServiceGrpc.getGetOutgoingEdgesMethod) == null) {
      synchronized (VertexServiceGrpc.class) {
        if ((getGetOutgoingEdgesMethod = VertexServiceGrpc.getGetOutgoingEdgesMethod) == null) {
          VertexServiceGrpc.getGetOutgoingEdgesMethod = getGetOutgoingEdgesMethod =
              io.grpc.MethodDescriptor.<com.server.graph_db.grpc.vertex.getOutgoingEdgesRequest, com.server.graph_db.grpc.vertex.getOutgoingEdgesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getOutgoingEdges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.getOutgoingEdgesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.getOutgoingEdgesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VertexServiceMethodDescriptorSupplier("getOutgoingEdges"))
              .build();
        }
      }
    }
    return getGetOutgoingEdgesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getIncomingEdgesRequest,
      com.server.graph_db.grpc.vertex.getIncomingEdgesResponse> getGetIncomingEdgesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getIncomingEdges",
      requestType = com.server.graph_db.grpc.vertex.getIncomingEdgesRequest.class,
      responseType = com.server.graph_db.grpc.vertex.getIncomingEdgesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getIncomingEdgesRequest,
      com.server.graph_db.grpc.vertex.getIncomingEdgesResponse> getGetIncomingEdgesMethod() {
    io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getIncomingEdgesRequest, com.server.graph_db.grpc.vertex.getIncomingEdgesResponse> getGetIncomingEdgesMethod;
    if ((getGetIncomingEdgesMethod = VertexServiceGrpc.getGetIncomingEdgesMethod) == null) {
      synchronized (VertexServiceGrpc.class) {
        if ((getGetIncomingEdgesMethod = VertexServiceGrpc.getGetIncomingEdgesMethod) == null) {
          VertexServiceGrpc.getGetIncomingEdgesMethod = getGetIncomingEdgesMethod =
              io.grpc.MethodDescriptor.<com.server.graph_db.grpc.vertex.getIncomingEdgesRequest, com.server.graph_db.grpc.vertex.getIncomingEdgesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getIncomingEdges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.getIncomingEdgesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.getIncomingEdgesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VertexServiceMethodDescriptorSupplier("getIncomingEdges"))
              .build();
        }
      }
    }
    return getGetIncomingEdgesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getEdgesRequest,
      com.server.graph_db.grpc.vertex.getEdgesResponse> getGetEdgesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getEdges",
      requestType = com.server.graph_db.grpc.vertex.getEdgesRequest.class,
      responseType = com.server.graph_db.grpc.vertex.getEdgesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getEdgesRequest,
      com.server.graph_db.grpc.vertex.getEdgesResponse> getGetEdgesMethod() {
    io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getEdgesRequest, com.server.graph_db.grpc.vertex.getEdgesResponse> getGetEdgesMethod;
    if ((getGetEdgesMethod = VertexServiceGrpc.getGetEdgesMethod) == null) {
      synchronized (VertexServiceGrpc.class) {
        if ((getGetEdgesMethod = VertexServiceGrpc.getGetEdgesMethod) == null) {
          VertexServiceGrpc.getGetEdgesMethod = getGetEdgesMethod =
              io.grpc.MethodDescriptor.<com.server.graph_db.grpc.vertex.getEdgesRequest, com.server.graph_db.grpc.vertex.getEdgesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getEdges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.getEdgesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.getEdgesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VertexServiceMethodDescriptorSupplier("getEdges"))
              .build();
        }
      }
    }
    return getGetEdgesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getOutGoingEdgesForVerticesRequest,
      com.server.graph_db.grpc.vertex.getEdgesResponse> getGetOutgoingEdgesForVerticesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getOutgoingEdgesForVertices",
      requestType = com.server.graph_db.grpc.vertex.getOutGoingEdgesForVerticesRequest.class,
      responseType = com.server.graph_db.grpc.vertex.getEdgesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getOutGoingEdgesForVerticesRequest,
      com.server.graph_db.grpc.vertex.getEdgesResponse> getGetOutgoingEdgesForVerticesMethod() {
    io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getOutGoingEdgesForVerticesRequest, com.server.graph_db.grpc.vertex.getEdgesResponse> getGetOutgoingEdgesForVerticesMethod;
    if ((getGetOutgoingEdgesForVerticesMethod = VertexServiceGrpc.getGetOutgoingEdgesForVerticesMethod) == null) {
      synchronized (VertexServiceGrpc.class) {
        if ((getGetOutgoingEdgesForVerticesMethod = VertexServiceGrpc.getGetOutgoingEdgesForVerticesMethod) == null) {
          VertexServiceGrpc.getGetOutgoingEdgesForVerticesMethod = getGetOutgoingEdgesForVerticesMethod =
              io.grpc.MethodDescriptor.<com.server.graph_db.grpc.vertex.getOutGoingEdgesForVerticesRequest, com.server.graph_db.grpc.vertex.getEdgesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getOutgoingEdgesForVertices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.getOutGoingEdgesForVerticesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.getEdgesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VertexServiceMethodDescriptorSupplier("getOutgoingEdgesForVertices"))
              .build();
        }
      }
    }
    return getGetOutgoingEdgesForVerticesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getIncomingEdgesForVerticesRequest,
      com.server.graph_db.grpc.vertex.getEdgesResponse> getGetIncomingEdgesForVerticesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getIncomingEdgesForVertices",
      requestType = com.server.graph_db.grpc.vertex.getIncomingEdgesForVerticesRequest.class,
      responseType = com.server.graph_db.grpc.vertex.getEdgesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getIncomingEdgesForVerticesRequest,
      com.server.graph_db.grpc.vertex.getEdgesResponse> getGetIncomingEdgesForVerticesMethod() {
    io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getIncomingEdgesForVerticesRequest, com.server.graph_db.grpc.vertex.getEdgesResponse> getGetIncomingEdgesForVerticesMethod;
    if ((getGetIncomingEdgesForVerticesMethod = VertexServiceGrpc.getGetIncomingEdgesForVerticesMethod) == null) {
      synchronized (VertexServiceGrpc.class) {
        if ((getGetIncomingEdgesForVerticesMethod = VertexServiceGrpc.getGetIncomingEdgesForVerticesMethod) == null) {
          VertexServiceGrpc.getGetIncomingEdgesForVerticesMethod = getGetIncomingEdgesForVerticesMethod =
              io.grpc.MethodDescriptor.<com.server.graph_db.grpc.vertex.getIncomingEdgesForVerticesRequest, com.server.graph_db.grpc.vertex.getEdgesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getIncomingEdgesForVertices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.getIncomingEdgesForVerticesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.getEdgesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VertexServiceMethodDescriptorSupplier("getIncomingEdgesForVertices"))
              .build();
        }
      }
    }
    return getGetIncomingEdgesForVerticesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getAllVerticesIdsRequest,
      com.server.graph_db.grpc.vertex.getAllVerticesIdsResponse> getGetAllVerticesIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllVerticesIds",
      requestType = com.server.graph_db.grpc.vertex.getAllVerticesIdsRequest.class,
      responseType = com.server.graph_db.grpc.vertex.getAllVerticesIdsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getAllVerticesIdsRequest,
      com.server.graph_db.grpc.vertex.getAllVerticesIdsResponse> getGetAllVerticesIdsMethod() {
    io.grpc.MethodDescriptor<com.server.graph_db.grpc.vertex.getAllVerticesIdsRequest, com.server.graph_db.grpc.vertex.getAllVerticesIdsResponse> getGetAllVerticesIdsMethod;
    if ((getGetAllVerticesIdsMethod = VertexServiceGrpc.getGetAllVerticesIdsMethod) == null) {
      synchronized (VertexServiceGrpc.class) {
        if ((getGetAllVerticesIdsMethod = VertexServiceGrpc.getGetAllVerticesIdsMethod) == null) {
          VertexServiceGrpc.getGetAllVerticesIdsMethod = getGetAllVerticesIdsMethod =
              io.grpc.MethodDescriptor.<com.server.graph_db.grpc.vertex.getAllVerticesIdsRequest, com.server.graph_db.grpc.vertex.getAllVerticesIdsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllVerticesIds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.getAllVerticesIdsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.server.graph_db.grpc.vertex.getAllVerticesIdsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VertexServiceMethodDescriptorSupplier("getAllVerticesIds"))
              .build();
        }
      }
    }
    return getGetAllVerticesIdsMethod;
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

    /**
     */
    public void createVertex(com.server.graph_db.grpc.vertex.createVertexRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.createVertexResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateVertexMethod(), responseObserver);
    }

    /**
     */
    public void deleteVertex(com.server.graph_db.grpc.vertex.deleteVertexRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.deleteVertexResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteVertexMethod(), responseObserver);
    }

    /**
     */
    public void updateVertex(com.server.graph_db.grpc.vertex.updateVertexRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.updateVertexResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateVertexMethod(), responseObserver);
    }

    /**
     */
    public void createEdge(com.server.graph_db.grpc.vertex.createEdgeRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.createEdgeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateEdgeMethod(), responseObserver);
    }

    /**
     */
    public void deleteEdge(com.server.graph_db.grpc.vertex.deleteEdgeRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.deleteEdgeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteEdgeMethod(), responseObserver);
    }

    /**
     */
    public void updateEdge(com.server.graph_db.grpc.vertex.updateEdgeRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.updateEdgeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateEdgeMethod(), responseObserver);
    }

    /**
     */
    public void getOutgoingEdges(com.server.graph_db.grpc.vertex.getOutgoingEdgesRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getOutgoingEdgesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOutgoingEdgesMethod(), responseObserver);
    }

    /**
     */
    public void getIncomingEdges(com.server.graph_db.grpc.vertex.getIncomingEdgesRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getIncomingEdgesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIncomingEdgesMethod(), responseObserver);
    }

    /**
     */
    public void getEdges(com.server.graph_db.grpc.vertex.getEdgesRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getEdgesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEdgesMethod(), responseObserver);
    }

    /**
     */
    public void getOutgoingEdgesForVertices(com.server.graph_db.grpc.vertex.getOutGoingEdgesForVerticesRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getEdgesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOutgoingEdgesForVerticesMethod(), responseObserver);
    }

    /**
     */
    public void getIncomingEdgesForVertices(com.server.graph_db.grpc.vertex.getIncomingEdgesForVerticesRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getEdgesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIncomingEdgesForVerticesMethod(), responseObserver);
    }

    /**
     */
    public void getAllVerticesIds(com.server.graph_db.grpc.vertex.getAllVerticesIdsRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getAllVerticesIdsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllVerticesIdsMethod(), responseObserver);
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
          .addMethod(
            getCreateVertexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.server.graph_db.grpc.vertex.createVertexRequest,
                com.server.graph_db.grpc.vertex.createVertexResponse>(
                  this, METHODID_CREATE_VERTEX)))
          .addMethod(
            getDeleteVertexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.server.graph_db.grpc.vertex.deleteVertexRequest,
                com.server.graph_db.grpc.vertex.deleteVertexResponse>(
                  this, METHODID_DELETE_VERTEX)))
          .addMethod(
            getUpdateVertexMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.server.graph_db.grpc.vertex.updateVertexRequest,
                com.server.graph_db.grpc.vertex.updateVertexResponse>(
                  this, METHODID_UPDATE_VERTEX)))
          .addMethod(
            getCreateEdgeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.server.graph_db.grpc.vertex.createEdgeRequest,
                com.server.graph_db.grpc.vertex.createEdgeResponse>(
                  this, METHODID_CREATE_EDGE)))
          .addMethod(
            getDeleteEdgeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.server.graph_db.grpc.vertex.deleteEdgeRequest,
                com.server.graph_db.grpc.vertex.deleteEdgeResponse>(
                  this, METHODID_DELETE_EDGE)))
          .addMethod(
            getUpdateEdgeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.server.graph_db.grpc.vertex.updateEdgeRequest,
                com.server.graph_db.grpc.vertex.updateEdgeResponse>(
                  this, METHODID_UPDATE_EDGE)))
          .addMethod(
            getGetOutgoingEdgesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.server.graph_db.grpc.vertex.getOutgoingEdgesRequest,
                com.server.graph_db.grpc.vertex.getOutgoingEdgesResponse>(
                  this, METHODID_GET_OUTGOING_EDGES)))
          .addMethod(
            getGetIncomingEdgesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.server.graph_db.grpc.vertex.getIncomingEdgesRequest,
                com.server.graph_db.grpc.vertex.getIncomingEdgesResponse>(
                  this, METHODID_GET_INCOMING_EDGES)))
          .addMethod(
            getGetEdgesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.server.graph_db.grpc.vertex.getEdgesRequest,
                com.server.graph_db.grpc.vertex.getEdgesResponse>(
                  this, METHODID_GET_EDGES)))
          .addMethod(
            getGetOutgoingEdgesForVerticesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.server.graph_db.grpc.vertex.getOutGoingEdgesForVerticesRequest,
                com.server.graph_db.grpc.vertex.getEdgesResponse>(
                  this, METHODID_GET_OUTGOING_EDGES_FOR_VERTICES)))
          .addMethod(
            getGetIncomingEdgesForVerticesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.server.graph_db.grpc.vertex.getIncomingEdgesForVerticesRequest,
                com.server.graph_db.grpc.vertex.getEdgesResponse>(
                  this, METHODID_GET_INCOMING_EDGES_FOR_VERTICES)))
          .addMethod(
            getGetAllVerticesIdsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.server.graph_db.grpc.vertex.getAllVerticesIdsRequest,
                com.server.graph_db.grpc.vertex.getAllVerticesIdsResponse>(
                  this, METHODID_GET_ALL_VERTICES_IDS)))
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

    /**
     */
    public void createVertex(com.server.graph_db.grpc.vertex.createVertexRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.createVertexResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVertexMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteVertex(com.server.graph_db.grpc.vertex.deleteVertexRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.deleteVertexResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVertexMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateVertex(com.server.graph_db.grpc.vertex.updateVertexRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.updateVertexResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVertexMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createEdge(com.server.graph_db.grpc.vertex.createEdgeRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.createEdgeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEdgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteEdge(com.server.graph_db.grpc.vertex.deleteEdgeRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.deleteEdgeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEdgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateEdge(com.server.graph_db.grpc.vertex.updateEdgeRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.updateEdgeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEdgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getOutgoingEdges(com.server.graph_db.grpc.vertex.getOutgoingEdgesRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getOutgoingEdgesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOutgoingEdgesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getIncomingEdges(com.server.graph_db.grpc.vertex.getIncomingEdgesRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getIncomingEdgesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIncomingEdgesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getEdges(com.server.graph_db.grpc.vertex.getEdgesRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getEdgesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEdgesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getOutgoingEdgesForVertices(com.server.graph_db.grpc.vertex.getOutGoingEdgesForVerticesRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getEdgesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOutgoingEdgesForVerticesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getIncomingEdgesForVertices(com.server.graph_db.grpc.vertex.getIncomingEdgesForVerticesRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getEdgesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIncomingEdgesForVerticesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllVerticesIds(com.server.graph_db.grpc.vertex.getAllVerticesIdsRequest request,
        io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getAllVerticesIdsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllVerticesIdsMethod(), getCallOptions()), request, responseObserver);
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

    /**
     */
    public com.server.graph_db.grpc.vertex.createVertexResponse createVertex(com.server.graph_db.grpc.vertex.createVertexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVertexMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.server.graph_db.grpc.vertex.deleteVertexResponse deleteVertex(com.server.graph_db.grpc.vertex.deleteVertexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVertexMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.server.graph_db.grpc.vertex.updateVertexResponse updateVertex(com.server.graph_db.grpc.vertex.updateVertexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVertexMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.server.graph_db.grpc.vertex.createEdgeResponse createEdge(com.server.graph_db.grpc.vertex.createEdgeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEdgeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.server.graph_db.grpc.vertex.deleteEdgeResponse deleteEdge(com.server.graph_db.grpc.vertex.deleteEdgeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEdgeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.server.graph_db.grpc.vertex.updateEdgeResponse updateEdge(com.server.graph_db.grpc.vertex.updateEdgeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEdgeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.server.graph_db.grpc.vertex.getOutgoingEdgesResponse getOutgoingEdges(com.server.graph_db.grpc.vertex.getOutgoingEdgesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOutgoingEdgesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.server.graph_db.grpc.vertex.getIncomingEdgesResponse getIncomingEdges(com.server.graph_db.grpc.vertex.getIncomingEdgesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIncomingEdgesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.server.graph_db.grpc.vertex.getEdgesResponse getEdges(com.server.graph_db.grpc.vertex.getEdgesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEdgesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.server.graph_db.grpc.vertex.getEdgesResponse getOutgoingEdgesForVertices(com.server.graph_db.grpc.vertex.getOutGoingEdgesForVerticesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOutgoingEdgesForVerticesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.server.graph_db.grpc.vertex.getEdgesResponse getIncomingEdgesForVertices(com.server.graph_db.grpc.vertex.getIncomingEdgesForVerticesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIncomingEdgesForVerticesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.server.graph_db.grpc.vertex.getAllVerticesIdsResponse getAllVerticesIds(com.server.graph_db.grpc.vertex.getAllVerticesIdsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllVerticesIdsMethod(), getCallOptions(), request);
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

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.server.graph_db.grpc.vertex.createVertexResponse> createVertex(
        com.server.graph_db.grpc.vertex.createVertexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVertexMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.server.graph_db.grpc.vertex.deleteVertexResponse> deleteVertex(
        com.server.graph_db.grpc.vertex.deleteVertexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVertexMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.server.graph_db.grpc.vertex.updateVertexResponse> updateVertex(
        com.server.graph_db.grpc.vertex.updateVertexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVertexMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.server.graph_db.grpc.vertex.createEdgeResponse> createEdge(
        com.server.graph_db.grpc.vertex.createEdgeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEdgeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.server.graph_db.grpc.vertex.deleteEdgeResponse> deleteEdge(
        com.server.graph_db.grpc.vertex.deleteEdgeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEdgeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.server.graph_db.grpc.vertex.updateEdgeResponse> updateEdge(
        com.server.graph_db.grpc.vertex.updateEdgeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEdgeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.server.graph_db.grpc.vertex.getOutgoingEdgesResponse> getOutgoingEdges(
        com.server.graph_db.grpc.vertex.getOutgoingEdgesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOutgoingEdgesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.server.graph_db.grpc.vertex.getIncomingEdgesResponse> getIncomingEdges(
        com.server.graph_db.grpc.vertex.getIncomingEdgesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIncomingEdgesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.server.graph_db.grpc.vertex.getEdgesResponse> getEdges(
        com.server.graph_db.grpc.vertex.getEdgesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEdgesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.server.graph_db.grpc.vertex.getEdgesResponse> getOutgoingEdgesForVertices(
        com.server.graph_db.grpc.vertex.getOutGoingEdgesForVerticesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOutgoingEdgesForVerticesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.server.graph_db.grpc.vertex.getEdgesResponse> getIncomingEdgesForVertices(
        com.server.graph_db.grpc.vertex.getIncomingEdgesForVerticesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIncomingEdgesForVerticesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.server.graph_db.grpc.vertex.getAllVerticesIdsResponse> getAllVerticesIds(
        com.server.graph_db.grpc.vertex.getAllVerticesIdsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllVerticesIdsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_VERTEX = 0;
  private static final int METHODID_GET_VERTICES = 1;
  private static final int METHODID_CREATE_VERTEX = 2;
  private static final int METHODID_DELETE_VERTEX = 3;
  private static final int METHODID_UPDATE_VERTEX = 4;
  private static final int METHODID_CREATE_EDGE = 5;
  private static final int METHODID_DELETE_EDGE = 6;
  private static final int METHODID_UPDATE_EDGE = 7;
  private static final int METHODID_GET_OUTGOING_EDGES = 8;
  private static final int METHODID_GET_INCOMING_EDGES = 9;
  private static final int METHODID_GET_EDGES = 10;
  private static final int METHODID_GET_OUTGOING_EDGES_FOR_VERTICES = 11;
  private static final int METHODID_GET_INCOMING_EDGES_FOR_VERTICES = 12;
  private static final int METHODID_GET_ALL_VERTICES_IDS = 13;

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
        case METHODID_CREATE_VERTEX:
          serviceImpl.createVertex((com.server.graph_db.grpc.vertex.createVertexRequest) request,
              (io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.createVertexResponse>) responseObserver);
          break;
        case METHODID_DELETE_VERTEX:
          serviceImpl.deleteVertex((com.server.graph_db.grpc.vertex.deleteVertexRequest) request,
              (io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.deleteVertexResponse>) responseObserver);
          break;
        case METHODID_UPDATE_VERTEX:
          serviceImpl.updateVertex((com.server.graph_db.grpc.vertex.updateVertexRequest) request,
              (io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.updateVertexResponse>) responseObserver);
          break;
        case METHODID_CREATE_EDGE:
          serviceImpl.createEdge((com.server.graph_db.grpc.vertex.createEdgeRequest) request,
              (io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.createEdgeResponse>) responseObserver);
          break;
        case METHODID_DELETE_EDGE:
          serviceImpl.deleteEdge((com.server.graph_db.grpc.vertex.deleteEdgeRequest) request,
              (io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.deleteEdgeResponse>) responseObserver);
          break;
        case METHODID_UPDATE_EDGE:
          serviceImpl.updateEdge((com.server.graph_db.grpc.vertex.updateEdgeRequest) request,
              (io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.updateEdgeResponse>) responseObserver);
          break;
        case METHODID_GET_OUTGOING_EDGES:
          serviceImpl.getOutgoingEdges((com.server.graph_db.grpc.vertex.getOutgoingEdgesRequest) request,
              (io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getOutgoingEdgesResponse>) responseObserver);
          break;
        case METHODID_GET_INCOMING_EDGES:
          serviceImpl.getIncomingEdges((com.server.graph_db.grpc.vertex.getIncomingEdgesRequest) request,
              (io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getIncomingEdgesResponse>) responseObserver);
          break;
        case METHODID_GET_EDGES:
          serviceImpl.getEdges((com.server.graph_db.grpc.vertex.getEdgesRequest) request,
              (io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getEdgesResponse>) responseObserver);
          break;
        case METHODID_GET_OUTGOING_EDGES_FOR_VERTICES:
          serviceImpl.getOutgoingEdgesForVertices((com.server.graph_db.grpc.vertex.getOutGoingEdgesForVerticesRequest) request,
              (io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getEdgesResponse>) responseObserver);
          break;
        case METHODID_GET_INCOMING_EDGES_FOR_VERTICES:
          serviceImpl.getIncomingEdgesForVertices((com.server.graph_db.grpc.vertex.getIncomingEdgesForVerticesRequest) request,
              (io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getEdgesResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_VERTICES_IDS:
          serviceImpl.getAllVerticesIds((com.server.graph_db.grpc.vertex.getAllVerticesIdsRequest) request,
              (io.grpc.stub.StreamObserver<com.server.graph_db.grpc.vertex.getAllVerticesIdsResponse>) responseObserver);
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
              .addMethod(getCreateVertexMethod())
              .addMethod(getDeleteVertexMethod())
              .addMethod(getUpdateVertexMethod())
              .addMethod(getCreateEdgeMethod())
              .addMethod(getDeleteEdgeMethod())
              .addMethod(getUpdateEdgeMethod())
              .addMethod(getGetOutgoingEdgesMethod())
              .addMethod(getGetIncomingEdgesMethod())
              .addMethod(getGetEdgesMethod())
              .addMethod(getGetOutgoingEdgesForVerticesMethod())
              .addMethod(getGetIncomingEdgesForVerticesMethod())
              .addMethod(getGetAllVerticesIdsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
