package Matrix;



import java.util.Scanner;

class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get dimensions
        System.out.println("Enter rows and columns for Matrix A:");
        int rowsA = sc.nextInt();
        int colsA = sc.nextInt();

        System.out.println("Enter rows and columns for Matrix B:");
        int rowsB = sc.nextInt();
        int colsB = sc.nextInt();

        // Matrix multiplication rule check
        if (colsA != rowsB) {
            System.out.println("Matrix multiplication not possible! Columns of A must match rows of B.");
            return;
        }

        int[][] A = new int[rowsA][colsA];
        int[][] B = new int[rowsB][colsB];
        int[][] C = new int[rowsA][colsB];  // Resultant matrix

        // Input for Matrix A
        System.out.println("Enter elements of Matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // Input for Matrix B
        System.out.println("Enter elements of Matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // Matrix Multiplication Logic
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                C[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];  // Multiply and sum up
                }
            }
        }

        // Display the Result
        System.out.println("Resultant Matrix after Multiplication:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}