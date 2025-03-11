import java.util.Scanner;
public class Strg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstName = "wasim";
        String lastName = "khan";
        String fullName = firstName + lastName;
        System.out.println(fullName);
        System.out.println(fullName.length());
        for(int i=0; i<fullName.length()-1;i++){
            System.out.println(fullName.charAt(i));
        }
       
    }
}
