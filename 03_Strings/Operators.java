import java.util.ArrayList;

/**
 * Operators
 */
public class Operators {

    public static void main(String[] args) {
        System.out.println('a' + 'b'); //195 summation of ascii values
        System.out.println("a" + "b"); //ab concatenate  (+ - operator overloading)
        System.out.println('a' + 3); //100
        System.out.println((char)('a' + 3)); //d

        System.out.println("a" + 1); //a1
        // this is same as "a" + "1"
        // integer will be converted into Integer (wrapper)
        // that will call to toString()

        // these are objects it will call toString on it
        System.out.println("ali" + new ArrayList<>()); // ali[]
        // System.out.println("ali" + new Integer(56)); // ali56

        // System.out.println(new Integer(45) + new ArrayList<>()); will not work
        System.out.println(new Integer(45) + " " + new ArrayList<>());
        // atleast one of the three objects is string and the final answer will be an string 
    }
}