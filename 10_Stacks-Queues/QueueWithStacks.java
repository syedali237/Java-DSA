
import java.util.Stack;

class QueueWithStacks {
    private final Stack<Integer> first;
    private final Stack<Integer> second;

    public QueueWithStacks() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item){
        first.push(item);
    }

    public int remove(int item){
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        int removed = second.pop();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return removed;
    }

    public int peek() throws Exception {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        int peeked = second.pop();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return peeked;
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }



}
