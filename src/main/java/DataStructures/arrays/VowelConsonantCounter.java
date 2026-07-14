package arrays;

//vowels and consonent counter

import java.util.Scanner;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine().toLowerCase(); // Convert input to lowercase
        
        int vowels = 0, consonants = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if ((ch >= 'a' && ch <= 'z')) { // Check if it's a letter
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);

        scanner.close();
    }
}






