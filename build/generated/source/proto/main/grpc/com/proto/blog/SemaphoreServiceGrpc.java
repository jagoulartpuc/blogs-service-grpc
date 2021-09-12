package com.proto.blog;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.29.0)",
    comments = "Source: blog/blog.proto")
public final class SemaphoreServiceGrpc {

  private SemaphoreServiceGrpc() {}

  public static final String SERVICE_NAME = "blog.SemaphoreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.blog.SemaphoreRequest,
      com.proto.blog.SemaphoreResponse> getAcquireMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Acquire",
      requestType = com.proto.blog.SemaphoreRequest.class,
      responseType = com.proto.blog.SemaphoreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.blog.SemaphoreRequest,
      com.proto.blog.SemaphoreResponse> getAcquireMethod() {
    io.grpc.MethodDescriptor<com.proto.blog.SemaphoreRequest, com.proto.blog.SemaphoreResponse> getAcquireMethod;
    if ((getAcquireMethod = SemaphoreServiceGrpc.getAcquireMethod) == null) {
      synchronized (SemaphoreServiceGrpc.class) {
        if ((getAcquireMethod = SemaphoreServiceGrpc.getAcquireMethod) == null) {
          SemaphoreServiceGrpc.getAcquireMethod = getAcquireMethod =
              io.grpc.MethodDescriptor.<com.proto.blog.SemaphoreRequest, com.proto.blog.SemaphoreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Acquire"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.blog.SemaphoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.blog.SemaphoreResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SemaphoreServiceMethodDescriptorSupplier("Acquire"))
              .build();
        }
      }
    }
    return getAcquireMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.blog.SemaphoreRequest,
      com.proto.blog.SemaphoreResponse> getReleaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Release",
      requestType = com.proto.blog.SemaphoreRequest.class,
      responseType = com.proto.blog.SemaphoreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.blog.SemaphoreRequest,
      com.proto.blog.SemaphoreResponse> getReleaseMethod() {
    io.grpc.MethodDescriptor<com.proto.blog.SemaphoreRequest, com.proto.blog.SemaphoreResponse> getReleaseMethod;
    if ((getReleaseMethod = SemaphoreServiceGrpc.getReleaseMethod) == null) {
      synchronized (SemaphoreServiceGrpc.class) {
        if ((getReleaseMethod = SemaphoreServiceGrpc.getReleaseMethod) == null) {
          SemaphoreServiceGrpc.getReleaseMethod = getReleaseMethod =
              io.grpc.MethodDescriptor.<com.proto.blog.SemaphoreRequest, com.proto.blog.SemaphoreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Release"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.blog.SemaphoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.blog.SemaphoreResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SemaphoreServiceMethodDescriptorSupplier("Release"))
              .build();
        }
      }
    }
    return getReleaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.blog.SemaphoreRequest,
      com.proto.blog.SemaphoreResponse> getPermitsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Permits",
      requestType = com.proto.blog.SemaphoreRequest.class,
      responseType = com.proto.blog.SemaphoreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.blog.SemaphoreRequest,
      com.proto.blog.SemaphoreResponse> getPermitsMethod() {
    io.grpc.MethodDescriptor<com.proto.blog.SemaphoreRequest, com.proto.blog.SemaphoreResponse> getPermitsMethod;
    if ((getPermitsMethod = SemaphoreServiceGrpc.getPermitsMethod) == null) {
      synchronized (SemaphoreServiceGrpc.class) {
        if ((getPermitsMethod = SemaphoreServiceGrpc.getPermitsMethod) == null) {
          SemaphoreServiceGrpc.getPermitsMethod = getPermitsMethod =
              io.grpc.MethodDescriptor.<com.proto.blog.SemaphoreRequest, com.proto.blog.SemaphoreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Permits"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.blog.SemaphoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.blog.SemaphoreResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SemaphoreServiceMethodDescriptorSupplier("Permits"))
              .build();
        }
      }
    }
    return getPermitsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SemaphoreServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SemaphoreServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SemaphoreServiceStub>() {
        @java.lang.Override
        public SemaphoreServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SemaphoreServiceStub(channel, callOptions);
        }
      };
    return SemaphoreServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SemaphoreServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SemaphoreServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SemaphoreServiceBlockingStub>() {
        @java.lang.Override
        public SemaphoreServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SemaphoreServiceBlockingStub(channel, callOptions);
        }
      };
    return SemaphoreServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SemaphoreServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SemaphoreServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SemaphoreServiceFutureStub>() {
        @java.lang.Override
        public SemaphoreServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SemaphoreServiceFutureStub(channel, callOptions);
        }
      };
    return SemaphoreServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SemaphoreServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void acquire(com.proto.blog.SemaphoreRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.SemaphoreResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAcquireMethod(), responseObserver);
    }

    /**
     */
    public void release(com.proto.blog.SemaphoreRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.SemaphoreResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReleaseMethod(), responseObserver);
    }

    /**
     */
    public void permits(com.proto.blog.SemaphoreRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.SemaphoreResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPermitsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAcquireMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.blog.SemaphoreRequest,
                com.proto.blog.SemaphoreResponse>(
                  this, METHODID_ACQUIRE)))
          .addMethod(
            getReleaseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.blog.SemaphoreRequest,
                com.proto.blog.SemaphoreResponse>(
                  this, METHODID_RELEASE)))
          .addMethod(
            getPermitsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.blog.SemaphoreRequest,
                com.proto.blog.SemaphoreResponse>(
                  this, METHODID_PERMITS)))
          .build();
    }
  }

  /**
   */
  public static final class SemaphoreServiceStub extends io.grpc.stub.AbstractAsyncStub<SemaphoreServiceStub> {
    private SemaphoreServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SemaphoreServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SemaphoreServiceStub(channel, callOptions);
    }

    /**
     */
    public void acquire(com.proto.blog.SemaphoreRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.SemaphoreResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAcquireMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void release(com.proto.blog.SemaphoreRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.SemaphoreResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReleaseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void permits(com.proto.blog.SemaphoreRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.SemaphoreResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPermitsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SemaphoreServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SemaphoreServiceBlockingStub> {
    private SemaphoreServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SemaphoreServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SemaphoreServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.blog.SemaphoreResponse acquire(com.proto.blog.SemaphoreRequest request) {
      return blockingUnaryCall(
          getChannel(), getAcquireMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.proto.blog.SemaphoreResponse release(com.proto.blog.SemaphoreRequest request) {
      return blockingUnaryCall(
          getChannel(), getReleaseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.proto.blog.SemaphoreResponse permits(com.proto.blog.SemaphoreRequest request) {
      return blockingUnaryCall(
          getChannel(), getPermitsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SemaphoreServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SemaphoreServiceFutureStub> {
    private SemaphoreServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SemaphoreServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SemaphoreServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.blog.SemaphoreResponse> acquire(
        com.proto.blog.SemaphoreRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAcquireMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.blog.SemaphoreResponse> release(
        com.proto.blog.SemaphoreRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReleaseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.blog.SemaphoreResponse> permits(
        com.proto.blog.SemaphoreRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPermitsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ACQUIRE = 0;
  private static final int METHODID_RELEASE = 1;
  private static final int METHODID_PERMITS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SemaphoreServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SemaphoreServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ACQUIRE:
          serviceImpl.acquire((com.proto.blog.SemaphoreRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.blog.SemaphoreResponse>) responseObserver);
          break;
        case METHODID_RELEASE:
          serviceImpl.release((com.proto.blog.SemaphoreRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.blog.SemaphoreResponse>) responseObserver);
          break;
        case METHODID_PERMITS:
          serviceImpl.permits((com.proto.blog.SemaphoreRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.blog.SemaphoreResponse>) responseObserver);
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

  private static abstract class SemaphoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SemaphoreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.blog.BlogOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SemaphoreService");
    }
  }

  private static final class SemaphoreServiceFileDescriptorSupplier
      extends SemaphoreServiceBaseDescriptorSupplier {
    SemaphoreServiceFileDescriptorSupplier() {}
  }

  private static final class SemaphoreServiceMethodDescriptorSupplier
      extends SemaphoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SemaphoreServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SemaphoreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SemaphoreServiceFileDescriptorSupplier())
              .addMethod(getAcquireMethod())
              .addMethod(getReleaseMethod())
              .addMethod(getPermitsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
