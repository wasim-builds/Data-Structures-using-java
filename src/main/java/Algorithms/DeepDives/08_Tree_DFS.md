# Understanding Tree Depth-First Search (DFS)

Think of Tree DFS like navigating a maze by keeping your hand on the left wall. You plunge as deep down a single path as you possibly can until you hit a dead end. Only then do you take one step back (backtrack) and try the next available path.

In trees, DFS is naturally implemented using **Recursion** (which uses the system's Call Stack under the hood). There are three standard ways to perform DFS, depending on when you process the "Current Node" compared to its children.

There are three primary types:
1. **Pre-order** (Current, Left, Right).
2. **In-order** (Left, Current, Right).
3. **Post-order** (Left, Right, Current).

## Type 1: Pre-order (Current, Left, Right)
You process the node the moment you first see it, then you go left, then you go right. This is highly useful for cloning a tree or serializing it, because you process parents before children.

### The Process Step-by-Step
**Goal:** Pre-order traverse this tree:
      1
    /   \
   2     3
  / \
 4   5

```plaintext
Step 1: Visit 1 (Record 1). Go left to 2.
Step 2: Visit 2 (Record 2). Go left to 4.
Step 3: Visit 4 (Record 4). Go left to null. Go right to null. Backtrack to 2.
Step 4: At 2, go right to 5. Visit 5 (Record 5). Go left/right to null. Backtrack to 2, then to 1.
Step 5: At 1, go right to 3. Visit 3 (Record 3). Go left/right to null. Backtrack.

Result: [1, 2, 4, 5, 3]
```

## Type 2: In-order (Left, Current, Right)
You travel all the way left first. Only when you can't go left anymore do you process the node, then you go right. In a Binary Search Tree (BST), In-order traversal visits nodes in perfectly ascending sorted order.

### The Process Step-by-Step
**Goal:** In-order traverse the same tree.

```plaintext
Step 1: Start 1. Go left to 2.
Step 2: At 2. Go left to 4.
Step 3: At 4. Go left to null. (Can't go left). Visit 4 (Record 4). Go right to null. Backtrack to 2.
Step 4: At 2. Left is done. Visit 2 (Record 2). Go right to 5.
Step 5: At 5. Go left to null. Visit 5 (Record 5). Go right to null. Backtrack to 1.
Step 6: At 1. Left is done. Visit 1 (Record 1). Go right to 3.
Step 7: At 3. Go left to null. Visit 3 (Record 3). Go right to null.

Result: [4, 2, 5, 1, 3]
```

## Type 3: Post-order (Left, Right, Current)
You process the children entirely before you process the current node. This is highly useful when deleting a tree (you must delete children before parents) or calculating heights/sizes from the bottom up.

### Comparison Summary
| Feature | Pre-order | In-order | Post-order |
|---------|-----------|----------|------------|
| **Order** | N - L - R | L - N - R | L - R - N |
| **BST Traversal** | Structural copy order. | Ascending sorted order. | Bottom-up order. |
| **Used For...** | Copying, Serialization. | Flattening BST, Sorting. | Deletion, Bottom-up calculations. |
