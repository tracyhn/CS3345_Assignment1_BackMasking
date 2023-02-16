import java.util.EmptyStackException;

public class ArrayStack implements BKStack{
    private int INITIAL_CAPACITY = 100;
    private double arrayStack[] = new double[INITIAL_CAPACITY];
    private int count = -1;                                             // Stack is empty

    public boolean isEmpty() {
        boolean status = true;
        if (count() > -1) {status = false;}
        return status;
    }

    public int count() {
        return count + 1;                                               // Index + 1 = number of elements in stack
    }

    public void push(double d) {
        checkCapacity();
        count++;
        arrayStack[count] = d;
    }

    public double pop() {
        double result;
        if (isEmpty()){
            throw new EmptyStackException();
        }
        else{
            result = arrayStack[count];
            count--;
        }
        return result;  
    }

    public double peek() {
        double result;
        if (isEmpty()){
            throw new EmptyStackException();
        }
        else{
            result = arrayStack[count];
        }
        return result;  
    }

    private void checkCapacity(){
        if (count == INITIAL_CAPACITY - 10){
            double newArray[] = new double[INITIAL_CAPACITY * 2];       // Double the size of the array
            for (int index = 0; index < count; index++){
                newArray[index] = arrayStack[index];
            }
            arrayStack = newArray;                                      // Set arrayStack pointer to newArray
            INITIAL_CAPACITY = INITIAL_CAPACITY * 2;                    // Set the new capacity
        }
    }
}
