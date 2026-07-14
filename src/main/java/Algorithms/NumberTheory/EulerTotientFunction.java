package Algorithms.NumberTheory;

/**
 * Euler's Totient Function
 * Counts the positive integers up to a given integer n that are relatively prime to n.
 */
public class EulerTotientFunction {
    public int phi(int n) {
        int result = n;
        for (int p = 2; p * p <= n; ++p) {
            if (n % p == 0) {
                while (n % p == 0)
                    n /= p;
                result -= result / p;
            }
        }
        if (n > 1)
            result -= result / n;
        return result;
    }
}
