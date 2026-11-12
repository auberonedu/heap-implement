import java.util.ArrayList;
import java.util.List;

/**
 * A min-heap.
 * 
 * Must contain functionality for the following: (n = # of elements in heap)
 * 
 * Adding a new value to the heap O(log(n))
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
 * - name methods
 * - determine return value and argument types
 * - hold private instance variables
 */
public class Heap {
  private List<Integer> list = new ArrayList<>();

  public int peek() {
    return list.get(0);
  }

  public int pop() {
    int minValue = list.get(0);
    int lastValue = list.remove(list.size() - 1);

    if (list.isEmpty()) {
    return minValue;

    
}

    if (!list.isEmpty()) {
      lastValue = list.set(0, lastValue);
      int currentIndex = 0;
      int leftChildIndex = (2 * currentIndex) + 1;
      int rightChildIndex = (2 * currentIndex) + 2;
      int smallerChildIndex = leftChildIndex;
      while (leftChildIndex < list.size()) {
        if (list.get(leftChildIndex) < list.get(rightChildIndex)) {
          smallerChildIndex = rightChildIndex;
        }
        if (list.get(currentIndex) > list.get(smallerChildIndex)) {
          currentIndex = smallerChildIndex;
        }
        break;
      }
    }
    return minValue;
  }

  public int size() {
    return list.size();
  }

  public int add(int value) {
    list.add(value);
    int currentIndex = list.size() - 1;

    while (currentIndex > 0) {
      int parentIndex = (currentIndex - 1) / 2;

      if (list.get(currentIndex) < list.get(parentIndex)) {
        currentIndex = parentIndex;
      } else {
        break;
      }
    }
    return value;
  }

  public boolean isEmpty() {
    if (list.size() == 0) {
      return true;
    } else {
      return false;
    }
  }

}