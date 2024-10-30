import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // constructor 1:`
        StringBuffer sb = new StringBuffer();
        // System.out.println(sb.capacity());
        
        // constructor 2: 
        StringBuffer sb2 = new StringBuffer("Syed Ali Ul Hasan");

        // constructor 3:
        StringBuffer sb3 = new StringBuffer(30);

        sb.append("HelloEvery");
        sb.append(" where are you all");

        // sb.insert(2, " ALI ");

        sb.replace(1, 4, "syed");

        sb.delete(1, 5);
        sb.reverse();

        // String str = sb.toString();
        // System.out.println(str);

        // Random random = new Random();
        // System.out.println(random.nextFloat());

        int n = 20;
        String name = RandomString.generate(n);
        System.out.println(name);

        // remove whitspaces

        String sentence = "hi hasdasd as sad ";
        System.out.println(sentence);
        System.out.println(sentence.replaceAll("\\s", ""));

        // split 
        String arr = "Kunal Appoore Rahul Snehal";
        String[] names = arr.split(" ");
        System.out.println(Arrays.toString(names));

        // rounding off

        DecimalFormat df = new DecimalFormat("0.0000");
        System.out.println(df.format(7.2));
    }
}
