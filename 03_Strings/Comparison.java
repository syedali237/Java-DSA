/**
 * Comparison
 */
public class Comparison {

    public static void main(String[] args) {
        String a = "kunal";
        String b = "kunal";

        // == 
        // System.out.println(a == b); // true

        String name1 = new String("Ali");
        String name2 = new String("Ali");

        // System.out.println(name1 == name2); // false
        // (only values are compared)
        System.out.println(name1.equals(name2)); // true
        System.out.println(name1.charAt(0)); // A

    }
}