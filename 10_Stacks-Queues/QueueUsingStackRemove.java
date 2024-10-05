
import java.util.Stack;

class QueueUsingStackRemove {
    private final Stack<Integer> first;
    private final Stack<Integer> second;

    public QueueUsingStackRemove() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item){
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }
        first.push(item);
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
    }

    public int remove(){
        return first.pop();
    }

    public int peek(){
        return first.peek();
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }



}
