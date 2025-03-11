import java.util.Scanner;
 
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();
        
        int totalRows = (n * 2) - 1;

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 1; j <= totalRows; j++) {
                // Print star at the leftmost diagonal and rightmost diagonal
                if (j == (n - (i - 1)) || j == (n + (i - 1))) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            // Move to the next line
            System.out.println();
        }

        sc.close();
    }
}
