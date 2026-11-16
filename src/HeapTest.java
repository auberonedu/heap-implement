import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class HeapTest {

    @Test
    public void testEmptyHeap() {
        Heap heap = new Heap();

        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void testAdd() {
        Heap heap = new Heap();

        heap.add(10);
        heap.add(5);
        heap.add(20);

        assertEquals(3, heap.size());
        assertEquals(5, heap.peek());
    }

    @Test
    public void testPeek() {
        Heap heap = new Heap();

        heap.add(8);
        heap.add(3);

        assertEquals(3, heap.peek());
        assertEquals(2, heap.size());
    }

    @Test
    public void testPop() {
        Heap heap = new Heap();

        heap.add(10);
        heap.add(4);
        heap.add(7);
        heap.add(2);

        assertEquals(2, heap.pop());
        assertEquals(4, heap.pop());
        assertEquals(7, heap.pop());
        assertEquals(10, heap.pop());

        assertTrue(heap.isEmpty());
    }

    @Test
    public void testNegativeNumbers() {
        Heap heap = new Heap();

        heap.add(-3);
        heap.add(5);
        heap.add(-8);

        assertEquals(-8, heap.pop());
        assertEquals(-3, heap.pop());
        assertEquals(5, heap.pop());
    }

    @Test
    public void testDuplicates() {
        Heap heap = new Heap();

        heap.add(5);
        heap.add(5);
        heap.add(2);

        assertEquals(2, heap.pop());
        assertEquals(5, heap.pop());
        assertEquals(5, heap.pop());
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekEmpty() {
        Heap heap = new Heap();
        heap.peek();
    }

    @Test(expected = IllegalStateException.class)
    public void testPopEmpty() {
        Heap heap = new Heap();
        heap.pop();
    }

}
