/**
 * Nto1
 */
public class Nto1 {
    public static void main(String[] args) {
        funBoth(5);
        fun(5);
        funRev(5);
    }

    // concept
    static void fxn(int n){
        if (n == 0) {
            return;
        }
        System.out.println(n);
        // fxn(n--); // infinite recursion
        fxn(--n);
        // n-- vs --n
    }

    static void fun(int n){
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        fun(n-1);
    }

    static void funRev(int n){
        if (n == 0) {
            return;
        }
        funRev(n-1);
        System.out.print(n + " ");
    }

    static void funBoth(int n){
        if (n == 0) {
            return;
        }
        System.out.println(n);
        funBoth(n-1);
        System.out.println(n);
    }
}