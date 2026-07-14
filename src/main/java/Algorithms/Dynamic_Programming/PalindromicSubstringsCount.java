package Dynamic_Programming;

public class PalindromicSubstringsCount {
    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expandCount(s, i, i);
            count += expandCount(s, i, i + 1);
        }
        return count;
    }

    private static int expandCount(String s, int l, int r) {
        int c = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            c++;
            l--;
            r++;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println("Palindromic substrings: " + countSubstrings("aaa"));
    }
}
