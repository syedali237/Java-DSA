/**
 * NoOfDigits
 */
public class NoOfDigits {

    public static void main(String[] args) {
        int n = 6; // 6 in binary (base 2) = 110
        int base = 2;
        System.out.println(digits(n , base)); // 3
    }

    static int digits(int n , int base){
        int ans = (int) (Math.log(n) / Math.log(base)) + 1;
        return ans;
    }
}