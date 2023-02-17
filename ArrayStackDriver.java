public class ArrayStackDriver {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        stack.push(1.22);
        stack.push(2.11);
        stack.push(1);
        System.out.println("count of stack is: " + stack.count());
        System.out.println(stack.pop());
        System.out.println("Now count of stack is: " + stack.count());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        System.out.println("Should return false: " + stack.isEmpty());

        System.out.println(stack.pop());
        System.out.println("count: " + stack.count());
        System.out.println("Now should return true: " + stack.isEmpty());
        System.out.println("Finally, count of stack is: " + stack.count());

   
    }
}
