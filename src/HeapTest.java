import static org.junit.Assert.*;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class HeapTest {

     @Test
    public void newHeapIsEmpty() {
        Heap h = new Heap();
        assertTrue(h.isEmpty());
        assertEquals(0, h.size());
    }
 
    @Test
    public void addOneElement() {
        Heap h = new Heap();
        h.add(5);
        assertFalse(h.isEmpty());
        assertEquals(1, h.size());
        assertEquals(5, h.peek());
    }

     @Test
    public void peekDoesNotRemove() {
        Heap h = new Heap();
        h.add(3);
        h.add(1);
        assertEquals(1, h.peek());
        assertEquals(1, h.peek());
        assertEquals(2, h.size());
    }
 
    @Test
    public void peekTracksMinimumAsValuesAdded() {
        Heap h = new Heap();
        h.add(10);
        assertEquals(10, h.peek());
        h.add(20);
        assertEquals(10, h.peek());
        h.add(5);
        assertEquals(5, h.peek());
    }
 
      @Test
    public void popReturnsValuesInSortedOrder() {
        Heap h = new Heap();
        int[] input = {7, 3, 9, 1, 5, 8, 2};
        for (int v : input) {
            h.add(v);
        }
        int[] expected = {1, 2, 3, 5, 7, 8, 9};
        for (int e : expected) {
            assertEquals(e, h.pop());
        }
        assertTrue(h.isEmpty());
    }
 
    @Test
    public void popDecrementsSize() {
        Heap h = new Heap();
        h.add(1);
        h.add(2);
        h.pop();
        assertEquals(1, h.size());
    }
@Test
    public void popOnSingleElementEmptiesHeap() {
        Heap h = new Heap();
        h.add(42);
        assertEquals(42, h.pop());
        assertTrue(h.isEmpty());
    }
}
