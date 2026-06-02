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
    private ArrayList<Integer> main;

    public Heap(Integer first) {
        main = new ArrayList<>();
        main.add(first);
    }
    public Heap() {
        main = new ArrayList<>();
    }

    public void add(int item) {
        if (size() == 0) {main.add(item); return;}
        main.add(item);
        int position = main.size()-1;
        while (position > 0) {
            int higher = (position - 1) / 2;
            if (main.get(position) >= main.get(higher)) break;

            int temp = main.get(position);
            main.set(position, main.get(higher));
            main.set(higher, temp);

            position = higher;
        }
    }

    public Integer pop() {
        if (size()==0) return null;
        if (size()==1) {
            int output = main.get(0);
            main.remove(0);
            return output;
        }

        int output = main.get(0);
        int position = 0;
        main.set(0, main.get(size()-1));
        main.remove(main.size() - 1);
        while (position < size()) {
            int left = 0;
            int right = 0;
            int swap = 0;
            if (2*position+1 < size()) {left = 2*position+1;}
            if (2*position+2 < size()) {right = 2*position+2;}

            if (left == 0 && right == 0) break;
            else if (left == 0) swap = right;
            else if (right == 0) swap = left;
            else if (main.get(left) <= main.get(right)) swap = left;
            else if (main.get(left) > main.get(right)) swap = right;

            if (main.get(position) <= main.get(swap)) break;
            else {
                int temp = main.get(swap); 
                main.set(swap, main.get(position)); 
                main.set(position, temp); 
                position = swap;
            }
        }
        return output;
    }

    public Integer peek() {
        if (size()==0) return null;
        return main.get(0);
    }

    public int size() {
        return main.size();
    }

    public boolean empty() {
        return main.size() == 0;
    }
}