package oops.staticExample;
// class Test {

// static String name;

//     public Test(String name){
//         Test.name = name;
//     }

// } output: Rahul Rahul 

// Outer classes cannot be static

public class InnerClasses {

    static class Test {
        String name; //static String name, then o/p: rahul rahul
        public Test(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    } // output: kunal rahul

    public static void main(String[] args) {
        Test a = new Test("Kunal");
        Test b = new Test("Rahul"); 

        System.out.println(a);
        // this is calling a.toString()
        //if toString() would not exist in the Test class 
        // then it will call the default toString() method and give
        // a hashcode

        // System.out.println(a.name);
        // System.out.println(b.name);
    }
}
