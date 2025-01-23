import java.util.Scanner;
import java.util.ArrayList;

public class Eve {
    private static ArrayList<String> commandList;
    public static void main(String[] args) {
        output(greetMessage());
        commandList = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("bye")) {
                break;
            } else if (command.equals("list")) {
                output(listMessage());
            } else {
                commandList.add(command);
                output("added: " + command);
            }
        }
        output(byeMessage());
    }

    public static String greetMessage() {
        return "Hello, I'm Eve!\nWhat can I do for you?";
    }

    public static String byeMessage() {
        return "Bye. Hope to see you again soon!";
    }

    public static String listMessage() {
        String message = "";
        int num = 1;
        for (String command : commandList) {
            message += Integer.toString(num) + ". " + command + "\n";
            num++;
        }
        return message.trim();
    }

    public static void output(String message) {
        String fullMessage = "---------------------------------------------------------------------------\n"
                + message + "\n"
                + "---------------------------------------------------------------------------\n";
        System.out.println(fullMessage);
    }
}
