
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1,3,5,2,7,6,3,1,4,8};

        int n = arr.length;

        // build a blocks array
        int sqrt = (int) Math.sqrt(n);

        int blocks_id = -1;

        int[] blocks = new int[sqrt + 1];

        for (int i = 0; i < n; i++) {
            // new block is starting
            if (i % sqrt == 0) {
                blocks_id++;                
            }
            blocks[blocks_id] += arr[i];
        }
        System.out.println(Arrays.toString(blocks));
        System.out.println(query(blocks, arr, 2, 7, sqrt));

        update(blocks, arr, 4, 8, sqrt);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(blocks));
    }

    public static int query(int[] blocks, int[] arr, int l, int r, int sqrt){
        int ans = 0;

        while (l % sqrt != 0 && l < r && l != 0) { // left hand side
            ans += arr[l];
            l++;
        }

        // mid part
        while (l + sqrt <= r) {
            ans += blocks[l/sqrt];
            l += sqrt;
        }

        // right part
        while (l <= r) {
            ans += arr[l];
            l++;
        }

        return ans;
    }

    public static void update(int[] blocks, int[] arr, int i, int val, int sqrt){
        int blocks_id = i / sqrt;  
        blocks[blocks_id] += (val - arr[i]);
        arr[i] = val;
    }

}
