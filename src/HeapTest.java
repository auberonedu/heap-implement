import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class HeapTest {

    @Test
    public void testHeapAddMethodWithoutNeedingSortedUsingPeek() {
        Heap minHeap = new Heap();

        minHeap.add(0);
        minHeap.add(1);

        int actual = minHeap.peek();

        assertEquals(0, actual);
    }

    @Test
    public void testHeapPopMethodWithoutNeedingSorted() {
        Heap minHeap = new Heap();

        minHeap.add(0);
        minHeap.add(1);

        int actual = minHeap.pop();

        assertEquals(0, actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopOnEmptyHeapThrows() {
        Heap heap = new Heap();
        heap.pop();
    }
     @Test
    public void peekReturnsSmallestWithoutRemoving() {
        Heap h = new Heap();
        h.add(5);
        h.add(2);
        h.add(8);

        assertEquals(2, h.peek());
        assertEquals(2, h.peek());
        assertEquals(3, h.size());
    }

    @Test
    public void peekUpdatesAfterAddAndPop() {
        Heap h = new Heap();

        h.add(10);
        assertEquals(10, h.peek());   

        h.add(4);
        assertEquals(4, h.peek());   

        h.add(7);
        assertEquals(4, h.peek());    

        h.pop();                      
        assertEquals(7, h.peek());   
}

    @Test(expected = NoSuchElementException.class)
    public void peekOnNewHeapThrows() {
        Heap h = new Heap();

        h.peek();
    }
    @Test
    public void testSizeMethod() {
        Heap heap = new Heap();
        heap.add(0);

        int actual = heap.size();

        assertEquals(1, actual);
    }

    @Test
    public void testIsEmptyMethod(){
        Heap heap = new Heap();
        heap.add(0);

        Boolean actual = heap.isEmpty();

        assertFalse(actual);
    }

    //AI REVIEW helped us come up with this one 
    // pop everything and check the sorted order
    @Test
    public void testPopAllReturnsSortedOrder() {
        Heap heap = new Heap();
        int[] input = {5, -3, 0, 9, 5, Integer.MAX_VALUE, Integer.MIN_VALUE, 2, -3, 7};
        int[] expected = {Integer.MIN_VALUE, -3, -3, 0, 2, 5, 5, 7, 9, Integer.MAX_VALUE};

        for (int value : input) {
            heap.add(value);
        }

        for (int value : expected) {
            assertEquals(value, heap.pop());
        }
        assertTrue(heap.isEmpty());
    }
}

   
