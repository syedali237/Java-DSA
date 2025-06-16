
import java.util.Arrays;

public class Basics {
    public static void main(String[] args) {
        int n = 6;
        int[] dp = new int[n+1]; 
        Arrays.fill(dp, -1);
        System.out.println(Arrays.toString(dp));    
        System.out.println(fibo(n, dp));
        System.out.println(Arrays.toString(dp));    

        System.out.println(fiboo(n));
    }

    // Memoization
    static int fibo(int n, int[] dp){
        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = fibo(n-1, dp) + fibo(n-2, dp);
    }

    // Tabulation
    int fibo(int n) {
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    // Optimizing Space
    static int fiboo(int n){
        int prev2 = 0;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
            int curri = prev + prev2;
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
    

}
