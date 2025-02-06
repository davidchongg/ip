package eve.command;

import eve.exception.InvalidDateTimeException;
import eve.exception.InvalidEventException;
import eve.task.Task;
import eve.ui.Ui;
import eve.util.Storage;

import java.util.ArrayList;
import eve.exception.InvalidDeadlineException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddCommandTest {
    @Test
    public void execute_deadlineMissingDateTime_exceptionThrown() {
        assertThrows(
                InvalidDeadlineException.class,
                () -> new AddCommand("deadline", "study").execute(
                        new ArrayList<Task>(), new Ui(), new Storage("", ""))
        );
    }

    @Test
    public void execute_deadlineInvalidDateTime_exceptionThrown() {
        assertThrows(
                InvalidDateTimeException.class,
                () -> new AddCommand("deadline", "study /by tonight").execute(
                        new ArrayList<Task>(), new Ui(), new Storage("", ""))
        );
    }

    @Test
    public void execute_eventMissingDateTime_exceptionThrown() {
        assertThrows(
                InvalidEventException.class,
                () -> new AddCommand("event", "study /from 23/01/2025").execute(
                        new ArrayList<Task>(), new Ui(), new Storage("", ""))
        );
    }
}
