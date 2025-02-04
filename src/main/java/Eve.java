import java.util.ArrayList;

public class Eve {
    private ArrayList<Task> taskList;
    private boolean isExit = false;
    private final Ui ui;

    public Eve() {
        ui = new Ui();
    }

    public void run() {
        ui.greet();
        Storage storage = new Storage("data/", "eve.txt");
        try {
            taskList = storage.load();
        } catch (EveException ex) {
            ui.showError(ex.getMessage());
        }
        while (!isExit) {
            String fullCommand = ui.nextCommand();
            try {
                Command command = CommandParser.parseString(fullCommand);
                command.execute(taskList, ui, storage);
                isExit = command.isExit();
            } catch (EveException ex) {
                ui.showError(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Eve().run();
    }
}
