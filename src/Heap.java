import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * A min-heap. 
 * 
 * Must contain functionality for the following: (n = # of elements in heap)
 * 
 * Adding a new value to the heap  O(log(n)) implemented
 * Popping the front of the heap O(log(n)) implemented
 * Peeking at the front of the heap without removing the element O(1) implemented
 * Getting the size of the heap O(1) implemented
 * Checking whether the heap is empty O(1) implemented
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
public class Heap<T extends Comparable<? super T>> {

    private final ArrayList<T> elements = new ArrayList<>();

    private int parentIndex(int currentIndex) {
        return (currentIndex - 1) / 2;
    }

    private int leftChildIndex(int currentIndex) {
        return (currentIndex * 2) + 1;
    }

    private int rightChildIndex(int currentIndex) {
        return (currentIndex * 2) + 2;
    }

    private void swap(int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Heap does not support null values");
        }

        elements.add(data);
        int currentIndex = elements.size() - 1;

        while (currentIndex > 0) {
            int parent = parentIndex(currentIndex);
            if (elements.get(currentIndex).compareTo(elements.get(parent)) < 0) {
                swap(currentIndex, parent);
                currentIndex = parent;
            } else {
                break;
            }
        }
    }

    public T pop() {
        if (elements.isEmpty()) {
            throw new NoSuchElementException("Empty heap and nothing to pop");
        }

        T removed = elements.get(0);
        if (elements.size() == 1) {
            elements.remove(0);
            return removed;
        }

        elements.set(0, elements.remove(elements.size() - 1));

        int currentIndex = 0;
        while (true) {
            int left = leftChildIndex(currentIndex);
            int right = rightChildIndex(currentIndex);

            if (left >= elements.size()) {
                break;
            }

            int smallerChild = left;
            if (right < elements.size() && elements.get(right).compareTo(elements.get(left)) < 0) {
                smallerChild = right;
            }

            if (elements.get(currentIndex).compareTo(elements.get(smallerChild)) <= 0) {
                break;
            }

            swap(currentIndex, smallerChild);
            currentIndex = smallerChild;
        }

        return removed;
    }

    public T peek() {
        if (elements.isEmpty()) {
            throw new NoSuchElementException("Empty heap and nothing to peek");
        }
        return elements.get(0);
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}