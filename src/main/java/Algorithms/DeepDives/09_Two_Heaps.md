# Understanding the Two Heaps Concept

Think of the Two Heaps pattern like a manager trying to instantly find the median worker productivity in an ever-growing company. To do this quickly, the manager splits the company into two groups: the "Lower Half" of performers and the "Upper Half".
The manager keeps the *best* worker of the Lower Half right at the top of their list (Max Heap), and the *worst* worker of the Upper Half at the top of the other list (Min Heap). 

By ensuring both lists are always roughly the same size, the median is always just a glance at the top of one or both piles, taking O(1) time instead of O(N log N) sorting time.

The core components are:
1. **Max Heap**: Stores the smaller half of the numbers. (The maximum of the smaller numbers is at the root).
2. **Min Heap**: Stores the larger half of the numbers. (The minimum of the larger numbers is at the root).

## Balancing the Heaps
Whenever we insert a new number, we must maintain two rules:
- **Order Rule**: Every number in the Max Heap must be smaller than or equal to every number in the Min Heap.
- **Size Rule**: The Max Heap can have at most 1 more element than the Min Heap (or they can be equal).

### The Process Step-by-Step
**Goal:** Insert numbers `[3, 1, 5, 4]` and find the median at each step.

```plaintext
Step 1: Insert '3'.
        Max Heap is empty. Put 3 in Max Heap.
        Max Heap: [3] | Min Heap: []
        Median: Top of Max Heap = 3.0

Step 2: Insert '1'.
        1 < 3 (Top of Max Heap), so put in Max Heap.
        Max Heap: [3, 1] | Min Heap: []
        Size Rule Violated! (Max Heap size is 2, Min Heap is 0).
        Move top of Max Heap (3) to Min Heap.
        Max Heap: [1] | Min Heap: [3]
        Median: (Top of Max Heap + Top of Min Heap) / 2 = (1 + 3) / 2 = 2.0

Step 3: Insert '5'.
        5 > 1 (Top of Max Heap), so put in Min Heap.
        Max Heap: [1] | Min Heap: [3, 5]
        Size Rule Violated! (Min Heap size is 2, Max Heap is 1).
        Move top of Min Heap (3) to Max Heap.
        Max Heap: [3, 1] | Min Heap: [5]
        Median: Top of Max Heap = 3.0

Step 4: Insert '4'.
        4 > 3 (Top of Max Heap), so put in Min Heap.
        Max Heap: [3, 1] | Min Heap: [4, 5]
        Median: (3 + 4) / 2 = 3.5
```

### Comparison Summary
| Feature | Max Heap | Min Heap |
|---------|----------|----------|
| **Contents** | The smaller half of the dataset. | The larger half of the dataset. |
| **Root Element**| The largest value among the small numbers. | The smallest value among the large numbers. |
| **Balancing** | Usually allowed to be exactly 1 larger than Min Heap for odd totals. | Never allowed to be larger than Max Heap. |
| **Used For...** | Finding Median of a Data Stream, Sliding Window Median. | |
