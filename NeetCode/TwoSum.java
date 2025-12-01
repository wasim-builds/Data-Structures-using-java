package NeetCode;

import java.util.Arrays;
import java.util.HashMap;
public class TwoSum

{
    public static int[] TwoSum(int nums[], int target){
        int n=nums.length;
        HashMap<Integer,Integer> mp= new HashMap<>();
        
        
        for(int i=0;i<n;i++){
            int comp=target-nums[i];
            if(mp.containsKey(comp)){
                return new int[]{mp.get(comp),i};
            }
            mp.put(nums[i],i);
            
        }
        return new int[]{}; // return empty array if no result found
        
    }
	public static void main(String[] args) {
	    
		int nums[]={5,7,3,6,1,4};
		int target=13;
		
		System.out.println(" printing indexs of target");
		int[] result = TwoSum(nums,target);
		
		if (result.length == 2) {
            System.out.println("Indices: " + Arrays.toString(result));
        } else {
            System.out.println("No two numbers add up to the target.");
        }
	
		
		
		
	}
}