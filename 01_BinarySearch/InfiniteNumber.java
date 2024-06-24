/**
 * InfiniteNumber
 */
public class InfiniteNumber {

    // ARRAY CONTAINS INFINITE NUMBERS
    // FIND POSTION OF ELEMENT IN A SORTED ARRAY OF INFINTE NUMBER
    // not use .length since we dont know length
    public static void main(String[] args) {
    
    }

    static int findingRange(int[] arr, int target){
        // find range
        // first start with box of size 2;
        int start = 0;
        int end= 1;
        // conditon for the target to lie in range
        while (target > arr[end]) {
            int newStart =  end +1;
            // end = prev.end + sizeOfBox *2 
            end = end + (end + 1 - start)*2;
            start = newStart; 
        }
        return binarySearch(arr, target , start, end);
    }
    
    static int binarySearch(int[] arr, int target, int start,int end){
        while (start <= end) {
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