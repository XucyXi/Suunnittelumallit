package chainofresponsibility.feedback;

public class ContactRequestHandler extends FeedbackHandler {
    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("[Customer Service] Handling contact request from " + message.getSenderEmail());
            System.out.println("  -> Action: Forwarding '" + message.getContent() + "' to the appropriate agent.");
        } else if (nextHandler != null) {
            nextHandler.handleMessage(message);
        }
    }
}