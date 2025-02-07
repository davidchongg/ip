package eve.command;

import eve.task.Task;
import eve.ui.Ui;
import eve.util.Storage;
import eve.exception.EveException;
import eve.exception.InvalidTaskNumException;

import java.util.ArrayList;

public class UnmarkCommand implements Command {
    private final int num;

    public UnmarkCommand(String description) {
        this.num = Integer.parseInt(description);
    }

    public void execute(ArrayList<Task> taskList, Ui ui, Storage storage) throws EveException {
        try {
            taskList.get(num - 1).markAsNotDone();
            ui.displayMessage("OK, I've marked this task as not done yet:\n\t"
                    + taskList.get(num - 1).toString());
            storage.writeToFile(taskList);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidTaskNumException();
        }
    }

    public boolean isExit() {
        return false;
    }
}
