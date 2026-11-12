import java.util.List;
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
    // VALUES
    List<Integer> heap = new ArrayList<>();

    // HELPER METHODS
    private int getLeftChildIndex(int index) { return 2 * index + 1; }
    private int getRightChildIndex(int index) { return 2 * index + 2; }
    private int getParentIndex(int index) { return index / 2; }

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < heap.size(); }
    private boolean hasRightChild(int index) { return getLeftChildIndex(index) < heap.size(); }
    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }

    private int left(int index) { return heap.get(getLeftChildIndex(index)); }
    private int right(int index) { return heap.get(getRightChildIndex(index)); }
    private int parent(int index) { return heap.get(getParentIndex(index)); }

    // METHODS
    // add
    public void add(int value){
        heap.add(value);
        bubbleUp();
    }

    //bubbleUp
    private void bubbleUp() {
        int index = heap.size() - 1;
        while(hasParent(index) && parent(index) > heap.get(index)){
            int parentIndex = getParentIndex(index);
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    // bubbleDown
    private void bubbleDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int smaller = getLeftChildIndex(index);
            if (hasRightChild(index) && left(index) < right(index)) {
                smaller = getRightChildIndex(index);
            }

            if (heap.get(index) < heap.get(smaller)) {
                break;
            } else {
                swap (index, smaller);
            }
            index = smaller;
        }
    }

    // pop
    private int pop() {
        if (heap.size() == 0) throw new IllegalStateException("Heap is empty");
        int pop = heap.removeFirst();
        bubbleDown();
        return pop;
    }

    // swap
    private void swap(int a, int b) {
        int t = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, t);
    }

    // peek
    public int peek() {
        if (heap.size() == 0) throw new IllegalStateException("Heap is empty");
        return heap.getFirst();
    }

    // size
    public int size() {
        return heap.size();
    }

    // empty
    public void empty() {
        heap = new ArrayList<>();
    }


}