package proxy.documents;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Document> documents = new HashMap<>();

    // Factory method for creating an unprotected document
    public void createUnprotectedDocument(String id, String creationDate, String content) {
        Document doc = new RealDocument(id, creationDate, content);
        documents.put(id, doc);
    }

    // Factory method for creating a protected document (wrapped in a Proxy)
    public void createProtectedDocument(String id, String creationDate, String content) {
        RealDocument realDoc = new RealDocument(id, creationDate, content);
        DocumentProxy proxy = new DocumentProxy(realDoc);
        documents.put(id, proxy);
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }
}