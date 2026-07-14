package Algorithms.SortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Bucket Sort Implementation
 * Sorts an array of floating point numbers using Bucket Sort.
 */
public class BucketSort {
    public void sort(float[] arr, int n) {
        if (n <= 0) return;
        
        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<Float>();
        }
        
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (arr[i] * n);
            buckets[bucketIndex].add(arr[i]);
        }
        
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }
}
