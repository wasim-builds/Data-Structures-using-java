package BitWise;

public class MultiplyByTwo {
    public static int multiplyByTwo(int n) {
        return n << 1;
    }
    public static void main(String[] args) {
        System.out.println(multiplyByTwo(7)); // 14
    }
}
