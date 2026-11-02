package proxy.documents;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;

    // Stores permissions as a composite string: "username:documentId"
    private final Set<String> allowedAccess = new HashSet<>();

    private AccessControlService() {}

    public static synchronized AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    // Grant a specific user access to a specific document
    public void grantAccess(String documentId, String username) {
        allowedAccess.add(username + ":" + documentId);
    }

    // Check if the user has access
    public boolean isAllowed(String documentId, String username) {
        return allowedAccess.contains(username + ":" + documentId);
    }
}