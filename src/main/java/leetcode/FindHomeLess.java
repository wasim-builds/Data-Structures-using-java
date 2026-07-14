package leetcode;
import java.util.Scanner;

public class FindHomeLess {
    public static void main(String args[])
    {
      Scanner sc = new Scanner (System.in);
      int n=sc.nextInt();
      int people[]= new int[n];
      int house[]= new int[n];
      for(int i=0; i<n; i++)
         people[i]=sc.nextInt();      
      for(int i=0; i<n; i++)
         house[i]=sc.nextInt();       
      int count = 0;
      for(int i=0; i<n; i++){       
          for(int j=0; j<n; j++){
           if(people[i]<house[j]){
              count+=1 ;
              house[j]=-1;
              break ;
              }
          }
      }
      System.out.println(".()");
      System.out.println(n-count);
    }
}
