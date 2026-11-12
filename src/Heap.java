import java.util.*;

/**
 * A generic min-heap using an ArrayList.
 */
public class Heap<T extends Comparable<T>> {
    private List<T> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void add(T a) {
        heap.add(a);
        int dex = heap.size() - 1;

        while (dex > 0) {
            int parent = (dex - 1) / 2;

            if (compare(heap.get(dex), heap.get(parent)) < 0) {
                T c = heap.get(dex);
                heap.set(dex, heap.get(parent));
                heap.set(parent, c);

                dex = parent;
            } else {
                break;
            }
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        T val = heap.get(0);

        // Remove last element and save its value.
        T last = heap.remove(heap.size() - 1);

        // If heap is now empty, we're finished.
        if (isEmpty()) {
            return val;
        }

        // Move last element to the root.
        heap.set(0, last);
        int dex = 0;

        while (true) {
            int left = 2 * dex + 1;
            int right = 2 * dex + 2;

            // No children left.
            if (left >= heap.size()) {
                break;
            }

            // Find the smaller child.
            int smallerChild = left;

            if (right < heap.size() &&
                compare(heap.get(right), heap.get(left)) < 0) {
                smallerChild = right;
            }

            // Stop if parent is already smaller.
            if (compare(heap.get(smallerChild), heap.get(dex)) >= 0) {
                break;
            }

            // Swap parent with smaller child.
            T c = heap.get(dex);
            heap.set(dex, heap.get(smallerChild));
            heap.set(smallerChild, c);

            dex = smallerChild;
        }

        return val;
    }

    public T peek() {
        return heap.get(0);
    }

    public void swap(T a, T b) {

    }

    public void bubbleUp(int index) {

    }

    public void bubbleDown() {

    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // < 0 First value is smaller
    //   0 Values are equal
    // > 0 First value is larger
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
}
