import java.util.ArrayList;

public class UnmarkCommand implements Command {
    private final int num;

    public UnmarkCommand(String description) {
        this.num = Integer.parseInt(description);
    }

    public void execute(ArrayList<Task> taskList, Ui ui, Storage storage) throws EveException {
        try {
            taskList.get(num - 1).markAsNotDone();
            ui.output("OK, I've marked this task as not done yet:\n\t"
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
