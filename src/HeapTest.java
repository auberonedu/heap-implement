import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {

    @Test
    public void testAddDifferentOrder() {
        Heap<Integer> heap = new Heap<>();

        heap.add(10);
        heap.add(20);
        heap.add(5);

        assertEquals(3, heap.newHeap.size());
        assertEquals(Integer.valueOf(5), heap.newHeap.get(0));

        heap.add(15);

        assertEquals(4, heap.newHeap.size());
        assertEquals(Integer.valueOf(15), heap.newHeap.get(1));
    }

    @Test 
    public void testAddAllSameNumbers() {
        Heap<Integer> heap = new Heap<>();

        heap.add(1);
        heap.add(1);
        heap.add(1);

        assertEquals(3, heap.newHeap.size());
        assertEquals(Integer.valueOf(1), heap.newHeap.get(0));
    }

    @Test 
    public void testPop() {
        Heap<Integer> heap = new Heap<>();

        heap.add(1);
        heap.add(2);
        heap.add(3);

        assertEquals(3, heap.newHeap.size());
        
        heap.Pop();

        assertEquals(2, heap.newHeap.size());

        assertFalse(heap.newHeap.contains(1));
    }

    @Test
    public void testPopAll() {
        Heap<Integer> heap = new Heap<>();

        heap.add(1);
        heap.add(2);
        heap.add(3);

        heap.Pop();
        heap.Pop();
        heap.Pop();

        assertTrue(heap.newHeap.size() == 0);
    }
}
