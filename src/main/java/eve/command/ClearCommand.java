package eve.command;

import eve.task.Task;
import eve.ui.Ui;
import eve.util.Storage;
import eve.exception.EveException;

import java.util.ArrayList;

public class ClearCommand implements Command {
    public void execute(ArrayList<Task> taskList, Ui ui, Storage storage) throws EveException {
        taskList.clear();
        ui.output("All the tasks in your list are cleared.");
        storage.writeToFile(taskList);
    }

    public boolean isExit() {
        return false;
    }
}
