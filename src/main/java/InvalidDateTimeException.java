public class InvalidDateTimeException extends EveException {
    public InvalidDateTimeException() {
        super("You should let me know the date and time using the format dd/mm/yyyy hh:mm");
    }
}
