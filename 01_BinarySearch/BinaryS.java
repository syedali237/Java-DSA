/**
 * BinaryS
 */
public class BinaryS {

    public static void main(String[] args) {
        int[] arr = {-1,0,2,3,4,5,18,22,45};
        int target = 3;
        System.out.println(binarySearch(arr, target));
    }

    // return target index
    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            // find the middle element
            // int mid = (start+end) / 2 ; int has fixed size
            // might be possible that start + end exceeds range of 
            // int in Java, so better way =>
            int mid = start + (end-start) / 2;

            if (target < arr[mid]) {
                end = mid -1 ;    
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}