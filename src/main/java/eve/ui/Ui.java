package eve.ui;

import java.util.Scanner;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMessage(String message) {
        String fullMessage = "-------------------------------------------------------------------------------------\n"
                + message + "\n"
                + "-------------------------------------------------------------------------------------\n";
        System.out.println(fullMessage);
    }

    public void showWelcomeMessage() {
        displayMessage("Hello, I'm Eve!\nWhat can I do for you?");
    }

    public String nextCommand() {
        return scanner.nextLine();
    }

    public void displayError(String message) {
        displayMessage(message);
    }
}
