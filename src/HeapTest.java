import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {
    @Test
    public void testAddingValues() {
        Heap heap = new Heap();

        heap.addingValue(5);
        heap.addingValue(3);
        heap.addingValue(8);
        heap.addingValue(1);

        assertEquals(4, heap.getSize());
    }

    @Test
    public void testNoValues() {
        Heap heap = new Heap();

        assertEquals(0, heap.getSize());

    }

    @Test
    public void testPeek() {
    Heap heap = new Heap();

    heap.addingValue(5);
    heap.addingValue(3);
    heap.addingValue(8);
    heap.addingValue(1);

    assertEquals(1, heap.peek());
    }

    @Test
    public void testPopInOrder() {
        Heap heap = new Heap();

        heap.addingValue(5);
        heap.addingValue(3);
        heap.addingValue(8);
        heap.addingValue(1);

        assertEquals(1, heap.popping());
        assertEquals(3, heap.popping());
        assertEquals(5, heap.popping());
        assertEquals(8, heap.popping());
    }

}
