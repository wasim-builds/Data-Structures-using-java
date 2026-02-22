package CompetitiveProgramming;

import java.io.*;
import java.util.*;


/**
 * Number Theory Template for Competitive Programming
 * 
 * Contains commonly used number theory functions:
 * - GCD and LCM
 * - Prime checking and generation (Sieve of Eratosthenes)
 * - Modular arithmetic (power, inverse, factorial)
 * - Divisors and prime factorization
 */
public class NumberTheoryTemplate {

    private static final int MOD = 1000000007; // 10^9 + 7

    // ==================== GCD and LCM ====================

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b; // Avoid overflow
    }

    // Extended GCD: returns gcd and coefficients x, y such that ax + by = gcd(a,b)
    public static long[] extendedGCD(long a, long b) {
        if (b == 0) {
            return new long[] { a, 1, 0 };
        }
        long[] result = extendedGCD(b, a % b);
        long gcd = result[0];
        long x = result[2];
        long y = result[1] - (a / b) * result[2];
        return new long[] { gcd, x, y };
    }

    // ==================== Prime Numbers ====================

    // Check if number is prime - O(√n)
    public static boolean isPrime(long n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Sieve of Eratosthenes - O(n log log n)
    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    // Get all primes up to n
    public static List<Integer> getPrimes(int n) {
        boolean[] isPrime = sieveOfEratosthenes(n);
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    // ==================== Modular Arithmetic ====================

    // Modular exponentiation: (base^exp) % mod - O(log exp)
    public static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

    // Modular inverse using Fermat's Little Theorem (when mod is prime)
    // a^(-1) ≡ a^(mod-2) (mod mod)
    public static long modInverse(long a, long mod) {
        return modPow(a, mod - 2, mod);
    }

    // Precompute factorials and inverse factorials for nCr calculations
    public static long[] precomputeFactorials(int n, long mod) {
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }
        return fact;
    }

    // nCr mod p using precomputed factorials
    public static long nCr(int n, int r, long[] fact, long mod) {
        if (r > n || r < 0)
            return 0;
        long numerator = fact[n];
        long denominator = (fact[r] * fact[n - r]) % mod;
        return (numerator * modInverse(denominator, mod)) % mod;
    }

    // ==================== Divisors ====================

    // Get all divisors of n - O(√n)
    public static List<Long> getDivisors(long n) {
        List<Long> divisors = new ArrayList<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        Collections.sort(divisors);
        return divisors;
    }

    // Count divisors
    public static int countDivisors(long n) {
        int count = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count += (i * i == n) ? 1 : 2;
            }
        }
        return count;
    }

    // Prime factorization - O(√n)
    public static Map<Long, Integer> primeFactorization(long n) {
        Map<Long, Integer> factors = new HashMap<>();

        // Check for 2
        while (n % 2 == 0) {
            factors.put(2L, factors.getOrDefault(2L, 0) + 1);
            n /= 2;
        }

        // Check odd factors
        for (long i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }

        if (n > 2) {
            factors.put(n, 1);
        }

        return factors;
    }

    // ==================== Other Utilities ====================

    // Sum of divisors
    public static long sumOfDivisors(long n) {
        long sum = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) {
                    sum += n / i;
                }
            }
        }
        return sum;
    }

    // Euler's Totient Function φ(n) - count of numbers ≤ n coprime to n
    public static long eulerTotient(long n) {
        long result = n;
        for (long p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }

    // ==================== Demo ====================

    public static void main(String[] args) {
        System.out.println("=== GCD and LCM ===");
        System.out.println("GCD(48, 18) = " + gcd(48, 18));
        System.out.println("LCM(48, 18) = " + lcm(48, 18));

        System.out.println("\n=== Prime Checking ===");
        System.out.println("Is 17 prime? " + isPrime(17));
        System.out.println("Is 18 prime? " + isPrime(18));

        System.out.println("\n=== Sieve (primes up to 30) ===");
        System.out.println(getPrimes(30));

        System.out.println("\n=== Modular Arithmetic ===");
        System.out.println("2^10 mod 1000000007 = " + modPow(2, 10, MOD));
        System.out.println("Inverse of 5 mod 1000000007 = " + modInverse(5, MOD));

        System.out.println("\n=== Divisors of 36 ===");
        System.out.println(getDivisors(36));
        System.out.println("Count: " + countDivisors(36));

        System.out.println("\n=== Prime Factorization of 60 ===");
        System.out.println(primeFactorization(60));

        System.out.println("\n=== Euler's Totient ===");
        System.out.println("φ(12) = " + eulerTotient(12));
    }
}
