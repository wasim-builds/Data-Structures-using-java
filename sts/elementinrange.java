package sts;



import java.util.*;

public class elementinrange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user for number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<>();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());  // Automatically sorted & no duplicates
        }

        // Ask for the range
        System.out.print("Enter lower bound (l): ");
        int l = sc.nextInt();
        System.out.print("Enter upper bound (r): ");
        int r = sc.nextInt();

        System.out.println("Elements in range [" + l + ", " + r + "]:");
        for (int val : set.subSet(l, true, r, true)) {
            System.out.print(val + " ");
        }
        System.out.println(); // new line at end
    }
}
