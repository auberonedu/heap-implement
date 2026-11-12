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

    private ArrayList<Integer> heap = new ArrayList<>();

    //Adding a new value to the heap  O(log(n))
    public void add(int value){
        //insert new integer at the end of the list
        heap.add(value);
    
        //if child is less than parent, swap child and parent
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while(childIndex > 0 && heap.get(childIndex) < heap.get(parentIndex)){
            //swap child and parent
            int temp = heap.get(childIndex);
            heap.set(childIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            //update child and parent indices
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
         }
    }

    //Popping the front of the heap O(log(n))
    public int pop(){
        if(heap.isEmpty()){
            throw new IllegalStateException("Heap is empty");
        }
        //store the value to be returned
        int minValue = heap.get(0);
        //remove the last element and place it at the front
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);
        //heapify down
        int parentIndex = 0;
        while(true){
            int leftChildIndex = 2 * parentIndex + 1;   

    
    }
}

