public class ArrayStackDriver {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        stack.push(1.22);
        stack.push(2.11);
        stack.push(1);
        stack.push(2);
        stack.push(5.00);
        stack.push(10.00);
        System.out.println("count of stack is: " + stack.count() + " , should be 6");
        System.out.println("Poping the stack should give 10.00: " + stack.pop());
        System.out.println("Now count of stack is: " + stack.count());
        System.out.println("Should give 5.00 when popping: " + stack.pop());
        System.out.println("Should give 2.00 when peeking: " + stack.peek());

        System.out.println("Should return false: " + stack.isEmpty());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
      
        
        System.out.println("count: " + stack.count());
        System.out.println(stack.pop());
        System.out.println("Finally, count of stack is: " + stack.count());
        System.out.println("Now should return true: " + stack.isEmpty());
        

   
    }
}
