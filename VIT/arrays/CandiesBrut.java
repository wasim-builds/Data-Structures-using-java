

import java.util.Arrays;
import java.util.Scanner;
public class CandiesBrut {
   
        
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int extraCandies=sc.nextInt();
        
        int candies[]= new int[n];
        
        for(int i=0;i<n;i++){
            candies[i]=sc.nextInt();
        }
        Arrays.toString(candies);
        // print the Arrays
        for(int i=0;i<n;i++){
            System.out.println(candies[i]);
        }
        
        
        int largest =0;
        // find largest value in candies
        for(int i=0;i<n;i++){
            if(candies[i]> largest){
                largest=candies[i];

            }
        }
        //print largest number in the array
        Arrays.sort(candies);
        System.out.println("largest : "+largest);
        // boolean value are after sorting the array
        for(int i=0;i<n;i++){
            if(candies[i] + extraCandies >= largest){
                System.out.println("true");
            }
            else{
                System.out.println("False");
            }
            
        }

    }
    
}
