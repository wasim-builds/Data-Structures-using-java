package arrays;

import java.util.*;




public class practise{

    
    public static int[] twosum(int nums[], int target){
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int x=target-nums[i];
            if(mp.containsKey(x)){
                
                return new int[]{mp.get(x), i};
            }
            mp.put(nums[i],i);
        }
        return null;
        

    }
    
    public static void main(String[] args) {
        

        practise man = new practise();
        int nums[]={1,2,3,4,5,6};
        int target =7;
        int wasim[]=man.twosum(nums,target);
        System.out.println(Arrays.toString(wasim));


        
    }

}