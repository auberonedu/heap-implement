import java.util.ArrayList;
import java.util.List;

/**
 * A min-heap implementation using an ArrayList.
 */
public class Heap {
    private final List<Integer> list;

    public Heap() {
        this.list = new ArrayList<>();
    }

    private int leftChildIndex(int index) {
        return (2 * index) + 1;
    }

    private int rightChildIndex(int index) {
        return (2 * index) + 2;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean leftChildExists(int index) {
        return leftChildIndex(index) < list.size();
    }

    private boolean rightChildExists(int index) {
        return rightChildIndex(index) < list.size();
    }

    private void swap(int a, int b) {
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    /**
     * Inserts a value into the heap.
     * Time Complexity: O(log n)
     */
    public void addValue(int value) {
        list.add(value);

        int currentIndex = list.size() - 1;

        while (currentIndex > 0
                && list.get(currentIndex) < list.get(getParentIndex(currentIndex))) {

            swap(currentIndex, getParentIndex(currentIndex));
            currentIndex = getParentIndex(currentIndex);
        }
    }

    /**
     * Removes the minimum value (root) from the heap.
     * Time Complexity: O(log n)
     */
    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        int removedValue = list.get(0);

        int lastValue = list.get(list.size() - 1);

        list.set(0, lastValue);
        list.remove(list.size() - 1);

        if (!isEmpty()) {
            heapifyDown(0);
        }

        return removedValue;
    }

    /**
     * Restores the heap property after removing the root.
     */
    private void heapifyDown(int index) {
        while (leftChildExists(index)) {

            int smallerChildIndex = leftChildIndex(index);

            if (rightChildExists(index)
                    && list.get(rightChildIndex(index))
                            < list.get(leftChildIndex(index))) {

                smallerChildIndex = rightChildIndex(index);
            }

            if (list.get(index) <= list.get(smallerChildIndex)) {
                break;
            }

            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    /**
     * Returns the minimum value without removing it.
     * Time Complexity: O(1)
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }

        return list.get(0);
    }

    /**
     * Returns the number of elements in the heap.
     * Time Complexity: O(1)
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Returns true if the heap contains no elements.
     * Time Complexity: O(1)
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void printHeap() {
        for (int value : list) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();

        heap.addValue(1);
        heap.addValue(2);
        heap.addValue(2);
        heap.addValue(3);
        heap.addValue(4);

        System.out.println("Before pop:");
        heap.printHeap();

        heap.pop();

        System.out.println("\nAfter pop:");
        heap.printHeap();
    }
}