
import java.util.Scanner;
import java.util.Stack;
public class Stacks {
    public static boolean isEmpty(Stack<Integer> s){
        return s.empty();

    }
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s= new Stack<>();
    
        if(isEmpty(s)){
        System.out.println("stack is empty");

        }else{
        System.out.println("not empty");
        }
        s.push(1);
        if(isEmpty(s)){
            System.out.println("stack is empty");
        }else{
            System.out.println("stack is not empty");
        }
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s);
        s.pop();
        System.out.println(s);
        int n=s.size();
        System.out.println(n);
        s.remove(2);
        System.out.println(s);
   }

}
