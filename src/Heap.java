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
    private final ArrayList<Integer> array;

    /**
     *  Constructs a Heap by initilizing the internal array list
     */
    public Heap(){
        array = new ArrayList<>();
    }

    /** 
     *  Adds the given value to the end of the heap then bubbles up 
     *  to make sure it is in the root is the smallest value
     * 
     *  @param value The value to add the the heap
     */
    public void add(int value){
        if(array.size() == 0){
            array.add(value);
            return;
        }
        array.add(value);
        bubbleUp();
    }

    /**
     *  Removes the root of the heap then brings up the last value in
     *  the heap then bubbles that value down to make sure the root
     *  of the heap is the smallest value
     * 
     * @throws NoSuchElementException If the heap is empty
     * 
     * @return The value removed from the heap
     */
    public int pop(){
        if(isEmpty()) throw new NoSuchElementException("Heap is empty");
        if(array.size() == 1) return array.remove(0);
        int removed = array.get(0);
        array.set(0, array.get(array.size()-1));
        array.remove(array.size()-1);
        bubbleDown(0);
        return removed;
    }

    /**
     *  Returns the value at the root of the heap without removing it
     * 
     *  @throws NoSuchElementException If the heap is empty
     * 
     *  @return The value at the root of the heap
     */
    public int peek(){
        if(isEmpty()) throw new NoSuchElementException("Heap is empty");
        return array.get(0);
    }

    /**
     *  Returns the current size of the heap
     * 
     *  @return The size of the heap
     */
    public int size(){
        return array.size();
    }

    /**
     *  Returns a boolean value if the heap is empty or not
     * 
     *  @return Boolean value if the heap is empty or not
     */
    public boolean isEmpty(){
        return array.isEmpty();
    }

    private void bubbleUp(){
        int currentIndex = array.size()-1;
        while(currentIndex > 0){
            int parentIndex = (currentIndex - 1) / 2 ;
            if(array.get(currentIndex) < array.get(parentIndex)) swap(currentIndex, parentIndex);
            else return;
            currentIndex = parentIndex;
        }
    }

    private void bubbleDown(int current){
        int left = current * 2 + 1;
        int right = current * 2 + 2;
        int smallest = current;
        if(left < array.size() && array.get(left) < array.get(smallest)) smallest = left;
        if(right < array.size() && array.get(right) < array.get(smallest)) smallest = right;
        if(smallest != current){
            swap(current, smallest);
            bubbleDown(smallest);
        }
    }

    private void swap(int i1, int i2){
        int temp = array.get(i2);
        array.set(i2, array.get(i1));
        array.set(i1, temp);
    }
}