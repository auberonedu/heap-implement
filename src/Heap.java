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
    // Instance fields
    private List<Integer> heap;

    // Heap constructor
    public Heap() {
        heap = new ArrayList<>();
    }

    /**
     * Helper method that swaps two elements in a heap
     * @param a first element being swapped
     * @param b second element being swapped
     */
    private void swap(int a, int b) {
        int index1 = heap.get(a);
        int index2 = heap.get(b);

        heap.set(a, index2);
        heap.set(b, index1);
    }

    /**
     * Adds a new element to the end of the heap and bubbles up if necessary
     * @param num new number to add to heap
     */
    public void add(int num) {
        heap.add(num);
        int childIndex = heap.size() - 1;

        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            if (heap.get(parentIndex) > heap.get(childIndex)) {
                swap(parentIndex, childIndex);
                childIndex = parentIndex; 
            } else break;
        }
    }
    
    /**
     * Popping the front of the heap O(log(n))
     * @return the integer of the popped element
     */
    public int pop() {
        if (heap.size() <= 0) throw new NoSuchElementException("Heap is empty");

        int min = heap.get(0);

        // Move last element to root and remove the last
        heap.set(0, heap.getLast());
        heap.removeLast();

        // Skips the bubble down if the heap is empty
        if (heap.isEmpty()) return min;

        // Bubble down
        int parentIndex = 0;

        while (true) {
            int leftChild = 2 * parentIndex + 1;
            int rightChild = 2 * parentIndex + 2;
            int smallest = parentIndex;

            if (leftChild < heap.size() && heap.get(leftChild) < heap.get(smallest)) {
                smallest = leftChild;
            }

            if (rightChild < heap.size() && heap.get(rightChild) < heap.get(smallest)) {
                smallest = rightChild;
            }

            if (smallest == parentIndex) break;

            swap(parentIndex, smallest);
            parentIndex = smallest;
        }

        return min;
    }

    /**
     * This method will peak at the first element in the heap, returning the found value.
     * Peeking at the front of the heap without removing the element O(1)
     * @return found integer
     */
    public int peak() {
        if (heap.size() <= 0) throw new NoSuchElementException("Heap is empty");
        return heap.getFirst();
    }

    /**
     * Getting the size of the heap O(1)
     * @return size of the heap
     */
    public int getSize() {
        return heap.size();
    }

    /**
     * Checking whether the heap is empty O(1)
     * @return true if the heap is empty, false otherwise
     */
    public boolean isEmpty() {
        return heap.size() == 0;
    }

}