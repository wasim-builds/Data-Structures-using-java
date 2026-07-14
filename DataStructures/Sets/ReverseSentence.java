package Sets;
import java.util.Stack;
public class ReverseSentence{
    public static void main(String[] args) {

        String name="wasim khan is very bad boy";
        String[] arr=name.split("\\s+");
        Stack<String> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
            stack.push(arr[i]);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
            System.out.print(" ");
        }

        
        

    }
}