public class Box {

    double l;
    double h;
    double w;
    // double weight;

    static void greeting() {
        System.out.println("Hey, I am in Box class. Greetings!");
    }

    public double getL() {
        return l;
    }

    Box () {
        // super(); calling Object Class

        this.h = -1;
        this.l = -1;
        this.w = -1; 
    }

    // cube
    Box (double side){
        this.w = side;
        this.l = side;
        this.h = side;
    }

    public Box (double l,double h,double w){
        System.out.println("Box class constructor");
        this.w = w;
        this.l = l;
        this.h = h;
    }

    Box (Box old){
        this.h = old.h;
        this.l = old.l;
        this.w = old.w;
    }

    public void information(){
        System.out.println("Running the Box");
    }

}
