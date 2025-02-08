package eve.command;

import eve.ui.Ui;
import eve.util.Storage;
import eve.util.DateTimeUtil;
import eve.util.TaskList;
import eve.exception.EveException;
import eve.exception.InvalidDateTimeException;
import eve.exception.InvalidDeadlineException;
import eve.exception.InvalidEventException;
import eve.task.ToDo;
import eve.task.Deadline;
import eve.task.Event;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class AddCommand implements Command {
    private final String command;
    private final String description;

    public AddCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws EveException {
        switch (command) {
        case "todo":
            taskList.add(new ToDo(description));
            break;
        case "deadline":
            try {
                String desc = description.split("/by")[0].trim();
                LocalDateTime by = DateTimeUtil.parseString(description.split("/by")[1].trim());
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
                LocalDateTime from = DateTimeUtil.parseString(description.split("/from")[1].split("/to")[0].trim());
                LocalDateTime to = DateTimeUtil.parseString(description.split("/from")[1].split("/to")[1].trim());
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
