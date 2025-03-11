import java.util.*;

public class CandiesLeet {

    public static List<Boolean> maxCandies(int candies[], int extraCandies) {
        int largest = 0;
        int n = candies.length;

        // Find the largest number of candies
        for (int i = 0; i < n; i++) {
            if (candies[i] > largest) {
                largest = candies[i];
            }
        }

        // Check if each kid can have the greatest number of candies
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (candies[i] + extraCandies >= largest) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();           // Number of kids
        int extraCandies = sc.nextInt(); // Extra candies to give each kid
        
        int candies[] = new int[n];      // Array to store candy count of each kid
        for (int i = 0; i < n; i++) {
            candies[i] = sc.nextInt();
        }

        // Call the function and get result
        List<Boolean> result = maxCandies(candies, extraCandies);

        // Print result (each true/false for each kid)
        System.out.println(result);
    }
}
