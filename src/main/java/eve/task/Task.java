package eve.task;

public class Task {
    protected String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void markAsDone() {
        isDone = true;
    };

    public void markAsNotDone() {
        isDone = false;
    };

    public String toDataString() {
        return description;
    }

    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }
}
