import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {
    @Test
    public void testIsEmpty() {
        Heap myHeap = new Heap();
        assertEquals(true, myHeap.isEmpty());
    }
}
