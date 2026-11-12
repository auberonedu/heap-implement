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

    @Test
    public void testHeapPopMethodWithoutNeedingSorted() {
        Heap minHeap = new Heap();

        minHeap.add(0);
        minHeap.add(1);

        int actual = minHeap.pop();

        assertEquals(0, actual);
    }
     @Test
    public void peekReturnsSmallestWithoutRemoving() {
        Heap h = new Heap();
        h.add(5);
        h.add(2);
        h.add(8);

        assertEquals(2, h.peek());
        assertEquals(2, h.peek());
        assertEquals(3, h.size());
    }

    @Test
    public void peekUpdatesAfterAddAndPop() {
        Heap h = new Heap();

        h.add(10);
        assertEquals(10, h.peek());   

        h.add(4);
        assertEquals(4, h.peek());   

        h.add(7);
        assertEquals(4, h.peek());    

        h.pop();                      
        assertEquals(7, h.peek());   
}
    @Test
    public void testSizeMethod() {
        Heap heap = new Heap();
        heap.add(0);

        int actual = heap.size();

        assertEquals(1, actual);
    }

    @Test
    public void testIsEmptyMethod(){
        Heap heap = new Heap();
        heap.add(0);

        Boolean actual = heap.isEmpty();

        assertFalse(actual);
    }



}

   
