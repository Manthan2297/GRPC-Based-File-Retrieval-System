package csc435.app;

public class FileRetrievalServer {
    public static void main(String[] args) {
        int serverPort = Integer.parseInt(args[0]);

        IndexStore store = new IndexStore();
        ServerProcessingEngine engine = new ServerProcessingEngine(store);
        ServerAppInterface appInterface = new ServerAppInterface(engine);

        engine.initialize(serverPort);
        appInterface.readCommands();
    }
}
