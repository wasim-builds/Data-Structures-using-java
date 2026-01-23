import java.util.*;

/**
 * LeetCode #207 - Course Schedule
 * Difficulty: Medium
 * Topological Sort / Cycle Detection
 * Time: O(V+E), Space: O(V+E)
 */
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        // Build graph
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
            inDegree[prereq[0]]++;
        }

        // Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            for (int next : graph.get(course)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][] { { 1, 0 } })); // true
        System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } })); // false
    }
}
