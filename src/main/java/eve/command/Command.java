package eve.command;

import eve.ui.Ui;
import eve.util.Storage;
import eve.util.TaskList;
import eve.exception.EveException;

public interface Command {
    public void execute(TaskList taskList, Ui ui, Storage storage)
            throws EveException;

    public boolean isExit();
}