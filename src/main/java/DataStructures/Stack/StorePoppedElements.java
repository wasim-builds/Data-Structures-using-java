package Stack;

import java.util.Scanner;
import java.util.Stack;

public class StorePoppedElements {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] poppedElements = new int[n]; // Array to store popped elements
        for(int i=0;i<n;i++){
            System.out.println("element : "+(i+1));
            int element=scanner.nextInt();

            stack.push(element);
        }
        System.out.println(stack);

        int arr[]= new int[n];
        int index =0;
        while(!stack.isEmpty()){
            arr[index++]=stack.pop();
        }
        System.out.println("Popped elements: ");
        for(int num:arr){
            System.out.print(num+" ");

        }
    }
    
}
