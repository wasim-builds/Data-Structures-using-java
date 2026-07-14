package Algorithms.GreedyAlgorithms;

import java.util.Arrays;

/**
 * Task Scheduler (LeetCode 621)
 * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task.
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for (int t : tasks) {
            frequencies[t - 'A']++;
        }
        Arrays.sort(frequencies);
        
        int f_max = frequencies[25];
        int idle_time = (f_max - 1) * n;
        
        for (int i = frequencies.length - 2; i >= 0 && idle_time > 0; --i) {
            idle_time -= Math.min(f_max - 1, frequencies[i]); 
        }
        idle_time = Math.max(0, idle_time);
        
        return idle_time + tasks.length;
    }
}
