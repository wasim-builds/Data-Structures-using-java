package Matrix;
import java.util.Scanner;

public class MaxElementMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int A[][]= new int[rows][cols];
        System.out.println("Enter elements in Matrix");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                A[i][j]=sc.nextInt();
            }
        }
        int maxElement=A[0][0];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(maxElement<A[i][j]){
                    maxElement=A[i][j];
                }
            }
        }
        System.out.println("Maxelement = "+maxElement);
    }
    
}
