package practices;


import java.util.*;

public class Targetsum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of elements
        int n = scanner.nextInt();
        int[] candidates = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            candidates[i] = scanner.nextInt();
        }

        // Read target sum
        int target = scanner.nextInt();

        // Find combinations
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to ensure lexicographical order
        findCombinations(candidates, target, 0, new ArrayList<>(), result);

        // Print results
        for (List<Integer> combination : result) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void findCombinations(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Found a valid combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break; // Optimization: stop if the number is greater than remaining target
            }
            current.add(candidates[i]); // Include the number
            findCombinations(candidates, target - candidates[i], i, current, result); // Recur with same index
            current.remove(current.size() - 1); // Backtrack
        }
    }
}
