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
    private final List<Integer> data;

    //make an empty heap
    public Heap(){
        data = new ArrayList<>();
    }

    // return the smallest value in the heap (which is the root)
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cant peek at an empty heap");
        }
        return data.get(0);
    }

    // return the size of things in the heap
    public int size() {
        return data.size();
    }

    // add a value, then method bubble it up to the right spot
    public void add(int value) {
        data.add(value);
        bubbleUp(data.size() - 1);
    }
    // remove the smallest value from heap (root) then return
    // if it empty -> throw
    public int pop() {
    if (isEmpty()) {
        throw new NoSuchElementException("Can't pop, heap EMPTY");
    }

    int min = data.get(0);
    int last = data.remove(data.size() - 1);

    // if there still value left, move the last value into the root spot
    if (!isEmpty()) {
        data.set(0, last);
        bubbleDown(0);
    }

    return min;
    }

    // return if the heap is empty or not
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // return index of parent of the given index
    private int parent(int index){
        return (index -1)/2;
    }

    // return the index of the right child of the index
    private int rightChild(int index){
        return index * 2 + 2;
    }

    // return the index of the left child of the given index
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // use to swap value at index between two index
    private void swap(int index1, int index2){
        int firstValue = data.get(index1);
        data.set(index1, data.get(index2));
        data.set(index2, firstValue);
    }

    // move the value at index up while it is smaller than its parent
    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = parent(index);
            if (data.get(index) >= data.get(parentIndex)) {
                return;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }
    // move the value at index down while it is bigger than its children
    private void bubbleDown(int index){
        int size = data.size();
        while (true) {
            int left = leftChild(index);
            int right = rightChild(index);

            int smallest = index;

            if (left < size && data.get(left) < data.get(smallest)) {
                smallest = left;
            }
            if (right < size && data.get(right) < data.get(smallest)) {
                smallest = right;
            }

            if (smallest == index) return;

            swap(index, smallest);
            index = smallest;
        }
    }
}