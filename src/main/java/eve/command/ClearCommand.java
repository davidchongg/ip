package eve.command;

import eve.ui.Ui;
import eve.util.Storage;
import eve.util.TaskList;
import eve.exception.EveException;


public class ClearCommand implements Command {
    public void execute(TaskList taskList, Ui ui, Storage storage) throws EveException {
        taskList.clear();
        ui.output("All the tasks in your list are cleared.");
        storage.writeToFile(taskList);
    }

    public boolean isExit() {
        return false;
    }
}
