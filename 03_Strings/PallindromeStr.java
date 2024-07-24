/**
 * PallindromeStr
 */
public class PallindromeStr {

    public static void main(String[] args) {
        // String str = "abcba";
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }

    static boolean isPalindrome(String str) {
        // if (str == null || str.length() == 0) {
        //     return true;
        // }
        // str = str.toLowerCase(); // for single strings without spaces

        str = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        if (str == null || str.length() == 0) { // check for the updated string
                return true;
        }

        for (int i = 0; i <= str.length() / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length() - 1 - i);

            if (start != end) {
                return false;
            }
        }
        return true;
    }
}