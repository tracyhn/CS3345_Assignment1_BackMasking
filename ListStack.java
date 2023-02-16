import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListStack implements BKStack, Iterable <ListStack.ListStackNode>{
    static ListStackNode head = new ListStackNode (0, null, null);

    public boolean isEmpty() {
        System.out.println("We are in the isEmpty() method");
        boolean result;
        if (head.prev == null){result = true;}
        else {result = false;}
        return result;
    }

    public int count(){
        System.out.println("We are in the count method()");
        int count = 0;
        Iterator <ListStackNode> it = iterator();
        while (it.hasNext()){
            System.out.println("Entered while loop in count()");
            count++;
            it.next();
        }
        System.out.println("Count is " + count);
        return count;
    }

    public void push(double d) {
        System.out.println("We are in the push method()");
        if (head.next == null && head.prev == null){                                                      // We are at the first node
            head.next = new ListStackNode(d, head, null); 
            head = head.next; 
            System.out.println("Pushed node: " + head.data);                                             // Set pointer to current new node
        }
        else {
            ListStackNode newNode = new ListStackNode(d, head, null);
            head.next = newNode;
            head = head.next;
            System.out.println("Pushed node: " + head.data); 
        }
    }

    public double pop() {
        System.out.println("We are in the pop method()");
        double answer;
        if (head.prev == null){
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

    public Iterator <ListStackNode> iterator() {
        System.out.println("Iterator constructor is called");
        Iterator <ListStackNode> iterate = new stackIterator();
        return iterate;
    }

    private static class stackIterator implements Iterator <ListStackNode>{
        private static ListStackNode current = ListStack.head;
        public boolean hasNext() {
            // System.out.println("Head is: " + head.data);
            // System.out.println("Entered the function hasNext()");
            return current.prev != null;
        }
        public ListStackNode next() {
            System.out.println("Etered the function next()");
            ListStackNode nextNode;
            if (hasNext() == false){
                throw new NoSuchElementException();
            }
            else{
                nextNode = current.prev;
                current = nextNode;
            }
            return nextNode;
        }
    }

    static class ListStackNode {
        public ListStackNode (double d, ListStackNode p, ListStackNode n){
            data = d;
            prev = p;
            next = n;
        }
        public double data;
        public ListStackNode prev;
        public ListStackNode next;
    }
}



