import java.util.List;
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
    public List<Integer> list;
    private int leftChildIndex(int index) { return (2 * index) + 1;};
    private boolean leftChildExists(int index) { boolean bool = leftChildIndex(index) < list.size() ? true : false; return bool;}
    private boolean rightChildExists(int index) { boolean bool = rightChildIndex(index) < list.size() ? true : false; return bool;}
    private int rightChildIndex(int index) { return (2 * index) + 2;};
    private int getParentIndex(int index) { return (index - 1) / 2;};

    

    public Heap() {
        this.list = new ArrayList<>();
    }

    public void addValue(int value){
        list.add(value);
        if(list.size() == 1) return;
        int lastInd = list.size() - 1;
        while(list.get(lastInd) < list.get((lastInd - 1) / 2)) {
            int parentVal = list.get((lastInd - 1) / 2);
            list.set((lastInd - 1) / 2, list.get(lastInd)); // set parent with last item added
            list.set(lastInd, parentVal);  // set last item added value to parent value (swap)
            lastInd = list.size() - 1;
        }
    }

    
    public void pop() {
        /* 
                2           1
              1   -1    -> 2   1
            2  2  2     2  2  2
        */

        // 1 2 2 3 4
        /*
              2
            3   2 
           4 
           
           2 3 2 4
        */
        //Left child: 2i + 1

        
        if(list.size() == 0) return;
        int end = list.get(list.size() - 1);
        int index = 0;
        // swap the last value in and remove it
        list.set(0, end);
        list.remove(list.size() - 1);
        
        
        popHelperMethod(index);
        
        
    }

    private void popHelperMethod(int index){
        // while the leftChildExists keep going
        while (leftChildExists(index)) {
           int nextLeftChild = list.get(leftChildIndex(index));

           // if the right child doesnt exist place max value so it so the if statment will default to false
           int nextRightChild = rightChildExists(index) ? list.get(rightChildIndex(index)) : Integer.MAX_VALUE;
           
           //swap and move elements/index based <=
           if(nextRightChild < nextLeftChild) {
            list.set(rightChildIndex(index), list.get(index));
            list.set(index, nextRightChild);
            index = rightChildIndex(index);
           } else {
            list.set(leftChildIndex(index), list.get(index));
            list.set(index, nextLeftChild);
            index = leftChildIndex(index);
           }
          
        }
    }

    public int peek() {
        return this.list.get(0);
    }

    public int getSize() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void printHeap(){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        /*
                2       
              1   1
            2  2  2     
        */
        // Heap heap = new Heap();
        // heap.addValue(0);
        // heap.addValue(1);
        // heap.addValue(1);
        // heap.addValue(2);
        // heap.addValue(2);
        // heap.addValue(2);
        // heap.addValue(2);

       

        // /*
        //       2
        //     1   1
        //    2 2 2
        // */
        // //2
        // //1
        // //1
        // //2
        // //2
        // //2


        // heap.pop();
        // System.out.println();
        // heap.printHeap();

        //     1
        //  2     1
        // 2 2   2 

        Heap heap2 = new Heap();
        heap2.addValue(1);
        heap2.addValue(2);
        heap2.addValue(2);
        heap2.addValue(3);
        heap2.addValue(4);

        /*
        4
        2
        2
        3
        

         2
        3 2
       4

        2 3 2 4
        */

        System.out.println();
        heap2.pop();
        heap2.printHeap();
    }
}