package Stack;
import java.util.Scanner;
import java.util.Stack;
public class StackInputInt {
    public static void main(String[] args) {
        Stack<Integer> num= new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter Element: "+(i+1));
            int element =sc.nextInt();
            num.push(element);
            
        }
        System.out.println(num);
        System.out.println(num.size());
        sc.close();
        // popping an element if the stack is not empty
        if(!num.isEmpty()){
            int popped=num.pop();
            System.out.println(popped);
            System.out.println(num);
        }
        else{
            System.out.println("stack is empty. Nothing to pop.");
        }
        System.out.println("before popping all element: "+ num);
        System.out.println("Top element : "+num.peek());
        while(!num.isEmpty()){
            System.out.println("popped : "+num.pop());
        }
        System.out.println(num);
        

    }
    
}
