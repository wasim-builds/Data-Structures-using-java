package BitWise;

public class FindUnique {
    public static int findUnique(int[] arr) {
        int res = 0;
        for (int n : arr) res ^= n;
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 4, 4};
        System.out.println(findUnique(arr)); // 3
    }
}
