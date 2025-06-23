
import java.util.Arrays;

public class Knapack {
    public static void main(String[] args) {
        int[] weight = { 3, 2, 5 };
        int[] value = { 30, 40, 60 };
        int n = 3;
        int maxWeight = 6;
        System.out.println(knapsnack(weight, value, n, maxWeight));
        System.out.println(knapsnackTabulation(weight, value, n, maxWeight));
        System.out.println(knapsnack2(weight, value, n, maxWeight));
        System.out.println(knapsnack3(weight, value, n, maxWeight));
    }

    static int knapsnack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        return helper(n - 1, maxWeight, weight, value, dp);
    }

    static int helper(int ind, int W, int[] wt, int[] val, int[][] dp) {
        if (ind == 0) {
            if (wt[0] <= W)
                return val[0];
            return 0;
        }

        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }

        int notTake = helper(ind - 1, W, wt, val, dp);
        int take = Integer.MIN_VALUE;
        if (wt[ind] <= W) {
            take = val[ind] + helper(ind - 1, W - wt[ind], wt, val, dp);
        }

        return dp[ind][W] = Math.max(notTake, take);
    }

    static int knapsnackTabulation(int[] wt, int[] val, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        for (int W = wt[0]; W <= maxWeight; W++) {
            dp[0][W] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int W = 0; W <= maxWeight; W++) {
                int notTake = dp[ind - 1][W];
                int take = Integer.MIN_VALUE;
                if (wt[ind] <= W) {
                    take = val[ind] + dp[ind - 1][W - wt[ind]];
                }
                dp[ind][W] = Math.max(notTake, take);
            }
        }

        return dp[n - 1][maxWeight];
    }

    // space optimization 
    static int knapsnack2(int[] wt, int[] val, int n, int maxWeight) {
        int[] prev = new int[maxWeight + 1];
        int[] curr = new int[maxWeight + 1];
        for (int W = wt[0]; W <= maxWeight; W++) {
            prev[W] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int W = 0; W <= maxWeight; W++) {
                int notTake = prev[W];
                int take = Integer.MIN_VALUE;
                if (wt[ind] <= W) {
                    take = val[ind] + prev[W - wt[ind]];
                }
                curr[W] = Math.max(notTake, take);
            }
            prev = curr;
        }

        return prev[maxWeight];
    }

    // further optimizing to 1 row
    static int knapsnack3(int[] wt, int[] val, int n, int maxWeight) {
        int[] prev = new int[maxWeight + 1];
        for (int W = wt[0]; W <= maxWeight; W++) {
            prev[W] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int W = maxWeight; W >= 0; W--) {
                int notTake = prev[W];
                int take = Integer.MIN_VALUE;
                if (wt[ind] <= W) {
                    take = val[ind] + prev[W - wt[ind]];
                }
                prev[W] = Math.max(notTake, take);
            }
        }

        return prev[maxWeight];
    }
}