package arrays;
import java.util.Scanner;

public class MaxMinArray {
    public static void findMaxMin(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty!");
            return;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        System.out.println("Maximum Element: " + max);
        System.out.println("Minimum Element: " + min);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        findMaxMin(arr);
        scanner.close();
    }
}
