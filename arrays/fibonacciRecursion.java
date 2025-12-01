package arrays;

import java.util.Scanner;
public class fibonacciRecursion {
    public static int fibonacciNumber(int n){
        if(n<=1){
            return n;
        }
        return fibonacciNumber(n-1)+fibonacciNumber(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        
        System.out.println("Fibonacci Seris: ");
        for(int i=0;i<n;i++){
            System.out.print(fibonacciNumber(i)+" ");
        }
        sc.close();
        
    }
    
}
