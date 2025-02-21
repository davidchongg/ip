package eve.command;

import eve.ui.Ui;
import eve.util.Storage;
import eve.util.TaskList;

/**
 * Represents a command to display all available commands to the user.
 */
public class HelpCommand implements Command {
    /**
     * Displays all the available commands to the user.
     *
     * @param taskList ArrayList containing all the tasks.
     * @param ui User interface for users.
     * @param storage Utils for storing information to data file.
     */
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        StringBuilder message = new StringBuilder();
        message.append("Looks like you need help! Here are all my available commands:\n")
                .append("\t1. todo <description>: Adds a todo task to the list.\n")
                .append("\t2. deadline <description> /by <dd/mm/yyyy hh:mm>: Adds a "
                        + "deadline to the list.\n")
                .append("\t3. event <description> /from <dd/mm/yyyy hh:mm> /to <dd/mm/yyyy hh:mm>"
                        + ": Adds a event to the list.\n")
                .append("\t4. delete <task number>: Deletes specified task from the list.\n")
                .append("\t5. find <description>: Finds task with matching description.\n")
                .append("\t6. list: Lists all tasks in the list.\n")
                .append("\t7. mark <task number>: Marks specified task as done.\n ")
                .append("\t8. unmark <task number>: Unmarks specified task to be not done.\n ")
                .append("\t9. bye: Exits the application\n");
        return message.toString();
    }

    public boolean isExit() {
        return false;
    }

    public boolean isCloseWindow() {
        return false;
    }
}
