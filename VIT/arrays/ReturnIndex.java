import java.util.Scanner;

public class ReturnIndex {
    public static int findNumberIndex(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i; // Return the first occurrence index
            }
        }
        return -1; // Return -1 if num is not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input values
        int n = sc.nextInt(); // Read size of the array
        int num = sc.nextInt(); // Read number to find
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // Read array elements
        }

        // Find and print the index
        System.out.println(findNumberIndex(arr, num));

        sc.close();
    }
}
