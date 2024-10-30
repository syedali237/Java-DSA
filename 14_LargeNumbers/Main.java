import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        BD();
    }


    static void BD(){
        double x = 0.03;
        double y = 0.04;
        double ans = y - x;
        System.out.println(ans);

        BigDecimal X = new BigDecimal("0.03");
        BigDecimal Y = new BigDecimal("0.04");
        BigDecimal ANS = Y.subtract(X);
        System.out.println(ANS);


        BigDecimal a = new BigDecimal("872349872947129.387431974912");
        BigDecimal b = new BigDecimal("12731923123.21398712391");

        // operations
        System.out.println(a.add(b));


    }


    static void BI() {
        int a = 30;
        int b = 67;

        BigInteger A = BigInteger.valueOf(33);
        BigInteger B = BigInteger.valueOf(334324234);
        int c = B.intValue(); // convert BI to int
        BigInteger C = new BigInteger("23412343122817381263891279873");
        System.out.println(C);

        // constants
        BigInteger D = BigInteger.TEN;

        // addition
        BigInteger s = A.add(B);

        BigInteger m = C.multiply(A);

        // System.out.println(s);

        System.out.println(Factorial.fact(21312));
    }

}
