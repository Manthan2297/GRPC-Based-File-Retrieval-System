package csc435.app;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class RPCServerWorker implements Runnable {
    private IndexStore store;
    // TO-DO keep track of the gRPC Server object
    private Server server;
    private int port;

    public RPCServerWorker(IndexStore store, int port) {
        this.store = store;
        this.port = port;
    }

    @Override
    public void run() {
        // TO-DO build the gRPC Server
        try {
            server = ServerBuilder.forPort(port)
                    .addService(new FileRetrievalEngineService(store))
                    .build()
                    .start();

            System.out.println("Server started on port " + port);
            server.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        // TO-DO shutdown the gRPC server
        if (server != null) {
            server.shutdown();
            System.out.println("Server shutting down...");
        }
    }
}
