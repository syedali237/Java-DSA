package oops.introduction;
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        // store 5 roll nos
        int[] numbers = new int[5];

        // store 5 names
        String[] names = new String[5];
    
        // data of 5 students: {roll no, name, marks}
        int[] rno = new int[5];
        String[] name = new String[5];
        float[] marks = new float[5];

        Student[] students = new Student[5];

        // Student syed; // just declaring 
        // System.out.println(Arrays.toString(students)); // by default: [null, null ...]
        // syed = new Student();

        Student syed = new Student(32, "Ali" , 91.2f);
        Student rahul = new Student();

        // syed.rno = 31;
        // syed.name = "Syed Ali";
        // syed.marks = 93.5f;
        

        // syed.changeName("ali");
        // syed.greeting();

        // System.out.println(syed.rno);
        // System.out.println(syed.name);
        // System.out.println(syed.marks);

        Student random = new Student(syed);
        // System.out.println(random.name);

        Student random2 = new Student();
        // System.out.println(random2.name);

        Student one = new Student();
        Student two = one;

        one.name = "Something";
        System.out.println(two.name); // Something
    }
}

// creating a class
class Student{
    int rno;
    String name;
    float marks;
    // class is just a template

    void greeting(){
        System.out.println("Hello my name is " + this.name);
    }

    void changeName(String name){
        // name = newName;
        this.name = name;
    }

    //Constructor 

    Student (Student other) {
        this.name = other.name;
        this.marks = other.marks;
        this.rno = other.rno;
    }

    // Constructor overloading
    Student() {
        // calling another constructor from a constructor
        // internally => new Student (12, "default persom", 100.0f);
        this (12, "default person", 100.0f);
    }

    //Student arpit = new Student(17, "arpit", 89.7f);
    //here, this = arpit
    Student(int rno, String name, float marks){
        // rno = roll; // since rno and roll are different this.rno = rno
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }
}