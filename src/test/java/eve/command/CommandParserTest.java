package eve.command;

import eve.exception.NotIntException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandParserTest {
    @Test
    public void parseString_markNotIntInput_exceptionThrown() {
        assertThrows(
                NotIntException.class,
                () -> CommandParser.parseString("mark that")
        );
    }
}
