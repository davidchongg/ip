import java.util.ArrayList;

public class ByeCommand implements Command {
    public void execute(ArrayList<Task> taskList, Ui ui, Storage storage) {
        ui.output( "Bye. Hope to see you again soon!");
    }

    public boolean isExit() {
        return true;
    }
}
