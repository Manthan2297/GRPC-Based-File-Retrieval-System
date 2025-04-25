package csc435.app;

import java.util.ArrayList;
import java.util.List;

class BenchmarkWorker implements Runnable {
    private ClientProcessingEngine clientEngine;
    private String datasetPath;
    private String serverIP;
    private String serverPort;
    private long totalBytesRead;
    private double executionTime;

    public BenchmarkWorker(String serverIP, String serverPort, String datasetPath) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        this.datasetPath = datasetPath;
    }

    @Override
    public void run() {
        clientEngine = new ClientProcessingEngine();
        clientEngine.connect(serverIP, serverPort);

        System.out.println("Client " + clientEngine.getInfo() + " indexing: " + datasetPath);
        IndexResult result = clientEngine.indexFiles(datasetPath);
        totalBytesRead = result.totalBytesRead;
        executionTime = result.executionTime;
    }

    public void search() {
        List<String> queries = List.of("distortion AND adaptation", "child-like", "the");
        for (String query : queries) {
            String[] terms = query.split(" AND ");
            clientEngine.searchFiles(new ArrayList<>(List.of(terms)));
        }
    }

    public void disconnect() {
        System.out.println("Client " + clientEngine.getInfo() + " disconnecting...");
    }

    public long getTotalBytesRead() {
        return totalBytesRead;
    }

    public double getExecutionTime() {
        return executionTime;
    }
}

public class FileRetrievalBenchmark {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("java FileRetrievalBenchmark <server IP> <server port> <number of clients> [<dataset paths>]");
            return;
        }

        String serverIP = args[0];
        String serverPort = args[1];
        int numberOfClients = Integer.parseInt(args[2]);
        List<BenchmarkWorker> workers = new ArrayList<>();

        // Initialize workers
        for (int i = 0; i < numberOfClients; i++) {
            workers.add(new BenchmarkWorker(serverIP, serverPort, args[i + 3]));
        }

        long startTime = System.currentTimeMillis();

        List<Thread> threads = new ArrayList<>();
        for (BenchmarkWorker worker : workers) {
            Thread thread = new Thread(worker);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        double totalExecutionTime = (endTime - startTime) / 1000.0;

        // Calculate total bytes read
        long totalBytesRead = 0;
        for (BenchmarkWorker worker : workers) {
            totalBytesRead += worker.getTotalBytesRead();
        }

        System.out.println("Total indexing in " + totalExecutionTime + " seconds");
        System.out.println("Total bytes indexed: " + totalBytesRead + " bytes");

        workers.get(0).search();

        // Disconnect clients properly
        for (BenchmarkWorker worker : workers) {
            worker.disconnect();
        }
    }
}
