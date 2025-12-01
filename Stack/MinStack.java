package Stack;
import java.util.Scanner;
import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Stack<Integer> minstack= new Stack<>();
        for(int i=0;i<n;i++){
            int num=sc.nextInt();
            if(minstack.isEmpty() || num<=minstack.peek()){
                minstack.push(num);
            }
        }
        System.out.println(minstack.peek());

    }
    
}
