import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * A min-heap of ints backed by an ArrayList.
 *
 * The heap is stored as a complete binary tree laid out level by level
 * in the list. The smallest value is always at the root (index 0). For the
 * element at index i
 *   parent      = (i - 1) / 2
 *   left child  = 2 * i + 1
 *   right child = 2 * i + 2
 *
 * Every parent is less than or equal to its children. Duplicate values
 * are allowed.
 * 
 * Time complexity (n = number of elements):
 *   add     O(log n)
 *   pop     O(log n)
 *   peek    O(1)
 *   size    O(1)
 *   isEmpty O(1)
 */
public class Heap {
    private final List<Integer> data;

    /** Constructs an empty heap. */
    public Heap() {
        data = new ArrayList<>();
    }

    /**
     * Adds a value to the heap.
     *
     * @param value the value to add
     */
    public void add(int value) {
        data.add(value);
        bubbleUp(data.size() - 1);
    }

    /**
     * Removes and returns the smallest value in the heap.
     *
     * @return the minimum value
     * @throws NoSuchElementException if the heap is empty
     */
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Can't pop from an empty heap");
        }

        int min = data.get(0);
        int last = data.remove(data.size() - 1);
        if (!isEmpty()) {
            data.set(0, last);
            bubbleDown(0);
        }

        return min;
    }
    /**
     * Returns the smallest value in the heap without removing it.
     *
     * @return the minimum value
     * @throws NoSuchElementException if the heap is empty
     */
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Can't peek at an empty heap");
        }
        return data.get(0);
    }

     /**
     * Returns the number of elements in the heap.
     *
     * @return the number of elements
     */
    public int size() {
        return data.size();
    }

    /**
     * Returns whether the heap has no elements.
     *
     * @return true if the heap is empty, false otherwise
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // Move the value at index up toward root, swap with its parents
    // stop when the value >= its parent or it reaches the root
    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = parent(index);
            if (data.get(index) >= data.get(parentIndex)) {
                return;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    // move the value at index down until there is no smaller child to swap with
    // stop when the value is <= both children or it reaches a leaf
    // make sure the heap is balance and in a heap order
    private void bubbleDown(int index){
        int size = data.size();
        while (true) {
            int left = leftChild(index);
            int right = rightChild(index);

            int smallest = index;

            if (left < size && data.get(left) < data.get(smallest)) {
                smallest = left;
            }
            if (right < size && data.get(right) < data.get(smallest)) {
                smallest = right;
            }

            if (smallest == index) return;

            swap(index, smallest);
            index = smallest;
        }
    }

    // return index of parent of the given index
    private static int parent(int index){
        return (index -1)/2;
    }

    // return the index of the left child of the given index
    private static int leftChild(int index) {
        return index * 2 + 1;
    }
    // return the index of the right child of the index
    private static int rightChild(int index) {
        return index * 2 + 2;
    }

    // use to swap value at index between two index
    private void swap(int index1, int index2){
        int firstValue = data.get(index1);
        data.set(index1, data.get(index2));
        data.set(index2, firstValue);
    }
}