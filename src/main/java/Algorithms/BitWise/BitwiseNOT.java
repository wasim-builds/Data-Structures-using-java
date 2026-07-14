package BitWise;

public class BitwiseNOT {
    public static int bitwiseNot(int n) {
        return ~n;
    }
    public static void main(String[] args) {
        System.out.println(bitwiseNot(5)); // -6
    }
}
