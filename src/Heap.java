import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A min-heap implementation.
 */
public class Heap {
    private final List<Integer> heap;
    
    public Heap() {
        this.heap = new ArrayList<>();
    }

    public void add(int num) {
        heap.add(num);
        siftUp(heap.size() - 1);
    }

    public int pop() {   
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        int minValue = heap.get(0);
        int lastValue = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastValue);
            siftDown(0);
        }

        return minValue;
    }

    private int getParent(int idx) {
        return (idx - 1) / 2;
    }

    private int getLeftChild(int idx) {
        return idx * 2 + 1;
    }

    private int getRightChild(int idx) {
        return idx * 2 + 2;
    }

    private void siftUp(int idx) {
        while (idx > 0 && heap.get(idx) < heap.get(getParent(idx))) {
            int parentIdx = getParent(idx);
            swap(idx, parentIdx);
            idx = parentIdx; 
        }        
    }

    private void siftDown(int idx) {
        int size = heap.size();
        
        while (getLeftChild(idx) < size) {
            int smallestChildIdx = getLeftChild(idx);
            int rightChildIdx = getRightChild(idx);

            if (rightChildIdx < size && heap.get(rightChildIdx) < heap.get(smallestChildIdx)) {
                smallestChildIdx = rightChildIdx;
            }

            if (heap.get(idx) <= heap.get(smallestChildIdx)) {
                break;
            }

            swap(idx, smallestChildIdx);
            idx = smallestChildIdx;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public List<Integer> toList() {
        return new ArrayList<>(this.heap); 
}
}