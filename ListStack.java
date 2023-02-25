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
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListStack implements BKStack, Iterable <ListStack.ListStackNode>{
    static ListStackNode head = new ListStackNode (0, null, null);

    public boolean isEmpty() {
        return head.prev == null;
    }

    public int count(){
        int count = 0;
        for (ListStackNode node : this){
            count++;
        }
        return count;
    }

    public void push(double d) {
        System.out.println("We are in the push method()");
        if (head.next == null && head.prev == null){          // Stack is currently empty                                                  // We are at the first node
            head.next = new ListStackNode(d, head, null); 
            head = head.next;                                 // Set pointer to current new node
        }
        else {
            ListStackNode newNode = new ListStackNode(d, head, null);
            head.next = newNode;
            head = head.next;
        }
    }

    public double pop() {
        System.out.println("We are popping...");
        double answer;
        if (head.prev == null){                              // head.prev == null when stack is empty
            throw new EmptyStackException();
        }
        else{
            answer = head.data;
            head = head.prev;
            head.next = null;
        }
        return answer;
    }

    public double peek() {
        double answer;
        if (head.prev == null){                
            throw new EmptyStackException();
        }
        else{
            answer = head.data; 
        }
        return answer;
    }


    private static class stackIterator implements Iterator <ListStackNode>{
        private ListStackNode current = ListStack.head;
        public boolean hasNext() {
            return current.prev != null;
        }
        public ListStackNode next() {
            ListStackNode nextNode;
            if (hasNext()){
                nextNode = current.prev;
                current = nextNode;
            }
            else{
                throw new NoSuchElementException();
            }
            return nextNode;
        }
    }

    public Iterator <ListStackNode> iterator() {
        Iterator <ListStackNode> iterate = new stackIterator();
        return iterate;
    }
    
    static class ListStackNode {
    private ListStackNode (double d, ListStackNode p, ListStackNode n){
        data = d;
        prev = p;
        next = n;
    }
    private double data;
    private ListStackNode prev;
    private ListStackNode next;
    }
}





