public class StackMain {
    public static void main(String[] args) throws StackException{
        // CustomStack stack = new CustomStack(5);
        DynamicStack stack = new DynamicStack(5);
        stack.push(55);
        stack.push(23);
        stack.push(9);
        stack.push(19);
        stack.push(20);
        stack.push(23);
    
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        // System.out.println(stack.pop());
    }

}
