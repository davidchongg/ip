package eve.command;

import eve.exception.EveException;
import eve.ui.Ui;
import eve.util.Storage;
import eve.util.TaskList;


/**
 * Represents a command to clear all the tasks in the taskList.
 */
public class ClearCommand implements Command {
    /**
     * Clears all the tasks in the taskList.
     *
     * @param taskList ArrayList containing all the tasks.
     * @param ui User interface for users.
     * @param storage Utils for storing information to data file.
     * @throws EveException Custom exceptions with custom error messages.
     */
    public void execute(TaskList taskList, Ui ui, Storage storage) throws EveException {
        taskList.clear();
        ui.displayMessage("All the tasks in your list are cleared.");
        storage.writeToFile(taskList);
    }

    public boolean isExit() {
        return false;
    }
}
