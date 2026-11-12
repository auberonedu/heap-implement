import static org.junit.Assert.*;
import org.junit.Test;


public class HeapTest {

    @Test
    void isEmptyReturnsTrueForNewHeapAndFalseAfterAdding() {
        Heap heap = new Heap();
        assertTrue(heap.isEmpty());

        heap.add(10);
        assertFalse(heap.isEmpty());
    }

}
