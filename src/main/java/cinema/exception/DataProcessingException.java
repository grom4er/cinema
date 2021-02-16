package cinema.exception;

public class DataProcessingException extends RuntimeException {
    public DataProcessingException(String message, Throwable e) {
        super(message, e);
    }

    public DataProcessingException(String msg) {
        super(msg);
    }
}
