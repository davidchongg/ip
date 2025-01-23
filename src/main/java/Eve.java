import java.util.Scanner;
import java.util.ArrayList;

public class Eve {
    private static ArrayList<Task> taskList;
    public static void main(String[] args) {
        greet();
        taskList = new ArrayList<Task>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.next();
            if (command.equals("bye")) {
                bye();
                break;
            } else if (command.equals("list")) {
                list();
            } else if (command.equals("mark")) {
                mark(scanner.nextInt());
            } else if (command.equals("unmark")) {
                unmark(scanner.nextInt());
            } else {
                add(command + scanner.nextLine());
            }
        }
    }

    public static void greet() {
        output("Hello, I'm Eve!\nWhat can I do for you?");
    }

    public static void bye() {
        output( "Bye. Hope to see you again soon!");
    }

    public static void list() {
        String message = "";
        int num = 1;
        for (Task task: taskList) {
            message += Integer.toString(num) + "." +  task.toString() + "\n";
            num++;
        }
        output(message.trim());
    }

    public static void mark(int num) {
        if (num <= taskList.size()) {
            taskList.get(num - 1).markAsDone();
            output("Nice! I've marked this task as done:\n\t"
                    + taskList.get(num - 1).toString());
        }
    }

    public static void unmark(int num) {
        if (num <= taskList.size()) {
            taskList.get(num - 1).markAsNotDone();
            output("OK, I've marked this task as not done yet:\n\t"
                    + taskList.get(num - 1).toString());
        }
    }

    public static void add(String description) {
        taskList.add(new Task(description));
        output("added: " + description);
    }

    public static void output(String message) {
        String fullMessage = "---------------------------------------------------------------------------\n"
                + message + "\n"
                + "---------------------------------------------------------------------------\n";
        System.out.println(fullMessage);
    }
}
