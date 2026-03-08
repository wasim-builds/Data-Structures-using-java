# DSA Problem Solving Patterns

Understanding these patterns will help you quickly identify the optimal approach for solving coding interview questions.

## 1. Two Pointers Pattern
**How it works:** You use two variables (pointers) to keep track of indices in an array or string. They usually start at opposite ends (left and right) and move towards each other, or they move in the same direction at different speeds (e.g., fast and slow pointers).
**When to use it:**
- Dealing with **sorted arrays** or linked lists.
- Finding a set of elements that fulfill certain constraints (e.g., pairs that sum to a target).
- Reversing items, finding palindromes, or detecting cycles in linked lists.
**Time Complexity:** Usually $O(N)$
**Example Problems:** Two Sum II, Valid Palindrome, Reverse String, Linked List Cycle.

## 2. Sliding Window Pattern
**How it works:** A "window" is formed over a portion of data (like a sub-array or sub-string), and this window slides across the data structure to search for a specific property. The window can be of fixed size or dynamically resize itself.
**When to use it:**
- When asked to find the **longest/shortest**, **maximum/minimum**, or **any sub-array/sub-string** that satisfies a given condition.
- It helps reduce a nested loop $O(N^2)$ down to a single loop $O(N)$.
**Time Complexity:** Usually $O(N)$
**Example Problems:** Maximum Sum Subarray of Size K, Longest Substring Without Repeating Characters, Minimum Window Substring.

## 3. Prefix Sum Pattern
**How it works:** You create a new array (the prefix sum array) where the element at index `i` stores the sum of all elements in the original array from index `0` to `i`. This allows you to answer queries about the sum of any sub-array in constant time $O(1)$.
`Sum(i to j) = PrefixSum[j] - PrefixSum[i - 1]`
**When to use it:**
- When you need to frequently query the **sum of elements within various ranges**.
- Finding sub-arrays that add up to a specific target sum.
**Time Complexity:** $O(N)$ to build, $O(1)$ per query.
**Example Problems:** Range Sum Query, Subarray Sum Equals K, Equilibrium Index.

## 4. Bit Manipulation Pattern
**How it works:** Utilizing bitwise operators (`&`, `|`, `^`, `~`, `<<`, `>>`) directly on the binary representation of numbers to optimize time and space complexities.
**When to use it:**
- Dealing with situations requiring math at the bit-level (e.g., counting set bits, checking if a number is a power of 2).
- Finding missing or unique numbers in pairs (using the XOR operator `^` where `a ^ a = 0`).
- Generating subsets/powerset combinations using bit masking.
**Time Complexity:** Usually $O(1)$ or $O(\text{number of bits})$
**Example Problems:** Single Number, Number of 1 Bits, Missing Number, Subsets.
