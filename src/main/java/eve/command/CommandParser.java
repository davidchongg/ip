package eve.command;

import eve.exception.EveException;
import eve.exception.IncompleteCommandException;
import eve.exception.InvalidCommandException;
import eve.exception.NotIntException;

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
        case "find":
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
                        return new UnmarkCommand(description);
                    } catch (NumberFormatException e) {
                        throw new NotIntException();
                    }
                case "todo":
                case "deadline":
                case "event":
                    return new AddCommand(command, description);
                case "delete":
                    try {
                        return new DeleteCommand(description);
                    } catch (NumberFormatException e) {
                        throw new NotIntException();
                    }
                case "find":
                    return new FindCommand(description);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IncompleteCommandException();
            }
        default:
            throw new InvalidCommandException();
        }
    }
}
