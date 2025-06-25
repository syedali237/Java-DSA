public class LCSubstring {

    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("abcd", "abzd"));
    }

    public static int longestCommonSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int j = 0 ; j <= m; j++) dp[0][j] = 0;
        for (int i = 0 ; i <= n; i++) dp[i][0] = 0;

        int ans = 0;
        for (int i1 = 1 ; i1 <= n; i1++){
            for (int i2 = 1; i2 <= m; i2++){
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)){
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                    ans = Math.max(ans, dp[i1][i2]);
                } else {
                    dp[i1][i2] = 0;
                }
            }
        }

        return ans;
    }

}
