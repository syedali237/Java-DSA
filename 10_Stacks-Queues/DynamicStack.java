public class DynamicStack extends CustomStack{

    public DynamicStack() {
        super(); // it will call CustomStack();
    }

    public DynamicStack(int size) {
        super(size); // it will call CustomStack(size);
    }

    @Override
    public boolean push(int item){
        if (this.isFull()) {
            // double the array size
            int[] temp = new int[data.length*2];

            // copy all prev items in new data
            System.arraycopy(data, 0, temp, 0, data.length);
            // for (int i = 0; i < data.length; i++) {
            //     temp[i] = data[i];
            // }
            data = temp;
        }
        // insert item
        return super.push(item);


    }









}
