import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {

    @Test public void emptyHeap(){
        Heap heap = new Heap();
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());

    }

    @Test(expected = IllegalStateException.class)
    public void addIncreaseSize(){
        Heap heap = new Heap();
        heap.add(5);
        heap.add(3);
        heap.add(9);
        assertEquals(3,heap.size());
        assertFalse(heap.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void popReturnsMinAndRemovesIt() {
        Heap heap = new Heap();
        heap.add(5);
        heap.add(1);
        heap.add(3);
        assertEquals(1, heap.pop());
        assertEquals(2, heap.size());
        assertEquals(3, heap.peek());
    }

    @Test
    public void popOnEmptyHeapThrows() {
        Heap heap = new Heap();
        heap.pop();
    }

    @Test
    public void peekOnEmpty(){
        Heap heap = new Heap();
        heap.peek();
    }

    @Test
    public void peekDoesNotRemove() {
    Heap heap = new Heap();
    heap.add(8);
    heap.add(3);
    heap.add(5);

    // Your assertions go here
    assertEquals(3,heap.peek());
    assertEquals(3,heap.size());
    }

    @Test
    public void popReturnsSortedOrder() {
        Heap heap = new Heap();
        heap.add(8);
        heap.add(3);
        heap.add(5);
        heap.add(1);

        assertEquals(1,heap.pop());
        assertEquals(3,heap.size());

        assertEquals(3, heap.pop());
        assertEquals(5, heap.pop());
        assertEquals(5, heap.pop());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void duplicateValues() {
    Heap heap = new Heap();
    heap.add(4);
    heap.add(2);
    heap.add(4);
    heap.add(2);

    assertEquals(2, heap.pop());
    assertEquals(2, heap.pop());
    assertEquals(4, heap.pop());
    assertEquals(4, heap.pop());
    assertTrue(heap.isEmpty());
}

    @Test
    public void negativeValues() {      
    Heap heap = new Heap();
    heap.add(5);
    heap.add(-3);
    heap.add(0);
    heap.add(-8);
    assertEquals(-8, heap.pop());
    assertEquals(-3, heap.pop());
    assertEquals(0, heap.pop());
    assertEquals(-3, heap.pop());
    assertEquals(5, heap.pop());
    assertTrue(heap.isEmpty());
}
}
