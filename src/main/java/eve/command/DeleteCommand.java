package eve.command;

import eve.task.Task;
import eve.ui.Ui;
import eve.util.Storage;
import eve.util.TaskList;
import eve.exception.EveException;
import eve.exception.InvalidTaskNumException;


/**
 * Represents a command for deleting a task from the taskList.
 */
public class DeleteCommand implements Command {
    private final int num;

    public DeleteCommand(String description) {
        this.num = Integer.parseInt(description);
    }

    /**
     * Deletes the task at index num - 1 from the taskList.
     *
     * @param taskList ArrayList containing all the tasks.
     * @param ui User interface for users.
     * @param storage Utils for storing information to data file.
     * @throws EveException Custom exceptions with custom error messages.
     */
    public void execute(TaskList taskList, Ui ui, Storage storage) throws EveException {
        try {
            Task task = taskList.remove(num - 1);
            ui.displayMessage("Noted. I've removed this task:\n\t" + task
                    + "\nNow you have " + Integer.toString(taskList.size())
                    + " tasks in the list.");
            storage.writeToFile(taskList);
        } catch (IndexOutOfBoundsException ex) {
            throw new InvalidTaskNumException();
        }

    }

    public boolean isExit() {
        return false;
    }
}
