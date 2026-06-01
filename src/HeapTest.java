import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

public class HeapTest {

  @Test
  public void testAddOneValue() {
    Heap heap = new Heap();

    heap.addHeap(15);

    assertEquals("[15]", heap.getHeap().toString());
  }

  @Test
  public void testBubbleUpToRoot() {
    Heap heap = new Heap();
    
    heap.addHeap(14);
    heap.addHeap(5);

    assertEquals("[5, 14]", heap.getHeap().toString());
  }

  @Test
  public void testMultipleBubbleUps() {
    Heap heap = new Heap();

    heap.addHeap(15);
    heap.addHeap(9);
    heap.addHeap(5);

    assertEquals("[5, 15, 9]", heap.getHeap().toString());
  }

  @Test
  public void testNoBubbleUpsNeeded() {
    Heap heap = new Heap();

    heap.addHeap(2);
    heap.addHeap(12);

    assertEquals("[2, 12]", heap.getHeap().toString());
  }

  @Test
  public void testAlotOfBubbleUps() {
    Heap heap = new Heap();

    heap.addHeap(15);
    heap.addHeap(10);
    heap.addHeap(5);
    heap.addHeap(9);
    heap.addHeap(3);
    heap.addHeap(11);
    heap.addHeap(2);

    assertEquals("[2, 5, 3, 15, 9, 11, 10]", heap.getHeap().toString());
  }

  @Test
  public void testPeekHeapDoesntModifyElements() {
    Heap heap = new Heap();

    heap.addHeap(10);
    heap.addHeap(5);
    heap.addHeap(8);
    heap.addHeap(3);
    heap.addHeap(9);
    
    heap.peekHeap();

    ArrayList<Integer> expected = new ArrayList<>();
    expected.add(3);
    expected.add(5);
    expected.add(8);
    expected.add(10);
    expected.add(9);

    assertEquals(expected, heap.getHeap());
  }

  @Test
  public void testPeekEmptyHeapPrintsNegativeOne() {
    Heap heap = new Heap();

    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));

    System.out.println(heap.peekHeap());

    assertEquals("-1", output.toString().trim());

  }

  @Test
  public void testPeekPrintsRootValue() {
    Heap heap = new Heap();

    heap.addHeap(2);
    heap.addHeap(4);
    heap.addHeap(5);

    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));

    System.out.println(heap.peekHeap());

    assertEquals("2", output.toString().trim());

  }

  @Test
  public void testPopHeap(){
    Heap heap = new Heap();

    heap.addHeap(15);
    heap.addHeap(10);
    heap.addHeap(5);
    heap.addHeap(9);
    heap.addHeap(3);
    heap.addHeap(11);
    heap.addHeap(2);
    heap.popHeap();

    assertEquals("[3, 5, 10, 15, 9, 11]", heap.getHeap().toString());
  }

  @Test
  public void testPopSingle() {
      Heap heap = new Heap();
  
      heap.addHeap(5);
  
      heap.popHeap();
  
      assertEquals("[]", heap.getHeap().toString());
  }

  @Test
public void testPopTwo() {
    Heap heap = new Heap();

    heap.addHeap(10);
    heap.addHeap(5);

    heap.popHeap();

    assertEquals("[10]", heap.getHeap().toString());
}

@Test
public void testPopThree() {
    Heap heap = new Heap();

    heap.addHeap(10);
    heap.addHeap(5);
    heap.addHeap(3);

    heap.popHeap();

    assertEquals("[5, 10]", heap.getHeap().toString());
}

@Test
public void testPops() {
    Heap heap = new Heap();

    heap.addHeap(15);
    heap.addHeap(10);
    heap.addHeap(5);
    heap.addHeap(9);
    heap.addHeap(3);

    heap.popHeap();
    heap.popHeap();

    assertEquals("[9, 15, 10]", heap.getHeap().toString());
}

@Test
public void testPopLarge() {
    Heap heap = new Heap();

    heap.addHeap(20);
    heap.addHeap(15);
    heap.addHeap(10);
    heap.addHeap(5);
    heap.addHeap(3);
    heap.addHeap(8);
    heap.addHeap(1);

    heap.popHeap();

    assertEquals("[3, 5, 8, 20, 10, 15]", heap.getHeap().toString());
}

@Test
public void testPopWDuplicates() {
    Heap heap = new Heap();

    heap.addHeap(5);
    heap.addHeap(5);
    heap.addHeap(5);
    heap.addHeap(5);

    heap.popHeap();

    assertEquals("[5, 5, 5]", heap.getHeap().toString());
}



}
