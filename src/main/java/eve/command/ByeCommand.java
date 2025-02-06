package eve.command;

import eve.task.Task;
import eve.ui.Ui;
import eve.util.Storage;

import java.util.ArrayList;

public class ByeCommand implements Command {
    public void execute(ArrayList<Task> taskList, Ui ui, Storage storage) {
        ui.output( "Bye. Hope to see you again soon!");
    }

    public boolean isExit() {
        return true;
    }
}
