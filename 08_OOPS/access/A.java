public class A {

    private int num; 
    // private variables can be accessed through 
    // getters and setter in other classes/files
    String name;
    int[] arr;
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public A(int num, String name) {
        this.num = num;
        this.name = name;
        this.arr = new int[num];
    }
}