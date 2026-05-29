import java.util.List;
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
    private final List<Integer> list;

    private int leftChildIndex(int index) {
        return (2 * index) + 1;
    };

    private boolean leftChildExists(int index) {
        return leftChildIndex(index) < list.size();
    }

    private boolean rightChildExists(int index) {
        return rightChildIndex(index) < list.size();
    }

    private int rightChildIndex(int index) {
        return (2 * index) + 2;
    };

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    };

    private void swap(int a, int b) {
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    public Heap() {
        this.list = new ArrayList<>();
    }

    public void addValue(int value) {
        list.add(value);
        if (list.size() == 1)
            return;
        int currentIndex = list.size() - 1;

        while (currentIndex > 0 &&
                list.get(currentIndex) < list.get(getParentIndex(currentIndex))) {

            swap(currentIndex, getParentIndex(currentIndex));

            currentIndex = getParentIndex(currentIndex);
        }
    }

    public void pop() {
        if (isEmpty())
            return;

        int end = list.get(list.size() - 1);

        list.set(0, end);
        list.remove(list.size() - 1);

        if (!isEmpty()) {
            popHelperMethod(0);
        }
    }

    private void popHelperMethod(int index) {
        while (leftChildExists(index)) {

            int smallerChildIndex = leftChildIndex(index);

            if (rightChildExists(index)
                    && list.get(rightChildIndex(index)) < list.get(leftChildIndex(index))) {

                smallerChildIndex = rightChildIndex(index);
            }

            if (list.get(index) <= list.get(smallerChildIndex)) {
                break;
            }

            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    public int peek() {
        return this.list.get(0);
    }

    public int getSize() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void printHeap() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        /*
         * 2
         * 1 1
         * 2 2 2
         */
        // Heap heap = new Heap();
        // heap.addValue(0);
        // heap.addValue(1);
        // heap.addValue(1);
        // heap.addValue(2);
        // heap.addValue(2);
        // heap.addValue(2);
        // heap.addValue(2);

        // /*
        // 2
        // 1 1
        // 2 2 2
        // */
        // //2
        // //1
        // //1
        // //2
        // //2
        // //2

        // heap.pop();
        // System.out.println();
        // heap.printHeap();

        // 1
        // 2 1
        // 2 2 2

        Heap heap2 = new Heap();
        heap2.addValue(1);
        heap2.addValue(2);
        heap2.addValue(2);
        heap2.addValue(3);
        heap2.addValue(4);

        /*
         * 4
         * 2
         * 2
         * 3
         * 
         * 
         * 2
         * 3 2
         * 4
         * 
         * 2 3 2 4
         */

        System.out.println();
        heap2.pop();
        heap2.printHeap();
    }
}