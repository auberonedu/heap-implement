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

    private ArrayList<Integer> heap;

    public Heap(){
        heap = new ArrayList<>();
    }

    /**
     * Provides access to the heap's internal structure for JUnit testing.
     */
    public ArrayList<Integer> getHeap() {
        return heap;
    }

    /**
     * Adds a value to a min heap and bubbles the value up till min heap contract is satisfied
     * @param value
     */
	public void addHeap(int value){
        // add value to the heap (next open spot at the left side of the tree)
        heap.add(value);
        // get the index of the value just added
        int currentIndex = heap.size() - 1;
        // get the parent index of the value just added
        int parentIndex = (currentIndex - 1) / 2;

        // if current index is equal to 0, currentIndex is the root index
        if (currentIndex == 0) return;
        
        // loop while parent value is greater than current value
        while (heap.get(parentIndex) > heap.get(currentIndex)) {
            int currentVal = heap.get(currentIndex);
            // use set method to move parent value into current index
            heap.set(currentIndex, heap.get(parentIndex));
            // use set method to move current value into parent index
            heap.set(parentIndex, currentVal);
            // change current index to parent index (the value that just bubbled up is now in the parents position)
            currentIndex = parentIndex;
            // recalculate parent index
            parentIndex = (currentIndex - 1) / 2;
        }
    }

    // used to print out heap for debug
    public void printHeap(){
        System.out.println(heap);
    }

    // look at 0 index
    public void peekHeap(){
        if (heap.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(heap.get(0));
        }
    }

    // remove num at top of heap/at 0 index
    public void popHeap(){
 
        // check if empty
        if (heap.isEmpty()) {
            return;
        }

        // the new root value is the last value added to array
        int newRoot = heap.get(heap.size() - 1);

        // start index at 0
        int index = 0;

        // remove last element
        heap.remove(heap.size()- 1);

        // return if empty
        if (heap.isEmpty()) {
            return;
        }

        // set the root value to the value of the last item in array if its not empty
        if(heap.size() > 0){
            heap.set(0, newRoot);
        }
        

        // get index of left and right child
        int leftChild = (index * 2) + 1;
        int rightChild = (index * 2) + 2;

        // keep looping if the parent value is greater than the child values
        // the leftchild should be filled before right child so check the leftchild index here
        while (leftChild < heap.size()){

            // used to find which path to take
            int pathIndex;

            // decides which path to take from left or right child . also checks if there is a right child 
            if(rightChild < heap.size() && heap.get(rightChild) < heap.get(leftChild)){
                pathIndex = rightChild;
            } else{
                // no right child so set path to the left 
                pathIndex = leftChild;
            }

            // path value of the path index depending on right or left child
            int pathValue = heap.get(pathIndex);


            // is the index value greater than the path child
            if(heap.get(index) > pathValue){
                // if so the child gets moved up to parent
                heap.set(index, pathValue);
                // the parent gets moved down to child
                heap.set(pathIndex, newRoot);
                // the new index was the child index that was being replaced
                index = pathIndex;
                
                // recalucalet child indexes
                leftChild = (index * 2) + 1;
                rightChild = (index * 2) + 2;
            } else{
                // if all good then leave the loop
                break;
            }
            }
        }

    

    // get size of heap
    public void sizeHeap(){
        System.out.println(heap.size());
    }

    // check if heap is empty
    public void emptyHeap(){
        System.out.println(heap.isEmpty());
    }

    
  
}