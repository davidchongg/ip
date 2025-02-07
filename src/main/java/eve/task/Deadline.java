package eve.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private final LocalDateTime by;

    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toDataString() {
        return "D | " + super.getStatusIcon() + " | " + this.description + " | " + this.by;
    }

    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.by.format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm")) + ")";
    }
}
