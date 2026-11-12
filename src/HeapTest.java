import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {

    // ----- Tests for add() ----- //
    @Test 
    public void testOneElementIsAddedToHeap(){
        Heap heap = new Heap();
        heap.add(1);
        assertEquals(1, heap.size());
    }

    // ----- Tests for pop() ----- //


    // ----- Tests for peek() ----- //


    // ----- Tests for size() ----- //
    @Test 
    public void testHeapHasOneElement(){
        Heap heap = new Heap();
        heap.add(1);
        assertEquals(1, heap.size());
    }

    // ----- Tests for isEmpty() ----- //
}
