
/**
 * Sieve of Eratosthenes - Find all primes up to n
 * Time Complexity: O(n log log n)
 * Space Complexity: O(n)
 */
import java.util.*;

public class SieveOfEratosthenes {

    public static List<Integer> sieveOfEratosthenes(int n) {
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

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    // Count primes up to n
    public static int countPrimes(int n) {
        if (n <= 2)
            return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i])
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 30;
        List<Integer> primes = sieveOfEratosthenes(n);

        System.out.println("Prime numbers up to " + n + ":");
        System.out.println(primes);

        System.out.println("\nCount of primes less than 100: " + countPrimes(100));
    }
}
