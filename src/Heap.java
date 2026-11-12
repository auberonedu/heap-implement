import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

  // backing array
  private final List<Integer> data;

  public Heap() {
    data = new ArrayList<>();
  }

  public void add(int value) {
    data.add(value);
    siftUp(data.size() - 1);
  }

  public int size() {
    return data.size();
  }

  public boolean isEmpty() {
    return data.isEmpty();
  }

  public int peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Heap is empty");
    }
    return data.get(0);
  }

  public int pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Heap is empty");
    }
    int root = data.get(0);
    int last = data.remove(data.size() - 1 );

    if (!data.isEmpty()) {
      data.set(0, last);
      siftDown(0);
    }

    return root;
  }

  /* private helpers */

  private int parent(int i) {
    return (i - 1) / 2;
  }

  private int leftChild(int i) {
    return 2 * i + 1;
  }

  private int rightChild(int i) {
    return 2 * i + 2;
  }

  private void swap(int i, int j) {
    int temp = data.get(i);
    data.set(i, data.get(j));
    data.set(j, temp);
  }

  private void siftUp(int i) {
    while(i > 0 && data.get(i) < data.get(parent(i))) {
      swap(i, parent(i));
      i = parent(i);
    }
  }

  private void siftDown(int i) {
    while(true) {
      int left = leftChild(i);
      int right = rightChild(i);
      int smallest = i;

      if(left < data.size() && data.get(left) < data.get(smallest)) {
        smallest = left;
      }

      if(right < data.size() && data.get(right) < data.get(smallest)) {
        smallest = right;
      }

      if(smallest == i) {
        return ;
      }

      swap(i, smallest);
      i = smallest;
    }
  }
}