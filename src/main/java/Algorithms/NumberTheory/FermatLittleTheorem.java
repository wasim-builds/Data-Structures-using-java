package Algorithms.NumberTheory;

import java.util.ArrayList;
import java.util.List;

/**
 * Fermat's Little Theorem
 * Used to find modular inverse of a under modulo m, where m is prime.
 */
public class FermatLittleTheorem {
    public long modInverse(long a, long m) {
        ModularExponentiation me = new ModularExponentiation();
        return me.power(a, m - 2, m);
    }
}
