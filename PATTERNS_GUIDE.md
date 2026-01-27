# 🎯 Problem-Solving Patterns Guide

Master common algorithmic patterns to solve 90% of coding interview problems.

## 📖 Table of Contents
- [Two Pointers](#two-pointers)
- [Sliding Window](#sliding-window)
- [Fast & Slow Pointers](#fast--slow-pointers)
- [Merge Intervals](#merge-intervals)
- [Cyclic Sort](#cyclic-sort)
- [Top K Elements](#top-k-elements)
- [Binary Search Variations](#binary-search-variations)
- [Tree DFS](#tree-dfs)
- [Tree BFS](#tree-bfs)
- [Graph Patterns](#graph-patterns)
- [Dynamic Programming](#dynamic-programming)
- [Backtracking](#backtracking)

---

## Two Pointers

**When to use**: Array/string problems with pairs, triplets, or subarrays.

**Pattern**: Use two pointers moving towards each other or in same direction.

### Template
```java
int left = 0, right = n - 1;
while (left < right) {
    // Process elements at left and right
    if (condition) {
        left++;
    } else {
        right--;
    }
}
```

### Common Problems
- **Two Sum (sorted array)** - O(n)
- **3Sum** - O(n²)
- **Container With Most Water** - O(n)
- **Remove Duplicates** - O(n)
- **Valid Palindrome** - O(n)

### Example: Two Sum (Sorted Array)
```java
public int[] twoSum(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum == target) return new int[]{left, right};
        if (sum < target) left++;
        else right--;
    }
    return new int[]{-1, -1};
}
```

**Repository Examples**: [TwoSum.java](InterviewQuestions/Arrays/TwoSum.java), [ThreeSum.java](InterviewQuestions/Arrays/ThreeSum.java), [ContainerWithMostWater.java](InterviewQuestions/Arrays/ContainerWithMostWater.java)

---

## Sliding Window

**When to use**: Contiguous subarray/substring problems.

**Pattern**: Expand window to include elements, contract when condition violated.

### Template
```java
int left = 0, right = 0;
while (right < n) {
    // Expand window
    windowAdd(arr[right]);
    right++;
    
    // Contract window while invalid
    while (windowInvalid()) {
        windowRemove(arr[left]);
        left++;
    }
    
    // Update result
    updateResult();
}
```

### Common Problems
- **Longest Substring Without Repeating** - O(n)
- **Minimum Window Substring** - O(n)
- **Maximum Sum Subarray of Size K** - O(n)
- **Longest Substring with K Distinct** - O(n)

### Example: Longest Substring Without Repeating
```java
public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int left = 0, maxLen = 0;
    
    for (int right = 0; right < s.length(); right++) {
        while (set.contains(s.charAt(right))) {
            set.remove(s.charAt(left++));
        }
        set.add(s.charAt(right));
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
```

**Repository Examples**: [LongestSubstringWithoutRepeating.java](InterviewQuestions/Strings/LongestSubstringWithoutRepeating.java), [MinimumWindowSubstring.java](InterviewQuestions/Strings/MinimumWindowSubstring.java)

---

## Fast & Slow Pointers

**When to use**: Linked list cycle detection, finding middle element.

**Pattern**: Two pointers moving at different speeds.

### Template
```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    
    if (slow == fast) {
        // Cycle detected
        return true;
    }
}
return false;
```

### Common Problems
- **Linked List Cycle** - O(n)
- **Find Middle of Linked List** - O(n)
- **Happy Number** - O(log n)
- **Palindrome Linked List** - O(n)

**Repository Examples**: [LinkedListCycle.java](InterviewQuestions/LinkedList/LinkedListCycle.java)

---

## Merge Intervals

**When to use**: Overlapping intervals, scheduling problems.

**Pattern**: Sort intervals, then merge overlapping ones.

### Template
```java
Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
List<int[]> result = new ArrayList<>();
int[] current = intervals[0];

for (int i = 1; i < intervals.length; i++) {
    if (intervals[i][0] <= current[1]) {
        // Merge
        current[1] = Math.max(current[1], intervals[i][1]);
    } else {
        result.add(current);
        current = intervals[i];
    }
}
result.add(current);
```

### Common Problems
- **Merge Intervals** - O(n log n)
- **Insert Interval** - O(n)
- **Meeting Rooms** - O(n log n)
- **Non-overlapping Intervals** - O(n log n)

**Repository Examples**: [MergeIntervals.java](InterviewQuestions/Arrays/MergeIntervals.java)

---

## Cyclic Sort

**When to use**: Array contains numbers in range [1, n].

**Pattern**: Place each number at its correct index.

### Template
```java
int i = 0;
while (i < n) {
    int correctIdx = nums[i] - 1;
    if (nums[i] != nums[correctIdx]) {
        swap(nums, i, correctIdx);
    } else {
        i++;
    }
}
```

### Common Problems
- **Find Missing Number** - O(n)
- **Find All Duplicates** - O(n)
- **Find First Missing Positive** - O(n)

---

## Top K Elements

**When to use**: Finding K largest/smallest elements.

**Pattern**: Use heap (priority queue).

### Template
```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
for (int num : nums) {
    minHeap.offer(num);
    if (minHeap.size() > k) {
        minHeap.poll();
    }
}
return minHeap.peek(); // Kth largest
```

### Common Problems
- **Kth Largest Element** - O(n log k)
- **Top K Frequent Elements** - O(n log k)
- **K Closest Points** - O(n log k)

**Repository Examples**: [Heap/KthLargestElement.java](Heap/KthLargestElement.java)

---

## Binary Search Variations

**When to use**: Sorted array, search space can be halved.

**Pattern**: Divide search space in half each iteration.

### Template
```java
int left = 0, right = n - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) return mid;
    if (arr[mid] < target) left = mid + 1;
    else right = mid - 1;
}
return -1;
```

### Variations
1. **Find exact match**
2. **Find first/last occurrence**
3. **Search in rotated array**
4. **Find peak element**
5. **Search in 2D matrix**

**Repository Examples**: [SearchRotatedSortedArray.java](InterviewQuestions/Arrays/SearchRotatedSortedArray.java)

---

## Tree DFS

**When to use**: Tree traversal, path problems.

**Pattern**: Recursively explore each branch.

### Template
```java
void dfs(TreeNode node) {
    if (node == null) return;
    
    // Preorder: process node first
    process(node);
    dfs(node.left);
    dfs(node.right);
    
    // Inorder: process between left and right
    // Postorder: process after children
}
```

### Common Problems
- **Maximum Depth** - O(n)
- **Path Sum** - O(n)
- **Validate BST** - O(n)
- **Lowest Common Ancestor** - O(n)

**Repository Examples**: [Tree/MaxDepth.java](InterviewQuestions/Trees/MaxDepth.java), [Tree/ValidateBST.java](InterviewQuestions/Trees/ValidateBST.java)

---

## Tree BFS

**When to use**: Level-order traversal, shortest path in tree.

**Pattern**: Use queue to process level by level.

### Template
```java
Queue<TreeNode> queue = new LinkedList<>();
queue.offer(root);

while (!queue.isEmpty()) {
    int levelSize = queue.size();
    for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        process(node);
        
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }
}
```

### Common Problems
- **Level Order Traversal** - O(n)
- **Zigzag Level Order** - O(n)
- **Binary Tree Right Side View** - O(n)

**Repository Examples**: [Tree/LevelOrderTraversal.java](InterviewQuestions/Trees/LevelOrderTraversal.java)

---

## Graph Patterns

### BFS (Shortest Path, Level-wise)
```java
Queue<Integer> queue = new LinkedList<>();
boolean[] visited = new boolean[n];
queue.offer(start);
visited[start] = true;

while (!queue.isEmpty()) {
    int node = queue.poll();
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            visited[neighbor] = true;
            queue.offer(neighbor);
        }
    }
}
```

### DFS (Cycle Detection, Topological Sort)
```java
void dfs(int node, boolean[] visited) {
    visited[node] = true;
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, visited);
        }
    }
}
```

### Common Problems
- **Number of Islands** - O(m×n)
- **Course Schedule** - O(V+E)
- **Clone Graph** - O(V+E)
- **Word Ladder** - O(n×m²)

**Repository Examples**: [Graph/BFS.java](Graph/BFS.java), [Graph/DFS.java](Graph/DFS.java), [NumberOfIslands.java](InterviewQuestions/Graphs/NumberOfIslands.java)

---

## Dynamic Programming

**When to use**: Optimization problems, counting problems, overlapping subproblems.

**Pattern**: Build solution from smaller subproblems.

### Common DP Patterns

#### 1. Fibonacci-style (1D DP)
```java
dp[i] = dp[i-1] + dp[i-2]
// Examples: Climbing Stairs, House Robber
```

#### 2. Knapsack (2D DP)
```java
dp[i][w] = max(dp[i-1][w], dp[i-1][w-weight[i]] + value[i])
// Examples: 0/1 Knapsack, Partition Equal Subset Sum
```

#### 3. LCS/LIS (2D DP)
```java
if (s1[i] == s2[j]) dp[i][j] = dp[i-1][j-1] + 1
else dp[i][j] = max(dp[i-1][j], dp[i][j-1])
// Examples: Longest Common Subsequence, Edit Distance
```

### Common Problems
- **Climbing Stairs** - O(n)
- **Coin Change** - O(amount×n)
- **Longest Increasing Subsequence** - O(n²) or O(n log n)
- **Edit Distance** - O(m×n)
- **Word Break** - O(n²)

**Repository Examples**: [ClimbingStairs.java](InterviewQuestions/DynamicProgramming/ClimbingStairs.java), [CoinChange.java](InterviewQuestions/DynamicProgramming/CoinChange.java), [Dynamic_Programming/](Dynamic_Programming/)

---

## Backtracking

**When to use**: Generate all combinations/permutations, constraint satisfaction.

**Pattern**: Try all possibilities, backtrack on failure.

### Template
```java
void backtrack(List<Integer> current, int start) {
    if (isValid(current)) {
        result.add(new ArrayList<>(current));
        return;
    }
    
    for (int i = start; i < n; i++) {
        current.add(nums[i]);
        backtrack(current, i + 1);
        current.remove(current.size() - 1); // Backtrack
    }
}
```

### Common Problems
- **Subsets** - O(2^n)
- **Permutations** - O(n!)
- **Combination Sum** - O(2^n)
- **N-Queens** - O(n!)
- **Sudoku Solver** - O(9^(n×n))
- **Palindrome Partitioning** - O(n×2^n)

**Repository Examples**: [Backtracking/NQueens.java](Backtracking/NQueens.java), [Backtracking/Subsets.java](Backtracking/Subsets.java), [PalindromePartitioning.java](InterviewQuestions/Strings/PalindromePartitioning.java)

---

## Pattern Recognition Cheat Sheet

| Problem Type | Pattern | Complexity |
|--------------|---------|------------|
| Pairs in sorted array | Two Pointers | O(n) |
| Contiguous subarray | Sliding Window | O(n) |
| Linked list cycle | Fast & Slow | O(n) |
| Overlapping intervals | Merge Intervals | O(n log n) |
| Array [1...n] | Cyclic Sort | O(n) |
| K largest/smallest | Heap | O(n log k) |
| Sorted search | Binary Search | O(log n) |
| Tree paths | DFS | O(n) |
| Tree levels | BFS | O(n) |
| Graph connectivity | DFS/BFS | O(V+E) |
| Optimization | DP | Varies |
| All combinations | Backtracking | O(2^n) or O(n!) |

---

## Interview Strategy

1. **Listen carefully** - Understand constraints and edge cases
2. **Ask clarifying questions** - Input size, duplicates, sorted?
3. **Identify the pattern** - Use this guide to recognize it
4. **Explain your approach** - Before coding
5. **Start with brute force** - Then optimize
6. **Code cleanly** - Use meaningful names
7. **Test with examples** - Include edge cases
8. **Analyze complexity** - Time and space

---

**Pro Tip**: Practice identifying patterns in problems. Once you recognize the pattern, the solution becomes much clearer!

Happy coding! 🚀
