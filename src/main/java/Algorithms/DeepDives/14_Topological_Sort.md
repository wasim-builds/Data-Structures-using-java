# Understanding Topological Sort Concept

Think of Topological Sort like getting dressed in the morning or taking courses in college. You have a list of tasks, but some tasks depend on others being finished first (you can't put on shoes before your socks; you can't take Calculus II before Calculus I). 

Topological Sort takes a Directed Acyclic Graph (DAG) and returns an ordered list where every parent comes before its children. 

To solve this efficiently, we use a concept called **In-Degree** (how many prerequisites a task has) and a **Source Queue** (tasks with zero prerequisites).

There are two primary variations:
1. **Valid Ordering** (Finding a sequence to complete tasks).
2. **Cycle Detection** (Checking if it's even possible to finish).

## Type 1: Valid Ordering
We count the prerequisites (In-Degree) for every node. Any node with an In-Degree of 0 is ready to be executed. We put it in a Queue. We pop it, add it to our result list, and then "virtually" cross it out. Crossing it out means we reduce the In-Degree of all its children by 1. If any child's In-Degree hits 0, they go into the Queue.

### The Process Step-by-Step
**Goal:** Courses: 0, 1, 2, 3.
Prerequisites: [1 depends on 0], [2 depends on 0], [3 depends on 1 and 2].

```plaintext
Step 1: Build the Graph and In-Degree counts.
        In-Degree: { 0: 0, 1: 1, 2: 1, 3: 2 }
        Graph: 0->[1, 2], 1->[3], 2->[3]

Step 2: Find all Sources (In-Degree == 0).
        Queue = [0]
        Result = []

Step 3: Pop 0. Add to Result.
        Reduce In-Degree of its children (1, 2).
        In-Degree of 1 becomes 0. Queue pushes 1.
        In-Degree of 2 becomes 0. Queue pushes 2.
        Queue = [1, 2]
        Result = [0]

Step 4: Pop 1. Add to Result.
        Reduce In-Degree of its child (3).
        In-Degree of 3 becomes 1.
        Queue = [2]
        Result = [0, 1]

Step 5: Pop 2. Add to Result.
        Reduce In-Degree of its child (3).
        In-Degree of 3 becomes 0. Queue pushes 3.
        Queue = [3]
        Result = [0, 1, 2]

Step 6: Pop 3. Add to Result. No children.
        Queue = []
        Result = [0, 1, 2, 3]
```

## Type 2: Cycle Detection
If there is a cycle (e.g., Course A needs B, and Course B needs A), they will never reach an In-Degree of 0. Thus, they will never enter the Queue. If our final Result list doesn't contain all the original nodes, we know a cycle exists and the sort is impossible.

### The Process Step-by-Step
**Goal:** Detect cycle: [1 depends on 0], [0 depends on 1].

```plaintext
Step 1: Build the Graph.
        In-Degree: { 0: 1, 1: 1 }
        
Step 2: Find Sources (In-Degree == 0).
        None! Queue = []

Step 3: Loop terminates immediately.
        Result = []
        
Step 4: Compare Result length (0) with total nodes (2).
        0 != 2. Cycle detected! Sort is impossible.
```

### Comparison Summary
| Feature | Valid Ordering | Cycle Detection |
|---------|----------------|-----------------|
| **Data Structures**| HashMap/Array for In-Degree, Queue for Sources. | Same. |
| **Logic Phase** | Push 0-degree nodes, decrement children. | Same. |
| **Final Check** | Return the Result array. | Check `Result.length == TotalNodes`. |
