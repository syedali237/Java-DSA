
import java.util.Arrays;

public class CountSubsets {

    public static void main(String[] args) {
        int[] arr = {1,3,2};
        // int[] arr = {0,0,1}; // if array has 0 in it
        int ans = countSubsetWithSum(arr);
        System.out.println(ans);
        System.out.println(countSubsetsTabulation(arr, 3));
        System.out.println(countSubsets(arr, 3));
    }

    static int countSubsetWithSum(int[] arr){
        int n = arr.length;
        int sum = 3;
        int[][] dp = new int[n][sum + 1];
        for (int[] r : dp){
            Arrays.fill(r, -1);
        }
        return helper(n - 1,sum, arr, dp);
    }

    // Memoization
    static int helper(int ind, int s, int[] arr, int[][] dp){
        // if (s == 0) return 1;
        // if (ind == 0) {
        //     if(arr[ind] == s){
        //         return 1;
        //     } 
        //     return 0;
        // }
        if (ind == 0) {
            if(s == 0 && arr[0] == 0  ) return 2; 
            if (s == 0 || s == arr[0]) return 1;
            return 0;
        }

        if (dp[ind][s] != -1) {
            return dp[ind][s];
        }

        int notPick = helper(ind - 1, s, arr, dp);
        int pick = 0;
        if (arr[ind] <= s) {
            pick = helper(ind-1, s - arr[ind], arr, dp);
        }

        return dp[ind][s] = pick + notPick;
    }

    static int countSubsetsTabulation(int[] arr, int s){
        int n =arr.length;
        int[][] dp = new int[n][s+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] <= s) {
            dp[0][arr[0]] = 1;
        }

        for (int i = 1; i < n; i++){
            for (int sum = 0; sum <= s; sum++){
                int notPick = dp[i-1][sum];
                int pick = 0;
                if (arr[i] <= sum) {
                    pick = dp[i-1][sum - arr[i]];
                }
                dp[i][sum] = pick + notPick;
            }
        }

        return dp[n-1][s];
    }

    // SPACE OPTIMIZATION
    static int countSubsets(int[] arr, int s){
        int n =arr.length;
        int[] prev = new int[s + 1];
        int[] curr = new int[s + 1];

        prev[0] = 1;
        curr[0] = 1;
        if (arr[0] <= s) {
            prev[arr[0]] = 1;
        }

        for (int i = 1; i < n; i++){
            for (int sum = 0; sum <= s; sum++){
                int notPick = prev[sum];
                int pick = 0;
                if (arr[i] <= sum) {
                    pick = prev[sum - arr[i]];
                }
                curr[sum] = pick + notPick;
            }
            prev = curr;
        }

        return prev[s];
    }

}
