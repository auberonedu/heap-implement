import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {

    // ----- Tests for add() ----- //
    @Test 
    public void testAddOneElementToHeap(){
        Heap heap = new Heap();
        heap.add(1);
        assertEquals(1, heap.size());
    }

    @Test 
    public void testAddMultipleElementToHeapWithMinAtTop(){
        Heap heap = new Heap();
        heap.add(1);
        assertEquals(1, heap.size());
    }

    // ----- Tests for pop() ----- //
    @Test 
    public void testPopOneElementFromHeap(){
        Heap heap = new Heap();
        heap.add(1);
        heap.pop();
        assertEquals(0, heap.size());
    }

    // ----- Tests for peek() ----- //
    @Test 
    public void testPeeksShowsOneElement(){
        Heap heap = new Heap();
        heap.add(127);
        assertEquals(127, heap.peek());
    }

    @Test 
    public void testPeekShowsMinElementWithMultipleElementsAddedAfterMin(){
        Heap heap = new Heap();
        heap.add(127);
        heap.add(130);
        heap.add(140);
        assertEquals(127, heap.peek());
    }

    @Test 
    public void testPeekShowsMinElementWithMultipleElementsAdded(){
        Heap heap = new Heap();
        heap.add(130);
        heap.add(127);
        heap.add(140);
        assertEquals(127, heap.peek());
    }

    // ----- Tests for size() ----- //
    @Test 
    public void testSizeOfSmallHeap(){
        Heap heap = new Heap();
        heap.add(1);
        heap.add(2);
        heap.add(3);
        assertEquals(3, heap.size());
    }

    @Test 
    public void testSizeOfEmptyHeap(){
        Heap heap = new Heap();
        assertEquals(0, heap.size());
    }

    // ----- Tests for isEmpty() ----- //
    @Test 
    public void testHeapIsNotEmpty(){
        Heap heap = new Heap();
        heap.add(1);
        heap.add(2);
        heap.add(3);
        assertFalse(heap.isEmpty());
    }

    @Test 
    public void testHeapIsEmpty(){
        Heap heap = new Heap();
        assertTrue(heap.isEmpty());
    }
}
