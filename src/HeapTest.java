import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {
    @Test
    public void newHeapStartsEmpty() {

        Heap heap = new Heap();

        assertTrue(heap.isEmpty());

        assertEquals(0, heap.size());
    }

    @Test
    public void addOneValue() {

        Heap heap = new Heap();

        heap.add(5);

        assertFalse(heap.isEmpty());

        assertEquals(1, heap.size());

        assertEquals(5, heap.peek());
    }

    @Test
    public void peekReturnsSmallestValue() {

        Heap heap = new Heap();

        heap.add(10);
        heap.add(4);
        heap.add(7);

        assertEquals(4, heap.peek());

        assertEquals(3, heap.size());
    }

    @Test
    public void popReturnsValuesInOrder() {

        Heap heap = new Heap();

        heap.add(8);
        heap.add(3);
        heap.add(10);
        heap.add(1);
        heap.add(6);

        assertEquals(1, heap.pop());

        assertEquals(3, heap.pop());

        assertEquals(6, heap.pop());

        assertEquals(8, heap.pop());

        assertEquals(10, heap.pop());

        assertTrue(heap.isEmpty());
    }

    @Test
    public void handlesDuplicatesAndNegatives() {

        Heap heap = new Heap();

        heap.add(5);
        heap.add(-2);
        heap.add(5);
        heap.add(0);
        heap.add(-2);

        assertEquals(-2, heap.pop());

        assertEquals(-2, heap.pop());

        assertEquals(0, heap.pop());

        assertEquals(5, heap.pop());

        assertEquals(5, heap.pop());
    }
}
