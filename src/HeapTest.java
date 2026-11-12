import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {

  @Test
  public void testPeekDoesNotRemoveElement() {
    Heap heap = new Heap();

    heap.add(10);

    assertEquals(10, heap.peek());


    assertEquals(10, heap.peek());
  }

  @Test
  public void testPopRemovesAndReturnsRoot() {
    Heap heap = new Heap();
    heap.add(5);


    int poppedValue = heap.pop();
    assertEquals(5, poppedValue);


    assertTrue(heap.isEmpty());
  }
}
