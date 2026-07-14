/**
 * GCD and LCM Algorithms
 * Time Complexity: O(log min(a,b))
 * Space Complexity: O(1) iterative, O(log min(a,b)) recursive
 */
public class GCDandLCM {

    // Euclidean algorithm - Recursive
    public static int gcdRecursive(int a, int b) {
        if (b == 0)
            return a;
        return gcdRecursive(b, a % b);
    }

    // Euclidean algorithm - Iterative
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // LCM using GCD
    public static long lcm(int a, int b) {
        return ((long) a * b) / gcd(a, b);
    }

    // Extended Euclidean Algorithm
    // Returns gcd and coefficients x, y such that ax + by = gcd(a,b)
    public static int[] extendedGCD(int a, int b) {
        if (b == 0) {
            return new int[] { a, 1, 0 };
        }

        int[] result = extendedGCD(b, a % b);
        int gcd = result[0];
        int x1 = result[1];
        int y1 = result[2];

        int x = y1;
        int y = x1 - (a / b) * y1;

        return new int[] { gcd, x, y };
    }

    // GCD of array
    public static int gcdArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
            if (result == 1)
                return 1;
        }
        return result;
    }

    // LCM of array
    public static long lcmArray(int[] arr) {
        long result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = lcm((int) result, arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("GCD(48, 18) = " + gcd(48, 18)); // 6
        System.out.println("LCM(48, 18) = " + lcm(48, 18)); // 144

        int[] arr = { 12, 18, 24 };
        System.out.println("\nGCD of array: " + gcdArray(arr)); // 6
        System.out.println("LCM of array: " + lcmArray(arr)); // 72

        int[] extended = extendedGCD(35, 15);
        System.out.println("\nExtended GCD(35, 15):");
        System.out.println("GCD = " + extended[0]);
        System.out.println("35*" + extended[1] + " + 15*" + extended[2] + " = " + extended[0]);
    }
}
