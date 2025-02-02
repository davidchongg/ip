import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Eve {
    private static ArrayList<Task> taskList;
    private static boolean continueRunning = true;
    private static final String DATA_FILE = "eve.txt";
    private static final String DATA_DIRECTORY = "data";

    public static void main(String[] args) {
        taskList = new ArrayList<Task>();
        try {
            load(DATA_DIRECTORY + "/" + DATA_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Data file eve.txt not found");
        }
        greet();
        Scanner scanner = new Scanner(System.in);
        while (continueRunning) {
            String fullCommand = scanner.nextLine();
            executeCommand(fullCommand.split(" ", 2));
        }
    }

    public static void executeCommand(String[] fullCommand) {
        String command = fullCommand[0];
        try {
            if (command.equals("bye")) {
                bye();
                return;     // Don't need update file
            } else if (command.equals("list")) {
                list();
                return;     // Don't need update file
            } else if (command.equals("mark")) {
                int num;
                try {
                    num = Integer.parseInt(fullCommand[1]);
                } catch (Exception ex) {
                    throw new NotIntException("You should input a task number instead");
                }
                mark(num);
            } else if (command.equals("unmark")) {
                int num;
                try {
                    num = Integer.parseInt(fullCommand[1]);
                } catch (Exception ex) {
                    throw new NotIntException("You should input a task number instead");
                }
                unmark(num);
            } else if (command.equals("todo") | command.equals("deadline") |
                    command.equals("event")) {
                add(command, fullCommand[1]);
            } else if (command.equals("delete")) {
                int num;
                try {
                    num = Integer.parseInt(fullCommand[1]);
                } catch (Exception ex) {
                    throw new NotIntException("You should input a task number instead");
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
        writeToFile();
    }

    public static void load(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner s = new Scanner(file);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            taskList.add(parseStringIntoTask(line));
        }
    }

    public static Task parseStringIntoTask(String line) {
        String[] parts = line.split(" \\| ");
        Task task;
        switch (parts[0]) {
        case "D":
            task = new Deadline(parts[2], parts[3]);
            break;
        case "E":
            task = new Event(parts[2], parts[3], parts[3]);
            break;
        default:    // "T"
            task = new ToDo(parts[2]);
            break;
        }
        if (parts[1].equals("X")) {
            task.markAsDone();
        }
        return task;
    }

    public static void greet() {
        output("Hello, I'm Eve!\nWhat can I do for you?");
    }

    public static void bye() {
        output( "Bye. Hope to see you again soon!");
        continueRunning = false;
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
                String desc = description.split("/by")[0].trim();
                String by = description.split("/by")[1].trim();
                taskList.add(new Deadline(desc, by));
            } catch (Exception ex) {
                throw new DeadlineTaskException("Let me know the deadline using keyword /by");
            }
        } else {
            try {
                String desc = description.split("/from")[0].trim();
                String from = description.split("/from")[1].split("/to")[0].trim();
                String to = description.split("/from")[1].split("/to")[1].trim();
                taskList.add(new Event(desc, from, to));
            } catch (Exception ex) {
                throw new EventTaskException("Let me know the time of the event using " +
                        "keywords /from and /to");
            }
        }
        output("Got it. I've added this task:\n\t" + taskList.get(taskList.size() - 1).toString()
                + "\nNow you have " + Integer.toString(taskList.size()) + " tasks in the list.");
    }

    private static void writeToFile() {
        StringBuilder dataToWrite = new StringBuilder();
        for (Task task: taskList) {
            dataToWrite.append(task.toDataString()).append("\n");
        }
        try {
            Files.createDirectories(Paths.get(DATA_DIRECTORY));
            Files.writeString(Paths.get(DATA_DIRECTORY + "/" + DATA_FILE), dataToWrite.toString());
        } catch (IOException ex) {
            System.out.println("Something went wrong when writing to file: " + ex.getMessage());
        }
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
