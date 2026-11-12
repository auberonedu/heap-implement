import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {

    @Test public void emptyHeap(){
        Heap heap = new Heap();
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());

    }

    @Test
    public void addIncreaseSize(){
        Heap heap = new Heap();
        heap.add(5);
        heap.add(3);
        heap.add(9);
        assertEquals(3,heap.size());
        assertFalse(heap.isEmpty());
    }

    @Test
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
}
