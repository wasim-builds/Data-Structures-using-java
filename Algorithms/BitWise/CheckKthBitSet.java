package BitWise;

public class CheckKthBitSet {
    public static boolean isKthBitSet(int n, int k) {
        return (n & (1 << k)) != 0;
    }
    public static void main(String[] args) {
        System.out.println(isKthBitSet(5, 2)); // true
    }
}
