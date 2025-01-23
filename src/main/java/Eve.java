public class Eve {
    public static void main(String[] args) {
        output(greetMessage());
        output(byeMessage());

    }

    public static String greetMessage() {
        return "Hello, I'm Eve!\nWhat can I do for you?";
    }

    public static String byeMessage() {
        return "Bye. Hope to see you again soon!";
    }

    public static void output(String message) {
        String fullMessage = "---------------------------------------------------------------------------\n"
                + message + "\n"
                + "---------------------------------------------------------------------------\n";
        System.out.println(fullMessage);
    }
}
