
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SubSet
 */
public class SubSet {

    public static void main(String[] args) {
        int[] arr = {1,2,2};
        List<List<Integer>> ans = subsetDuplicate(arr);
        for (List<Integer> list : ans){
            System.out.println(list);
        }
    }

    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int num : arr){
            int n = outer.size();
            for(int i = 0 ; i < n; i++){
                // internal list will be created how many times outer list size
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

    static List<List<Integer>> subsetDuplicate(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start;
        int end = 0;
        for(int i = 0 ; i < arr.length; i++){
            start = 0;
            // if current and previous elements is same, s = e + 1
            if (i > 0 && arr[i] == arr[i-1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for(int j = start ; j < n; j++){
                // internal list will be created how many times outer list size
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}