package eve.command;

import eve.ui.Ui;
import eve.util.Storage;
import eve.util.TaskList;

/**
 * Represent a command to exit the program.
 */
public class CloseWindowCommand implements Command {
    /**
     * Does nothing as window will be close.
     *
     * @param taskList ArrayList containing all the tasks.
     * @param ui User interface for users.
     * @param storage Utils for storing information to data file.
     */
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        return "";
    }

    public boolean isExit() {
        return true;
    }

    public boolean isCloseWindow() {
        return true;
    }
}
