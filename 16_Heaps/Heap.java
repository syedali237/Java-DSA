import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

    final private ArrayList<T> list;
    public Heap() {
        list = new ArrayList<>();
    }

    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index){
        return (index - 1)/ 2;
    }

    private int left(int index){
        return index * 2 + 1;
    }

    private int right(int index){
        return index * 2 + 2;
    }

    public void insert(T value){
        list.add(value);
        upheap(list.size() - 1);
    }

    private void upheap(int index){
        if (index == 0) {
            return;
        }
        int parent = parent(index);
        if (list.get(parent).compareTo(list.get(index)) > 0) {
            swap(index, parent);
            upheap(parent);
        }
    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap!");
        }
        T temp = list.get(0);

        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }
        return temp;
    }

    private void downheap(int index){
        int min = index;
        int left = left(index);
        int right = right(index);

        // Check if the left child exists and is smaller than the current element
        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0){
            min = left;
        }

        // Check if the right child exists and is smaller than the current minimum
        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0){
            min = right;
        }

        // If the current element is not the smallest, swap and continue downheap
        if (min != index) {
            swap(min, index); // Swap with the smallest child
            downheap(min); 
        }
    }

    // O(N*logN)
    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();

        while (!list.isEmpty()) {
            data.add(this.remove());
        } 
        return data;
    }
}
