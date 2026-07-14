# Understanding Modified Binary Search

Think of Binary Search like looking up a word in a physical dictionary. Instead of reading page by page from the beginning, you open the book exactly in the middle. If your word starts with 'M' and the middle page starts with 'P', you know your word is in the left half. You tear the book in half, throw away the right side, and repeat the process on the left side.

Standard binary search only works on perfectly sorted arrays to find an exact match. But by slightly modifying the rules of how we move our `Start` and `End` pointers, we can solve complex variations.

There are two primary variations:
1. **Order-Agnostic Binary Search** (Don't know if sorted ascending or descending).
2. **Finding the Boundary** (Finding the first or last occurrence of a duplicate).

## Type 1: Order-Agnostic Binary Search
Usually, we assume the array is ascending. But what if it's descending? We just compare the first and last elements to determine the order, and then flip our logic for moving `Start` and `End`.

### The Process Step-by-Step
**Goal:** Find '4' in a descending array `[10, 8, 6, 4, 2]`.

```plaintext
Data: [10, 8, 6, 4, 2]
Order: 10 > 2, so it's Descending.

Step 1: Start=0 (10), End=4 (2).
        Mid = (0+4)/2 = 2. Value at Mid is 6.
        Target is 4. Since 4 < 6, and array is DESCENDING, 4 must be to the RIGHT of 6.
        Move Start to Mid + 1. Start = 3.

Step 2: Start=3 (4), End=4 (2).
        Mid = (3+4)/2 = 3. Value at Mid is 4.
        Target 4 == Mid 4. FOUND! Stop.
```

## Type 2: Finding the Boundary (First/Last Occurrence)
If an array has duplicates, finding the "target" isn't enough. To find the *first* occurrence, when you find a match at `Mid`, you don't stop. You record it, but then keep searching the left half to see if an earlier match exists.

### The Process Step-by-Step
**Goal:** Find the first occurrence of '5' in `[1, 3, 5, 5, 5, 8]`.

```plaintext
Data: [1, 3, 5, 5, 5, 8]

Step 1: Start=0 (1), End=5 (8).
        Mid = 2. Value is 5. 
        Match! Record index 2. 
        But we want the FIRST occurrence, so there might be more to the left.
        End = Mid - 1 = 1.

Step 2: Start=0 (1), End=1 (3).
        Mid = 0. Value is 1.
        1 < 5. Target must be right.
        Start = Mid + 1 = 1.

Step 3: Start=1 (3), End=1 (3).
        Mid = 1. Value is 3.
        3 < 5. Target must be right.
        Start = Mid + 1 = 2.

Step 4: Start (2) > End (1). Loop terminates. 
Result: The lowest recorded index was 2.
```

### Comparison Summary
| Feature | Order-Agnostic | Finding Boundary |
|---------|----------------|------------------|
| **Core Change** | Check start/end to flip `>` logic. | Don't stop on `target == mid`. Continue searching. |
| **Pointers Move**| Based on Asc/Desc boolean. | Move `End` left for First, `Start` right for Last. |
| **Used For...** | Unknown sort order APIs. | Ranges, counting frequency in sorted arrays. |
