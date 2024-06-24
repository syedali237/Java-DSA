public class Main {
    public static void main(String[] args) {
        int[] arr ={2,3,5,9,14,16,18};
        int target = 15;
        int ans = Ceiling(arr,target);
        // int ans2 = Floor(arr,target);
        System.out.println(ans);
    }

    // smallest number greater than or equal to target
    static int Ceiling(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while(start<= end){
            int mid = start + (end-start)/2;
            if(target < arr[mid]){
                end = mid - 1;
             } else if (target > arr[mid]){
                start = mid +1;
            } else {
                return mid;
            }
        }
        return start;
    }

    // greatest number less than or equal to target
    static int Floor(int[] arr,int target){

        // what if target is greater than the greatest number in the array
        if (target>arr[arr.length-1]){
            return -1;
        }

        int start = 0;
        int end = arr.length-1;
        while(start<= end){
            int mid = start + (end-start)/2;
            if(target < arr[mid]){
                end = mid - 1;
            } else if (target > arr[mid]){
                start = mid +1;
            } else {
                return mid;
            }
        }
        return end;
    }

}