/**
 * 
 * 
 * Tracy Huynh
 * Net ID: thh220000
 * CS 3345.503
 * Assignment 1
 * February 17, 2023
 */
import java.util.EmptyStackException;

public class ArrayStack implements BKStack{
    private int INITIAL_CAPACITY = 10000;
    private double arrayStack[] = new double[INITIAL_CAPACITY];
    private int count = -1;                                             // Stack is empty

    public boolean isEmpty() {
        return (count() == 0);                                          // count() returns count + 1
                                                                        // stack is empty when count == -1
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
        if (count == INITIAL_CAPACITY - 2){
            double newArray[] = new double[INITIAL_CAPACITY * 2];       // Double the size of the array
            for (int index = 0; index <= count; index++){
                newArray[index] = arrayStack[index];
            }
            arrayStack = newArray;                                      // Set arrayStack pointer to newArray
            INITIAL_CAPACITY = INITIAL_CAPACITY * 2;                    // Set the new capacity
        }
    }
}
