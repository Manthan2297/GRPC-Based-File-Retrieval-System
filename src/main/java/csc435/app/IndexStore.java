package csc435.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Data structure that stores a document number and the number of times a word/term appears in the document
class DocFreqPair {
    public long documentNumber;
    public long wordFrequency;

    public DocFreqPair(long documentNumber, long wordFrequency) {
        this.documentNumber = documentNumber;
        this.wordFrequency = wordFrequency;
    }
}

public class IndexStore {
    // Keeps track of document numbers
    private HashMap<String, Long> documentMap = new HashMap<>();
    private long documentCounter = 0;

    // Keeps track of word frequencies in documents
    private HashMap<String, List<DocFreqPair>> termInvertedIndex = new HashMap<>();

    // Stores which client owns each document
    private HashMap<String, Long> documentClientMap = new HashMap<>();

    // Locks for synchronization
    private final Object documentLock = new Object();
    private final Object indexLock = new Object();

    public IndexStore() {}

    public long putDocument(String documentPath) {
        long documentNumber;
        synchronized (documentLock) {
            documentCounter++;
            documentMap.put(documentPath, documentCounter);
            documentNumber = documentCounter;
        }
        return documentNumber;
    }

    public String getDocument(long documentNumber) {
        for (String key : documentMap.keySet()) {
            if (documentMap.get(key) == documentNumber) {
                return key;
            }
        }
        return "";
    }

    public void updateIndex(long documentNumber, HashMap<String, Long> wordFrequencies) {
        synchronized (indexLock) {
            for (String word : wordFrequencies.keySet()) {
                long frequency = wordFrequencies.get(word);
                termInvertedIndex.computeIfAbsent(word, k -> new ArrayList<>())
                        .add(new DocFreqPair(documentNumber, frequency));
            }
        }
    }

    public ArrayList<DocFreqPair> lookupIndex(String term) {
        return new ArrayList<>(termInvertedIndex.getOrDefault(term, new ArrayList<>()));
    }


    public void associateDocumentWithClient(String documentPath, long clientId) {
        synchronized (documentLock) {
            documentClientMap.put(documentPath, clientId);
        }
    }


    public String getDocumentOwner(String documentPath) {
        synchronized (documentLock) {
            return documentClientMap.containsKey(documentPath) ? String.valueOf(documentClientMap.get(documentPath)) : "Unknown";
        }
    }
}
