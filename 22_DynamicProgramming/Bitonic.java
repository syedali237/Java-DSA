import java.util.Arrays;

public class Bitonic {

    public static void main(String[] args) {
        int[] arr = {1, 11, 2,10,4,5,2,1};
        System.out.println(longestBitonic(arr));
    }

    static int longestBitonic(int[] arr) {
        int n = arr.length;
        
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1); 
        Arrays.fill(dp2, 1); 

        for (int i = 1 ; i < n; i++){
            for (int j = 0; j < i; j++){
                if (arr[j] < arr[i] && 1 + dp1[j] > dp1[i]) {
                    dp1[i] = 1 + dp1[j];
                }                
            }
        }
    
        for (int i = n - 1 ; i >= 0; i--){
            for (int j = n -1; j > i; j--){
                if (arr[j] < arr[i] && 1 + dp2[j] > dp2[i]) {
                    dp2[i] = 1 + dp2[j];
                }                
            }
        }

        int maxi = 0;
        for (int i = 0; i < n; i++){
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }

        return maxi;
    }

}
