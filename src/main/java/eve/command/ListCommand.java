package eve.command;

import eve.ui.Ui;
import eve.util.Storage;
import eve.util.TaskList;

/**
 * Represents a command to list all the tasks in the taskList.
 */
public class ListCommand implements Command {
    /**
     * Lists all the tasks in the taskList.
     *
     * @param taskList ArrayList containing all the tasks.
     * @param ui User interface for users.
     * @param storage Utils for storing information to data file.
     */
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        String message = "Here are the tasks in your list:\n";
        ui.displayMessage(message + taskList.toString());
    }

    public boolean isExit() {
       return false;
    }
}
