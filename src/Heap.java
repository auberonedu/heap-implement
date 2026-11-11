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

     private final List<Integer> data = new ArrayList<>();
 
     //public void  add 
     // data.add val

     // data size - 1
    public void add(int value) {
        data.add(value);
        siftUp(data.size() - 1);
    }
 
 
    // private method up
    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (data.get(index) >= data.get(parent)) {
                break;
            }
            swap(index, parent);
            index = parent;
        }
    }
 
    // private method down
    private void siftDown(int index) {
        int n = data.size();
        while (true) {
            int left = 2 * index + 1;
            int right = left + 1;
            int smallest = index;
            if (left < n && data.get(left) < data.get(smallest)) {
                smallest = left;
            }
            if (right < n && data.get(right) < data.get(smallest)) {
                smallest = right;
            }
            if (smallest == index) {
                break;
            }
            swap(index, smallest);
            index = smallest;
        }
    }
 

    // private method swap 
    private void swap(int i, int j) {
        int tmp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, tmp);
    }
}