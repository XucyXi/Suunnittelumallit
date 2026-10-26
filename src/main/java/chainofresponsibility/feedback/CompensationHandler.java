package chainofresponsibility.feedback;

public class CompensationHandler extends FeedbackHandler {
    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("[Compensation Dept] Reviewing claim from " + message.getSenderEmail());
            System.out.println("  -> Action: Claim for '" + message.getContent() + "' has been approved and processed.");
        } else if (nextHandler != null) {
            nextHandler.handleMessage(message); // Pass to the next handler
        }
    }
}