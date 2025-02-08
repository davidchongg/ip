package eve.util;

import eve.task.Task;

import java.util.ArrayList;
import java.util.Iterator;

public class TaskList implements Iterable<Task> {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public int size() {
        return tasks.size();
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    public void clear() {
        tasks.clear();
    }

    public Task remove(int index) {
        return tasks.remove(index);
    }

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
