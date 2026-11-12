import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Test;

public class HeapTest {

    @Test
    public void newHeapStartsEmpty() {
        Heap heap = new Heap();
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void addAndPeekReturnSmallestValue() {
        Heap heap = new Heap();
        heap.add(5);
        heap.add(3);
        heap.add(7);
        heap.add(1);

        assertEquals(1, heap.peek());
        assertEquals(4, heap.size());
        assertFalse(heap.isEmpty());
    }

    @Test
    public void popReturnsValuesInAscendingOrder() {
        Heap heap = new Heap();
        int[] values = {9, 4, 7, 1, 3, 8};

        for (int value : values) {
            heap.add(value);
        }

        int[] expected = {1, 3, 4, 7, 8, 9};

        for (int expectedValue : expected) {
            assertEquals(expectedValue, heap.pop());
        }

        assertTrue(heap.isEmpty());
    }

    @Test
    public void emptyHeapThrowsOnPeekAndPop() {
        Heap heap = new Heap();

        try {
            heap.peek();
            fail("Expected NoSuchElementException from peek on an empty heap");
        } catch (NoSuchElementException expected) {
            // expected
        }

        try {
            heap.pop();
            fail("Expected NoSuchElementException from pop on an empty heap");
        } catch (NoSuchElementException expected) {
            // expected
        }
    }
}
