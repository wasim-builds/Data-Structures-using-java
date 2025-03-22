package arrays;
import java.util.Scanner;

public class FibonacciArray {
    public static void printFibonacci(int n) {
        int a = 0, b = 1, c;
        System.out.print(a + " " + b + " "); // First two numbers

        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print("Fibonacci Series: ");
        printFibonacci(n);
    }
    
}
