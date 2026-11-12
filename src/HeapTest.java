import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class HeapTest {

    @Test
    public void smallHeapPeek(){
        Heap heap = new Heap();
        heap.add(10);
        heap.add(1);
        assertEquals(1, heap.peek());
    }

    @Test
    public void smallHeapPop(){
        Heap heap = new Heap();
        heap.add(10);
        heap.add(1);
        assertEquals(1, heap.peek());
        assertEquals(1, heap.pop());
        assertEquals(10, heap.pop());
    }

    @Test 
    public void largeHeapTest(){
        Heap heap = new Heap();
        Random r = new Random();
        for(int i = 0; i < 10000; i++){
            heap.add(r.nextInt());
        }
        int current = heap.pop();
        while(!heap.isEmpty()){
            assertTrue(current < heap.peek());
            current = heap.pop();
        }
    }

    @Test 
    public void testSize(){
        Heap heap = new Heap();
        for(int i = 0; i < 100; i++){
            heap.add(i);
        }
        assertEquals(100, heap.size());
        heap.pop();
        assertEquals(99, heap.size());
    }

    @Test public void testIsEmpty(){
        Heap heap = new Heap();
        assertTrue(heap.isEmpty());
        heap.add(1);
        assertFalse(heap.isEmpty());
        heap.pop();
        assertTrue(heap.isEmpty());
    }


}
