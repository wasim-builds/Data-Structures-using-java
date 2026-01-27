package InterviewQuestions.Graphs;

import java.util.*;

/**
 * LeetCode 417: Pacific Atlantic Water Flow
 * 
 * Problem: Given an m x n matrix of non-negative integers representing the
 * height of each cell,
 * find all cells from which water can flow to both the Pacific and Atlantic
 * oceans.
 * 
 * Water can flow from a cell to another one with height equal or lower.
 * Pacific ocean touches left and top edges, Atlantic touches right and bottom
 * edges.
 * 
 * Approach: DFS from both oceans
 * - Start DFS from all Pacific border cells
 * - Start DFS from all Atlantic border cells
 * - Return cells reachable from both
 * 
 * Time Complexity: O(m × n)
 * Space Complexity: O(m × n)
 */
public class PacificAtlanticWaterFlow {

    private static int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // DFS from Pacific borders (top and left)
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);
        }

        // DFS from Atlantic borders (bottom and right)
        for (int i = 0; i < m; i++) {
            dfs(heights, atlantic, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, atlantic, m - 1, j);
        }

        // Find cells reachable from both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private static void dfs(int[][] heights, boolean[][] visited, int row, int col) {
        int m = heights.length;
        int n = heights[0].length;

        visited[row][col] = true;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Check bounds and if not visited
            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                continue;
            }
            if (visited[newRow][newCol]) {
                continue;
            }
            // Water can only flow from higher or equal height
            if (heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            dfs(heights, visited, newRow, newCol);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Standard grid
        int[][] heights1 = {
                { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 }
        };
        List<List<Integer>> result1 = pacificAtlantic(heights1);
        System.out.println("Test 1: " + result1);
        // Expected: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

        // Test Case 2: Small grid
        int[][] heights2 = { { 1 } };
        List<List<Integer>> result2 = pacificAtlantic(heights2);
        System.out.println("Test 2: " + result2);
        // Expected: [[0,0]]

        // Test Case 3: 2x2 grid
        int[][] heights3 = {
                { 1, 2 },
                { 2, 1 }
        };
        List<List<Integer>> result3 = pacificAtlantic(heights3);
        System.out.println("Test 3: " + result3);
        // Expected: [[0,0],[0,1],[1,0],[1,1]]
    }
}
