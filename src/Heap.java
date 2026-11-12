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
    private int size;
    private List<Integer> array;

    public Heap(){
        size = 0;
        array = new ArrayList<>();
    }

    public void add(int value){
        if(size == 0){
            array.add(value);
            size++;
            return;
        }
        array.add(size, value);
        size++;
        bubbleUp();
    }

    public int pop(){
        int removed = array.get(0);
        array.set(0, array.get(size-1));
        array.remove(size-1);
        size--;
        bubbleDown(0);
        return removed;
    }

    public int peek(){
        return array.get(0);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void bubbleUp(){
        int currentIndex = size-1;
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
        if(left < size && array.get(left) < array.get(smallest)) smallest = left;
        if(right < size && array.get(right) < array.get(smallest)) smallest = right;
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