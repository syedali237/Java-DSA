/**
 * Performance
 */
public class Performance {

    public static void main(String[] args) {
        String series = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            series = series + ch; // series += ch 
            // each time new object will be created
        }
        System.out.println(series);
    }
}