import java.util.ArrayList;

public class FrogJump {

    // classic frog jump
    int helper(int index, int[] stones){
        if (index == 0) return 0;

        int left = helper(index - 1, stones) + Math.abs(stones[index] - stones[index - 1]);
        int right = Integer.MAX_VALUE;
        if (index > 1){
            right = helper(index - 2, stones) + Math.abs(stones[index] - stones[index - 2]);
        }

        return Math.min(left, right);
    }
    public int frog(int[] stones) {
        int n = stones.length;
        return helper(n-1, stones);
    }

    // using DP = Memoization
    int helper2(int index, int[] stones, ArrayList<Integer> dp){
        if (index == 0) return 0;

        if (dp.get(index) != -1) {
            return dp.get(index);
        }

        int left = helper2(index - 1, stones, dp) + Math.abs(stones[index] - stones[index - 1]);
        int right = Integer.MAX_VALUE;
        if (index > 1){
            right = helper2(index - 2, stones, dp) + Math.abs(stones[index] - stones[index - 2]);
        }

        int minCost = Math.min(left, right);
        dp.set(index, minCost);
        return minCost;
    }
    public int frog2(int[] stones) {
        int n = stones.length;
        ArrayList<Integer> dp = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            dp.add(-1);
        }
        return helper2(n-1, stones, dp);
    }

    // Tabulation
    public int frog3(int[] a) {
        int n = a.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int fs = dp[i-1] + Math.abs(a[i] - a[i-1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = dp[i-2] + Math.abs(a[i] - a[i-2]);
            }
            dp[i] = Math.min(fs, ss);
        }
        return dp[n-1];
    }

    // space optimization
    public int frog4(int[] a) {
        int n = a.length;
        int prev = 0;
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int fs = prev + Math.abs(a[i] - a[i-1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = prev2 + Math.abs(a[i] - a[i-2]);
            }
            int curr = Math.min(fs, ss);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
