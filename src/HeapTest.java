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

  @Test
  public void testSize() {
    Heap heap = new Heap();
    assertEquals(0, heap.size());

    heap.add(10);
    assertEquals(1, heap.size());

    heap.add(20);
    assertEquals(2, heap.size());

    heap.pop();
    assertEquals(1, heap.size());
  }

  @Test
  public void testAddKeepsMinimumAtRoot() {
    Heap heap = new Heap();

    heap.add(20);
    heap.add(5);
    heap.add(15);
    heap.add(10);

    assertEquals(5, heap.peek());
    assertEquals(4, heap.size());
  }
  @Test
public void testIsEmpty() {
    Heap heap = new Heap();
    assertTrue(heap.isEmpty());
    
    heap.add(1);
    assertFalse(heap.isEmpty());
    
    heap.pop();
    assertTrue(heap.isEmpty());
}
}