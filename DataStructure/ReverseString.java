import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String reverse = "";
        for(int i=name.length()-1;i>=0;i--){
            reverse = reverse + name.charAt(i);
        }
        System.out.println(reverse);

        if(name.compareTo(reverse)==0){
            System.out.println("The string is a palindrome");
        }else{
            System.out.println("not a pallindrom");
        }
    }
}
