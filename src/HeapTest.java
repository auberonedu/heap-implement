import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {

    @Test
    public void testAdd() {
        Heap heap = new Heap();

        heap.add(10);
        heap.add(5);
        heap.add(2);
        heap.add(6);
        heap.add(20);
        heap.add(1);

        assertEquals(1, heap.peek());
    }
}
