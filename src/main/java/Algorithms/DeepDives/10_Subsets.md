# Understanding the Subsets Concept

Think of generating Subsets like packing for a trip. You look at every item you own and make a binary choice: either pack it, or leave it. 

Instead of writing complex recursive loops, the easiest way to generate subsets is the **Cascading (BFS-style)** approach. You start with an empty suitcase. Then, for every new item, you take a snapshot (clone) of every packing combination you already have, and add the new item to those clones. 

There are two primary variations:
1. **Subsets without Duplicates** (Distinct elements).
2. **Subsets with Duplicates** (Array contains duplicate numbers).

## Type 1: Subsets without Duplicates
We start with a list containing an empty subset. For each number in our input, we iterate through all existing subsets in our list, copy them, and add the new number to the copies.

### The Process Step-by-Step
**Goal:** Generate all subsets for `[1, 5, 3]`.

```plaintext
Step 1: Initialize.
        Result = [ [] ]

Step 2: Process '1'.
        Take existing subsets: []
        Clone them and add '1': [1]
        Add clones to Result.
        Result = [ [], [1] ]

Step 3: Process '5'.
        Take existing subsets: [], [1]
        Clone them and add '5': [5], [1, 5]
        Add clones to Result.
        Result = [ [], [1], [5], [1, 5] ]

Step 4: Process '3'.
        Take existing subsets: [], [1], [5], [1, 5]
        Clone them and add '3': [3], [1, 3], [5, 3], [1, 5, 3]
        Add clones to Result.
        Result = [ [], [1], [5], [1, 5], [3], [1, 3], [5, 3], [1, 5, 3] ]
```

## Type 2: Subsets with Duplicates
If the input array has duplicates (e.g., `[1, 5, 3, 3]`), our standard method will create identical subsets. To prevent this, we:
1. Sort the array so duplicates are next to each other.
2. If we encounter a duplicate, we *only* add it to the subsets that were created in the immediately previous step, not all historical subsets.

### The Process Step-by-Step
**Goal:** Generate subsets for `[1, 3, 3]`.

```plaintext
Step 1: Initialize.
        Result = [ [] ]

Step 2: Process '1'.
        New subsets added: [1]
        Result = [ [], [1] ]

Step 3: Process first '3'.
        New subsets added: [3], [1, 3]
        Result = [ [], [1], [3], [1, 3] ]
        (Remember, we added 2 subsets in this step).

Step 4: Process second '3'.
        It's a duplicate! Only add to the subsets created in Step 3 ([3] and [1, 3]).
        New subsets added: [3, 3], [1, 3, 3]
        Result = [ [], [1], [3], [1, 3], [3, 3], [1, 3, 3] ]
```

### Comparison Summary
| Feature | Subsets (Distinct) | Subsets (Duplicates) |
|---------|--------------------|----------------------|
| **Prerequisite** | None. | Array MUST be sorted first. |
| **Duplication Logic**| Add to ALL existing subsets. | Add ONLY to subsets generated in the previous step. |
| **Complexity** | Time: O(N * 2^N) | Time: O(N * 2^N) |
