package oops.introduction;
/**
 * WrapperClass
 */
public class WrapperClass {

    public static void main(String[] args) {
        // int a = 10;
        // // not a primitive, using it as an object
        // Integer num = 45;

        Integer a = 10;
        Integer b = 20;

        swap(a, b);

        // System.out.println(a + " " + b);

        // final int BONUS = 2; // final fixes the value can't modify it
        // BONUS = 3; // fixes for primitve data types

        // For other, it can change the value of the object 
        // but cannot assign it

        final A syed =  new A("syed ali");
        syed.name = "other name";


        // when a non primitive is final, you cannot reassign it.
        // syed = new A("new object");


        A obj;
        for (int i = 0; i < 1000; i++) {
            obj = new A("Random name");
        }
    }

    static void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }
}

class A {
    // always initialise while declaring final
    final int num = 10;
    String name;

    public A(String name) {
        // System.out.println("object created");
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is Destroyed");
    };

}