
import java.util.Arrays;

public class SubsetSum {

    // Memoization
    boolean subsetSumK(int[] arr, int target) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], null);
        }
        return helper(n - 1, target, arr, dp);
    }

    boolean helper(int ind, int target, int[] arr, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }
        if (ind == 0) {
            return arr[0] == target;
        }

        if (dp[ind][target] != null) {
            return dp[ind][target];
        }

        boolean notTake = helper(ind - 1, target, arr, dp);
        boolean take = false;
        if (arr[ind] <= target) {
            take = helper(ind - 1, target - arr[ind], arr, dp);
        }

        return dp[ind][target] = take | notTake;
    }

    // Tabulation
    boolean subsetSumK2(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;    
        }
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int j = 1; j <= target; j++) { // target
                boolean notTake = dp[ind - 1][j];
                boolean take = false;
                if (arr[ind] <= j) {
                    take = dp[ind - 1][j - arr[ind]];
                }
                dp[ind][j] = take | notTake;
            }
        }
        return dp[n-1][target];
    }

    // Space Optimization
    boolean subsetSumK3(int[] arr, int target) {
        int n = arr.length;
        boolean[] prev = new boolean[target + 1];
        boolean[] curr = new boolean[target + 1];
        prev[0] = curr[0] = true;

        // prev[arr[0]] = true;
        if (arr[0] <= target) {
            prev[arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int j = 1; j <= target; j++) {
                boolean notTake = prev[j];
                boolean take = false;
                if (arr[ind] <= j) {
                    take = prev[j - arr[ind]];
                }
                curr[j] = take | notTake;
            }
            prev = curr;
        }
        return prev[target];
    }
}