# Understanding In-Place Reversal of a LinkedList

Think of reversing a LinkedList like turning a series of one-way street signs to point in the opposite direction. You start at the first sign, turn it to point behind you, move to the next sign, turn it to point to the previous one, and so on. You don't need to build a whole new road of signs; you just change where the current ones point.

In code, this means we reverse the pointers of a LinkedList without using any extra memory. We rely on three pointers: `Current`, `Previous`, and `Next`.

There are two primary types:
1. **Reversing the Entire List**.
2. **Reversing a Sub-list (a specific portion)**.

## Type 1: Reversing the Entire List
We iterate through the list. At each node, we save the next node, reverse the current node's pointer to point to the previous node, and then shift our pointers one step forward.

### The Process Step-by-Step
**Goal:** Reverse the linked list `1 -> 2 -> 3 -> null`.

```plaintext
Setup: Prev = null, Current = 1

Step 1: [Current: 1]
        Next = 1.next (which is 2)
        1.next = Prev (which is null, so 1 -> null)
        Prev = 1
        Current = 2
        (List state: 1 -> null.   Remaining: 2 -> 3 -> null)

Step 2: [Current: 2]
        Next = 2.next (which is 3)
        2.next = Prev (which is 1, so 2 -> 1 -> null)
        Prev = 2
        Current = 3
        (List state: 2 -> 1 -> null.  Remaining: 3 -> null)

Step 3: [Current: 3]
        Next = 3.next (which is null)
        3.next = Prev (which is 2, so 3 -> 2 -> 1 -> null)
        Prev = 3
        Current = null

Result: Current is null, loop ends. Head is now Prev (3). 
Final list: 3 -> 2 -> 1 -> null.
```

## Type 2: Reversing a Sub-list
If we only want to reverse from position `p` to `q`, we skip the first `p-1` nodes. We remember the node right before `p` (to connect it later to the new head of the reversed part) and remember the `p`th node itself (which will become the tail and needs to connect to `q+1`).

### The Process Step-by-Step
**Goal:** Reverse positions 2 to 4 in `1 -> 2 -> 3 -> 4 -> 5 -> null`.

```plaintext
Step 1: Skip to position p (node 2).
        Node before p is '1' (let's call it nodeBeforeSublist).
        Node at p is '2' (let's call it sublistWorkingTail).

Step 2: Reverse nodes from position 2 to 4.
        Reverse 2, 3, 4 just like Type 1.
        Reversed sublist becomes: 4 -> 3 -> 2 -> null.

Step 3: Reconnect.
        nodeBeforeSublist.next = reversedHead (1 -> 4 -> 3 -> 2)
        sublistWorkingTail.next = nodeAfterSublist (2 -> 5)

Result: 1 -> 4 -> 3 -> 2 -> 5 -> null
```

### Comparison Summary
| Feature | Entire List | Sub-list |
|---------|-------------|----------|
| **Traversal** | Starts from Head to end. | Skips to `p`, reverses to `q`, stops. |
| **Pointers Needed** | `Prev`, `Current`, `Next` | `Prev`, `Current`, `Next` + references to reconnect bounds. |
| **Complexity** | O(N) time, O(1) space. | O(N) time, O(1) space. |
