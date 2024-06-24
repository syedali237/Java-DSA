import java.util.Arrays;

/**
 * CylicSort
 */
public class CylicSort {

    public static void main(String[] args) {
        int[] nums = {3,5,2,1,4};
        cycleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void cycleSort(int[] arr){
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr , i, correctIndex);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}