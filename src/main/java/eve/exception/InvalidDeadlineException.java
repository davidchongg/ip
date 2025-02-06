package eve.exception;

public class InvalidDeadlineException extends EveException {
    public InvalidDeadlineException() {
        super("Let me know the deadline using keyword /by");
    }
}
