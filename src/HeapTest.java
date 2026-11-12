import static org.junit.Assert.*;
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
}
