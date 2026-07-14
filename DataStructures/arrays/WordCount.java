package arrays;

//Word count
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine().trim();
        
        String[] words = input.split("\\s+");
        System.out.println("Word Count: " + words.length);
        
        scanner.close();

        
    }
}
