import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Interactive runner program for testing your Heap implementation.
 * 
 * Commands:
 *   - Add a value
 *   - Pop the front value
 *   - Peek at the front value
 *   - Check the size
 *   - Check whether the heap is empty
 *   - Quit
 * 
 * Wherever you see TODO comments, you will need to fill in the appropriate
 * code to construct your Heap or call one of its methods. The method names
 * and return types are up to you based on your design decisions.
 */
public class HeapRunner <T>{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO: Construct your Heap here.
        Heap<Integer> heap = new Heap<>();

        System.out.println("=== Heap Tester ===");

        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("a") || choice.equals("add")) {
                System.out.print("Enter a value to add: ");
                String input = scanner.nextLine().trim();
                int value;
                try {
                    value = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("That wasn't a valid integer. Try again.");
                    continue;
                }
 
                // TODO: Call your "add" method on the heap, passing in 'value'.
                // TODO: Print message letting user know value was added
                System.out.println("Value " + heap.add(value) + " Added");
 
            } else if (choice.equals("p") || choice.equals("pop")){
                // TODO: Call your "pop" method and print the result.
                
                // Properly handle the case of an empty heap!
                

                try {
                    var value = heap.Pop();
                    System.out.println("Value: " + value);
                } catch (NoSuchElementException e){
                    System.out.println("There is nothing in the pool");
                }
            } else if (choice.equals("k") || choice.equals("peek")) {
                // TODO: Call your "peek" method and print the result
                // Properly handle the case of an empty heap!
                System.out.println("Peeked value: " + heap.Peek());

            } else if (choice.equals("s") || choice.equals("size")) {
                // TODO: Call your "size" method and print the result
                System.out.println("Size of Heap: " + heap.heapSize());

            } else if (choice.equals("e") || choice.equals("empty")) {
                // TODO: Call your "isEmpty" method and print the result
                System.out.println("Is the heap Empty : " + heap.heapIsEmpty());

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
        System.out.println("  a / add   - add a value to the heap");
        System.out.println("  p / pop   - pop the front value off the heap");
        System.out.println("  k / peek  - peek at the front value of the heap");
        System.out.println("  s / size  - print the size of the heap");
        System.out.println("  e / empty - check whether the heap is empty");
        System.out.println("  q / quit  - exit the program");
        System.out.print("Enter command: ");
    }
}