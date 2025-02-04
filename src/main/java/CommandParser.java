public class CommandParser {
    public static Command parseString(String fullCommand) throws EveException {
        String[] tokens = fullCommand.split(" ", 2);
        String command = tokens[0];
        switch (command) {
        case "bye":
            return new ByeCommand();
        case "list":
            return new ListCommand();
        case "clear":
            return new ClearCommand();
        }
        switch (command) {
        case "mark":
        case "unmark":
        case "todo":
        case "deadline":
        case "event":
        case "delete":
            try {
                String description = tokens[1];
                switch (command) {
                case "mark":
                    try {
                        return new MarkCommand(description);
                    } catch (NumberFormatException e) {
                        throw new NotIntException();
                    }
                case "unmark":
                    try {
                        return new UnmarkCommand(tokens[1]);
                    } catch (NumberFormatException e) {
                        throw new NotIntException();
                    }
                case "todo":
                case "deadline":
                case "event":
                    return new AddCommand(command, tokens[1]);
                case "delete":
                    try {
                        return new DeleteCommand(tokens[1]);
                    } catch (NumberFormatException e) {
                        throw new NotIntException();
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IncompleteCommandException();
            }
        default:
            throw new InvalidCommandException();
        }
    }
}
