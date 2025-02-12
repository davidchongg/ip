package eve.command;

import eve.ui.Ui;
import eve.util.Storage;
import eve.util.TaskList;


/**
 * Represent a command to exit the program.
 */
public class ByeCommand implements Command {
    /**
     * Displays the goodbye message to the ui.
     *
     * @param taskList ArrayList containing all the tasks.
     * @param ui User interface for users.
     * @param storage Utils for storing information to data file.
     */
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.displayMessage("Bye. Hope to see you again soon!");
    }

    public boolean isExit() {
        return true;
    }
}
