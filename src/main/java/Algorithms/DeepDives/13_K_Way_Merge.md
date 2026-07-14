# Understanding K-Way Merge Concept

Think of K-Way Merge like sorting playing cards. You have K different decks of cards on the table, and every deck is already sorted face-up. To create one massive sorted deck, you don't need to look at every single card at once. You only need to look at the top card of each of the K decks. You pick the absolute smallest card among those top cards, put it in your master deck, and reveal the next card from the deck you just pulled from.

To efficiently find the smallest card among the K decks, we use a **Min Heap**. 

There are two primary variations:
1. **Merging K Sorted Arrays/Lists**.
2. **Finding the Kth Smallest Element in M Sorted Lists**.

## Type 1: Merging K Sorted Arrays
We place the first element of each array into a Min Heap. The Heap automatically brings the smallest element to the top. We extract it, put it in our result array, and then push the *next* element from the exact same array that the extracted element came from.

### The Process Step-by-Step
**Goal:** Merge `L1=[2, 6, 8]`, `L2=[3, 6, 7]`, `L3=[1, 3, 4]`.

```plaintext
Step 1: Push the first element of each list into Min Heap.
        (Track value, list_index, element_index).
        Heap: [1(from L3), 2(from L1), 3(from L2)]
        Result: []

Step 2: Pop top of Heap -> 1 (from L3).
        Result: [1]
        Push next element from L3 -> 3.
        Heap: [2(L1), 3(L2), 3(L3)]

Step 3: Pop top of Heap -> 2 (from L1).
        Result: [1, 2]
        Push next element from L1 -> 6.
        Heap: [3(L2), 3(L3), 6(L1)]

Step 4: Pop top of Heap -> 3 (from L2).
        Result: [1, 2, 3]
        Push next element from L2 -> 6.
        Heap: [3(L3), 6(L1), 6(L2)]

... This continues until all lists are empty.
Result: [1, 2, 3, 3, 4, 6, 6, 7, 8]
```

## Type 2: Kth Smallest in M Sorted Lists
This uses the exact same logic. Instead of building a fully merged array, we just pop elements from the Min Heap K times. The Kth element we pop is our answer.

### The Process Step-by-Step
**Goal:** Find 4th smallest in `L1=[2, 6]`, `L2=[3, 7]`, `L3=[1, 4]`.

```plaintext
Target: K = 4.

Step 1: Init Heap with first elements.
        Heap: [1(L3), 2(L1), 3(L2)]

Step 2: Pop 1st (1 from L3). Push next from L3 (4).
        Heap: [2(L1), 3(L2), 4(L3)]

Step 3: Pop 2nd (2 from L1). Push next from L1 (6).
        Heap: [3(L2), 4(L3), 6(L1)]

Step 4: Pop 3rd (3 from L2). Push next from L2 (7).
        Heap: [4(L3), 6(L1), 7(L2)]

Step 5: Pop 4th (4 from L3). 
        We reached K! Target found.

Result: 4
```

### Comparison Summary
| Feature | Merging K Lists | Kth Smallest in M Lists |
|---------|-----------------|-------------------------|
| **Data Structure** | Min Heap | Min Heap |
| **Heap Contents** | (Value, Array Index, Element Index) | (Value, Array Index, Element Index) |
| **Termination** | When Heap is entirely empty. | When we have popped exactly K times. |
