package Algorithms.NumberTheory;

import java.util.Random;

/**
 * Miller-Rabin Primality Test
 * A probabilistic primality test: an algorithm which determines whether a given number is likely to be prime.
 */
public class MillerRabinPrimalityTest {
    
    private ModularExponentiation me = new ModularExponentiation();
    
    public boolean isPrime(long n, int k) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0) return false;
        
        long d = n - 1;
        while (d % 2 == 0)
            d /= 2;
            
        Random rand = new Random();
        for (int i = 0; i < k; i++) {
            long a = 2 + (Math.abs(rand.nextLong()) % (n - 4));
            long x = me.power(a, d, n);
            if (x == 1 || x == n - 1)
                continue;
                
            boolean primeProb = false;
            long tempD = d;
            while (tempD != n - 1) {
                x = (x * x) % n;
                tempD *= 2;
                if (x == 1) return false;
                if (x == n - 1) {
                    primeProb = true;
                    break;
                }
            }
            if (!primeProb) return false;
        }
        return true;
    }
}
