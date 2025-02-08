package eve.command;

import eve.ui.Ui;
import eve.util.Storage;
import eve.util.TaskList;

public class ListCommand implements Command {
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        String message = "Here are the tasks in your list:\n";
        ui.output(message + taskList.toString());
    }

    public boolean isExit() {
       return false;
    }
}
