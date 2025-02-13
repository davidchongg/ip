package eve;

import eve.command.Command;
import eve.command.CommandParser;
import eve.exception.EveException;
import eve.ui.Ui;
import eve.util.Storage;
import eve.util.TaskList;

/**
 * Main class for Eve chatbot
 */
public class Eve {
    private TaskList taskList;
    private boolean isExit = false;
    private final Ui ui;

    public Eve() {
        ui = new Ui();
    }

    /**
     * Executes the main control loop of the program.
     */
    public void run() {
        ui.showWelcomeMessage();
        Storage storage = new Storage("data/", "eve.txt");
        try {
            taskList = storage.loadTasks();
        } catch (EveException ex) {
            ui.displayError(ex.getMessage());
        }
        while (!isExit) {
            String fullCommand = ui.nextCommand();
            try {
                Command command = CommandParser.parseString(fullCommand);
                command.execute(taskList, ui, storage);
                isExit = command.isExit();
            } catch (EveException ex) {
                ui.displayError(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Eve().run();
    }
}
