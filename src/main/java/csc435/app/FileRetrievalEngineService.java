package csc435.app;

import io.grpc.stub.StreamObserver;
import java.util.HashMap;
import java.util.Map;

public class FileRetrievalEngineService extends FileRetrievalEngineGrpc.FileRetrievalEngineImplBase {
    private IndexStore store;
    private long clientIdCounter = 0; // Ensures unique client IDs

    public FileRetrievalEngineService(IndexStore store) {
        this.store = store;
        this.clientIdCounter = 0; // Ensures IDs start fresh on each server start
    }

    @Override
    public void register(com.google.protobuf.Empty request, StreamObserver<RegisterRep> responseObserver) {
        responseObserver.onNext(doRegister());
        responseObserver.onCompleted();
    }

    private synchronized RegisterRep doRegister() { // Ensures thread-safe unique ID assignment
        clientIdCounter++;
        System.out.println("Assigning Client ID: " + clientIdCounter);
        return RegisterRep.newBuilder().setClientId((int) clientIdCounter).build();
    }

    @Override
    public void computeIndex(IndexReq request, StreamObserver<IndexRep> responseObserver) {
        long clientId = request.getClientId();
        store.associateDocumentWithClient(request.getDocumentPath(), clientId);
        responseObserver.onNext(doIndex(request));
        responseObserver.onCompleted();
    }

    @Override
    public void computeSearch(SearchReq request, StreamObserver<SearchRep> responseObserver) {
        responseObserver.onNext(doSearch(request));
        responseObserver.onCompleted();
    }

    private IndexRep doIndex(IndexReq request) {
        long docId = store.putDocument(request.getDocumentPath());
        store.updateIndex(docId, new HashMap<>(request.getWordFrequenciesMap()));
        return IndexRep.newBuilder().build();
    }

    private SearchRep doSearch(SearchReq request) {
        SearchRep.Builder responseBuilder = SearchRep.newBuilder();
        Map<String, Long> combinedResults = new HashMap<>(); // Aggregates results across terms

        for (String term : request.getTermsList()) {
            store.lookupIndex(term).forEach(doc -> {
                String documentPath = store.getDocument(doc.documentNumber);
                String clientInfo = store.getDocumentOwner(documentPath);
                String key = "Client " + clientInfo + ":" + documentPath;

                combinedResults.put(key, combinedResults.getOrDefault(key, 0L) + doc.wordFrequency);
            });
        }

        combinedResults.forEach(responseBuilder::putSearchResults);
        return responseBuilder.build();
    }
}
