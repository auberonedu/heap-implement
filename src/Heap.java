import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
  private final List<Integer> list = new ArrayList<>();

  public int peek() {
    return list.get(0);
  }

  public void pop() {
    int lastValue = list.remove(list.size() - 1);

    if (list.isEmpty()) {
      return;
    }
    if (!list.isEmpty()) {
      lastValue = list.set(0, lastValue);
      int currentIndex = 0;
      while (true) {
        int leftChildIndex = (2 * currentIndex) + 1;
        if (leftChildIndex >= list.size()) {
          break;
        }
        int rightChildIndex = (2 * currentIndex) + 2;
        int smallerChildIndex = leftChildIndex;
        if (rightChildIndex < list.size() && list.get(rightChildIndex) < list.get(leftChildIndex)) {
          smallerChildIndex = rightChildIndex;
        }

        if (list.get(currentIndex) <= list.get(smallerChildIndex)) {
          break;
        }

        int childValue = list.get(currentIndex);
        list.set(currentIndex, list.get(smallerChildIndex));
        list.set(smallerChildIndex, childValue);
        currentIndex = smallerChildIndex;
      }
      }
    }
  

  public int size() {
    return list.size();
  }

  public void add(int value) {
    list.add(value);
    int currentIndex = list.size() - 1;

    while (currentIndex > 0) {
      int parentIndex = (currentIndex - 1) / 2;

      if (list.get(currentIndex) < list.get(parentIndex)) {
        int childValue = list.get(currentIndex);
        list.set(currentIndex, list.get(parentIndex));
        list.set(parentIndex, childValue);
        currentIndex = parentIndex;
      } else {
        break;
      }
    }
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

}