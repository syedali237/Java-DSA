
import java.util.Arrays;

public class NinjaTraining {

    int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        Arrays.fill(dp, -1);
        // return f(n - 1, 3, points);
        return f(n - 1, 3, points, dp);
    }

    // tle
    int f(int day, int last, int[][] arr) {
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, arr[0][task]);
                }
            }
            return maxi;
        }

        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            int point = arr[day][task] + f(day - 1, task, arr);
            maxi = Math.max(maxi, point);
        }
        return maxi;
    }

    // Memoization
    int f(int day, int last, int[][] arr, int[][] dp) {
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, arr[0][task]);
                }
            }
            return maxi;
        }

        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            int point = arr[day][task] + f(day - 1, task, arr);
            maxi = Math.max(maxi, point);
        }
        return dp[day][last] = maxi;
    }

    // using Tabulation

    int ninja(int n, int[][] points) {
        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][1], points[0][0]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;

                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }
        return dp[n - 1][3];
    }

    // space optimization
    int ninja2(int n, int[][] points) {
        int[] prev = new int[4];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][1], points[0][0]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;

                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }

}
