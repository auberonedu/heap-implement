import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class HeapTest {
    // add()
    @Test
    public void testIfValueAdded() {
        Heap heap = new Heap();
        heap.add(2);
        assertEquals(2, heap.values().get(0).intValue());
    }

    @Test 
    public void testIfHeapSortsCorrectlyAfterAdd() {
        Heap heap = new Heap();
        heap.add(2);
        heap.add(1);

        assertEquals(2, heap.values().get(1).intValue());
        assertEquals(1, heap.values().get(0).intValue());
    }

    @Test
    public void testIfHeapSuccessfullyAddsTwoSameValues() {
        Heap heap = new Heap();
        heap.add(3);
        heap.add(3);

        assertTrue(heap.values().get(0).intValue() == heap.values().get(1).intValue());
    }

    @Test
    public void testIfHeapIsSortedCorrectlyAfterManyValuesAdded() {
        Heap heap = new Heap();
        int count = 0;

        for (int i = 5; i >= 1; i--) {
            heap.add(i);
            count++;
        }

        for (int i = 0; i < 5; i++) {
            if (i * 2 + 1 < count) {
                assertTrue(heap.values().get(i).intValue() <= heap.values().get(i * 2 + 1));
            }
            if (i * 2 + 2 < count) {
                assertTrue(heap.values().get(i).intValue() <= heap.values().get(i * 2 + 2));
            }
        }
    }

    // pop()
    @Test
    public void testIfValuePopped() {
        Heap heap = new Heap();
        heap.add(2);
        assertEquals(2, heap.pop());
    }

    @Test
    public void testIfMinimumValueIsRemovedAfterPopping() {
        Heap heap = new Heap();
        heap.add(2);
        heap.add(1);
        assertEquals(1, heap.pop());
    }

    @Test
    public void testIfMinimumValueIsPoppedEverytimeForABigHeap() {
        Heap heap = new Heap();

        for (int i = 20; i >= 1; i--) {
            heap.add(i);
        }

        for (int i = 1; i <= 20; i++) {
            assertEquals(i, heap.pop());
        }
    }

    @Test
    public void testExceptionThrownWhenTryingToPopAnEmptyHeap() {
        Heap heap = new Heap();

        assertThrows(NoSuchElementException.class, () -> heap.pop());
    }

    // peek()
    @Test
    public void testIfPeekReturnsTheSmallesValue() {
        Heap heap = new Heap();

        for (int i = 20; i >= 1; i--) {
            heap.add(i);
        }

        assertEquals(1, heap.peek());
    }

    @Test
    public void testExceptionThrownWhenTryingToPeekInAnEmptyHeap() {
        Heap heap = new Heap();

        assertThrows(NoSuchElementException.class, () -> heap.peek());
    }

    // isEmpty()
    @Test
    public void testIsEmptyOnAnEmptyHeap() {
        Heap heap = new Heap();

        assertTrue(heap.isEmpty());
    }

    @Test
    public void testIsEmptyOnAnNotEmptyHeap() {
        Heap heap = new Heap();
        heap.add(1);
        
        assertFalse(heap.isEmpty());
    }

    // size()
    @Test
    public void testSizeWithAHeapWithValues() {
        Heap heap = new Heap();

        for (int i = 1; i <= 10; i++) {
            heap.add(i);
        }

        assertEquals(10, heap.size());
    }

    @Test
    public void testSizeWithAnEmptyHeap() {
        Heap heap = new Heap();

        assertEquals(0, heap.size());
    }
}
