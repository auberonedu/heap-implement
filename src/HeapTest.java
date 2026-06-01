import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class HeapTest {

    @Test
    public void testAddDifferentOrder() {
        Heap<Integer> heap = new Heap<>();

        heap.add(10);
        heap.add(20);
        heap.add(5);
        heap.add(15);

        assertEquals(4, heap.size());
        assertEquals(Integer.valueOf(5), heap.peek());
    }

    @Test 
    public void testAddAllSameNumbers() {
        Heap<Integer> heap = new Heap<>();

        heap.add(1);
        heap.add(1);
        heap.add(1);

        assertEquals(3, heap.size());
        assertEquals(Integer.valueOf(1), heap.peek());
    }

    @Test 
    public void testPop() {
        Heap<Integer> heap = new Heap<>();

        heap.add(1);
        heap.add(2);
        heap.add(3);

        assertEquals(Integer.valueOf(1), heap.pop());
        assertEquals(2, heap.size());
        assertEquals(Integer.valueOf(2), heap.peek());
    }

    @Test
    public void testPopAll() {
        Heap<Integer> heap = new Heap<>();

        heap.add(1);
        heap.add(2);
        heap.add(3);

        assertEquals(Integer.valueOf(1), heap.pop());
        assertEquals(Integer.valueOf(2), heap.pop());
        assertEquals(Integer.valueOf(3), heap.pop());

        assertTrue(heap.isEmpty());
    }

    @Test
    public void testPeek() {
        Heap<Integer> heap = new Heap<>();

        heap.add(1);
        heap.add(2);
        heap.add(3);

        assertEquals(Integer.valueOf(1), heap.peek());
        assertEquals(3, heap.size());
    }

    @Test
    public void testPeekException() {
        Heap<Integer> heap = new Heap<>();
        assertThrows(NoSuchElementException.class, heap::peek);
    }

    @Test
    public void testSize() {
        Heap<Integer> heap = new Heap<>();

        heap.add(1);
        heap.add(2);
        heap.add(3);

        assertEquals(3, heap.size());
    }

    @Test
    public void testSizeZero() {
        Heap<Integer> heap = new Heap<>();

        assertEquals(0, heap.size());
    }

    @Test
    public void testIsEmptyWhenZero() {
        Heap<Integer> heap = new Heap<>();

        assertTrue(heap.isEmpty());
    }

    @Test
    public void testIsEmptyWhenNotZero() {
        Heap<Integer> heap = new Heap<>();

        heap.add(1);
        heap.add(2);
        heap.add(3);

        assertFalse(heap.isEmpty());
    }

    @Test
    public void testPopSingleElementReturnsElement() {
        Heap<Integer> heap = new Heap<>();

        heap.add(42);
        assertEquals(Integer.valueOf(42), heap.pop());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testPopOnEmptyThrows() {
        Heap<Integer> heap = new Heap<>();

        assertThrows(NoSuchElementException.class, heap::pop);
    }
}
