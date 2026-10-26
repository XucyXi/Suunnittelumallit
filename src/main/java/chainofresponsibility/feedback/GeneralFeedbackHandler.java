package chainofresponsibility.feedback;

public class GeneralFeedbackHandler extends FeedbackHandler {
    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("[PR Dept] Analyzing general feedback from " + message.getSenderEmail());
            System.out.println("  -> Action: Sent automated thank-you email for: '" + message.getContent() + "'.");
        } else if (nextHandler != null) {
            nextHandler.handleMessage(message);
        }
    }
}