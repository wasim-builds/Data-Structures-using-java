package arrays;
import java.util.*;
public class TwoDArray {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int arr[][]= new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        Arrays.toString(arr);
        int sum=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(arr[i][j]+"\t");           
            }
            System.out.println();
        }
        System.out.println("Sum value");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(arr[i][j]<0){
                    sum-=arr[i][j];
                }
                           
            }
            
        }
        System.out.println(sum);



    }
    
}
