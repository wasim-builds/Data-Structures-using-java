package Strings;
import java.util.Scanner;

public class UpperEachWord {
    public static String capitalizeWords(String sentence){
        String[] words = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        for(String word : words){
            if(!word.isEmpty()){
                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
        }

        return result.toString().trim();
    }
// printing
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter a sentence");
        String sentence = sc.nextLine();
        System.out.println("Capitalized sentence : "+ capitalizeWords(sentence));
        sc.close();
        
    }
    
}
