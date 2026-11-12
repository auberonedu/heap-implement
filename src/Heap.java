import java.util.ArrayList;

/**
 * A min-heap.
 * 
 * Must contain functionality for the following: (n = # of elements in heap)
 * 
 * Adding a new value to the heap O(log(n))
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
 * - name methods
 * - determine return value and argument types
 * - hold private instance variables
 */
public class Heap {
    private ArrayList<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void add(int value) {
        heap.add(value);
        int index = heap.size() - 1;

        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap.get(index) >= heap.get(parent)) {
                break;
            }

            int temp = heap.get(index);
            heap.set(index, heap.get(parent));
            heap.set(parent, temp);

            index = parent;
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        return heap.get(0);
    }

}