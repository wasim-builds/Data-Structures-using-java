import java.util.*;

/**
 * K Closest Points to Origin
 * 
 * Problem: Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane
 * and an integer k, return the k closest points to the origin (0, 0).
 * 
 * The distance between two points on the X-Y plane is the Euclidean distance: sqrt((x1 - x2)^2 + (y1 - y2)^2).
 * 
 * Example 1:
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation: Distance from origin: (1,3) = sqrt(10), (-2,2) = sqrt(8)
 * 
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]] (or [[-2,4],[3,3]])
 * 
 * Approach: Use Max Heap of size k
 * - Store points with their distances in max heap
 * - If heap size > k, remove the farthest point
 * - Remaining k points are the closest
 * 
 * Time Complexity: O(n log k)
 * Space Complexity: O(k)
 */
public class KClosestPoints {
    
    /**
     * Point class with distance calculation
     */
    static class Point {
        int x, y;
        double distance;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            // Calculate squared distance (no need for sqrt for comparison)
            this.distance = x * x + y * y;
        }
        
        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }
    }
    
    /**
     * Find K closest points using max heap
     */
    public static int[][] kClosest(int[][] points, int k) {
        // Max heap based on distance (squared)
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(b.distance, a.distance)
        );
        
        for (int[] point : points) {
            Point p = new Point(point[0], point[1]);
            maxHeap.offer(p);
            
            // Keep only k closest points
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        // Build result
        int[][] result = new int[k][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            Point p = maxHeap.poll();
            result[index][0] = p.x;
            result[index][1] = p.y;
            index++;
        }
        
        return result;
    }
    
    /**
     * Alternative using built-in array sorting
     */
    public static int[][] kClosestSort(int[][] points, int k) {
        // Sort by distance
        Arrays.sort(points, (a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(distA, distB);
        });
        
        // Return first k points
        return Arrays.copyOfRange(points, 0, k);
    }
    
    /**
     * Using PriorityQueue directly with arrays
     */
    public static int[][] kClosestDirect(int[][] points, int k) {
        // Max heap with custom comparator
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                int distA = a[0] * a[0] + a[1] * a[1];
                int distB = b[0] * b[0] + b[1] * b[1];
                return Integer.compare(distB, distA); // Max heap
            }
        );
        
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        
        return result;
    }
    
    /**
     * Print points array
     */
    private static void printPoints(int[][] points) {
        System.out.print("[");
        for (int i = 0; i < points.length; i++) {
            System.out.print(Arrays.toString(points[i]));
            if (i < points.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    /**
     * Calculate and print distance
     */
    private static double calculateDistance(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[][] points1 = {{1, 3}, {-2, 2}};
        int k1 = 1;
        System.out.println("Points: ");
        printPoints(points1);
        System.out.println("K = " + k1);
        System.out.print("K Closest Points: ");
        printPoints(kClosest(points1, k1));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 2
        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int k2 = 2;
        System.out.println("Points with distances:");
        for (int[] p : points2) {
            System.out.printf("%s -> distance: %.2f%n", 
                Arrays.toString(p), calculateDistance(p));
        }
        System.out.println("K = " + k2);
        System.out.print("K Closest Points: ");
        printPoints(kClosest(points2, k2));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 3
        int[][] points3 = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        int k3 = 3;
        System.out.println("Points: ");
        printPoints(points3);
        System.out.println("K = " + k3);
        System.out.print("K Closest Points (Direct): ");
        printPoints(kClosestDirect(points3, k3));
    }
}
