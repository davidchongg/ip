public class Event extends Task {
    String from;
    String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toDataString() {
        return "T | " + super.getStatusIcon() + " | " + this.description + " | " + this.from + " | " + this.to;
    }

    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.from + " to: " + this.to + ")";
    }

}
