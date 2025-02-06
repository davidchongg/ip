package eve.exception;

public class DataFileWriteException extends EveException {
    public DataFileWriteException() {
        super("Something went wrong when trying to write data file");
    }
}
