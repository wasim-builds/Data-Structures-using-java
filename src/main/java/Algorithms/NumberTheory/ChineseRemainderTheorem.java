package Algorithms.NumberTheory;

/**
 * Chinese Remainder Theorem
 * Solves a system of congruences: x = a_i (mod m_i) for i = 1 to k.
 */
public class ChineseRemainderTheorem {
    public int findMinX(int[] num, int[] rem) {
        int prod = 1;
        for (int i = 0; i < num.length; i++) {
            prod *= num[i];
        }
        
        int result = 0;
        for (int i = 0; i < num.length; i++) {
            int pp = prod / num[i];
            result += rem[i] * modInverse(pp, num[i]) * pp;
        }
        
        return result % prod;
    }
    
    private int modInverse(int a, int m) {
        int[] res = ExtendedEuclideanAlgorithm.gcdExtended(a, m);
        int x = res[1];
        return (x % m + m) % m;
    }
}
