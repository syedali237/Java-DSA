/**
 * Power
 */
public class Power {

    public static void main(String[] args) {
        int base = 2;
        int pow = 4;
        System.out.println(answer(base, pow));
    }

    static int answer(int base, int pow){
        int ans = 1;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                ans *= base;
            }
            base *= base;
            pow = pow >> 1;
        }
        return ans;
    }
}