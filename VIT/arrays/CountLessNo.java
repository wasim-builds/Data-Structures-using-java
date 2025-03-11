import java.util.Arrays;
import java.util.Scanner;
public class CountLessNo {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int nums[]= new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        
        Arrays.toString(nums);
        int largest=nums[0];
        for(int i=0;i<n;i++){
            if(nums[i]>largest){
                largest=nums[i];
            }
        }
        System.out.println(largest);

    }
    
}
