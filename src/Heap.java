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

    public Heap(){
        this.heap = new ArrayList<>();
    }

    public void add(int element){
        heap.add(element);

        int elementIndex = heap.size()-1;

        while(elementIndex > 0){
            int parent = (elementIndex - 1) / 2;
            
            if(element < heap.get(parent)){
                int smallerElement = heap.get(elementIndex);
                heap.set(elementIndex, heap.get(parent));
                heap.set(parent, smallerElement);

                elementIndex = parent;
            }else{
                break;
            }
        }
    }

    public int pop(){
        int current = heap.get(0);

        if(!heap.isEmpty()){
            heap.remove(0);
        }else{
            current = 0;
        }

        return current;
    }

    public int peek(){
        return heap.get(0);
    }

    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){
        if(heap.size()>0) return false;
        else return true;
    }

    public String printHeap(){
        return heap.toString();
    }
}