package BitWise;

public class RightmostSetBit {
    public static int rightmostSetBit(int n) {
        return n & -n;
    }
    public static void main(String[] args) {
        System.out.println(rightmostSetBit(12)); // 4
    }
}
