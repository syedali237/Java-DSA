public class Fibonacci {
    public static void main(String[] args) {
        int ans = fibo2(4);
        System.out.println(ans);
    }

    static int fibo2(int n){
        if(n<2){
            return n;
        }
        return fibo2(n-2) + fibo2(n-1);
    }
}
