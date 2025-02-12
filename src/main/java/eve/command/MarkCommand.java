package eve.command;

import eve.exception.EveException;
import eve.exception.InvalidTaskNumException;
import eve.ui.Ui;
import eve.util.Storage;
import eve.util.TaskList;

/**
 * Represents a command to mark a task as done in the taskList.
 */
public class MarkCommand implements Command {
    private final int num;

    public MarkCommand(String description) {
        this.num = Integer.parseInt(description);
    }

    /**
     * Marks the task at index num - 1 in the taskList as done.
     *
     * @param taskList ArrayList containing all the tasks.
     * @param ui User interface for users.
     * @param storage Utils for storing information to data file.
     * @throws EveException Custom exceptions with custom error messages.
     */
    public void execute(TaskList taskList, Ui ui, Storage storage) throws EveException {
        try {
            taskList.get(num - 1).markAsDone();
            ui.displayMessage("Nice! I've marked this task as done:\n\t"
                    + taskList.get(num - 1).toString());
            storage.writeToFile(taskList);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidTaskNumException();
        }
    }

    public boolean isExit() {
        return false;
    }
}
