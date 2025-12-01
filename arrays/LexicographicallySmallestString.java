package arrays;

//Lexicographically Smallest Substring After K Swaps

public class LexicographicallySmallestString {
    public static String getLexicographicallySmallest(String str, int k) {
        char[] arr = str.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n - 1 && k > 0; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n && j - i <= k; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            for (int j = minIndex; j > i; j--) {
                char temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
            k -= (minIndex - i);
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String str = "cba";
        int k = 1;
        System.out.println(getLexicographicallySmallest(str, k)); // Output: "bca"
    }
}
