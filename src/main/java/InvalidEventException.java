public class InvalidEventException extends EveException {
    public InvalidEventException() {
        super("Let me know the time of the event using keywords /from and /to");
    }
}
