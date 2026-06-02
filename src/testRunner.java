import java.util.Scanner;

/**
 * Interactive runner program for testing your test implementation.
 * 
 * Commands:
 *   - Add a value
 *   - Pop the front value
 *   - Peek at the front value
 *   - Check the size
 *   - Check whether the test is empty
 *   - Quit
 * 
 * Wherever you see TODO comments, you will need to fill in the appropriate
 * code to construct your test or call one of its methods. The method names
 * and return types are up to you based on your design decisions.
 */
public class testRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Heap test = new Heap();

        System.out.println("=== test Tester ===");

        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("a") || choice.equals("add")) {
                System.out.print("Enter an integer to add: ");
                String input = scanner.nextLine().trim();
                int value;
                try {
                    value = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("That wasn't a valid integer. Try again.");
                    continue;
                }
 
                test.add(value);
                System.out.println("Added sucessfully");
 
            } else if (choice.equals("p") || choice.equals("pop")) {
                if (test.size() == 0) System.out.println("Empty test");
                else System.out.println(test.pop());

            } else if (choice.equals("k") || choice.equals("peek")) {
                if (test.size() == 0) System.out.println("Empty test");
                else System.out.println(test.peek());

            } else if (choice.equals("s") || choice.equals("size")) {
                System.out.println(test.size());

            } else if (choice.equals("e") || choice.equals("empty")) {
                System.out.println(test.empty());

            } else if (choice.equals("q") || choice.equals("quit")) {
                break;

            } else {
                System.out.println("Unknown command. Please try again.");
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    /**
     * Prints the menu of available commands.
     */
    private static void printMenu() {
        System.out.println();
        System.out.println("---- Commands ----");
        System.out.println("  a / add   - add a value to the test");
        System.out.println("  p / pop   - pop the front value off the test");
        System.out.println("  k / peek  - peek at the front value of the test");
        System.out.println("  s / size  - print the size of the test");
        System.out.println("  e / empty - check whether the test is empty");
        System.out.println("  q / quit  - exit the program");
        System.out.print("Enter command: ");
    }
}