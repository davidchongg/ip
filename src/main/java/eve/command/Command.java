package eve.command;

import eve.exception.EveException;
import eve.ui.Ui;
import eve.util.Storage;
import eve.util.TaskList;

/**
 * Represents a command to be executed.
 */
public interface Command {
    public void execute(TaskList taskList, Ui ui, Storage storage)
            throws EveException;

    /**
     * Returns whether it is a command to exit the program.
     *
     * @return If command to exit the program.
     */
    public boolean isExit();
}
