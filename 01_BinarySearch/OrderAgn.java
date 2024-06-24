/**
 * OrderAgn
 */
public class OrderAgn {

    public static void main(String[] args) {
        // int[] arr = {-18,-12,-4,0,2,3,4,15,16,18,22,45,89};
        int[] arr = {99,88,78,65,21,10};
        int target = 21;
        int ans = orderAgnosticBS(arr, target);
        System.out.println(ans);
    }

    static int orderAgnosticBS(int[] arr, int target){
        int start =0;
        int end= arr.length - 1;
        // find sorted array is ascending or descending?
        boolean isAsc = arr[start] < arr[end];
        // if(arr[start] < arr[end]){
        //     isAsc = true;
        // } else {
        //     isAsc = false;
        // }
        System.out.println(isAsc);

        while (start <= end) {
            int mid = start + (end-start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid -1 ;    
                } else {
                    start = mid + 1;
                } 
            } else {
                if (target > arr[mid]) {
                    end = mid -1 ;    
                } else {
                    start = mid + 1;
                } 
            }
        }
        return -1;
    }
}