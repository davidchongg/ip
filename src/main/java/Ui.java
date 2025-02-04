import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void output(String message) {
        String fullMessage = "-------------------------------------------------------------------------------------\n"
                + message + "\n"
                + "-------------------------------------------------------------------------------------\n";
        System.out.println(fullMessage);
    }

    public void greet() {
        output("Hello, I'm Eve!\nWhat can I do for you?");
    }

    public String nextCommand() {
        return scanner.nextLine();
    }

    public void showError(String message) {
        output(message);
    }
}
