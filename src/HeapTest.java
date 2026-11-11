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
 

}
