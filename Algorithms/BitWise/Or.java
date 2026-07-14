package BitWise;

public class Or {
    public static void main(String[] args) {
        int a = 5;  // 0101
        int b = 3;  // 0011
        
        System.out.println("AND: " + (a & b)); // 0001 -> 1
        System.out.println("OR: " + (a | b));  // 0111 -> 7
        System.out.println("XOR: " + (a ^ b)); // 0110 -> 6
        System.out.println("NOT a: " + (~a));  // -(5+1) -> -6
        System.out.println("Left Shift a << 1: " + (a << 1));  // 1010 -> 10
        System.out.println("Right Shift a >> 1: " + (a >> 1)); // 0010 -> 2
        System.out.println("Unsigned Right Shift -8 >>> 1: " + (-8 >>> 1));
    }
    
}
