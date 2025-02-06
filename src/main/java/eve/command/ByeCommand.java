package eve.command;

import eve.task.Task;
import eve.ui.Ui;
import eve.util.Storage;

import java.util.ArrayList;

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
    public void execute(ArrayList<Task> taskList, Ui ui, Storage storage) {
        ui.output( "Bye. Hope to see you again soon!");
    }

    public boolean isExit() {
        return true;
    }
}
