package it.unibo.pps.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private  CircularQueue queue;

    @BeforeEach
    public void beforeEach(){
        queue = new CircularQueueImpl();
    }

    private void fulfilQueue(){
        for (int i = 0; i < CircularQueueImpl.MAX_CAPACITY; i++) {
            queue.push(4);
        }
    }

    @Test
    public void testStoreNewElementOverwriteLastInFullQueue() {
        fulfilQueue();
        queue.push(5);
        assertEquals(5, queue.getFirstElement());
    }

    @Test
    public void testGettingSize() {
        queue.push(4);
        queue.push(10);
        queue.pop();
        queue.push(9);
        assertEquals(2, queue.getSize());
    }

    @Test
    public void testFirstElementRemovedFirst() {
        queue.push(3);
        queue.push(5);
        queue.push(8);
        int element = queue.pop();
        assertEquals(3, element);
    }
}
