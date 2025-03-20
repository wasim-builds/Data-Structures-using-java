package arrays;

public class findLeaders {
    
}


//LEADERS IN ARRAY

import java.util.*;
import java.lang.*;
public class Main
{
public static void main(String[] args) {
Scanner s = new Scanner(System.in);
System.out.println("Enter size of the array");
        int n = s.nextInt();
        int[] arr = new int[n];
System.out.println("Enter elements of the array");
        for (int i = 0; i < n; i++){ 
        arr[i] = s.nextInt();
        }
findLeaders(arr, n);}
static void findLeaders(int arr[], int size){
   int rightMaximum=arr[arr.length-1];   
System.out.print(rightMaximum+" ");
      for (int i = size-2; i>=0; i--) {
         if(arr[i] > rightMaximum){
            rightMaximum=arr[i];
            System.out.print(rightMaximum+" ");
         }
      }
   }
}

