public class IncompleteCommandException extends EveException {
    public IncompleteCommandException() {
        super("Oh no... You are missing important information in your command.");
    }
}
