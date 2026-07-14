package leetcode;

import java.util.Scanner;

public class KthLargestfactor {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       int number,r,i,count=0;
       number = sc.nextInt();
       r = sc.nextInt();
       
       for (i = number; i >= 1; i--) 
       {
          if((number%i)==0)
              count++;
          if(count==r)
          {
              System.out.println(i);
              break;
          }
       }
       if(count!=r)
           System.out.println(1);
    

    }   
}
