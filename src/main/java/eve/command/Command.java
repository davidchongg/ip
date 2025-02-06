package eve.command;

import eve.task.Task;
import eve.ui.Ui;
import eve.util.Storage;
import eve.exception.EveException;

import java.util.ArrayList;

/**
 * Represents a command to be executed.
 */
public interface Command {
    public void execute(ArrayList<Task> taskList, Ui ui, Storage storage)
            throws EveException;

    /**
     * Returns whether it is a command to exit the program.
     *
     * @return If command to exit the program.
     */
    public boolean isExit();
}