package BitWise;

public class CountBitsToFlip {
    public static int countBitsToFlip(int a, int b) {
        int xor = a ^ b, count = 0;
        while (xor != 0) {
            count++;
            xor &= (xor - 1);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countBitsToFlip(10, 20)); // 4
    }
}
