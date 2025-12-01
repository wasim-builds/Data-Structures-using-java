
class Main{
    public static void main(String[] args) {
        try {
            int a = 10 / 0;
            System.out.println("After divide");
        } catch (ArithmeticException e) {
            System.out.println("In catch");
        } finally {
            System.out.println("In finally");
        }
        System.out.println("After try-catch");
    }
}