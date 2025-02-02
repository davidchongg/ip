public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toDataString() {
        return "T | " + super.getStatusIcon() + " | " + this.description;
    }

    public String toString() {
        return "[T]" + super.toString();
    }
}
