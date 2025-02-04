import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class AddCommand implements Command {
    private final String command;
    private final String description;

    public AddCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public void execute(ArrayList<Task> taskList, Ui ui, Storage storage) throws EveException {
        switch (command) {
        case "todo":
            taskList.add(new ToDo(description));
            break;
        case "deadline":
            try {
                String desc = description.split("/by")[0].trim();
                LocalDateTime by = DateTime.parseString(description.split("/by")[1].trim());
                taskList.add(new Deadline(desc, by));
                break;
            } catch (DateTimeParseException ex) {
                throw new InvalidDateTimeException();
            } catch (Exception ex) {
                throw new InvalidDeadlineException();
            }
        case "event":
            try {
                String desc = description.split("/from")[0].trim();
                LocalDateTime from = DateTime.parseString(description.split("/from")[1].split("/to")[0].trim());
                LocalDateTime to = DateTime.parseString(description.split("/from")[1].split("/to")[1].trim());
                taskList.add(new Event(desc, from, to));
                break;
            } catch (DateTimeParseException ex) {
                throw new InvalidDateTimeException();
            } catch (Exception ex) {
                throw new InvalidEventException();
            }
        }
        ui.output("Got it. I've added this task:\n\t" + taskList.get(taskList.size() - 1).toString()
                + "\nNow you have " + Integer.toString(taskList.size()) + " tasks in the list.");

        storage.writeToFile(taskList);
    }

    public boolean isExit() {
        return false;
    }
}
