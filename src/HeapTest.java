import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class HeapTest {

    // new heap starts empty and size is 0.
    @Test
    public void HeapIsEmpty() {
        Heap heap = new Heap();
        
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    // test for adding one element
     @Test
    public void testAddOneElement() {
       Heap heap = new Heap();

       heap.add(8);

      assertEquals(1, heap.size());
      assertEquals(8, heap.peek());

}

    // Tests multiple elements when u add several numbers.
    @Test
    public void testAddMultipleElements() {
    Heap heap = new Heap();

    heap.add(12);
    heap.add(5);
    heap.add(9);

    assertEquals(5, heap.peek());
    assertEquals(3, heap.size());
}

    // pop removes and returns the smallest number
    @Test
    public void testPop() {
    Heap heap = new Heap();

    heap.add(10);
    heap.add(3);
    heap.add(7);

    assertEquals(3, heap.pop());
    assertEquals(2, heap.size());
}

    // Tests negative number
    @Test
    public void testAddNegativeElement() {
    Heap heap = new Heap();

    heap.add(4);
    heap.add(-6);
    heap.add(2);

    assertEquals(-6, heap.peek());
}

// AI Helped create these additional test

// Tests duplicate values
@Test
public void testDuplicateNumbers() {
    Heap heap = new Heap();

    heap.add(4);
    heap.add(4);
    heap.add(4);

    assertEquals(4, heap.pop());
    assertEquals(4, heap.pop());
    assertEquals(4, heap.pop());
}

// Tests single element heap
@Test
public void testSingleElementHeap() {
    Heap heap = new Heap();

    heap.add(7);
    assertEquals(7, heap.pop());

    assertTrue(heap.isEmpty());
}

// Tests  empty heap exceptions
@Test
public void testEmptyHeap() {
    Heap heap = new Heap();

    assertThrows(NoSuchElementException.class, () -> heap.pop());
    assertThrows(NoSuchElementException.class, () -> heap.peek());
}

// Tests duplicate values with different numbers
@Test
public void testDuplicateWithDifferentNumbers() {
    Heap heap = new Heap();

    heap.add(5);
    heap.add(3);
    heap.add(5);

    assertEquals(3, heap.pop());
    assertEquals(5, heap.pop());
    assertEquals(5, heap.pop());

    assertTrue(heap.isEmpty());
}

// Tests multiple negative numbers
@Test
public void testMultipleNegativeNumbers() {
    Heap heap = new Heap();

    heap.add(-10);
    heap.add(5);
    heap.add(-20);

    assertEquals(-20, heap.pop());
    assertEquals(-10, heap.pop());
    assertEquals(5, heap.pop());

    assertTrue(heap.isEmpty());
}

// Tests adding and removing elements multiple times
@Test
public void testRepeatedAddAndPop() {
    Heap heap = new Heap();

    heap.add(10);
    heap.add(4);
    heap.add(15);
    heap.add(2);

    assertEquals(2, heap.pop());
    assertEquals(4, heap.pop());

    heap.add(1);
    heap.add(8);

    assertEquals(1, heap.pop());
    assertEquals(8, heap.pop());
    assertEquals(10, heap.pop());
    assertEquals(15, heap.pop());

    assertTrue(heap.isEmpty());
}

// Tests that peek does not remove an element
@Test
public void testPeekDoesNotRemove() {
    Heap heap = new Heap();

    heap.add(10);
    heap.add(3);
    heap.add(7);

    assertEquals(3, heap.peek());
    assertEquals(3, heap.peek());
    assertEquals(3, heap.size());

    assertEquals(3, heap.pop());
    assertEquals(2, heap.size());
}


}
