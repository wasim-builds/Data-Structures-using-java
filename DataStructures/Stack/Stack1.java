package Stack;
import java.util.Stack;

public class Stack1 {
    public static void main(String[] args) {
        Stack<Integer> num = new Stack<>();
        num.push(1);
        num.push(4);
        num.push(2);
        num.push(143);

        System.out.println(num);
        num.peek();
        System.out.println(num.peek());
        num.pop();
        System.out.println(num);
        if(!num.isEmpty())
        {
            System.out.println("is not empty stack");
        }else{
            System.out.println("empty");
        }
        // pop all element
        while(!num.isEmpty()){
            System.out.println(num.pop());
        }
    }
}
