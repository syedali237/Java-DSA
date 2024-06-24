/**
 * Fib
 */
public class Fib {
    public static void main(String[] args) {
        // int ans = fibonacci(6);
        // System.out.println(ans);
        // for (int i = 0; i < 11; i++) {
        //     System.out.println(fiboFormula(i));
        // }

        System.out.println(fiboFormula(60));
    }

    // using formula
    static long fiboFormula(int n){
        // just for demo, use long instead
        // return  (int) ((Math.pow(((1 + Math.sqrt(5)) / 2), n) - Math.pow(((1 - Math.sqrt(5)) / 2), n)) / Math.sqrt(5));
        // OR (since other less dominating)
        return  (long) (Math.pow(((1 + Math.sqrt(5)) / 2), n)/ Math.sqrt(5));
    }

    static int fibonacci(int n){
        if(n<2){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}