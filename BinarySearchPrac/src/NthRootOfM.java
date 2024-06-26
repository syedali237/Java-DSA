public class NthRootOfM {
    public static void main(String[] args) {
        int n = 6;
        int m =15625;
        System.out.println(NthRoot(n, m));
    }

    static int NthRoot(int n, int m){
        // code here
        if (m == 1) return 1;
        int start = 1;
        int end = m;
        double epsilon = 1e-9; // Tolerance for floating-point comparison

        while (start <= end) {
            int mid = start + (end - start) / 2;
            double midPower = Math.pow(mid, n);

            if (Math.abs(midPower - m) < epsilon) {
                return mid;
            }

            if (midPower < m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
