/**
 * SB
 */
public class SB {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        // mutable : changes in the same object 
        // no new object is created
        // therefore performance wise better
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            builder.append(ch);
        }
        System.out.println(builder);
    }
}