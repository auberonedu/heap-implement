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
    public void addOneItemChangesSize() {
        Heap heap = new Heap();

        heap.add(10);

        assertFalse(heap.isEmpty());
        assertEquals(1, heap.size());
    }

     @Test
    public void peekReturnsSmallestItem() {
        Heap heap = new Heap();

        heap.add(10);
        heap.add(5);
        heap.add(20);

        assertEquals(5, heap.peek());
        assertEquals(3, heap.size());
    }

    @Test
    public void popReturnsSmallestItem() {
        Heap heap = new Heap();

        heap.add(10);
        heap.add(5);
        heap.add(20);

        assertEquals(5, heap.pop());
        assertEquals(2, heap.size());
    }

    @Test
    public void popReturnsItemsInSortedOrder() {
        Heap heap = new Heap();

        heap.add(30);
        heap.add(10);
        heap.add(20);
        heap.add(5);

        assertEquals(5, heap.pop());
        assertEquals(10, heap.pop());
        assertEquals(20, heap.pop());
        assertEquals(30, heap.pop());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void peekOnEmptyHeapThrowsException() {
        Heap heap = new Heap();

        assertThrows(IllegalStateException.class, () -> {
            heap.peek();
        });
    }

    @Test
    public void popOnEmptyHeapThrowsException() {
        Heap heap = new Heap();

        assertThrows(IllegalStateException.class, () -> {
            heap.pop();
        });
    }
}
