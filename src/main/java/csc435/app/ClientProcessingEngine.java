package csc435.app;

import csc435.app.FileRetrievalEngineGrpc.FileRetrievalEngineBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.File;
import java.util.*;

class IndexResult {
    public double executionTime;
    public long totalBytesRead;

    public IndexResult(double executionTime, long totalBytesRead) {
        this.executionTime = executionTime;
        this.totalBytesRead = totalBytesRead;
    }
}

class DocPathFreqPair {
    public String documentPath;
    public long wordFrequency;

    public DocPathFreqPair(String documentPath, long wordFrequency) {
        this.documentPath = documentPath;
        this.wordFrequency = wordFrequency;
    }
}

class SearchResult {
    public double executionTime;
    public ArrayList<DocPathFreqPair> documentFrequencies;

    public SearchResult(double executionTime, ArrayList<DocPathFreqPair> documentFrequencies) {
        this.executionTime = executionTime;
        this.documentFrequencies = documentFrequencies;
    }
}

public class ClientProcessingEngine {
    private ManagedChannel channel;
    private FileRetrievalEngineBlockingStub stub;
    private long clientId = -1;

    public ClientProcessingEngine() {}

    public void connect(String serverIP, String serverPort) {
        if (serverIP == null || serverPort == null || serverIP.isEmpty() || serverPort.isEmpty()) {
            System.err.println("ERROR: Missing IP or Port. Usage: connect <serverIP> <serverPort>");
            return;
        }

        try {
            int port = Integer.parseInt(serverPort);
            channel = ManagedChannelBuilder.forAddress(serverIP, port)
                    .usePlaintext()
                    .build();
            stub = FileRetrievalEngineGrpc.newBlockingStub(channel);
            clientId = (long) stub.register(com.google.protobuf.Empty.getDefaultInstance()).getClientId();
            System.out.println("Connection successful! Assigned Client ID: " + clientId);
        } catch (NumberFormatException e) {
            System.err.println("ERROR: Invalid port number. Port must be an integer.");
        } catch (Exception e) {
            System.err.println("ERROR: Failed to connect to server at " + serverIP + ":" + serverPort);
        }
    }

    // ? Returns client ID for identification
    public long getInfo() {
        return clientId;
    }

    public IndexResult indexFiles(String folderPath) {
        if (folderPath == null || folderPath.isEmpty()) {
            System.err.println("ERROR: Missing index path. Usage: index <folderPath>");
            return new IndexResult(0.0, 0);
        }

        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println("ERROR: Invalid path. Directory does not exist: " + folderPath);
            return new IndexResult(0.0, 0);
        }

        System.out.println("Client " + clientId + " indexing files from: " + folderPath);
        IndexResult result = new IndexResult(0.0, 0);
        long totalBytes = 0;
        long startTime = System.currentTimeMillis();

        List<File> allFiles = getAllFiles(folder);

        for (File file : allFiles) {
            if (file.isFile()) {
                HashMap<String, Long> wordFrequencies = extractWords(file);
                totalBytes += file.length();
                IndexReq request = IndexReq.newBuilder()
                        .setClientId((int) clientId)
                        .setDocumentPath(file.getAbsolutePath())
                        .putAllWordFrequencies(wordFrequencies)
                        .build();
                stub.computeIndex(request);
            }
        }

        long endTime = System.currentTimeMillis();
        result.executionTime = (endTime - startTime) / 1000.0;
        result.totalBytesRead = totalBytes;
        System.out.println("Client " + clientId + " completed indexing " + totalBytes + " bytes in " + result.executionTime + " seconds");

        return result;
    }

    public SearchResult searchFiles(ArrayList<String> terms) {
        if (terms == null || terms.isEmpty()) {
            System.err.println("ERROR: No search terms provided. Usage: search <term1> [<term2> <term3>]");
            return new SearchResult(0.0, new ArrayList<>());
        }

        if (terms.size() > 3) {
            System.err.println("ERROR: Maximum of 3 search terms allowed.");
            return new SearchResult(0.0, new ArrayList<>());
        }

        SearchResult result = new SearchResult(0.0, new ArrayList<>());

        long startTime = System.currentTimeMillis();
        SearchReq request = SearchReq.newBuilder().addAllTerms(terms).build();
        SearchRep response = stub.computeSearch(request);
        long endTime = System.currentTimeMillis();

        result.executionTime = (endTime - startTime) / 1000.0;

        response.getSearchResultsMap().forEach((docPath, freq) ->
                result.documentFrequencies.add(new DocPathFreqPair(docPath, freq))
        );

        result.documentFrequencies.sort((a, b) -> Long.compare(b.wordFrequency, a.wordFrequency));

        System.out.println("> search " + String.join(" ", terms));
        System.out.println("Search completed in " + result.executionTime + " seconds");
        System.out.println("Search results (top " + Math.min(10, result.documentFrequencies.size()) + " out of " + result.documentFrequencies.size() + "):");

        result.documentFrequencies.stream()
                .limit(10)
                .forEach(doc -> System.out.println("* " + doc.documentPath + ":" + doc.wordFrequency));

        return result;
    }

    private List<File> getAllFiles(File rootDir) {
        List<File> fileList = new ArrayList<>();
        if (rootDir.exists() && rootDir.isDirectory()) {
            File[] files = rootDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        fileList.addAll(getAllFiles(file));
                    } else {
                        fileList.add(file);
                    }
                }
            }
        }
        return fileList;
    }

    private HashMap<String, Long> extractWords(File file) {
        HashMap<String, Long> frequencies = new HashMap<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[^a-zA-Z0-9_-]", "").toLowerCase();
                if (word.length() > 3) {
                    frequencies.put(word, frequencies.getOrDefault(word, 0L) + 1);
                }
            }
        } catch (Exception e) {
            System.err.println("ERROR: Failed to process file: " + file.getAbsolutePath());
        }
        return frequencies;
    }
}
