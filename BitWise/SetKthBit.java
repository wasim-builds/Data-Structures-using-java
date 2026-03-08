package BitWise;

public class SetKthBit {
    public static int setKthBit(int n, int k) {
        return n | (1 << k);
    }
    public static void main(String[] args) {
        System.out.println(setKthBit(5, 1)); // 7
    }
}
