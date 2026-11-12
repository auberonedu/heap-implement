
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

    List<Integer> items = new ArrayList<>();

    public void swap(int indexOne , int indexTwo){
        int item = items.get(indexOne);
        items.set(indexOne, items.get(indexTwo));
        items.set(indexTwo, item);

    }
    public void addingValue( int item){
        items.add(item);
        int newValueIndex = items.size()-1;
        int parent = (newValueIndex-1) /2;

        int childValue = items.get(newValueIndex);
        int parentValue = items.get(parent);

        while (newValueIndex > 0 && childValue<parentValue) {
                swap(newValueIndex, parent);
                newValueIndex = parent;
                parent = (newValueIndex-1)/2;
                childValue = items.get(newValueIndex);
                parentValue = items.get(parent);

        }
    }
    public int peek(){
        if(items.isEmpty()) throw new IllegalStateException();
        return items.get(0);

    }




}