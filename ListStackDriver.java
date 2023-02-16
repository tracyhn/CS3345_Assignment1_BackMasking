public class ListStackDriver {
    public static void main(String[] args) {
        ListStack stack = new ListStack();
        stack.push(1.0);
        stack.push(2.0);
        stack.push(3.0);
        System.out.println("Is it empty? Should be false: " + stack.isEmpty());

        System.out.println("The first one popped should be 3.0: " + stack.pop());
        System.out.println("Now there should be two items in the stack: " + stack.count());

        stack.pop();
        System.out.println("Peek should return 1.0: " + stack.peek());
        stack.pop();
        System.out.println("Now there should be zero items in the stack: " + stack.count());
        System.out.println("Should throw an exception:");
        stack.peek();
        System.out.println();
    }
}
