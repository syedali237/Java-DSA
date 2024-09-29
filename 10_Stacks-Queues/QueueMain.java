public class QueueMain {
    public static void main(String[] args) throws Exception {
        // CustomQueue queue = new CustomQueue(5);
        CircularQueue queue = new CircularQueue(5);
        queue.insert(5);
        queue.insert(7);
        queue.insert(11);
        queue.insert(1);
        queue.insert(98);

        queue.display();

        System.out.println(queue.remove());
        queue.insert(133);
        queue.display();
    }

}
