public class Fibonacci {
    public static void main(String[] args) {
        int ans = fibo(4);
        System.out.println(ans);
    }

    static int fibo(int n){
        if(n<2){
            return n;
        }
        return fibo(n-2) + fibo(n-1);
    }
}
