package proxy.documents;

public class RealDocument implements Document {
    private final String id;
    private final String creationDate;
    private final String content;

    protected RealDocument(String id, String creationDate, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getCreationDate() { return creationDate; }

    @Override
    public String getContent(User user) {
        // Unprotected documents just return their content immediately
        return content;
    }
}