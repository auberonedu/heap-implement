import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {

    @Test public void emptyHeap(){
        Heap heap = new heap();
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());

    }
}
