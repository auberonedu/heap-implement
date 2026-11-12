import java.util.ArrayList;
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
    //We will start out by making an ArrayList of integers to hold our data
    //With the root being held at index 0
    private final ArrayList<Integer> heap = new ArrayList<>();

    //Distinguish the parent and children of this node using the index equations
    //2i + 1 = left child, 2i + 2 = right child, (i-1)//2 = parent
    private int parent(int i) {
        return (i-1)/2;
    }

    private int leftChild(int i) {
        return (2*i + 1);
    }

    private int rightChild(int i) {
        return (2*i + 2);
    }
    //Implement each of these methods (bubbling up or down respectively): 
    //add(), peek(), pop(), isEmpty(), size()
    public void add(int value) {
        heap.add(value);
        bubbleUp(heap.size()-1);
    }

    //Private method that compares an integer to it's parent and then calls the swap 
    //method if i is less than it's parent
    private void bubbleUp(int i) {
        while (i>0 && heap.get(parent(i)) > heap.get(i)){
            swap(i, parent(i));

            i = parent(i);
        }
    }
    // Private method for swapping a current index with it's intended target
    private void swap(int currentIndex, int targetIndex) {
        int temp = heap.get(currentIndex);
        heap.set(currentIndex, heap.get(targetIndex));
        heap.set(targetIndex, temp);
    }

    //Private method for sifting down, moving an integer down to it's smaller child
    //and calling swap method until the children of i are not bigger than i 
    private void siftDown(int i){
        int size = heap.size();

        while( true ) {
            int left = leftChild(i);
            int right = rightChild(i);
            int smallest = i;

            if(left < size && heap.get(left) < heap.get(smallest)){
                smallest = left;
            }
            if(right< size && heap.get(right) < heap.get(smallest)){
                smallest = right;
            }
            if(smallest == i){
                break;
            }
            swap(i, smallest);
            i = smallest;

        }
    }

    //Throw errors for an empty Heap, so pop and peek would throw an exception 
    public int peek() {

        if (!heap.isEmpty()) {
            return heap.get(0);
        }
        
        throw new NoSuchElementException("The heap is empty");
    }

    public int pop() {
        if(isEmpty()){
            throw new NoSuchElementException ("The heap is empty");
        }
        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        
        if(!isEmpty()) {
            heap.set(0, last);
            siftDown(0);
        }
        return min;
    }
    public boolean isEmpty(){
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }


    

    //We need to add private helper methods: parent, leftChild, rightChild, bubbleUp, siftDown, and swap 

    


}