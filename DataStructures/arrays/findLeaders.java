package arrays;
// LEADERS IN AN ARRAY
import java.util.Scanner;

public class findLeaders {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter size of the array: ");
        int n = s.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        System.out.println("Leaders in the array:");
        findLeaders(arr, n);
    }

    static void findLeaders(int[] arr, int size) {
        int rightMaximum = arr[size - 1];
        System.out.print(rightMaximum + " "); // Rightmost element is always a leader

        for (int i = size - 2; i >= 0; i--) {
            if (arr[i] > rightMaximum) {
                rightMaximum = arr[i];
                System.out.print(rightMaximum + " ");
            }
        }
    }
}


