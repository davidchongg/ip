public class Deadline extends Task{
    private String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toDataString() {
        return "T | " + super.getStatusIcon() + " | " + this.description + " | " + this.by;
    }

    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.by + ")";
    }
}
