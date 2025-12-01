package regex;
public class Regexsbasic {
    public static void main(String args[]){
        String text = "First item: Part-A   Second item: Part-B_123.";

        // String arr[] = text.split(" ");
        // for(String name:arr){
        //     System.out.println(name+" ");
        // }
        String num[] = text.split("\\s+");

        for(String n:num){
            System.out.println(n +" ");
        }
    }
    
}
