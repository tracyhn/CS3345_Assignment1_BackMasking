/**
 * Implements a Stack of type double using an Array.
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
    private int index = -1;                                             // Stack is empty 

    public boolean isEmpty() {
        return (count() == 0);                                          // Since count() returns index + 1, then stack must be                                                                                                                     
    }                                                                   // empty when count() == 0 

    public int count() {
        return index + 1;                                               // index + 1 = number of elements in stack
    }

    public void push(double d) {
        checkCapacity();
        index++;
        arrayStack[index] = d;
    }

    public double pop() {
        double result;
        if (isEmpty()){
            throw new EmptyStackException();
        }
        else{
            result = arrayStack[index];
            index--;
        }
        return result;  
    }

    public double peek() {
        double result;
        if (isEmpty()){
            throw new EmptyStackException();
        }
        else{
            result = arrayStack[index];
        }
        return result;  
    }

    private void checkCapacity(){
        if (index == INITIAL_CAPACITY - 2){
            double newArray[] = new double[INITIAL_CAPACITY * 2];       // Double the size of the array
            for (int i = 0; i <= index; i++){
                newArray[i] = arrayStack[i];
            }
            arrayStack = newArray;                                      // Set arrayStack pointer to newArray
            INITIAL_CAPACITY = INITIAL_CAPACITY * 2;                    // Set the new capacity
        }
    }
}
