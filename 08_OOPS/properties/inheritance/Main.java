public class Main {
    public static void main(String[] args) {
        Box box1 = new Box(4,3,2);
        box1.getL();
        // Box box2 = new Box(box1);
        // System.out.println(box1.l + " " + box1.w + " " + box1.h);

        // BoxWeight box3 = new BoxWeight();
        // System.out.println(box3.h + " " + box3.weight);

        // type of reference variable decides what to refer not the object type
        // eg: box5.weight cant be accessed

        // Box box5 = new BoxWeight(2,3,4,6);

        // System.out.println(box5.w);
        // System.out.println(box5.weight); error

        // there are many variables in both parent and child classes
        // you are given access to variables that are in the ref type i.e. BoxWeight
        // hence, you should have access to weight variable
        // this also means, that the ones you are trying to access should be initialised
        // but here, when the obj itself is of type parent class, how will you call the constructor of child class
        // this is why error
    //    BoxWeight box6 = new Box(2, 3, 4);
    //    System.out.println(box6);

    // BoxWeight boxi = new BoxWeight(2,3,4,6);
    // System.out.println(boxi.h);


    // BoxPrice box = new BoxPrice();

    Box.greeting();

    BoxWeight box = new BoxWeight();
    BoxWeight.greeting();// you can inherit but you cannot override
    }
}