package Stack;
import java.util.Scanner;
import java.util.Stack;
public class ReverseStrUsingStack{
    public static String reverseString(String str){
        Stack<Character> stack = new Stack<>();
        for( char ch:str.toCharArray()){
            stack.push(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while(!stack.isEmpty()){
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to revers: ");
        String input = scanner.nextLine();
        String reversed=reverseString(input);
        System.out.println("reversed string:"+ reversed);
        scanner.close();
      

       


    }
}