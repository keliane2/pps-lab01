package it.unibo.pps.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private MinMaxStack stack;

    @BeforeEach
    void beforeEach(){
        stack = new MinMaxStackImpl();
    }

    private void serialPush(List<Integer> l) {
        l.forEach(e->stack.push(e));
    }

    @Test
    public void testPushing() {
        stack.push(2);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPopFromNotEmptyStack() {
        stack.push(2);
        int element=stack.pop();
        assertTrue(stack.isEmpty() && element == 2);
    }

    @Test
    public void testPopFromEmptyStack() {
        assertThrows(IllegalStateException.class,()->stack.pop());
    }

    @Test
    public void testPeekFromEmptyStack() {
        assertThrows(IllegalStateException.class,()->stack.peek());
    }

    @Test
    public void testPeekFromNotEmptyStack() {
        stack.push(2);
        int element = stack.peek();
        assertTrue(!stack.isEmpty() && element == 2);
    }

    @Test
    public void testGettingMinFromEmptyStack() {
        stack.push(2);
        stack.pop();
        assertThrows(IllegalStateException.class,()->stack.getMin());
    }

    @Test
    public void testGettingMinFromNotEmptyStack() {
        serialPush(List.of(2,5));
        assertEquals(2, stack.getMin());
    }

    @Test
    public void testGettingMaxFromEmptyStack() {
       pushAndPop(2);
        assertThrows(IllegalStateException.class,()->stack.getMin());
    }

    @Test
    public void testGettingMaxFromNotEmptyStack() {
        serialPush(List.of(2,5));
        assertEquals(5, stack.getMax());
    }

    @Test
    public void testSizeOfEmptyStack() {
        pushAndPop(2);
        assertEquals(0, stack.size());
    }

    private void pushAndPop(int i) {
        stack.push(i);
        stack.pop();
    }

    @Test
    public void testSizeOfNotEmptyStack() {
        serialPush(List.of(2,5,1));
        assertEquals(3, stack.size());
    }
}