package eve.task;

/**
 * Represents a generic task added by users.
 */
public class Task {
    protected String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the status icon of task. X for done and blank space for not done.
     */
    protected String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Marks this task as done.
     */
    public void markAsDone() {
        isDone = true;
    };

    /**
     * Marks this task as not done.
     */
    public void markAsNotDone() {
        isDone = false;
    };

    /**
     * Returns a string representing this task to be stored in the data file.
     */
    public String toDataString() {
        return description;
    }

    /**
     * Returns a string describing this task to be displayed on the user interface.
     * @return
     */
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }
}
