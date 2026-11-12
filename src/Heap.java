import java.util.ArrayList;
import java.util.List;

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
    private List<Integer> heap;
    private int size;

    public Heap(){
        this.heap = new ArrayList<>();
        this.size = 0;
    }

    public void add(int element){
        heap.add(element);
        size++;


    }

    public int pop(){
        int current = heap.get(0);

        if(!heap.isEmpty()){
            heap.remove(0);
            size--;
        }else{
            current = 0;
        }

        return current;
    }

    public int peek(){
        return heap.get(0);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size>0) return false;
        else return true;
    }
}