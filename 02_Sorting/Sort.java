import java.util.Arrays;

/**
 * Sort
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr ={5,4,3,2,1};
        // bubbleSort(arr);
        // selectionSort(arr);
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // INSERTION SORT
    static void insertionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                } else { 
                    // when element at j !smaller than prev element then break
                    // since , sorted Left hand side array
                    break;
                }
            }
        }
    }
    
    // SELECTION SORT
    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            // find the max item in remaining array 
            // and swap the correct index
            int last = arr.length - i -1;
            int maxIndex = getMaxIndex(arr,0,last);
            swap(arr, maxIndex, last);
        }
    }

    static int getMaxIndex(int[] arr, int start, int end){
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr, int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // BUBBLE SORT
    static void bubbleSort(int[] arr){
        boolean swapped;
        // run the steps n-1 times
        for(int i = 0; i<arr.length;i++){
            swapped = false;
            // for each step, max item will come at the last respective index
            for (int j = 1; j < arr.length - i; j++) {
                // swap if the item is smaller than prev one
                if (arr[j] < arr[j-1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            // if you did not swap for a particular vale of i,
            // it means arr is sorted , stop the program
            if (!swapped) { // !false = true
                break;
            }
        }
    }
}