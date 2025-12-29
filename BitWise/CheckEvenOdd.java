// 1. Check if a number is even or odd using bitwise operator
public class CheckEvenOdd {
    public static void main(String[] args) {
        int n = 5;
        if ((n & 1) == 0)
            System.out.println(n + " is Even");
        else
            System.out.println(n + " is Odd");
    }
}
