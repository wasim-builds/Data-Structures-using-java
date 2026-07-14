package Algorithms.NumberTheory;

import java.util.ArrayList;
import java.util.List;

/**
 * Prime Factorization
 * Finds all prime factors of a given number n.
 */
public class PrimeFactorization {
    public List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        
        if (n > 2) {
            factors.add(n);
        }
        
        return factors;
    }
}
