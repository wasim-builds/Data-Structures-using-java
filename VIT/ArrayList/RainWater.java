package ArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class RainWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int sum =0;
        int left=arr[0];
        int right=arr[n-1];
        int water_level=Math.min(left,right);
        for(int i=0;i<n;i++){
            if(arr[i]<water_level){
                sum +=water_level-arr[i];
            }
        }
        System.out.println(sum);


    }
    
}
