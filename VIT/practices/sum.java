package practices;



import java.lang.*;
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        int target =7;
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.toString(arr);
        for(int num : arr){
            System.out.println(num + " ");
        }
        sc.close();
        for(int i=0;i<n;i++){
            int curr=arr[i];
            if(curr[i] + arr[i] =7){

            }

        }
        
	}
} 
    

