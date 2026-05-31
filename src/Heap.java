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

    private ArrayList<Integer> values;

    public Heap() {
        values = new ArrayList<Integer>();
    }

    public void add(int value) {
        values.add(value);
        siftUp(values.size() - 1);
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop from a empty heap");
        }

        int smallest = values.get(0);

        int last = values.remove(values.size() - 1);

        if (!isEmpty()) {
            values.set(0, last);
            siftDown(0);
        }

        return smallest;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek at an empty heap");
        }

        return values.get(0);
    }

    public int size() {
        return values.size();
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    private void siftUp(int index) {
        while (index > 0) {

            int parentIndex = getParentIndex(index);

            if (values.get(parentIndex) <= values.get(index)) {
                break;
            }

            swap(parentIndex, index);

            index = parentIndex;
        }
    }

    private void siftDown(int index) {

        while (hasLeftChild(index)) {

            int smallerChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && values.get(getRightChildIndex(index)) < values.get(smallerChildIndex)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (values.get(index) <= values.get(smallerChildIndex)) {
                break;
            }

            swap(index, smallerChildIndex);

            index = smallerChildIndex;
        }
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < values.size();
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < values.size();
    }

    private void swap(int firstIndex, int secondIndex) {

        int temp = values.get(firstIndex);

        values.set(firstIndex, values.get(secondIndex));

        values.set(secondIndex, temp);
    }

    @Override
    public String toString() {
        return values.toString();
    }
}