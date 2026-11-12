import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {
    @Test
    public void testEmptyAndSize() {
        Heap heap = new Heap();
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekEmptyThrowsException() {
        Heap heap = new Heap();
        heap.peek();
    }

    @Test
    public void testInsertAndPeekMin() {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        assertEquals(5, heap.peek());
        assertEquals(3, heap.size());
    }
}
