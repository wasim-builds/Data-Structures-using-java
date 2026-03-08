package BitWise;

public class ClearKthBit {
    public static int clearKthBit(int n, int k) {
        return n & ~(1 << k);
    }
    public static void main(String[] args) {
        System.out.println(clearKthBit(7, 1)); // 5
    }
}
