
import java.util.Arrays;
import java.util.List;

// here T should be Number or its subclasses.
public class WildcardExample<T extends Number > {

    private Object[] data;
    private static final int DEFAULT_SIZE = 10;
    private int size = 0; //also working as an index value

    public WildcardExample(){
        this.data = new Object[DEFAULT_SIZE];
    }

    public void getList(List<? extends Number> list){
        // this is called wildcard
    }

    public void add(T num){
        if (this.isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];
        //copy prev items
        System.arraycopy(data, 0, temp, 0, data.length);
        // for (int i = 0; i < data.length; i++) {
        //     temp[i] = data[i];
        // }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public T remove(){
        T removed = (T) data[--size];
        return removed;
    }

    public T get(int index){
        return (T) data[index];
    }

    public int size(){
        return size;
    }

    public void set(int index, T value){
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayList {" +
                "data = " + Arrays.toString(data) + 
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        WildcardExample<Integer> list2 = new WildcardExample<>();
        for (int i = 0; i < 14; i++) {
            list2.add(2 * i);
        }
        System.out.println(list2);
    }
}
