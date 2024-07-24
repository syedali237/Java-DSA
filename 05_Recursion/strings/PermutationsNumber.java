import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsNumber {
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        // permutation(new int[0], nums);

        ArrayList<int[]> ans = permutationList(new int[0], nums);
        for (int[] perm : ans) {
            System.out.println(Arrays.toString(perm));
        }

        // System.out.println("Count: " + permutationCount(new int[0], new int[]{1, 2, 3, 4}));
    }

    static void permutation(int[] p, int[] up) {
        if (up.length == 0) {
            System.out.println(Arrays.toString(p));
            return;
        }

        int num = up[0];
        for (int i = 0; i <= p.length; i++) {
            int[] newP = insertAt(p, i, num);
            permutation(newP, Arrays.copyOfRange(up, 1, up.length));
        }
    }

    static ArrayList<int[]> permutationList(int[] p, int[] up) {
        if (up.length == 0) {
            ArrayList<int[]> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int num = up[0];
        ArrayList<int[]> ans = new ArrayList<>();
        for (int i = 0; i <= p.length; i++) {
            int[] newP = insertAt(p, i, num);
            ans.addAll(permutationList(newP, Arrays.copyOfRange(up, 1, up.length)));
        }
        return ans;
    }

    static int permutationCount(int[] p, int[] up) {
        if (up.length == 0) {
            return 1;
        }
        int count = 0;
        int num = up[0];
        for (int i = 0; i <= p.length; i++) {
            int[] newP = insertAt(p, i, num);
            count += permutationCount(newP, Arrays.copyOfRange(up, 1, up.length));
        }
        return count;
    }

    static int[] insertAt(int[] array, int index, int num) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = num;
        System.arraycopy(array, index, newArray, index + 1, array.length - index);
        return newArray;
    }
}
