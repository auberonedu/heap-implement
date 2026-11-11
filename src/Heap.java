import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A min-heap. 
 * 
 * Must contain functionality for the following: (n = # of elements in heap)
 * 
 * Adding a new value to the heap  O(log(n))
 * Popping the front of the heap O(log(n))
 * Peeking at the front of the heap without removing the element O(1)
 * Getting the size of the heap O(1)
 * Checking whether the heap is empty O(1)
 * 
 * 
 * The Heap must hold ints
 * 
 * Use List/ArrayList as a backing array, but DO NOT use the 
 * PriorityQueue class. Do not make Node objects, use array
 * indexing instead.
 * 
 * It is up to you to make design decisions about how to:
 *  - name methods
 *  - determine return value and argument types
 *  - hold private instance variables
 */

public class Heap {

    private List<Integer> data = new ArrayList<>();

    // Add a value to the heap
    public void add(int value) {
        data.add(value);
        siftUp(data.size() - 1);
    }

    // Remove and return the smallest value
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int smallest = data.get(0);

        data.set(0, data.get(data.size() - 1));
        data.remove(data.size() - 1);

        if (!isEmpty()) {
            siftDown(0);
        }

        return smallest;
    }

    // Return the smallest value without removing it
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return data.get(0);
    }

    // Return the number of values
    public int size() {
        return data.size();
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // Move a value up until it is in the correct position
    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (data.get(index) >= data.get(parent)) {
                break;
            }

            swap(index, parent);
            index = parent;
        }
    }

    // Move a value down until it is in the correct position
    private void siftDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < data.size() && data.get(left) < data.get(smallest)) {
                smallest = left;
            }

            if (right < data.size() && data.get(right) < data.get(smallest)) {
                smallest = right;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    // Swap two values
    private void swap(int i, int j) {
        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}
