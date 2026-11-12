/**
 * A min-heap backed by a List.
 *
 * A min-heap keeps the smallest element at the root and guarantees:
 * - add: O(log n)
 * - pop: O(log n)
 * - peek: O(1)
 * - size: O(1)
 * - isEmpty: O(1)
 */
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Heap {
    private final List<Integer> data;

    public Heap() {
        data = new ArrayList<>();
    }

    /**
     * Adds a value to the heap and restores the heap property.
     *
     * @param value the integer to insert
     */
    public void add(int value) {
        data.add(value);
        bubbleUp(data.size() - 1);
    }

    /**
     * Removes and returns the minimum value in the heap.
     *
     * @return the minimum value in the heap
     * @throws NoSuchElementException if the heap is empty
     */
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }

        int min = data.get(0);
        int lastValue = data.remove(data.size() - 1);

        if (!isEmpty()) {
            data.set(0, lastValue);
            bubbleDown(0);
        }

        return min;
    }

    /**
     * Returns the minimum value in the heap without removing it.
     *
     * @return the minimum value in the heap
     * @throws NoSuchElementException if the heap is empty
     */
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }

        return data.get(0);
    }

    /**
     * Returns the number of elements in the heap.
     *
     * @return the current heap size
     */
    public int size() {
        return data.size();
    }

    /**
     * Checks whether the heap contains any elements.
     *
     * @return true if the heap is empty, false otherwise
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = parentIndex(index);

            if (data.get(index) >= data.get(parentIndex)) {
                break;
            }

            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void bubbleDown(int index) {
        while (true) {
            int leftIndex = leftChildIndex(index);
            int rightIndex = rightChildIndex(index);
            int smallestIndex = index;

            if (leftIndex < data.size() && data.get(leftIndex) < data.get(smallestIndex)) {
                smallestIndex = leftIndex;
            }

            if (rightIndex < data.size() && data.get(rightIndex) < data.get(smallestIndex)) {
                smallestIndex = rightIndex;
            }

            if (smallestIndex == index) {
                break;
            }

            swap(index, smallestIndex);
            index = smallestIndex;
        }
    }

    private static int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private static int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    private static int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}