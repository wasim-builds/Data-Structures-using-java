package arrays;



public class productArrays{
    public static void main(String args[]){
        int nums[]={-1,-2,3,4,7,-3};
        
        int maxproduct=0;
        for(int i=0;i<nums.length;i++){
            int curr= 1;
            
            for(int j=i;j<nums.length;j++){
                curr *=nums[j];
                maxproduct=Math.max(maxproduct,curr);
            }
        }
        System.out.println(maxproduct);
    }
}