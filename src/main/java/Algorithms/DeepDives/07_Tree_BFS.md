# Understanding Tree Breadth-First Search (BFS)

Think of Tree BFS like exploring a corporate hierarchy level by level. You start at the top (the CEO). Before talking to any managers, you talk to all the Vice Presidents (level 1). Then, you talk to all the Directors (level 2), and finally the Managers (level 3). You never skip a level.

To keep track of who to talk to next without jumping ahead, we use a **Queue** (a First-In-First-Out line, like people waiting at a grocery store).

There are two primary variations:
1. **Standard Level Order Traversal** (Left-to-Right).
2. **Zigzag Traversal** (Alternating directions per level).

## Type 1: Standard Level Order Traversal
We push the root node into the queue. Then, we use a loop that runs as long as the queue has elements. Inside the loop, we count how many nodes are in the queue (this is the size of the current level), pop that many nodes, and push their children into the queue for the next level.

### The Process Step-by-Step
**Goal:** Traverse the tree level by level.
Tree: 
      1
    /   \
   2     3
  / \   / \
 4   5 6   7

```plaintext
Step 1: Initialize Queue = [1]
        Result = []

Step 2: Queue size is 1 (Level 0).
        Pop 1. Add 1 to Result.
        Push children of 1 (2, 3).
        Queue = [2, 3]
        Result = [[1]]

Step 3: Queue size is 2 (Level 1).
        Pop 2. Add to levelResult. Push children (4, 5).
        Pop 3. Add to levelResult. Push children (6, 7).
        Queue = [4, 5, 6, 7]
        Result = [[1], [2, 3]]

Step 4: Queue size is 4 (Level 2).
        Pop 4, 5, 6, 7. Push their children (none).
        Queue = []
        Result = [[1], [2, 3], [4, 5, 6, 7]]
```

## Type 2: Zigzag Traversal
This is exactly the same as standard BFS, but we maintain a boolean flag that flips at each level. If the flag is true, we add the popped nodes to the current level's result array from left-to-right. If false, we add them right-to-left.

### The Process Step-by-Step
**Goal:** Zigzag traverse the same tree.

```plaintext
Step 1: Level 0 (Left-to-Right). 
        Queue = [1]. Pop 1.
        Level Result = [1]. 
        Push children (2, 3). Queue = [2, 3]

Step 2: Level 1 (Right-to-Left).
        Queue size = 2. 
        Pop 2. Insert at BEGINNING of Level Result -> [2].
        Pop 3. Insert at BEGINNING of Level Result -> [3, 2].
        Push children (4, 5, 6, 7). Queue = [4, 5, 6, 7]

Step 3: Level 2 (Left-to-Right).
        Queue size = 4.
        Pop 4, 5, 6, 7. Append normally.
        Level Result = [4, 5, 6, 7].

Result: [[1], [3, 2], [4, 5, 6, 7]]
```

### Comparison Summary
| Feature | Standard Level Order | Zigzag Traversal |
|---------|----------------------|------------------|
| **Data Structure** | Queue | Queue (with directional flag) |
| **Collection Method**| Append to end of level list. | Alternate append to end / insert at front. |
| **Used For...** | Shortest path, level averages, right-view. | Specialized UI rendering, spiral matrix logic. |
