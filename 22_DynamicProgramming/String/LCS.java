public class LCS {

    public static void main(String[] args) {
        longestCommonSubsequenceTab("abcde", "bdgek");
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        return getMaxLengthLCS(n - 1, m - 1, text1, text2);
    }

    int getMaxLengthLCS(int i1, int i2, String s1, String s2 ){
        if (i1 < 0 || i2 < 0){
            return 0;
        }

        if (s1.charAt(i1) == s2.charAt(i2)) return 1 + getMaxLengthLCS(i1 - 1, i2 - 1, s1, s2);
        return Math.max(getMaxLengthLCS(i1 - 1, i2, s1, s2 ), getMaxLengthLCS(i1, i2 - 1, s1, s2 ));
    }

    // Memoization
    int helper(int i1, int i2, String s1, String s2, int[][] dp){
        if (i1 < 0 || i2 < 0){
            return 0;
        }

        if (dp[i1][i2] != -1) return dp[i1][i2];
        if (s1.charAt(i1) == s2.charAt(i2)) return dp[i1][i2] = 1 + helper(i1 - 1, i2 - 1, s1, s2, dp);
        return dp[i1][i2] = 0 + Math.max(helper(i1 - 1, i2, s1, s2, dp ), helper(i1, i2 - 1, s1, s2, dp ));
    }

    // Tabulation
    public static int longestCommonSubsequenceTab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int j = 0 ; j <= m; j++) dp[0][j] = 0;
        for (int i = 0 ; i <= n; i++) dp[i][0] = 0;

        for (int i1 = 1 ; i1 <= n; i1++){
            for (int i2 = 1; i2 <= m; i2++){
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)){
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                } else {
                    dp[i1][i2] = 0 + Math.max(dp[i1 - 1][i2], dp[i1][i2 - 1]);
                }
            }
        }

        for (int[] dp1 : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp1[j] + " "); 
            }
        }

        return dp[n][m];
    }

    // Space optimization
    public int longestCommonSubsequenceSpace(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m + 1];

        for (int i1 = 1; i1 <= n; i1++) {
            int[] curr = new int[m + 1];  // new array in each row
            for (int i2 = 1; i2 <= m; i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
                    curr[i2] = 1 + prev[i2 - 1];
                } else {
                    curr[i2] = Math.max(prev[i2], curr[i2 - 1]);
                }
            }
            prev = curr;
        }

        return prev[m];
    }

}
