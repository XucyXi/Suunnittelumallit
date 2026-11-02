package proxy.documents;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService acs = AccessControlService.getInstance();

        // Create Users
        User alice = new User("alice_admin");
        User bob = new User("bob_intern");

        // Populate the Library
        library.createUnprotectedDocument("DOC-001", "2026-10-26", "Welcome to the company! Here is the lunch menu.");
        library.createProtectedDocument("DOC-002", "2026-10-26", "TOP SECRET: Project Quantix architectural plans.");

        // Set Permissions
        acs.grantAccess("DOC-002", "alice_admin"); // Alice gets access to the secret doc. Bob doesn't.

        // Test Scenarios
        System.out.println("--- TESTING UNPROTECTED DOCUMENT ---");
        Document doc1 = library.getDocument("DOC-001");
        System.out.println("Document Date: " + doc1.getCreationDate());
        try {
            System.out.println("Bob tries to read DOC-001: " + doc1.getContent(bob));
            System.out.println("Alice tries to read DOC-001: " + doc1.getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- TESTING PROTECTED DOCUMENT ---");
        Document doc2 = library.getDocument("DOC-002");
        System.out.println("Document Date: " + doc2.getCreationDate()); // Should succeed for anyone (metadata is public)

        try {
            System.out.println("\nAlice tries to read DOC-002...");
            System.out.println("Result: " + doc2.getContent(alice)); // Should succeed
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nBob tries to read DOC-002...");
            System.out.println("Result: " + doc2.getContent(bob)); // Should fail and jump to catch block
        } catch (AccessDeniedException e) {
            System.err.println(e.getMessage());
        }
    }
}