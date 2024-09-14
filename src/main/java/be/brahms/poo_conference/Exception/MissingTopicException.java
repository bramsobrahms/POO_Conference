package be.brahms.poo_conference.Exception;

public class MissingTopicException extends RuntimeException {
    public MissingTopicException() {
        super();
    }

    public MissingTopicException(String message) {
        super(message);
    }
}
