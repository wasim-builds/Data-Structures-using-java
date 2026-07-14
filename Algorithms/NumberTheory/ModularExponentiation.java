/**
 * Modular Exponentiation
 * Computes (x^y) % p in O(log y) time.
 */
public class ModularExponentiation {
    public long power(long x, long y, long p) {
        long res = 1;
        x = x % p;
        if (x == 0) return 0;
        
        while (y > 0) {
            if ((y & 1) != 0) {
                res = (res * x) % p;
            }
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
}
