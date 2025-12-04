// ============================================
// RECURSION PROBLEMS IN JAVA - COMPLETE COLLECTION
// Author: MOHAMMED WASIM KHAN
// 14 Problems from Basic to Advanced
// ============================================

import java.util.*;

public class RecursionProblems {
    
    // ==================== WARM-UP PROBLEMS ====================
    
    // 1. Factorial - Calculate n!
    public static long factorial(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive case
        return n * factorial(n - 1);
    }
    
    // 2. Fibonacci - Find nth Fibonacci number
    public static int fibonacci(int n) {
        // Base cases
        if (n <= 1) {
            return n;
        }
        // Recursive case
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    // 3. Sum of Digits - Sum all digits recursively
    public static int sumOfDigits(int n) {
        // Base case
        if (n == 0) {
            return 0;
        }
        // Recursive case
        return (n % 10) + sumOfDigits(n / 10);
    }
    
    // 4. Power Function - Calculate x^n
    public static double power(double x, int n) {
        // Base case
        if (n == 0) {
            return 1;
        }
        // Handle negative exponents
        if (n < 0) {
            return 1 / power(x, -n);
        }
        // Optimize with divide and conquer
        double half = power(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
    
    // ==================== INTERMEDIATE PROBLEMS ====================
    
    // 5. Reverse a String
    public static String reverseString(String str) {
        // Base case
        if (str.isEmpty()) {
            return str;
        }
        // Recursive case
        return reverseString(str.substring(1)) + str.charAt(0);
    }
    
    // 6. Palindrome Check
    public static boolean isPalindrome(String str) {
        return isPalindromeHelper(str, 0, str.length() - 1);
    }
    
    private static boolean isPalindromeHelper(String str, int left, int right) {
        // Base case
        if (left >= right) {
            return true;
        }
        // Check if characters match
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        // Recursive case
        return isPalindromeHelper(str, left + 1, right - 1);
    }
    
    // 7. Binary Search - Recursive implementation
    public static int binarySearch(int[] arr, int target, int left, int right) {
        // Base case - element not found
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        
        // Element found
        if (arr[mid] == target) {
            return mid;
        }
        
        // Search left half
        if (arr[mid] > target) {
            return binarySearch(arr, target, left, mid - 1);
        }
        
        // Search right half
        return binarySearch(arr, target, mid + 1, right);
    }
    
    // 8. Tower of Hanoi - Classic recursive problem
    public static void towerOfHanoi(int n, char from, char to, char aux) {
        // Base case
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }
        
        // Move n-1 disks from 'from' to 'aux' using 'to'
        towerOfHanoi(n - 1, from, aux, to);
        
        // Move the nth disk from 'from' to 'to'
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        
        // Move n-1 disks from 'aux' to 'to' using 'from'
        towerOfHanoi(n - 1, aux, to, from);
    }
    
    // 9. Generate All Subsets (Power Set)
    public static void generateSubsets(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        // Base case - add current subset to result
        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Exclude current element
        generateSubsets(arr, index + 1, current, result);
        
        // Include current element
        current.add(arr[index]);
        generateSubsets(arr, index + 1, current, result);
        current.remove(current.size() - 1); // Backtrack
    }
    
    // ==================== ADVANCED PROBLEMS ====================
    
    // 10. N-Queens Problem - Backtracking
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> solutions = new ArrayList<>();
        nQueensHelper(board, 0, solutions);
        return solutions;
    }
    
    private static void nQueensHelper(char[][] board, int row, List<List<String>> solutions) {
        // Base case - all queens placed
        if (row == board.length) {
            solutions.add(constructSolution(board));
            return;
        }
        
        // Try placing queen in each column
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                nQueensHelper(board, row + 1, solutions);
                board[row][col] = '.'; // Backtrack
            }
        }
    }
    
    private static boolean isSafe(char[][] board, int row, int col) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        
        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        
        return true;
    }
    
    private static List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
    
    // 11. Generate All Permutations
    public static void generatePermutations(int[] arr, int start, List<List<Integer>> result) {
        // Base case
        if (start == arr.length - 1) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : arr) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }
        
        // Swap and recurse
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            generatePermutations(arr, start + 1, result);
            swap(arr, start, i); // Backtrack
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // 12. Maze Solver - Find path from (0,0) to (n-1,n-1)
    public static boolean solveMaze(int[][] maze, int x, int y, int[][] solution) {
        int n = maze.length;
        
        // Base case - reached destination
        if (x == n - 1 && y == n - 1 && maze[x][y] == 1) {
            solution[x][y] = 1;
            return true;
        }
        
        // Check if valid move
        if (isValidMove(maze, x, y)) {
            // Mark as part of solution
            solution[x][y] = 1;
            
            // Move right
            if (solveMaze(maze, x, y + 1, solution)) {
                return true;
            }
            
            // Move down
            if (solveMaze(maze, x + 1, y, solution)) {
                return true;
            }
            
            // Backtrack
            solution[x][y] = 0;
            return false;
        }
        
        return false;
    }
    
    private static boolean isValidMove(int[][] maze, int x, int y) {
        int n = maze.length;
        return x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1;
    }
    
    // 13. Flood Fill Algorithm (Paint Bucket Tool)
    public static void floodFill(int[][] image, int sr, int sc, int newColor, int originalColor) {
        // Base cases
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }
        if (image[sr][sc] != originalColor || image[sr][sc] == newColor) {
            return;
        }
        
        // Fill current pixel
        image[sr][sc] = newColor;
        
        // Recursive calls for 4 directions
        floodFill(image, sr + 1, sc, newColor, originalColor); // Down
        floodFill(image, sr - 1, sc, newColor, originalColor); // Up
        floodFill(image, sr, sc + 1, newColor, originalColor); // Right
        floodFill(image, sr, sc - 1, newColor, originalColor); // Left
    }
    
    // 14. Word Search in 2D Grid - Backtracking
    public static boolean wordSearch(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (wordSearchHelper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean wordSearchHelper(char[][] board, String word, int i, int j, int index) {
        // Base case - word found
        if (index == word.length()) {
            return true;
        }
        
        // Check boundaries and character match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
            board[i][j] != word.charAt(index)) {
            return false;
        }
        
        // Mark as visited
        char temp = board[i][j];
        board[i][j] = '#';
        
        // Search in all 4 directions
        boolean found = wordSearchHelper(board, word, i + 1, j, index + 1) ||
                       wordSearchHelper(board, word, i - 1, j, index + 1) ||
                       wordSearchHelper(board, word, i, j + 1, index + 1) ||
                       wordSearchHelper(board, word, i, j - 1, index + 1);
        
        // Backtrack
        board[i][j] = temp;
        
        return found;
    }
    
    // ==================== MAIN METHOD WITH TEST CASES ====================
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║   RECURSION PROBLEMS - COMPLETE COLLECTION    ║");
        System.out.println("║        14 Problems from Basic to Advanced      ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");
        
        // ========== WARM-UP PROBLEMS ==========
        System.out.println("========== WARM-UP PROBLEMS ==========\n");
        
        // 1. Factorial
        System.out.println("1. FACTORIAL");
        System.out.println("   Input: 5");
        System.out.println("   Output: " + factorial(5));
        System.out.println("   Explanation: 5! = 5 × 4 × 3 × 2 × 1 = 120\n");
        
        // 2. Fibonacci
        System.out.println("2. FIBONACCI");
        System.out.println("   Input: 7");
        System.out.println("   Output: " + fibonacci(7));
        System.out.println("   Explanation: Sequence: 0,1,1,2,3,5,8,13... (7th = 13)\n");
        
        // 3. Sum of Digits
        System.out.println("3. SUM OF DIGITS");
        System.out.println("   Input: 12345");
        System.out.println("   Output: " + sumOfDigits(12345));
        System.out.println("   Explanation: 1+2+3+4+5 = 15\n");
        
        // 4. Power
        System.out.println("4. POWER FUNCTION");
        System.out.println("   Input: 2^10");
        System.out.println("   Output: " + power(2, 10));
        System.out.println("   Explanation: 2^10 = 1024 (using divide & conquer)\n");
        
        // ========== INTERMEDIATE PROBLEMS ==========
        System.out.println("\n========== INTERMEDIATE PROBLEMS ==========\n");
        
        // 5. Reverse String
        System.out.println("5. REVERSE STRING");
        System.out.println("   Input: 'Hello'");
        System.out.println("   Output: '" + reverseString("Hello") + "'");
        System.out.println("   Explanation: Characters reversed recursively\n");
        
        // 6. Palindrome
        System.out.println("6. PALINDROME CHECK");
        System.out.println("   Input: 'racecar'");
        System.out.println("   Output: " + isPalindrome("racecar"));
        System.out.println("   Input: 'hello'");
        System.out.println("   Output: " + isPalindrome("hello") + "\n");
        
        // 7. Binary Search
        System.out.println("7. BINARY SEARCH");
        int[] sortedArr = {1, 3, 5, 7, 9, 11, 13};
        System.out.println("   Array: [1, 3, 5, 7, 9, 11, 13]");
        System.out.println("   Search: 7");
        System.out.println("   Output: Index " + binarySearch(sortedArr, 7, 0, sortedArr.length - 1));
        System.out.println("   Explanation: Found at index 3\n");
        
        // 8. Tower of Hanoi
        System.out.println("8. TOWER OF HANOI (3 disks)");
        System.out.println("   Moving from A to C using B:");
        towerOfHanoi(3, 'A', 'C', 'B');
        System.out.println("   Total moves: 7 (2^3 - 1)\n");
        
        // 9. Subsets
        System.out.println("9. GENERATE ALL SUBSETS");
        System.out.println("   Input: [1, 2, 3]");
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(new int[]{1, 2, 3}, 0, new ArrayList<>(), subsets);
        System.out.println("   Output: " + subsets);
        System.out.println("   Total subsets: " + subsets.size() + " (2^3)\n");
        
        // ========== ADVANCED PROBLEMS ==========
        System.out.println("\n========== ADVANCED PROBLEMS ==========\n");
        
        // 10. N-Queens
        System.out.println("10. N-QUEENS PROBLEM (4x4 board)");
        List<List<String>> queensSolutions = solveNQueens(4);
        System.out.println("    Total solutions: " + queensSolutions.size());
        System.out.println("    First solution:");
        for (String row : queensSolutions.get(0)) {
            System.out.println("    " + row);
        }
        System.out.println();
        
        // 11. Permutations
        System.out.println("11. GENERATE PERMUTATIONS");
        System.out.println("    Input: [1, 2, 3]");
        List<List<Integer>> perms = new ArrayList<>();
        generatePermutations(new int[]{1, 2, 3}, 0, perms);
        System.out.println("    Output: " + perms);
        System.out.println("    Total permutations: " + perms.size() + " (3!)\n");
        
        // 12. Maze Solver
        System.out.println("12. MAZE SOLVER");
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        int[][] solution = new int[4][4];
        System.out.println("    Maze (1=path, 0=wall):");
        for (int[] row : maze) {
            System.out.print("    ");
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        if (solveMaze(maze, 0, 0, solution)) {
            System.out.println("\n    Solution path (1=path taken):");
            for (int[] row : solution) {
                System.out.print("    ");
                for (int cell : row) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        }
        System.out.println();
        
        // 13. Flood Fill
        System.out.println("13. FLOOD FILL");
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        System.out.println("    Original image:");
        for (int[] row : image) {
            System.out.print("    ");
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        floodFill(image, 1, 1, 2, 1);
        System.out.println("\n    After flood fill (1→2) from (1,1):");
        for (int[] row : image) {
            System.out.print("    ");
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        // 14. Word Search
        System.out.println("14. WORD SEARCH IN 2D GRID");
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        System.out.println("    Grid:");
        for (char[] row : board) {
            System.out.print("    ");
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println("\n    Search 'ABCCED': " + wordSearch(board, "ABCCED"));
        System.out.println("    Search 'SEE': " + wordSearch(board, "SEE"));
        System.out.println("    Search 'ABCB': " + wordSearch(board, "ABCB"));
        
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║          All 14 problems executed!             ║");
        System.out.println("╚════════════════════════════════════════════════╝");
    }
}
