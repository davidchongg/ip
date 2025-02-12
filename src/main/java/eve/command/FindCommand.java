package eve.command;

import eve.ui.Ui;
import eve.util.Storage;
import eve.util.TaskList;

public class FindCommand implements Command {
    private final String description;

    public FindCommand(String description) {
        this.description = description;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.displayMessage(taskList.getMatchingTasks(this.description));
    }

    public boolean isExit() {
        return false;
    }
}
