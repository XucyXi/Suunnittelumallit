package chainofresponsibility.feedback;

public class DevelopmentHandler extends FeedbackHandler {
    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("[R&D Team] Logging development suggestion from " + message.getSenderEmail());
            System.out.println("  -> Action: Idea '" + message.getContent() + "' added to the Jira backlog.");
        } else if (nextHandler != null) {
            nextHandler.handleMessage(message);
        }
    }
}