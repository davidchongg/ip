import java.util.ArrayList;

public class MarkCommand implements Command {
    private final int num;

    public MarkCommand(String description) {
        this.num = Integer.parseInt(description);
    }

    public void execute(ArrayList<Task> taskList, Ui ui, Storage storage) throws EveException {
        try {
            taskList.get(num - 1).markAsDone();
            ui.output("Nice! I've marked this task as done:\n\t"
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
