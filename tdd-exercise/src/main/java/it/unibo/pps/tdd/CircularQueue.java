package it.unibo.pps.tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  <br>
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  <br>
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {

    /**
     * Insert an element at the empty next position
     * If the queue is full, the data insertion restart from the beginning
     * */
    void push(int i);

    /**
     * @return the oldest element of the queue
     * */
    int getFirstElement();

    /**
     * @return the size of the queue
     * */
    int getSize();

    /**
     * Removes the oldest element of the queue
     * If the queue is empty, throws an exception
     * @return the removed element
     * */
    int pop();
}