package LinearSearch;

public class FindMin {
    public static void main(String[] args) {
        int[] arr ={18,12,-7,3,14 ,28};
        System.out.println(min(arr));
    }

    static int min(int[] arr){
        int minimum = arr[0];
        for (int i = 1 ; i<arr.length ; i++ ){
            if (arr[i] < minimum){
                minimum = arr[i];
            }
        }
        return minimum;
    }
}