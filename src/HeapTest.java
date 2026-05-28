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

    @Test
    public void testNegativeValues() {
        Heap heap = new Heap();

        heap.add(-4);
        heap.add(-9);
        heap.add(0);
        heap.add(1);

        assertEquals(-9, heap.pop());
        assertEquals(-4, heap.pop());
        assertEquals(0, heap.pop());
        assertEquals(1, heap.pop());
    }

    @Test 
    public void testPeek() {
        Heap heap = new Heap();

        heap.add(5);
        heap.add(7);
        heap.add(2);

        assertEquals(2, heap.peek());
    }

    @Test
    public void testSize() {
        Heap heap = new Heap();

        heap.add(1);
        heap.add(3);
        heap.add(5);
        heap.add(7);
        heap.add(9);
        heap.add(11);

        assertEquals(6, heap.size());
    }

    @Test
    public void testSizeSingleValue() {
        Heap heap = new Heap();

        heap.add(0);

        assertEquals(1, heap.size());
    }

    @Test
    public void testHeapIsEmpty() {
        Heap heap = new Heap();

        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
    }
}
