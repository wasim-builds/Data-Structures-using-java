# Understanding Top K Elements Concept

Think of the Top K Elements pattern like managing a VIP club with a strict capacity of exactly K people. As new guests arrive, they try to get in. If the club isn't full, they just walk in. If the club *is* full, they have to prove they are more VIP than the least important person currently inside. If they are, the least important person gets kicked out, and the new guest takes their spot.

To manage this "club" efficiently, we use a **Heap** (Priority Queue). A Heap automatically keeps the "least important" person right at the front door, so comparing and kicking them out takes O(log K) time instead of O(N log N) sorting.

There are two primary variations:
1. **Top K Largest Elements** (Use a Min Heap).
2. **Top K Smallest Elements** (Use a Max Heap).

## Type 1: Top K Largest Elements (Min Heap)
To find the largest numbers, we use a Min Heap of size K. Why a Min Heap? Because we want the smallest of our current "largest" collection to be at the top. When a new number comes along, if it's larger than the top of the Min Heap, it means the top number isn't big enough to be in the Top K anymore. We pop it and insert the new number.

### The Process Step-by-Step
**Goal:** Find Top 3 largest numbers in `[3, 1, 5, 12, 2, 11]`.

```plaintext
K = 3. Heap structure: Min Heap.

Step 1: Insert 3, 1, 5 (until Heap size is K).
        Min Heap: [1, 3, 5] (1 is at the top/root).

Step 2: Process 12.
        12 > 1 (Heap top). 
        Pop 1. Insert 12.
        Min Heap: [3, 5, 12] (3 is at the top).

Step 3: Process 2.
        2 < 3 (Heap top). 
        Ignore it. Heap stays [3, 5, 12].

Step 4: Process 11.
        11 > 3 (Heap top).
        Pop 3. Insert 11.
        Min Heap: [5, 11, 12] (5 is at the top).

Result: The Heap contains the Top 3 elements: [5, 11, 12].
```

## Type 2: Top K Smallest Elements (Max Heap)
To find the smallest numbers, we flip the logic. We use a Max Heap of size K. The *largest* of our current "smallest" collection is kept at the top. If a new number is smaller than the top, we pop the top and insert the new number.

### The Process Step-by-Step
**Goal:** Find Top 2 smallest numbers in `[5, 12, 1, 3]`.

```plaintext
K = 2. Heap structure: Max Heap.

Step 1: Insert 5, 12.
        Max Heap: [12, 5] (12 is at the top).

Step 2: Process 1.
        1 < 12 (Heap top).
        Pop 12. Insert 1.
        Max Heap: [5, 1] (5 is at the top).

Step 3: Process 3.
        3 < 5 (Heap top).
        Pop 5. Insert 3.
        Max Heap: [3, 1] (3 is at the top).

Result: The Heap contains the Top 2 smallest: [3, 1].
```

### Comparison Summary
| Feature | Top K Largest | Top K Smallest |
|---------|---------------|----------------|
| **Data Structure** | Min Heap | Max Heap |
| **Logic** | If `new > heap.top()`, replace top. | If `new < heap.top()`, replace top. |
| **Efficiency** | Space: O(K), Time: O(N log K) | Space: O(K), Time: O(N log K) |
