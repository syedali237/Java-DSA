import java.util.Arrays;

public class HouseRobber {

    // TLE
int rob(int[] nums) {
        int n = nums.length - 1;

        return helper(nums, n);    
    }

    int helper(int[] nums, int n){
        if (n == 0) return nums[n];
        if (n < 0) return 0;

        int pick = nums[n] + helper(nums, n - 2); // left side of recursive tree
        int notPick = 0 + helper(nums, n - 1); // right

        return Math.max(pick, notPick);
    }


    // Memoization
    int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, dp, n-1);    
    }

    int helper(int[] nums, int[] dp,int n){
        if (n == 0) return nums[0];
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];

        int pick = nums[n] + helper(nums, dp, n - 2); // left side of recursive tree
        int notPick = helper(nums, dp, n - 1); // right
        
        return dp[n] = Math.max(pick, notPick);
    }

    // With Space Optimization:

    int rob3(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        for (int i = 0; i < n; i++){
            int take = nums[i];
            if(i > 1) take += prev2;
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }




}

