package Matrix;
import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int A[][]= new int[rows][cols];
        int B[][]= new int[rows][cols];
        int C[][]= new int[rows][cols];
        System.out.println("Matrix A : ");

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                A[i][j]=sc.nextInt();
            }
        }
        System.out.println("Matrix B");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                B[i][j]=sc.nextInt();

            }
        }
        System.out.println("Matrix C :");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                C[i][j]=A[i][j]+B[i][j];

            }
        }

        System.out.println("printing c");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(C[i][j]+" ");
            }
            System.out.println("");
        }





    }
    
}
