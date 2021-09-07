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
public final class BlogServiceGrpc {

  private BlogServiceGrpc() {}

  public static final String SERVICE_NAME = "blog.BlogService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.blog.CreateBlogRequest,
      com.proto.blog.CreateBlogResponse> getCreateBlogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBlog",
      requestType = com.proto.blog.CreateBlogRequest.class,
      responseType = com.proto.blog.CreateBlogResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.blog.CreateBlogRequest,
      com.proto.blog.CreateBlogResponse> getCreateBlogMethod() {
    io.grpc.MethodDescriptor<com.proto.blog.CreateBlogRequest, com.proto.blog.CreateBlogResponse> getCreateBlogMethod;
    if ((getCreateBlogMethod = BlogServiceGrpc.getCreateBlogMethod) == null) {
      synchronized (BlogServiceGrpc.class) {
        if ((getCreateBlogMethod = BlogServiceGrpc.getCreateBlogMethod) == null) {
          BlogServiceGrpc.getCreateBlogMethod = getCreateBlogMethod =
              io.grpc.MethodDescriptor.<com.proto.blog.CreateBlogRequest, com.proto.blog.CreateBlogResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBlog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.blog.CreateBlogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.blog.CreateBlogResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BlogServiceMethodDescriptorSupplier("CreateBlog"))
              .build();
        }
      }
    }
    return getCreateBlogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.blog.ReadBlogRequest,
      com.proto.blog.ReadBlogResponse> getReadBlogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadBlog",
      requestType = com.proto.blog.ReadBlogRequest.class,
      responseType = com.proto.blog.ReadBlogResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.blog.ReadBlogRequest,
      com.proto.blog.ReadBlogResponse> getReadBlogMethod() {
    io.grpc.MethodDescriptor<com.proto.blog.ReadBlogRequest, com.proto.blog.ReadBlogResponse> getReadBlogMethod;
    if ((getReadBlogMethod = BlogServiceGrpc.getReadBlogMethod) == null) {
      synchronized (BlogServiceGrpc.class) {
        if ((getReadBlogMethod = BlogServiceGrpc.getReadBlogMethod) == null) {
          BlogServiceGrpc.getReadBlogMethod = getReadBlogMethod =
              io.grpc.MethodDescriptor.<com.proto.blog.ReadBlogRequest, com.proto.blog.ReadBlogResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadBlog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.blog.ReadBlogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.blog.ReadBlogResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BlogServiceMethodDescriptorSupplier("ReadBlog"))
              .build();
        }
      }
    }
    return getReadBlogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.blog.UpdateBlogRequest,
      com.proto.blog.UpdateBlogResponse> getUpdateBlogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBlog",
      requestType = com.proto.blog.UpdateBlogRequest.class,
      responseType = com.proto.blog.UpdateBlogResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.blog.UpdateBlogRequest,
      com.proto.blog.UpdateBlogResponse> getUpdateBlogMethod() {
    io.grpc.MethodDescriptor<com.proto.blog.UpdateBlogRequest, com.proto.blog.UpdateBlogResponse> getUpdateBlogMethod;
    if ((getUpdateBlogMethod = BlogServiceGrpc.getUpdateBlogMethod) == null) {
      synchronized (BlogServiceGrpc.class) {
        if ((getUpdateBlogMethod = BlogServiceGrpc.getUpdateBlogMethod) == null) {
          BlogServiceGrpc.getUpdateBlogMethod = getUpdateBlogMethod =
              io.grpc.MethodDescriptor.<com.proto.blog.UpdateBlogRequest, com.proto.blog.UpdateBlogResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBlog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.blog.UpdateBlogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.blog.UpdateBlogResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BlogServiceMethodDescriptorSupplier("UpdateBlog"))
              .build();
        }
      }
    }
    return getUpdateBlogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.blog.DeleteBlogRequest,
      com.proto.blog.DeleteBlogResponse> getDeleteBlogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBlog",
      requestType = com.proto.blog.DeleteBlogRequest.class,
      responseType = com.proto.blog.DeleteBlogResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.blog.DeleteBlogRequest,
      com.proto.blog.DeleteBlogResponse> getDeleteBlogMethod() {
    io.grpc.MethodDescriptor<com.proto.blog.DeleteBlogRequest, com.proto.blog.DeleteBlogResponse> getDeleteBlogMethod;
    if ((getDeleteBlogMethod = BlogServiceGrpc.getDeleteBlogMethod) == null) {
      synchronized (BlogServiceGrpc.class) {
        if ((getDeleteBlogMethod = BlogServiceGrpc.getDeleteBlogMethod) == null) {
          BlogServiceGrpc.getDeleteBlogMethod = getDeleteBlogMethod =
              io.grpc.MethodDescriptor.<com.proto.blog.DeleteBlogRequest, com.proto.blog.DeleteBlogResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBlog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.blog.DeleteBlogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.blog.DeleteBlogResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BlogServiceMethodDescriptorSupplier("DeleteBlog"))
              .build();
        }
      }
    }
    return getDeleteBlogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.blog.FindAllBlogRequest,
      com.proto.blog.FindAllBlogResponse> getFindAllBlogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAllBlog",
      requestType = com.proto.blog.FindAllBlogRequest.class,
      responseType = com.proto.blog.FindAllBlogResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.blog.FindAllBlogRequest,
      com.proto.blog.FindAllBlogResponse> getFindAllBlogMethod() {
    io.grpc.MethodDescriptor<com.proto.blog.FindAllBlogRequest, com.proto.blog.FindAllBlogResponse> getFindAllBlogMethod;
    if ((getFindAllBlogMethod = BlogServiceGrpc.getFindAllBlogMethod) == null) {
      synchronized (BlogServiceGrpc.class) {
        if ((getFindAllBlogMethod = BlogServiceGrpc.getFindAllBlogMethod) == null) {
          BlogServiceGrpc.getFindAllBlogMethod = getFindAllBlogMethod =
              io.grpc.MethodDescriptor.<com.proto.blog.FindAllBlogRequest, com.proto.blog.FindAllBlogResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAllBlog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.blog.FindAllBlogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.blog.FindAllBlogResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BlogServiceMethodDescriptorSupplier("FindAllBlog"))
              .build();
        }
      }
    }
    return getFindAllBlogMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BlogServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BlogServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BlogServiceStub>() {
        @java.lang.Override
        public BlogServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BlogServiceStub(channel, callOptions);
        }
      };
    return BlogServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BlogServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BlogServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BlogServiceBlockingStub>() {
        @java.lang.Override
        public BlogServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BlogServiceBlockingStub(channel, callOptions);
        }
      };
    return BlogServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BlogServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BlogServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BlogServiceFutureStub>() {
        @java.lang.Override
        public BlogServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BlogServiceFutureStub(channel, callOptions);
        }
      };
    return BlogServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BlogServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createBlog(com.proto.blog.CreateBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.CreateBlogResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateBlogMethod(), responseObserver);
    }

    /**
     */
    public void readBlog(com.proto.blog.ReadBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.ReadBlogResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReadBlogMethod(), responseObserver);
    }

    /**
     */
    public void updateBlog(com.proto.blog.UpdateBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.UpdateBlogResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateBlogMethod(), responseObserver);
    }

    /**
     */
    public void deleteBlog(com.proto.blog.DeleteBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.DeleteBlogResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteBlogMethod(), responseObserver);
    }

    /**
     */
    public void findAllBlog(com.proto.blog.FindAllBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.FindAllBlogResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFindAllBlogMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateBlogMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.blog.CreateBlogRequest,
                com.proto.blog.CreateBlogResponse>(
                  this, METHODID_CREATE_BLOG)))
          .addMethod(
            getReadBlogMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.blog.ReadBlogRequest,
                com.proto.blog.ReadBlogResponse>(
                  this, METHODID_READ_BLOG)))
          .addMethod(
            getUpdateBlogMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.blog.UpdateBlogRequest,
                com.proto.blog.UpdateBlogResponse>(
                  this, METHODID_UPDATE_BLOG)))
          .addMethod(
            getDeleteBlogMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.blog.DeleteBlogRequest,
                com.proto.blog.DeleteBlogResponse>(
                  this, METHODID_DELETE_BLOG)))
          .addMethod(
            getFindAllBlogMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.proto.blog.FindAllBlogRequest,
                com.proto.blog.FindAllBlogResponse>(
                  this, METHODID_FIND_ALL_BLOG)))
          .build();
    }
  }

  /**
   */
  public static final class BlogServiceStub extends io.grpc.stub.AbstractAsyncStub<BlogServiceStub> {
    private BlogServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlogServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BlogServiceStub(channel, callOptions);
    }

    /**
     */
    public void createBlog(com.proto.blog.CreateBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.CreateBlogResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateBlogMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readBlog(com.proto.blog.ReadBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.ReadBlogResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadBlogMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateBlog(com.proto.blog.UpdateBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.UpdateBlogResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateBlogMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteBlog(com.proto.blog.DeleteBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.DeleteBlogResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteBlogMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAllBlog(com.proto.blog.FindAllBlogRequest request,
        io.grpc.stub.StreamObserver<com.proto.blog.FindAllBlogResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getFindAllBlogMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BlogServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<BlogServiceBlockingStub> {
    private BlogServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlogServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BlogServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.blog.CreateBlogResponse createBlog(com.proto.blog.CreateBlogRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateBlogMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.proto.blog.ReadBlogResponse readBlog(com.proto.blog.ReadBlogRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadBlogMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.proto.blog.UpdateBlogResponse updateBlog(com.proto.blog.UpdateBlogRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateBlogMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.proto.blog.DeleteBlogResponse deleteBlog(com.proto.blog.DeleteBlogRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteBlogMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.proto.blog.FindAllBlogResponse> findAllBlog(
        com.proto.blog.FindAllBlogRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getFindAllBlogMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BlogServiceFutureStub extends io.grpc.stub.AbstractFutureStub<BlogServiceFutureStub> {
    private BlogServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlogServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BlogServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.blog.CreateBlogResponse> createBlog(
        com.proto.blog.CreateBlogRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateBlogMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.blog.ReadBlogResponse> readBlog(
        com.proto.blog.ReadBlogRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadBlogMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.blog.UpdateBlogResponse> updateBlog(
        com.proto.blog.UpdateBlogRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateBlogMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.blog.DeleteBlogResponse> deleteBlog(
        com.proto.blog.DeleteBlogRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteBlogMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_BLOG = 0;
  private static final int METHODID_READ_BLOG = 1;
  private static final int METHODID_UPDATE_BLOG = 2;
  private static final int METHODID_DELETE_BLOG = 3;
  private static final int METHODID_FIND_ALL_BLOG = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BlogServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BlogServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_BLOG:
          serviceImpl.createBlog((com.proto.blog.CreateBlogRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.blog.CreateBlogResponse>) responseObserver);
          break;
        case METHODID_READ_BLOG:
          serviceImpl.readBlog((com.proto.blog.ReadBlogRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.blog.ReadBlogResponse>) responseObserver);
          break;
        case METHODID_UPDATE_BLOG:
          serviceImpl.updateBlog((com.proto.blog.UpdateBlogRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.blog.UpdateBlogResponse>) responseObserver);
          break;
        case METHODID_DELETE_BLOG:
          serviceImpl.deleteBlog((com.proto.blog.DeleteBlogRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.blog.DeleteBlogResponse>) responseObserver);
          break;
        case METHODID_FIND_ALL_BLOG:
          serviceImpl.findAllBlog((com.proto.blog.FindAllBlogRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.blog.FindAllBlogResponse>) responseObserver);
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

  private static abstract class BlogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BlogServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.blog.BlogOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BlogService");
    }
  }

  private static final class BlogServiceFileDescriptorSupplier
      extends BlogServiceBaseDescriptorSupplier {
    BlogServiceFileDescriptorSupplier() {}
  }

  private static final class BlogServiceMethodDescriptorSupplier
      extends BlogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BlogServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BlogServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BlogServiceFileDescriptorSupplier())
              .addMethod(getCreateBlogMethod())
              .addMethod(getReadBlogMethod())
              .addMethod(getUpdateBlogMethod())
              .addMethod(getDeleteBlogMethod())
              .addMethod(getFindAllBlogMethod())
              .build();
        }
      }
    }
    return result;
  }
}
