// Code submitted by syedali237 at 24/9/2025, 11:25:13 pm
// This will generate a compilation error

import java.io.*;
import java.util.*;

public class Main {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = in.nextInt(); // uncomment for multiple test cases
        while (t-- > 0) {
            solve();
        }
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++)
            a[i] = in.nextInt();

        boolean ok = true;
        for (int i = 1; i < m; i++) {
            if (a[i] != a[i - 1] + 1) {
                ok = false;
                break;
            }
        }

        if (!ok) {
            out.println(0);
            return;
        }

        int maxVal = a[m - 1];
        if (maxVal > n) {
            out.println(0);
            return;
        }

        out.println(n - maxVal + 1);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
