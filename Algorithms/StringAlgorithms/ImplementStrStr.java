/**
 * Implement strStr() (LeetCode 28) - Knuth-Morris-Pratt (KMP) Algorithm
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] lps = computeLPSArray(needle);
        
        int i = 0; // index for haystack
        int j = 0; // index for needle
        while (i < haystack.length()) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
                i++;
            }
            if (j == needle.length()) {
                return i - j;
            } else if (i < haystack.length() && needle.charAt(j) != haystack.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }
    
    private int[] computeLPSArray(String pat) {
        int[] lps = new int[pat.length()];
        int len = 0;
        int i = 1;
        lps[0] = 0;
        
        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
