/**
 * Greedy Algorithms Collection
 * 
 * Activity Selection Problem
 * Time Complexity: O(n log n) for sorting
 * Space Complexity: O(1)
 * 
 * Select maximum number of non-overlapping activities
 */
public class ActivitySelection {

    static class Activity {
        int start;
        int finish;
        int index;

        Activity(int start, int finish, int index) {
            this.start = start;
            this.finish = finish;
            this.index = index;
        }
    }

    // Select maximum activities (activities sorted by finish time)
    public static java.util.List<Integer> selectActivities(int[] start, int[] finish) {
        int n = start.length;
        java.util.List<Activity> activities = new java.util.ArrayList<>();

        for (int i = 0; i < n; i++) {
            activities.add(new Activity(start[i], finish[i], i));
        }

        // Sort by finish time
        activities.sort((a, b) -> Integer.compare(a.finish, b.finish));

        java.util.List<Integer> selected = new java.util.ArrayList<>();
        selected.add(activities.get(0).index);

        int lastFinishTime = activities.get(0).finish;

        for (int i = 1; i < n; i++) {
            if (activities.get(i).start >= lastFinishTime) {
                selected.add(activities.get(i).index);
                lastFinishTime = activities.get(i).finish;
            }
        }

        return selected;
    }

    // Get maximum number of activities
    public static int maxActivities(int[] start, int[] finish) {
        return selectActivities(start, finish).size();
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] finish = { 2, 4, 6, 7, 9, 9 };

        System.out.println("Activity Selection Problem");
        System.out.println("Start times:  " + java.util.Arrays.toString(start));
        System.out.println("Finish times: " + java.util.Arrays.toString(finish));

        java.util.List<Integer> selected = selectActivities(start, finish);
        System.out.println("\nSelected activities (indices): " + selected);
        System.out.println("Maximum activities: " + selected.size());

        System.out.println("\nActivity Details:");
        for (int i : selected) {
            System.out.println("Activity " + i + ": [" + start[i] + ", " + finish[i] + "]");
        }
    }
}
