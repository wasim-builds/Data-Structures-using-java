import java.util.*;

/**
 * Job Sequencing with Deadlines
 * Time Complexity: O(n^2) or O(n log n) with optimized approach
 * Space Complexity: O(n)
 * 
 * Maximize profit by scheduling jobs within deadlines
 */
public class JobSequencing {

    static class Job {
        char id;
        int deadline;
        int profit;

        Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    // Schedule jobs to maximize profit
    public static void scheduleJobs(Job[] jobs) {
        // Sort jobs by profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Create slots array
        char[] result = new char[maxDeadline];
        boolean[] slot = new boolean[maxDeadline];

        int totalProfit = 0;
        int jobCount = 0;

        // Schedule jobs
        for (Job job : jobs) {
            // Find a free slot for this job (starting from last possible slot)
            for (int j = Math.min(maxDeadline, job.deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = job.id;
                    slot[j] = true;
                    totalProfit += job.profit;
                    jobCount++;
                    break;
                }
            }
        }

        // Print results
        System.out.println("Scheduled Jobs:");
        for (int i = 0; i < maxDeadline; i++) {
            if (slot[i]) {
                System.out.print(result[i] + " ");
            }
        }
        System.out.println("\n\nTotal jobs scheduled: " + jobCount);
        System.out.println("Total profit: " + totalProfit);
    }

    // Get maximum profit and job sequence
    public static int getMaxProfit(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        boolean[] slot = new boolean[maxDeadline];
        int totalProfit = 0;

        for (Job job : jobs) {
            for (int j = Math.min(maxDeadline, job.deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        Job[] jobs = {
                new Job('A', 2, 100),
                new Job('B', 1, 19),
                new Job('C', 2, 27),
                new Job('D', 1, 25),
                new Job('E', 3, 15)
        };

        System.out.println("Job Sequencing Problem");
        System.out.println("\nJobs:");
        System.out.println("ID\tDeadline\tProfit");
        System.out.println("--\t--------\t------");
        for (Job job : jobs) {
            System.out.println(job.id + "\t" + job.deadline + "\t\t" + job.profit);
        }

        System.out.println("\n" + "=".repeat(40));
        scheduleJobs(jobs);

        // Another example
        System.out.println("\n" + "=".repeat(40));
        System.out.println("\nExample 2:");
        Job[] jobs2 = {
                new Job('a', 4, 20),
                new Job('b', 1, 10),
                new Job('c', 1, 40),
                new Job('d', 1, 30)
        };

        System.out.println("\nJobs:");
        System.out.println("ID\tDeadline\tProfit");
        System.out.println("--\t--------\t------");
        for (Job job : jobs2) {
            System.out.println(job.id + "\t" + job.deadline + "\t\t" + job.profit);
        }

        System.out.println("\n" + "=".repeat(40));
        scheduleJobs(jobs2);
    }
}
