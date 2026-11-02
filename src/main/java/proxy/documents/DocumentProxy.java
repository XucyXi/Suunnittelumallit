package proxy.documents;

public class DocumentProxy implements Document {
    private final RealDocument document;

    protected DocumentProxy(RealDocument document) {
        this.document = document;
    }

    @Override
    public String getId() { return document.getId(); }

    @Override
    public String getCreationDate() { return document.getCreationDate(); }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        AccessControlService acs = AccessControlService.getInstance();

        if (acs.isAllowed(document.getId(), user.getUsername())) {
            return document.getContent(user); // Forward to the real document
        } else {
            throw new AccessDeniedException("Access Denied: User '" + user.getUsername() + "' does not have permission to view document '" + document.getId() + "'.");
        }
    }
}