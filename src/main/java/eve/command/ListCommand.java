package eve.command;

import eve.task.Task;
import eve.ui.Ui;
import eve.util.Storage;

import java.util.ArrayList;

public class ListCommand implements Command {
    public void execute(ArrayList<Task> taskList, Ui ui, Storage storage) {
        StringBuilder message = new StringBuilder();
        message.append("Here are the tasks in your list:\n");
        int num = 1;
        for (Task task: taskList) {
            message.append("\t").append(Integer.toString(num)).append(".")
                    .append(task.toString()).append("\n");
            num++;
        }
        ui.output(message.toString().trim());
    }

    public boolean isExit() {
       return false;
    }
}
