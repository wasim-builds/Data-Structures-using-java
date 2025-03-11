import java.util.Scanner;
public class primNum{
    public static void main(String[] args) {
        int count =0;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=1;i<=num;i++){
            if(num%i==0){
                count++;
            }
        }
        if(count==2){
            System.out.println(num+" is a prime number");
        }else{
            System.out.println("not a prime");
        }

    }
}