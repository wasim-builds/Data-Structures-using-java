# Understanding the Cyclic Sort Concept

Think of Cyclic Sort like a group of people holding numbered tickets (from 1 to N) standing in a row of chairs, but they are completely scrambled. To fix this, you tell the first person to go to the chair that matches their ticket. They swap places with whoever is sitting there. You repeat this until the person in the first chair actually has ticket number 1. Then you move to the second chair and do the same.

This pattern is highly effective when you are dealing with an array containing numbers in a given range (e.g., 1 to N, or 0 to N). Because the numbers match the array indices, we can place them at their correct index in O(N) time without using traditional O(N log N) sorting algorithms.

There are two primary variations:
1. **Finding the Missing Number**.
2. **Finding the Duplicate Number**.

## Type 1: Placing Numbers in Correct Indices
We iterate through the array. For each number, if it is not at its correct index (i.e., `number != array[number - 1]`), we swap it with the number that is currently at its correct index.

### The Process Step-by-Step
**Goal:** Sort the array `[3, 1, 5, 4, 2]` containing numbers 1 to 5.

```plaintext
Indices:  0   1   2   3   4
Data:    [3,  1,  5,  4,  2]

Step 1: Index 0 has '3'. Correct index for '3' is 2. Swap(0, 2)
        Data becomes: [5, 1, 3, 4, 2]

Step 2: Index 0 has '5'. Correct index for '5' is 4. Swap(0, 4)
        Data becomes: [2, 1, 3, 4, 5]

Step 3: Index 0 has '2'. Correct index for '2' is 1. Swap(0, 1)
        Data becomes: [1, 2, 3, 4, 5]

Step 4: Index 0 has '1'. Correct index. Move to Index 1.
Step 5: Index 1 has '2'. Correct index. Move to Index 2.
Step 6: Index 2 has '3'. Correct index. Move to Index 3.
... (All are in correct places).
```

## Type 2: Finding Missing or Duplicate Numbers
Once the array is cyclically sorted, finding missing or duplicate numbers is trivial. We just iterate through the sorted array, and the first index that doesn't match its expected value holds the duplicate (and the missing number is the expected value of that index).

### The Process Step-by-Step
**Goal:** Find the missing number in `[4, 2, 1, 4]` (range 1 to 4).

```plaintext
Indices:  0   1   2   3
Data:    [4,  2,  1,  4]

Step 1: Index 0 has '4'. Correct index for '4' is 3. Swap(0, 3)
        Data becomes: [4, 2, 1, 4]  <- Wait, index 3 already has a '4'. Duplicate found! 
        Move to next index.

Step 2: Index 1 has '2'. Correct index. Move to Index 2.
Step 3: Index 2 has '1'. Correct index for '1' is 0. Swap(2, 0)
        Data becomes: [1, 2, 4, 4]

Step 4: Array is cyclically sorted as much as possible.
        Let's scan:
        Index 0: 1 (Matches)
        Index 1: 2 (Matches)
        Index 2: 4 (Mismatch! Should be 3. Missing is 3, Duplicate is 4)
```

### Comparison Summary
| Feature | Missing Number | Duplicate Number |
|---------|----------------|------------------|
| **Core Action** | Swap numbers to target indices. | Swap numbers to target indices. |
| **Detection Phase** | Scan for `array[i] != i + 1` | Same, or stop when `array[current] == array[target]` |
| **Used For...** | Ranges 0 to N or 1 to N, finding missing numbers. | Finding single or multiple duplicates in O(N) time and O(1) space. |
