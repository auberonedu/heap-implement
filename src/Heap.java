import java.util.ArrayList;

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
    private ArrayList<Integer> heap;

    public Heap() {
        heap = new ArrayList<Integer>();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (2 * i) + 1;
    }

    private int rightChild(int i) {
        return (2 * i) + 2;
    }

    private void swapPlaces(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void add(int value) {
        heap.add(value);
        int currentIndex = heap.size() - 1;

        while (currentIndex > 0 && heap.get(currentIndex) < heap.get(parent(currentIndex))) {
            swapPlaces(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    public int peek() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty!");
        }

        return heap.get(0);
    }

    public int pop() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty!");
        }

        int min = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            int currentIndex = 0;

            while (true) {
                int left = leftChild(currentIndex);
                int right = rightChild(currentIndex);
                int smallest = currentIndex;

                if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                    smallest = left;
                }

                if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                    smallest = right;
                }

                if (smallest == currentIndex) break;

                swapPlaces(currentIndex, smallest);
                currentIndex = smallest;
            }
        }

        return min;
    }
}