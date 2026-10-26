package chainofresponsibility.feedback;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Instantiating the handlers
        FeedbackHandler compensation = new CompensationHandler();
        FeedbackHandler contact = new ContactRequestHandler();
        FeedbackHandler development = new DevelopmentHandler();
        FeedbackHandler general = new GeneralFeedbackHandler();

        // Chaining them together
        // Compensation -> Contact -> Development -> General
        compensation.setNext(contact).setNext(development).setNext(general);

        // Creating a batch of mixed feedback messages
        List<Message> inbox = new ArrayList<>();
        inbox.add(new Message(MessageType.GENERAL_FEEDBACK, "I love the new UI!", "user1@test.com"));
        inbox.add(new Message(MessageType.DEVELOPMENT_SUGGESTION, "Add a dark mode.", "dev_fan@test.com"));
        inbox.add(new Message(MessageType.COMPENSATION_CLAIM, "My game crashed and I lost my items.", "angry_gamer@test.com"));
        inbox.add(new Message(MessageType.CONTACT_REQUEST, "I can't access my account, please call me.", "locked_out@test.com"));

        // Feeding all messages into the FRONT of the chain
        System.out.println("--- Starting Feedback Processing ---");
        for (Message msg : inbox) {
            System.out.println("\nIncoming Message Type: " + msg.getType());

            // We only ever give the message to the first handler in the chain.
            // The chain itself should figure out where it needs to go.
            compensation.handleMessage(msg);
        }
    }
}