package eve.command;

import eve.ui.Ui;
import eve.util.Storage;
import eve.util.TaskList;


public class ByeCommand implements Command {
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.output( "Bye. Hope to see you again soon!");
    }

    public boolean isExit() {
        return true;
    }
}
