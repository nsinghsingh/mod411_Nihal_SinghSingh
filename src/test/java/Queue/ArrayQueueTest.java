package Queue;

import Queue.ArrayQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    ArrayQueue queue;

    @BeforeEach
    void setUp() {
        queue = new ArrayQueue(6);
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
        queue.put(10);
        queue.put(10);
        queue.put(10);
        queue.put(10);
        queue.put(10);
        queue.put(10);
        assertFalse(queue.isEmpty());
        
    }

    @Test
    void getFrontElement() {
        queue.put(10);
        queue.put(true);
        queue.put(3.6);
        queue.put(99);
        queue.put("test");
        int result = (int) queue.getFrontElement();
        assertEquals(10, result);
    }

    @Test
    void getRearElement() {
        queue.put(10);
        queue.put(true);
        queue.put(3.6);
        queue.put(99);
        queue.put("test");
        String result = (String) queue.getRearElement();
        assertEquals("test", result);
    }

    @Test
    void put() {
        queue.put(10);
        assertFalse(queue.isEmpty());
        int result = (int) queue.getFrontElement();
        assertEquals(10, result);
        queue.put(10);
        queue.put(10);
        queue.put(10);
        queue.put(10);
        queue.put(10);
        assertThrows(IndexOutOfBoundsException.class, () -> queue.put(10));
    }

    @Test
    void remove() {
        queue.put(10);
        queue.put(true);
        queue.put(3.6);
        queue.put(99);
        queue.put("test");
        queue.remove();
        queue.remove();
        double result = (double) queue.getFrontElement();
        assertEquals(3.6, result);
        queue.remove();
        queue.remove();
        queue.remove();
        assertTrue(queue.isEmpty());
    }

    @Test
    void throwException(){
        assertThrows(IllegalArgumentException.class, () -> {ArrayQueue queue = new ArrayQueue(0);});
    }
}