package eve.command;

import eve.task.Task;
import eve.ui.Ui;
import eve.util.Storage;
import eve.util.TaskList;
import eve.exception.EveException;
import eve.exception.InvalidTaskNumException;


public class DeleteCommand implements Command {
    private final int num;

    public DeleteCommand(String description) {
        this.num = Integer.parseInt(description);
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws EveException {
        try {
            Task task = taskList.remove(num - 1);
            ui.output("Noted. I've removed this task:\n\t" + task
                    + "\nNow you have " + Integer.toString(taskList.size())
                    + " tasks in the list.");
            storage.writeToFile(taskList);
        } catch (IndexOutOfBoundsException ex) {
            throw new InvalidTaskNumException();
        }

    }

    public boolean isExit() {
        return false;
    }
}
