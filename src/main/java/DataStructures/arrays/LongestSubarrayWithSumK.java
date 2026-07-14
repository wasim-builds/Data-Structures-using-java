package arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public static int longestSubarraywithsumK(int[] arr, int k){
        Map<Integer,Integer> sumIndex = new HashMap<>();
        int prefixSum=0,maxLength=0;
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];
            if(prefixSum ==k){
                maxLength=i+1;// from index 0 to i

            }
            if(sumIndex.containsKey(prefixSum-k)){
                maxLength=Math.max(maxLength, i-sumIndex.get(prefixSum-k));
            }
            sumIndex.putIfAbsent(prefixSum, i);

        }
        return maxLength;
       
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,1,1,1,1,4,2};
        int k=5;
        System.out.println(longestSubarraywithsumK(arr, k));//output
    }
    
}
