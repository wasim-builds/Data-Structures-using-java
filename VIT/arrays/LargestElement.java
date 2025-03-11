package arrays;
import java.util.Scanner;
public class LargestElement{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i] =sc.nextInt();

        }
        // Arrays.toString(arr);
        // Arrays.sort(arr);

        // int Large=0;
        // int SecLarge=0;
        // if(arr[n-1] > n-2){
        //     Large=arr[n-1];
        //     System.out.println(Large);

        // }
        // if(arr[n-1] == arr[n-2]){
        //     SecLarge=arr[n-3];
        //     System.out.println(SecLarge);
        // }
        int largest=arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        System.out.println(largest);




    }

}