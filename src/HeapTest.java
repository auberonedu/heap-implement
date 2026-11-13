import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {
    @Test 
    public void newHeapIsEmpty() {
        Heap heap = new Heap();

        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }
    @Test 
    public void addingElementsUpdatesSize() {
        Heap heap = new Heap();

        heap.add(10);
        heap.add(20);
        heap.add(5);

        assertEquals(3, heap.size());
        assertFalse(heap.isEmpty());

    }

    @Test 
    public void peekReturnsSmallestElement() {
        Heap heap = new Heap();
        heap.add(10);
        heap.add(5);
        heap.add(20);
        heap.add(2);

        assertEquals(2, heap.peek());
        assertEquals(4, heap.size());
    }

    @Test 
    public void popReturnsELementsInAscendingOrder() {
        Heap heap = new Heap();
        heap.add(10);
        heap.add(5);
        heap.add(20);
        heap.add(2);


        assertEquals(2, heap.pop());
        assertEquals(5, heap.pop());
        assertEquals(10, heap.pop());
        assertEquals(20, heap.pop());

        assertTrue(heap.isEmpty());
    }

    @Test 
    public void peekDoesNotRemoveelement() {
        Heap heap = new Heap();

        heap.add(7);

        assertEquals(7, heap.peek());
        assertEquals(7, heap.peek());
        assertEquals(1, heap.size());

    }
}
