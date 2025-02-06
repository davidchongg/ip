package eve.exception;

public class InvalidTaskNumException extends EveException {
    public InvalidTaskNumException() {
        super("The task number you specified does not exist...");
    }
}
