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
    private int size;
    private final List<Integer> arr;

    public Heap() {
        size = 0;
        arr = new ArrayList<>();
    }

    public void add(int num) {
        if (size == 0) {
            arr.add(num);
            size++;
            return;
        }

        arr.add(num);
        int index = size;

        while (index > 0 && arr.get(index) < arr.get((index - 1) / 2)) {
            int current = arr.get(index);
            int parent = arr.get((index - 1) / 2);

            arr.set(index, parent);
            arr.set((index - 1) / 2, current);

            index = (index - 1) / 2;
        }

        size++;
    }

    public int pop() {
        if (size == 0) throw new NoSuchElementException();
        if (size == 1) {
            size--;
            return arr.remove(0);
        }

        int root = arr.get(0);
        int last = arr.get(size - 1);

        arr.set(0, last);
        arr.set(size - 1, root);

        int removed = arr.remove(size - 1);
        size--;

        int index = 0;

        while (index * 2 + 1 < size) {
            int current = arr.get(index);
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int childIndex;
 
            if (right < size) {
                if (arr.get(left) < arr.get(right)) childIndex = left;
                else childIndex = right;

                int child = arr.get(childIndex);

                if (current <= child) break;

                arr.set(index, child);
                arr.set(childIndex, current);
                index = childIndex;
            } else {
                int child = arr.get(left);
                if (current <= child) break;

                arr.set(index, child);
                arr.set(left, current);
                index = left;
            }
        }

        return removed;
    }

    public int peek() {
        if (size == 0) throw new NoSuchElementException();
        return arr.get(0);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public List<Integer> values() {
        return List.copyOf(arr);
    }
}