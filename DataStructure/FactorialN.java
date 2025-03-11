public class FactorialN {
    public static void main(String[] args) {
        int n=5;
        int facto = 1;
        for(int i=1; i<=5;i++){
            facto = facto *i;
            System.out.println(facto);
        }
        System.out.println("factorial of number is "+facto);
        

    }
}
