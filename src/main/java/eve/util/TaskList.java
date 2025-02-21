package eve.util;

import java.util.ArrayList;
import java.util.Iterator;

import eve.task.Task;

/**
 * Utility class to represent a list of tasks.
 */
public class TaskList implements Iterable<Task> {
    private ArrayList<Task> tasks;

    /**
     * Initializes an empty task list.
     */
    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    /**
     * Adds the task specified to the task list.
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Returns the number of tasks in the task list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Returns the task at index specified.
     */
    public Task get(int index) {
        assert index >= 0 : "Index should not be negative";
        return tasks.get(index);
    }

    /**
     * Clears all task in the task list.
     */
    public void clear() {
        tasks.clear();
    }

    /**
     * Removes task at index specified.
     * @return Task removed.
     */
    public Task remove(int index) {
        assert index >= 0 : "Index should not be negative";
        return tasks.remove(index);
    }

    /**
     * Returns a string of all tasks containing the specified description string.
     */
    public String getMatchingTasks(String description) {
        StringBuilder message = new StringBuilder();
        int num = 1;
        for (Task task: tasks) {
            if (task.containString(description)) {
                message.append("\t").append(Integer.toString(num)).append(".")
                        .append(task.toString()).append("\n");
            }
            num++;
        }
        return message.toString().replaceFirst("\n$", "");
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        int num = 1;
        for (Task task: tasks) {
            message.append("\t").append(Integer.toString(num)).append(".")
                    .append(task.toString()).append("\n");
            num++;
        }
        return message.toString().replaceFirst("\n$", "");
    }

    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator(); // Return the iterator of the underlying ArrayList
    }
}
