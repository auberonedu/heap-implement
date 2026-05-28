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
    private ArrayList<Integer> heapArray = new ArrayList<>();

    //if the left child exists, returns the index of the left child.
    //otherwise returns -1
    private int left(int index) {
        int leftChild = index*2+1;
        if(leftChild < heapArray.size()) {
            return leftChild;
        }
        return -1;
    }

    //if the right child exists, returns the index of the right child.
    //otherwise returns -1
    private int right(int index) {
        int rightChild = index*2+2;
        if(rightChild < heapArray.size()) {
            return rightChild;
        }
        return -1;
    }

    // if parent is greater than 0, then return the parent of the given index.
    private int parent(int index) {
        int parent = (index - 1) / 2;
        if (parent >= 0) {
            return parent;
        }
        return -1;
    }

    public void add(int num) {
        heapArray.add(num);
        int numLocation = heapArray.size() - 1;
        int parentLocation = parent(numLocation);
        
        while(num > parent(numLocation)) {
            swap(numLocation, parentLocation);
            numLocation = parentLocation;
            parentLocation = parent(numLocation);
        }
    }

    private void swap(int a, int b) {
        int holder = heapArray.get(b);
        heapArray.set(b, heapArray.get(a));
        heapArray.set(a, holder);
    }

    public int pop() {
        if(heapArray.size() == 0) {
            throw new IllegalArgumentException();
        }
        int popped = heapArray.get(0);

        int last = heapArray.remove(heapArray.size()-1);

        if(heapArray.isEmpty()) return popped;

        heapArray.set(0, last);
        int current = 0;

        while(true) {
            int left = left(current);
            int right = right(current);

            int smallest = current;

            if(left != -1 && heapArray.get(left) < heapArray.get(smallest)) {
                smallest = left;
            }
            if(right != -1 && heapArray.get(right) < heapArray.get(smallest)) {
                smallest = right;
            }

            if(smallest == current) break;

            swap(current, smallest);
            current = smallest;
        }

        return popped;
    }

    public int peek() {
        if(heapArray.size() == 0) {
            throw new IllegalArgumentException();
        }

        return heapArray.get(0);
    }

    public int size() {
        return heapArray.size();
    }

    public boolean isEmpty() {
        return heapArray.isEmpty();
    }

}