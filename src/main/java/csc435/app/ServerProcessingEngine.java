package csc435.app;

public class ServerProcessingEngine {
    private IndexStore store;
    // TO-DO keep track of the RPCServerWorker object
    private RPCServerWorker worker;
    // TO-DO keep track of the gRPC server thread
    private Thread serverThread;

    public ServerProcessingEngine(IndexStore store) {
        this.store = store;
    }

    // TO-DO create and start the gRPC Server
    public void initialize(int serverPort) {
        worker = new RPCServerWorker(store, serverPort);
        serverThread = new Thread(worker);
        serverThread.start();
    }

    // TO-DO shutdown the gRPC Server
    public void shutdown() {
        worker.shutdown();
        try {
            serverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
