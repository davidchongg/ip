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
            try {
                if (command.equals("bye")) {
                    bye();
                    break;
                } else if (command.equals("list")) {
                    list();
                    scanner.nextLine();
                } else if (command.equals("mark")) {
                    int num;
                    try {
                        num = scanner.nextInt();
                    } catch (Exception ex) {
                        throw new NotIntException("You should input a task number instead");
                    } finally {
                        scanner.nextLine();
                    }
                    mark(num);
                } else if (command.equals("unmark")) {
                    int num;
                    try {
                        num = scanner.nextInt();
                    } catch (Exception ex) {
                        throw new NotIntException("You should input a task number instead");
                    } finally {
                        scanner.nextLine();
                    }
                    unmark(num);
                } else if (command.equals("todo") | command.equals("deadline") |
                        command.equals("event")) {
                    add(command, scanner.nextLine());
                } else if (command.equals("delete")) {
                    int num;
                    try {
                        num = scanner.nextInt();
                    } catch (Exception ex) {
                        throw new NotIntException("You should input a task number instead");
                    } finally {
                        scanner.nextLine();
                    }
                    delete(num);
                } else {
                    throw new InvalidCommandException("Oh no... I have no idea what you " +
                            "just said. Please try again...");
                }
            } catch (InvalidCommandException | EventTaskException | DeadlineTaskException |
                    InvalidTaskNumException | NotIntException ex) {
                System.out.println(ex.getMessage() + "\n");
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
        String message = "Here are the tasks in your list:\n";
        int num = 1;
        for (Task task: taskList) {
            message += "\t" + Integer.toString(num) + "." +  task.toString() + "\n";
            num++;
        }
        output(message.trim());
    }

    public static void mark(int num) throws InvalidTaskNumException {
        try {
            taskList.get(num - 1).markAsDone();
            output("Nice! I've marked this task as done:\n\t"
                    + taskList.get(num - 1).toString());
        } catch (Exception ex) {
            throw new InvalidTaskNumException("The task number you specified does not exist...");
        }
    }

    public static void unmark(int num) throws InvalidTaskNumException {
        try {
            taskList.get(num - 1).markAsNotDone();
            output("OK, I've marked this task as not done yet:\n\t"
                    + taskList.get(num - 1).toString());
        } catch (Exception ex) {
            throw new InvalidTaskNumException("The task number you specified does not exist...");
        }
    }

    public static void add(String command, String description) throws EventTaskException, DeadlineTaskException{
        if (command.equals("todo")) {
            taskList.add(new ToDo(description));
        } else if (command.equals("deadline")) {
            try {
                taskList.add(new Deadline(description.split("/by")[0].trim(),
                        description.split("/by")[1].trim()));
            } catch (Exception ex) {
                throw new DeadlineTaskException("Let me know the deadline using keyword /by");
            }
        } else {
            try {
                taskList.add(new Event(description.split("/from")[0].trim(),
                        description.split("/from")[1].split("/to")[0].trim(),
                        description.split("/from")[1].split("/to")[1].trim()));
            } catch (Exception ex) {
                throw new EventTaskException("Let me know the time of the event using " +
                        "keywords /from and /to");
            }
        }
        output("Got it. I've added this task:\n\t" + taskList.get(taskList.size() - 1).toString()
                + "\nNow you have " + Integer.toString(taskList.size()) + " tasks in the list.");
    }

    public static void delete(int num) throws InvalidTaskNumException {
        try {
            Task task = taskList.remove(num - 1);
            output("Noted. I've removed this task:\n\t" + task
                    + "\nNow you have " + Integer.toString(taskList.size())
                    + " tasks in the list.");
        } catch (Exception ex) {
            throw new InvalidTaskNumException("The task number you specified does not exist...");
        }
    }

    public static void output(String message) {
        String fullMessage = "---------------------------------------------------------------------------\n"
                + message + "\n"
                + "---------------------------------------------------------------------------\n";
        System.out.println(fullMessage);
    }
}
