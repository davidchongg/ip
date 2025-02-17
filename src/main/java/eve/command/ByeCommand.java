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
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        return "Bye. Hope to see you again soon!\nType \"close\" to close the program window.";
    }

    public boolean isExit() {
        return true;
    }

    public boolean isCloseWindow() {
        return false;
    }
}
