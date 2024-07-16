import java.util.ArrayList;

/**
 * LinearS
 */
public class LinearS {

    public static void main(String[] args) {
        int[] arr = {1,2,4,18,18,15};
        int target = 18;
        System.out.println(search(arr, target, 0));
        System.out.println(findIndex(arr, target, 0));
        System.out.println(findIndexLast(arr, target, arr.length - 1));
        findAllIndex(arr, 18, 0);
        System.out.println(list);
        System.out.println(findAllIndexinList(arr, target, 0, new ArrayList<>()));

        System.out.println(findAllIndexinList2(arr, target, 0));
    }

    static boolean search(int[] arr, int target, int index){
        if (index == arr.length) {
            return false;
        }
        return arr[index] == target || search(arr, target, index + 1);
    }

    static int findIndex(int[] arr, int target, int index){
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        } else{
            return findIndex(arr, target, index+1);
        }
    }

    static int findIndexLast(int[] arr, int target, int index){
        if (index == -1) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        } else{
            return findIndex(arr, target, index-1);
        }
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndex(int[] arr, int target, int index){
        if (index == arr.length) {
            return;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        findAllIndex(arr, target, index + 1);
    }

    static ArrayList findAllIndexinList(int[] arr, int target, int index, ArrayList<Integer> list){
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        return findAllIndexinList(arr, target, index + 1, list);
    }

    static ArrayList findAllIndexinList2(int[] arr, int target, int index){
        ArrayList<Integer> listt = new ArrayList<>();

        if (index == arr.length) {
            return listt;
        }

        // this will contain answer for that fxn only
        if (arr[index] == target) {
            listt.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = findAllIndexinList2(arr, target, index + 1);
        
        listt.addAll(ansFromBelowCalls);

        return listt;
    }

}