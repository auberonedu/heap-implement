import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {
    @Test
    public void testIsEmpty() {
        Heap myHeap = new Heap();
        assertEquals(true, myHeap.isEmpty());
    }

    @Test
    public void testPeakSingleElementHeap() {
        Heap myHeap = new Heap();
        myHeap.addValue(1);
        assertEquals(1, myHeap.peek());
    }

    @Test
    public void testPeakMultipleElementHeap() {
        Heap myHeap = new Heap();
        myHeap.addValue(4);
        myHeap.addValue(2);
        myHeap.addValue(1);
        myHeap.addValue(5);
        assertEquals(1, myHeap.peek());
    }

    @Test
    public void testSizeMultipleElementHeap() {
        Heap myHeap = new Heap();
        myHeap.addValue(4);
        myHeap.addValue(2);
        myHeap.addValue(1);
        myHeap.addValue(5);
        assertEquals(4, myHeap.getSize());
    }


    @Test
    public void testHeapOrder() {
        /*
              1
             / \
            2   2
           / \
          3   4 
        */
        //Arrange
        Heap heap = new Heap();
        int[] order = new int[]{1,2,2,3,4};
        heap.addValue(1);
        heap.addValue(2);
        heap.addValue(2);
        heap.addValue(3);
        heap.addValue(4);
        
        for (int i = 0; i < heap.list.size(); i++) {
            //Act
            int Actual = heap.list.get(i);

            //assert
            assertEquals(Actual, order[i]);
        }
      
    }

    @Test
    public void testHeapPop() {
        //Arrange
        int[] expected = new int[]{2, 3, 2, 4};
        Heap heap = new Heap();
        
        heap.addValue(1);
        heap.addValue(2);
        heap.addValue(2);
        heap.addValue(3);
        heap.addValue(4);

        heap.pop();
        //Actual
        for(int i = 0; i < heap.list.size(); i++){
            int actual = heap.list.get(i);
            assertEquals(actual, expected[i]);
        }

        //Assert
        
    }
}
