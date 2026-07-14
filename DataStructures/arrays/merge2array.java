// Online Java Compiler
// Use this editor to write, compile and run your Java code online
package arrays;
import java.util.Arrays;

class merge2array {
    public static void main(String[] args) {
        int nums[]={1,2,3,0,0,0};
        int nums2[]={2,3,5};
        int m=3,n=3;
        MergeArrays(nums,nums2,m,n);
        System.out.println(Arrays.toString(nums));
    }
    public static void MergeArrays(int[] nums, int[] nums2,int m,int n){
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(j>=0){
            if(i>=0 && nums[i]>nums2[j]){
                nums[k]=nums[i];
                
                i--;
            }
            else{
                nums[k]=nums2[j];
                
                j--;
            }
            k--;
        }
        
    }
}