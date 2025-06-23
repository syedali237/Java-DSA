import java.util.Arrays;

public class CounSubsetsWithDifference {

    static int mod = Integer.MAX_VALUE;
    static int countPartition(int[] arr,  int D){
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        if (totalSum - D < 0 || (totalSum - D) % 2 != 0) {
            return 0;
        }

        return countSubsetWithSum(arr, (totalSum - D)/2);
    }

    static int countSubsetWithSum(int[] arr, int sum){
        int n = arr.length;
        int[][] dp = new int[n][sum + 1];
        for (int[] r : dp){
            Arrays.fill(r, -1);
        }
        return helper(n - 1,sum, arr, dp);
    }

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

        return dp[ind][s] = (pick + notPick) % mod;
    }

}
