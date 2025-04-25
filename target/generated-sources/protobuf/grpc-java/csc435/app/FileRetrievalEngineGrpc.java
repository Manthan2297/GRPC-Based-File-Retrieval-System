package csc435.app;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: csc435/app/file_retrieval_engine.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FileRetrievalEngineGrpc {

  private FileRetrievalEngineGrpc() {}

  public static final java.lang.String SERVICE_NAME = "FileRetrievalEngine";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      csc435.app.RegisterRep> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Register",
      requestType = com.google.protobuf.Empty.class,
      responseType = csc435.app.RegisterRep.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      csc435.app.RegisterRep> getRegisterMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, csc435.app.RegisterRep> getRegisterMethod;
    if ((getRegisterMethod = FileRetrievalEngineGrpc.getRegisterMethod) == null) {
      synchronized (FileRetrievalEngineGrpc.class) {
        if ((getRegisterMethod = FileRetrievalEngineGrpc.getRegisterMethod) == null) {
          FileRetrievalEngineGrpc.getRegisterMethod = getRegisterMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, csc435.app.RegisterRep>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  csc435.app.RegisterRep.getDefaultInstance()))
              .setSchemaDescriptor(new FileRetrievalEngineMethodDescriptorSupplier("Register"))
              .build();
        }
      }
    }
    return getRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<csc435.app.IndexReq,
      csc435.app.IndexRep> getComputeIndexMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComputeIndex",
      requestType = csc435.app.IndexReq.class,
      responseType = csc435.app.IndexRep.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<csc435.app.IndexReq,
      csc435.app.IndexRep> getComputeIndexMethod() {
    io.grpc.MethodDescriptor<csc435.app.IndexReq, csc435.app.IndexRep> getComputeIndexMethod;
    if ((getComputeIndexMethod = FileRetrievalEngineGrpc.getComputeIndexMethod) == null) {
      synchronized (FileRetrievalEngineGrpc.class) {
        if ((getComputeIndexMethod = FileRetrievalEngineGrpc.getComputeIndexMethod) == null) {
          FileRetrievalEngineGrpc.getComputeIndexMethod = getComputeIndexMethod =
              io.grpc.MethodDescriptor.<csc435.app.IndexReq, csc435.app.IndexRep>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ComputeIndex"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  csc435.app.IndexReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  csc435.app.IndexRep.getDefaultInstance()))
              .setSchemaDescriptor(new FileRetrievalEngineMethodDescriptorSupplier("ComputeIndex"))
              .build();
        }
      }
    }
    return getComputeIndexMethod;
  }

  private static volatile io.grpc.MethodDescriptor<csc435.app.SearchReq,
      csc435.app.SearchRep> getComputeSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComputeSearch",
      requestType = csc435.app.SearchReq.class,
      responseType = csc435.app.SearchRep.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<csc435.app.SearchReq,
      csc435.app.SearchRep> getComputeSearchMethod() {
    io.grpc.MethodDescriptor<csc435.app.SearchReq, csc435.app.SearchRep> getComputeSearchMethod;
    if ((getComputeSearchMethod = FileRetrievalEngineGrpc.getComputeSearchMethod) == null) {
      synchronized (FileRetrievalEngineGrpc.class) {
        if ((getComputeSearchMethod = FileRetrievalEngineGrpc.getComputeSearchMethod) == null) {
          FileRetrievalEngineGrpc.getComputeSearchMethod = getComputeSearchMethod =
              io.grpc.MethodDescriptor.<csc435.app.SearchReq, csc435.app.SearchRep>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ComputeSearch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  csc435.app.SearchReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  csc435.app.SearchRep.getDefaultInstance()))
              .setSchemaDescriptor(new FileRetrievalEngineMethodDescriptorSupplier("ComputeSearch"))
              .build();
        }
      }
    }
    return getComputeSearchMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FileRetrievalEngineStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FileRetrievalEngineStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FileRetrievalEngineStub>() {
        @java.lang.Override
        public FileRetrievalEngineStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FileRetrievalEngineStub(channel, callOptions);
        }
      };
    return FileRetrievalEngineStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FileRetrievalEngineBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FileRetrievalEngineBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FileRetrievalEngineBlockingStub>() {
        @java.lang.Override
        public FileRetrievalEngineBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FileRetrievalEngineBlockingStub(channel, callOptions);
        }
      };
    return FileRetrievalEngineBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FileRetrievalEngineFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FileRetrievalEngineFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FileRetrievalEngineFutureStub>() {
        @java.lang.Override
        public FileRetrievalEngineFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FileRetrievalEngineFutureStub(channel, callOptions);
        }
      };
    return FileRetrievalEngineFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void register(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<csc435.app.RegisterRep> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /**
     */
    default void computeIndex(csc435.app.IndexReq request,
        io.grpc.stub.StreamObserver<csc435.app.IndexRep> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getComputeIndexMethod(), responseObserver);
    }

    /**
     */
    default void computeSearch(csc435.app.SearchReq request,
        io.grpc.stub.StreamObserver<csc435.app.SearchRep> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getComputeSearchMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FileRetrievalEngine.
   */
  public static abstract class FileRetrievalEngineImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FileRetrievalEngineGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FileRetrievalEngine.
   */
  public static final class FileRetrievalEngineStub
      extends io.grpc.stub.AbstractAsyncStub<FileRetrievalEngineStub> {
    private FileRetrievalEngineStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileRetrievalEngineStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FileRetrievalEngineStub(channel, callOptions);
    }

    /**
     */
    public void register(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<csc435.app.RegisterRep> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void computeIndex(csc435.app.IndexReq request,
        io.grpc.stub.StreamObserver<csc435.app.IndexRep> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getComputeIndexMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void computeSearch(csc435.app.SearchReq request,
        io.grpc.stub.StreamObserver<csc435.app.SearchRep> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getComputeSearchMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FileRetrievalEngine.
   */
  public static final class FileRetrievalEngineBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FileRetrievalEngineBlockingStub> {
    private FileRetrievalEngineBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileRetrievalEngineBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FileRetrievalEngineBlockingStub(channel, callOptions);
    }

    /**
     */
    public csc435.app.RegisterRep register(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public csc435.app.IndexRep computeIndex(csc435.app.IndexReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getComputeIndexMethod(), getCallOptions(), request);
    }

    /**
     */
    public csc435.app.SearchRep computeSearch(csc435.app.SearchReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getComputeSearchMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FileRetrievalEngine.
   */
  public static final class FileRetrievalEngineFutureStub
      extends io.grpc.stub.AbstractFutureStub<FileRetrievalEngineFutureStub> {
    private FileRetrievalEngineFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileRetrievalEngineFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FileRetrievalEngineFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<csc435.app.RegisterRep> register(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<csc435.app.IndexRep> computeIndex(
        csc435.app.IndexReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getComputeIndexMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<csc435.app.SearchRep> computeSearch(
        csc435.app.SearchReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getComputeSearchMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_COMPUTE_INDEX = 1;
  private static final int METHODID_COMPUTE_SEARCH = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<csc435.app.RegisterRep>) responseObserver);
          break;
        case METHODID_COMPUTE_INDEX:
          serviceImpl.computeIndex((csc435.app.IndexReq) request,
              (io.grpc.stub.StreamObserver<csc435.app.IndexRep>) responseObserver);
          break;
        case METHODID_COMPUTE_SEARCH:
          serviceImpl.computeSearch((csc435.app.SearchReq) request,
              (io.grpc.stub.StreamObserver<csc435.app.SearchRep>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getRegisterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              csc435.app.RegisterRep>(
                service, METHODID_REGISTER)))
        .addMethod(
          getComputeIndexMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              csc435.app.IndexReq,
              csc435.app.IndexRep>(
                service, METHODID_COMPUTE_INDEX)))
        .addMethod(
          getComputeSearchMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              csc435.app.SearchReq,
              csc435.app.SearchRep>(
                service, METHODID_COMPUTE_SEARCH)))
        .build();
  }

  private static abstract class FileRetrievalEngineBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FileRetrievalEngineBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return csc435.app.FileRetrievalEngineProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FileRetrievalEngine");
    }
  }

  private static final class FileRetrievalEngineFileDescriptorSupplier
      extends FileRetrievalEngineBaseDescriptorSupplier {
    FileRetrievalEngineFileDescriptorSupplier() {}
  }

  private static final class FileRetrievalEngineMethodDescriptorSupplier
      extends FileRetrievalEngineBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FileRetrievalEngineMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FileRetrievalEngineGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FileRetrievalEngineFileDescriptorSupplier())
              .addMethod(getRegisterMethod())
              .addMethod(getComputeIndexMethod())
              .addMethod(getComputeSearchMethod())
              .build();
        }
      }
    }
    return result;
  }
}
