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


    public void add(int number) {
        heap.add(number);
        bubbleUp(heap.size() -1);
    }

    public int pop() {
        

    }

    public int peek() {
        return heap.get(heap.size()-1);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();

        
    }

    private void bubbleUp(int index) {

        while (index > 0) {

            int parentIndex = (index - 1) / 2;
          
            if (heap.get(index) < heap.get(parentIndex)) {
                int temp = heap.get(index);
                heap.set(index, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

     private void bubbleDown(int index) {

        while (2 * index + 1< heap.size()) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallerChild = leftChild;
            if (rightChild < heap.size() && heap.get(rightChild) < heap.get(leftChild)) {
                smallerChild = rightChild;
            }
            if(heap.get(index) > heap.get(smallerChild)) {

                int temp = heap.get(index);
            heap.set(index, heap.get(smallerChild));
            heap.set(smallerChild, temp);
            index = smallerChild;
            }
            else {
                break;
            }
            }
        }

        
    }

}