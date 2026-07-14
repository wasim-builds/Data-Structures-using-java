# Understanding the Merge Intervals Concept

Think of Merge Intervals like booking meetings in a conference room on a calendar. If you have one meeting from 1:00 PM to 3:00 PM and another meeting from 2:00 PM to 4:00 PM, they overlap. Instead of keeping them separate, you combine them into a single blocked-out block from 1:00 PM to 4:00 PM.

This technique involves dealing with sets of overlapping intervals. The trick is to **sort the intervals** by their starting points first. Once sorted, any overlapping intervals will be right next to each other, allowing you to merge them in a single pass.

There are two primary operations:
1. **Merging Overlapping Intervals** (Combining intervals that intersect).
2. **Finding Intersecting Intervals** (Finding common overlaps between lists).

## Type 1: Merging Overlapping Intervals
First, we sort the array of intervals based on their start values. Then, we take the first interval and compare its end value with the next interval's start value. If they overlap, we merge them by taking the maximum end value.

### The Process Step-by-Step
**Goal:** Merge the intervals `[[1, 3], [2, 6], [8, 10], [15, 18]]`.

```plaintext
Data: [[1, 3], [2, 6], [8, 10], [15, 18]]
(Already sorted by start times: 1, 2, 8, 15)

Step 1: Current = [1, 3]
        Compare with [2, 6]. 
        Does 2 <= 3? Yes! Overlap exists.
        Merge: Start = 1, End = max(3, 6) = 6.
        New Current = [1, 6]

Step 2: Current = [1, 6]
        Compare with [8, 10].
        Does 8 <= 6? No! No overlap.
        Push [1, 6] to Result.
        New Current = [8, 10]

Step 3: Current = [8, 10]
        Compare with [15, 18].
        Does 15 <= 10? No! No overlap.
        Push [8, 10] to Result.
        New Current = [15, 18]

Step 4: End of list. Push final Current [15, 18] to Result.

Result: [[1, 6], [8, 10], [15, 18]]
```

## Type 2: Inserting a New Interval
When inserting a new interval into a list of already non-overlapping intervals, you iterate through the list. You add intervals that come before the new one, merge the overlapping ones by updating the new interval's bounds, and then add the remaining intervals.

### The Process Step-by-Step
**Goal:** Insert `[4, 8]` into `[[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]]`.

```plaintext
New Interval: [4, 8]
Data: [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]]

Step 1: Compare [1, 2] with [4, 8]. Ends before 4. 
        Add [1, 2] to Result.

Step 2: Compare [3, 5] with [4, 8]. Overlaps!
        Merge: [min(3, 4), max(5, 8)] = [3, 8].
        New Interval is now [3, 8].

Step 3: Compare [6, 7] with [3, 8]. Overlaps!
        Merge: [min(6, 3), max(7, 8)] = [3, 8].
        New Interval remains [3, 8].

Step 4: Compare [8, 10] with [3, 8]. Overlaps!
        Merge: [min(8, 3), max(10, 8)] = [3, 10].
        New Interval is now [3, 10].

Step 5: Compare [12, 16] with [3, 10]. Starts after 10.
        Add merged New Interval [3, 10] to Result.
        Add [12, 16] to Result.

Result: [[1, 2], [3, 10], [12, 16]]
```

### Comparison Summary
| Feature | Merging All Overlaps | Inserting New Interval |
|---------|----------------------|------------------------|
| **Prerequisite** | Must sort intervals by start time. | Existing list is already sorted. |
| **Logic** | `next.start <= current.end` | `current.end < new.start` or `current.start > new.end` |
| **Used For...** | Consolidating time slots, finding free time. | Adding appointments, dynamic scheduling. |
