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
    @Test 
    public void testOneElementIsRemovedFromHeap(){
        Heap heap = new Heap();
        heap.add(1);
        heap.pop();
        assertEquals(0, heap.size());
    }

    // ----- Tests for peek() ----- //


    // ----- Tests for size() ----- //

    // ----- Tests for isEmpty() ----- //
}
