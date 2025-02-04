import java.util.ArrayList;

public interface Command {
    public void execute(ArrayList<Task> taskList, Ui ui, Storage storage)
            throws EveException;

    public boolean isExit();
}