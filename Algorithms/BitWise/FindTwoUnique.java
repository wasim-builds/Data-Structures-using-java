package BitWise;

public class FindTwoUnique {
    public static int[] findTwoUnique(int[] arr) {
        int xor = 0;
        for (int n : arr) xor ^= n;
        int setBit = xor & -xor;
        int[] res = new int[2];
        for (int n : arr) {
            if ((n & setBit) == 0) res[0] ^= n;
            else res[1] ^= n;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 9, 2, 4};
        int[] res = findTwoUnique(arr);
        System.out.println(res[0] + ", " + res[1]); // 7, 9
    }
}
