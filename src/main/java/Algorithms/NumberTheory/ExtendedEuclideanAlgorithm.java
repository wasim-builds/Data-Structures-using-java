package Algorithms.NumberTheory;

/**
 * Extended Euclidean Algorithm
 * Finds integer coefficients x and y such that ax + by = gcd(a, b).
 */
public class ExtendedEuclideanAlgorithm {
    public static int[] gcdExtended(int a, int b) {
        if (a == 0) {
            return new int[] { b, 0, 1 };
        }
        int[] vals = gcdExtended(b % a, a);
        int gcd = vals[0];
        int x1 = vals[1];
        int y1 = vals[2];
        
        int x = y1 - (b / a) * x1;
        int y = x1;
        
        return new int[] { gcd, x, y };
    }
}
