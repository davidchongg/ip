package eve.command;

import eve.task.Task;
import eve.ui.Ui;
import eve.util.Storage;
import eve.exception.EveException;

import java.util.ArrayList;

public interface Command {
    public void execute(ArrayList<Task> taskList, Ui ui, Storage storage)
            throws EveException;

    public boolean isExit();
}