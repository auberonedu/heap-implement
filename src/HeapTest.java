import static org.junit.Assert.*;
import org.junit.Test;
import java.util.NoSuchElementException;

public class HeapTest {

    @Test
    public void HeapIsEmpty() {
        Heap heap = new Heap();
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void peekOnEmptyHeapThrows() {
        new Heap().peek();
    }

    // tests for add
    @Test
    public void addOneElement() {
        Heap heap = new Heap();
        heap.add(7);
        assertFalse(heap.isEmpty());
        assertEquals(1, heap.size());
        assertEquals(7, heap.peek());
    }

    @Test
    public void peekGiveMinimum() {
        Heap heap = new Heap();
        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);
        heap.add(4);
        assertEquals(1, heap.peek());
    }

    @Test
    public void addingSmallerValueBecomeFront() {
        Heap heap = new Heap();
        heap.add(10);
        assertEquals(10, heap.peek());
        heap.add(4);
        assertEquals(4, heap.peek());
        heap.add(6);
        assertEquals(4, heap.peek());
        heap.add(-1);
        assertEquals(-1, heap.peek());
    }

    @Test
    public void peekDoesNotRemove() {
        Heap heap = new Heap();
        heap.add(2);
        heap.add(9);
        assertEquals(2, heap.peek());
        assertEquals(2, heap.peek());
        assertEquals(2, heap.size());
    }

     @Test
    public void popOnEmptyHeapThrow() {
        Heap heap = new Heap();
        try {
            heap.pop();
            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
        }
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void peekAfterEmptyingHeapThrow() {
        Heap heap = new Heap();
        heap.add(5);
        heap.pop();
        try {
            heap.peek();
            fail("Expected NoSuchElementException");
        // expected this down here
        } catch (NoSuchElementException e) {
        }
}

    @Test
    public void popsInSortedOrder() {
        Heap heap = new Heap();
        heap.add(1);
        heap.add(2);
        heap.add(3);
        assertEquals(1, heap.pop());
        assertEquals(2, heap.pop());
        assertEquals(3, heap.pop());
    }
}
