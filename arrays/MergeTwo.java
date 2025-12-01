package arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MergeTwo{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int nums1[]= new int[m];
        int nums2[]= new int[n];
        
        
        
        
        for(int i=0;i<m;i++){
            nums1[i]=sc.nextInt();
        }
        
        
        for(int i=0;i<n;i++){
            nums2[i]=sc.nextInt();
        }
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<m;i++){
            list.add(nums1[i]);
            
        }
        for(int i=0;i<n;i++){
            list.add(nums2[i]);
            
        }

        System.out.println(list);

        
    }
}