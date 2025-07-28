
import java.util.Arrays;

public class MCM {

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int n = arr.length;
        System.out.println(getWays(1, n - 1, arr));
        int[][] dp = new int[n][n];
        for(int[] r :dp ) {
            Arrays.fill(r, -1);
        }
        System.out.println(getWays(1, n - 1, arr, dp)); 
        System.out.println(getWaysTab(arr, n));
    }

    static int getWays(int i, int j, int[] arr){
        if (i == j) return 0;
        int mini = Integer.MAX_VALUE;

        for (int k = i; k < j; k++){
            int steps = arr[i-1] * arr[k] * arr[j] + getWays(i, k, arr) + getWays(k + 1, j, arr);
            if (steps < mini){
                mini = steps;
            }
        }
        return mini;
    }

    // Memoization
    static int getWays(int i, int j, int[] arr, int[][] dp){
        if (i == j) return 0;
        int mini = Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];

        for (int k = i; k < j; k++){
            int steps = arr[i-1] * arr[k] * arr[j] + getWays(i, k, arr) + getWays(k + 1, j, arr);
            if (steps < mini){
                mini = steps;
            }
        }
        return dp[i][j] = mini;
    }

    // Tabulation
    static int getWaysTab(int[] arr, int n){
        int[][] dp = new int[n][n];
        
        for (int i = n - 1; i >= 1 ; i--){
            for (int j = i + 1; j < n; j++){
                int mini = Integer.MAX_VALUE;
                for (int k = i; k < j; k++){
                    int steps = arr[i-1] * arr[k] * arr[j] + dp[i][ k] + dp[k + 1][ j];
                    if (steps < mini){
                        mini = steps;
                    }
                }
                dp[i][j] = mini;                
            }
        }

        return dp[1][n - 1];
    }
}
