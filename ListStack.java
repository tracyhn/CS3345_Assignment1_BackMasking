/**
 * Implements a Stack of type double using a Linked List.
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
            head.next = new ListStackNode(d, head, null);
            head = head.next;                                 // Point to the new node
    }

    public double pop() {
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





