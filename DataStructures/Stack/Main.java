package Stack;

import java.util.Stack;

class Main {
    public static void main(String[] args) {
        String name="much very you loves khan wasim".trim();
        
        String arr[]=name.split("\\s+");
        
        System.out.println(arr.length);
        Stack<String> md=new Stack<>();
        for(int i=0;i<arr.length;i++){
            md.push(arr[i]);
        }
        System.out.println(md);
        while(!md.isEmpty()){
            
            System.out.print(md.pop());
            System.out.print(" ");
        }
        
    }
}
