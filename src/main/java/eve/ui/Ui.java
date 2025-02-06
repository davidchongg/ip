package eve.ui;

import java.util.Scanner;

/**
 * User interface for interaction with the user.
 */
public class Ui {
    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the message to the user interface.
     *
     * @param message Message to be displayed on the user interface.
     */
    public void output(String message) {
        String fullMessage = "-------------------------------------------------------------------------------------\n"
                + message + "\n"
                + "-------------------------------------------------------------------------------------\n";
        System.out.println(fullMessage);
    }

    /**
     * Displays the welcome message on the user interface.
     */
    public void greet() {
        output("Hello, I'm Eve!\nWhat can I do for you?");
    }

    /**
     * Returns the next input of the user.
     *
     * @return User input.
     */
    public String nextCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays the error message to the user interface.
     *
     * @param message Error message to be displayed on the user interface.
     */
    public void showError(String message) {
        output(message);
    }
}
