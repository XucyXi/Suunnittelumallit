package chainofresponsibility.feedback;

public abstract class FeedbackHandler {
    protected FeedbackHandler nextHandler;

    // Sets the next link in the chain and returns it to allow easy chaining
    public FeedbackHandler setNext(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public abstract void handleMessage(Message message);
}