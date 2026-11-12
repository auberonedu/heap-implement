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

    private void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    private void bubbleDown(int elementIndex){
        int leftChild = 2 * elementIndex + 1;
        int rightChild = 2 * elementIndex + 2;

        while(leftChild < heap.size()){

            int smallerChild = leftChild;

            if(rightChild < heap.size() &&
                heap.get(rightChild) < heap.get(leftChild)){
                smallerChild = rightChild;
            }

            if(heap.get(elementIndex) > heap.get(smallerChild)){
                swap(elementIndex, smallerChild);
                elementIndex = smallerChild;

                leftChild = 2 * elementIndex + 1;
                rightChild = 2 * elementIndex + 2;
            }else{
                break;
            }
        }
    }

    public void add(int element){
        heap.add(element);

        int elementIndex = heap.size()-1;

        while(elementIndex > 0){
            int parent = (elementIndex - 1) / 2;

            if(heap.get(elementIndex) < heap.get(parent)){
                swap(elementIndex, parent);
                elementIndex = parent;
            }else{
                break;
            }
        }
    }

    public int pop(){
        if(heap.isEmpty()){
            throw new IllegalStateException("Heap is empty");
        }

        int current = heap.get(0);

        int lastElement = heap.remove(heap.size() - 1);

        if(!heap.isEmpty()){
            heap.set(0, lastElement);
            bubbleDown(0);
        }

        return current;
    }

    public int peek(){
        if(!heap.isEmpty()) return heap.get(0);
        else throw new IllegalStateException("Heap is empty");
    }

    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }

    public String printHeap(){
        return heap.toString();
    }
}