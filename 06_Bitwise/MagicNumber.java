/**
 * MagicNumber
 */
public class MagicNumber {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(magic(n));
    }
    
    static int magic(int n){
        int ans = 0;
        int base = 5;
        while (n > 0) {
            int last = n & 1; // gives last number in binary form
            n = n >> 1; // right shift to the next number
            ans += last * base;
            base = base * 5;
        } 
        return ans;
    }
}