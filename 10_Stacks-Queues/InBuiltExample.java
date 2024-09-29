import java.util.ArrayDeque;
import java.util.Deque;

public class InBuiltExample {

    public static void main(String[] args) {
        // Stack<Integer> stack = new Stack<>();
        // stack.push(34);
        // stack.push(44);
        // stack.push(4);
        // stack.push(18);
        // stack.push(9);

        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());

        // Queue<Integer> queue = new LinkedList<>();
        // queue.add(3);
        // queue.add(6);
        // queue.add(9);
        // queue.add(12);
        // queue.add(5);

        // // System.out.println(queue.peek()); // head of this queue : 3
        // System.out.println(queue.remove()); // remove head
        // System.out.println(queue.remove());  

        Deque<Integer> deque = new ArrayDeque<>();
        // faster than queue (linked list) and stack 

        deque.add(89);
        deque.add(4);
        deque.addLast(78);
        deque.add(56);
        deque.removeFirst();
        System.out.println(deque);
    }

}
