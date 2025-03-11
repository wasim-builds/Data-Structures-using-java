import java.util.Scanner;
public class ReverseInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        int rev =0;
        while(num >0){
            rev = rev*10 + num%10;
            num = num/10;
        }
        
        
        if (num==rev) {
            System.out.println("pallin");
            
        }
        else{
            System.out.println("not pallin");
        }

    }
}
