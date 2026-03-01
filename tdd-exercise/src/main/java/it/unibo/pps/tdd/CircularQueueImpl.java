package tdd;

import java.util.ArrayList;

public class CircularQueueImpl implements CircularQueue{


    private final ArrayList<Integer> queue;
    private int currentPosition;
    private static final int POSITIVE_INCREMENT = 1;
    private static final int NEGATIVE_INCREMENT = -1;
    public static final int MAX_CAPACITY = 5;

    public  CircularQueueImpl(){
        currentPosition = 0;
        queue = new ArrayList<>();
    }
    
    @Override
    public void push(int i) {
        queue.add(currentPosition,i);
        updateCurrentPosition(POSITIVE_INCREMENT);
    }

    private void updateCurrentPosition(int increment) {
        currentPosition = (currentPosition + increment)%MAX_CAPACITY;
    }


    @Override
    public int getFirstElement() {
        return queue.get(0);
    }

    @Override
    public int getSize() {
        return queue.size();
    }

    @Override
    public int pop() {
        if (!queue.isEmpty()) {
            int first_element = queue.get(0);
            queue.remove(0);
            updateCurrentPosition(NEGATIVE_INCREMENT);
            return first_element;
        }
        throw new IllegalStateException("Empty queue");
    }
}
