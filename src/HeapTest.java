import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {

    @Test
    public void testAdd() {
        Heap heap = new Heap();

        heap.add(10);
        heap.add(5);
        heap.add(2);
        heap.add(6);
        heap.add(20);
        heap.add(1);

        assertEquals(1, heap.peek());
    }

    @Test
    public void testPop() {
        Heap heap = new Heap();

        heap.add(10);
        heap.add(5);
        heap.add(2);
        heap.add(6);
        heap.add(20);
        heap.add(1);

        heap.pop();

        assertEquals(2, heap.peek());
    }

    @Test
    public void testPopSingleValue() {
        Heap heap = new Heap();

        heap.add(7);

        assertEquals(7, heap.pop());
        assertEquals(true, heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void testDuplicateValues() {
        Heap heap = new Heap();

        heap.add(7);
        heap.add(7);
        heap.add(5);
        heap.add(5);

        assertEquals(5, heap.pop());
        assertEquals(5, heap.pop());
        assertEquals(7, heap.pop());
        assertEquals(7, heap.pop());
    }
}
