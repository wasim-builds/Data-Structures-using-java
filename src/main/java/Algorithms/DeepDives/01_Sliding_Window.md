# Understanding the Sliding Window Concept

Think of a Sliding Window like looking through a camera's zoom lens as you pan across a landscape. The full landscape is your data (a long list of numbers or characters), but at any single moment, you can only see a small portion—this portion is your "Window."

Instead of starting a new search from scratch every single time you move, you use the information already inside the window and just update what enters and what leaves. This saves huge amounts of time.

There are two primary types:
1. **Fixed-Size Window** (The size is always constant).
2. **Variable-Size Window** (The size grows or shrinks based on a condition).

## Type 1: Fixed-Size Sliding Window
In this type, the window size (let's call it k) is fixed from the start. You might need to find the maximum sum of any k consecutive numbers, or the average of k elements. We slide the window one step at a time, keeping its size constant.

### The Process Step-by-Step
**Goal:** Slide a window of exactly 3 elements across the data [A, B, C, D, E, F].

```plaintext
Data:  A   B   C   D   E   F
       -----------------------
Step 1: [A   B   C]               (Initial window, calculate sum/average)
Step 2:      [B   C   D]          (Slide right by 1: Drop A, Add D)
Step 3:          [C   D   E]      (Slide right by 1: Drop B, Add E)
Step 4:              [D   E   F]  (Slide right by 1: Drop C, Add F - End) 
```

## Type 2: Variable-Size Sliding Window
A variable window does not have a fixed size. Instead, it expands or contracts based on a defined constraint. We maintain two pointers: a 'Right' pointer (the window's leading edge) and a 'Left' pointer (the window's trailing edge).

- **Expand**: We move the Right pointer to include new elements as long as the constraint is satisfied.
- **Shrink**: If the constraint is violated, we move the Left pointer to remove elements from the window until the constraint is met again.

### The Process Step-by-Step
**Goal:** Find segments where the sum of numbers is strictly less than 5 in the data [1, 2, 1, 3, 1, 4].

```plaintext
Data:  1   2   1   3   1   4
       -----------------------
Step 1: [1]                           (Sum = 1. Valid < 5, EXPAND right)
Step 2: [1   2]                       (Sum = 3. Valid < 5, EXPAND right)
Step 3: [1   2   1]                   (Sum = 4. Valid < 5, EXPAND right)
Step 4: [1   2   1   3]               (Sum = 7. INVALID! > 5, must SHRINK left)
Step 5:  1  [2   1   3]               (Sum = 6. INVALID! > 5, must SHRINK left)
Step 6:  1   2  [1   3]               (Sum = 4. Valid < 5, EXPAND right)
Step 7:  1   2  [1   3   1]           (Sum = 5. INVALID! Not < 5, SHRINK left)
Step 8:  1   2   1  [3   1]           (Sum = 4. Valid < 5, EXPAND right)
Step 9:  1   2   1  [3   1   4]       (Sum = 8. INVALID! > 5, SHRINK left)
Step 10: 1   2   1   3  [1   4]       (Sum = 5. INVALID! Not < 5, SHRINK left)
Step 11: 1   2   1   3   1  [4]       (Sum = 4. Valid < 5. Reached End)
```

### Comparison Summary
| Feature | Fixed-Size Window | Variable-Size Window |
|---------|-------------------|----------------------|
| **Size (k)** | Constant (Set at the beginning) | Dynamic (Grows or shrinks) |
| **Pointers** | One pointer (usually tracking the window's start) | Two pointers (one Left, one Right) |
| **Primary Action** | The window slides (shifted by one). | The window expands (R++) or shrinks (L++). |
| **Used For...** | Analyzing a set amount of consecutive data. | Finding the best segment that meets a dynamic rule. |
