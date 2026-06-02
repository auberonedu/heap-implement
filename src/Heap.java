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
    static ArrayList<Integer> main;

    Heap(Integer first) {
        main = new ArrayList<>();
        main.add(first);
    }
    Heap() {
        main = new ArrayList<>();
    }

    public static void add(Integer item) {
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

    public static Integer pop() {
        if (size()==0) return null;
        int output = main.get(0);
        int position = 0;
        while (position<main.size()-1) {
            main.set(position, main.get(position+1));
            position++;
        }
        main.remove(main.size() - 1);
        return output;
    }

    public static Integer peek() {
        if (size()==0) return null;
        return main.get(0);
    }

    public static Integer size() {
        return main.size();
    }

    public static Boolean empty() {
        if (main.size() == 0) return true;
        else return false;
    }
}