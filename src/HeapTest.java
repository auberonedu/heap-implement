import static org.junit.Assert.*;
import org.junit.Test;
public class HeapTest {



    @Test
    public void CheckNumberOrderTest() {
        Heap heap = new Heap();

        heap.add(3);
        heap.add(2);
        heap.add(5);
        heap.add(1);
        heap.add(4);

        int[] actual = new int[5];
        actual[0] = heap.pop();
        actual[1] = heap.pop();
        actual[2] = heap.pop();
        actual[3] = heap.pop();
        actual[4] = heap.pop();

        int[] expected = new int[]{1, 2, 3, 4, 5};

        assertArrayEquals(expected, actual);
    }
}
