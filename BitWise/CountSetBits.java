package BitWise;


public class CountSetBits {
    public static void main(String[] args) {
        int num = 29; // 11101 (4 ones)
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        System.out.println("Number of 1s: " + count);
    }
}
