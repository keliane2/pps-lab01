package tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack{

    private int max;
    private  int min;
    private ArrayList<Integer> stack;

    public MinMaxStackImpl(){
         resetMinMax();
         stack = new ArrayList<>();
    }

    @Override
    public void push(int value) {
        stack.add(value);
        if (value > max || size() == 1) max = value;
        if (value < min || size() == 1) min = value;
    }

    @Override
    public int pop() {
        if (!isEmpty()){
            int last_element = stack.get(size() - 1);
            stack.remove(stack.get(size() - 1));
            resetMinMax();
            setMinMaxAfterPop();
            return last_element;
        }
        else throw new IllegalStateException("Empty stack");
    }

    private void setMinMaxAfterPop(){
        if (!isEmpty()){
            stack.stream().forEach(e->{
                if (e > max) max = e;
                if (e < min) min = e;
            });
        }
    }

    private void resetMinMax() {
        min = 0;
        max = 0;
    }

    @Override
    public int peek() {
        if (!isEmpty())
            return stack.get(size()-1);
        else throw new IllegalStateException("Empty stack");
    }

    @Override
    public int getMin() {
        if (!isEmpty())
            return min;
        else throw new IllegalStateException("Empty stack");
    }

    @Override
    public int getMax() {
        if (!isEmpty())
            return max;
        else throw new IllegalStateException("Empty stack");
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
