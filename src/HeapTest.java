import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {

    @Test public void emptyHeap(){
        Heap heap = new heap();
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
}
