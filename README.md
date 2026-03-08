# DSA in Java — Basic to Advanced

A personal DSA learning repository in Java. Organized as a step-by-step roadmap from absolute basics to advanced topics like Graphs and Dynamic Programming.

---

## RECOMMENDED FOLDER STRUCTURE (Basic to Advanced)

Follow this order when studying. Each level builds on the previous one.

```
VIT/
│
├── LEVEL 1 — FOUNDATIONS
│   ├── OOps/               ← Start here. Java classes, objects, inheritance
│   ├── arrays/             ← Most interview questions. Rotations, searching, duplicates
│   ├── Strings/            ← Palindromes, anagrams, reversals
│   ├── BitWise/            ← Even/Odd, Power of 2, XOR tricks
│   └── Matrix/             ← 2D arrays, spiral traversal
│
├── LEVEL 2 — CORE DATA STRUCTURES
│   ├── ArrayList/          ← Dynamic arrays, MAXMIN, RainWater
│   ├── hashmap/            ← Frequency count, Two-Sum, anagrams
│   ├── Sets/               ← Unique elements, set operations
│   ├── Stack/              ← Valid parentheses, Next Greater Element
│   ├── Queue/              ← BFS base, sliding window max
│   └── LinkedList/         ← Cycle detection, reverse, merge
│
├── LEVEL 3 — ALGORITHMS & PATTERNS
│   ├── dsa pattern/        ← Two Pointers, Sliding Window, Prefix Sum, BFS/DFS
│   ├── RecursionProb/      ← Fibonacci, Tower of Hanoi, Backtracking
│   └── DequeExmp/          ← Deque for sliding window problems
│
├── LEVEL 4 — ADVANCED TOPICS
│   ├── Tree/               ← BFS, DFS, BST, LCA, height
│   ├── Dynamic_Programming/← Memoization, Tabulation, DP patterns
│   └── Graph (TODO)        ← BFS/DFS on graphs, Topological Sort, Dijkstra
│
└── LEVEL 5 — PRACTICE & COMPETITIVE
    ├── leetcode/            ← Solved LeetCode problems
    ├── NeetCode/            ← NeetCode roadmap solutions
    ├── CodeChef/            ← Competitive programming
    └── practices/           ← Daily practice scratchpad
```

---

## LEARNING ROADMAP

### Level 1 — Foundations (Week 1-2)
| Topic       | Key Concepts                                    | Status |
|-------------|------------------------------------------------|--------|
| OOPs        | Classes, Objects, Inheritance, Polymorphism    | [ ]    |
| Arrays      | Traversal, Sorting, Searching, Two Pointers    | [ ]    |
| Strings     | Reverse, Palindrome, Anagram, Substring        | [ ]    |
| Bit Manipulation | AND/OR/XOR, Check even/odd, Count bits    | [ ]    |
| Matrix      | Row/Column traversal, Diagonal, Spiral         | [ ]    |

### Level 2 — Core Data Structures (Week 3-5)
| Topic       | Key Concepts                                    | Status |
|-------------|------------------------------------------------|--------|
| ArrayList   | Add/Remove, Search, Sort, Merge                | [ ]    |
| HashMap     | Frequency map, Two-Sum, Group Anagrams         | [ ]    |
| HashSet     | Duplicates removal, Set intersections          | [ ]    |
| Stack       | Push/Pop, Valid Parentheses, Min Stack         | [ ]    |
| Queue       | Enqueue/Dequeue, Circular Queue                | [ ]    |
| Linked List | Traversal, Reverse, Detect Cycle, Merge        | [ ]    |

### Level 3 — Algorithms & Patterns (Week 6-8)
| Topic           | Key Concepts                                | Status |
|-----------------|---------------------------------------------|--------|
| Recursion       | Base case, Backtracking, N-Queens           | [ ]    |
| Two Pointers    | Pair Sum, Triplet Sum, Remove Duplicates    | [ ]    |
| Sliding Window  | Max/Min Subarray, Longest Substring         | [ ]    |
| Prefix Sum      | Range Sum Query, Subarray Sum = K           | [ ]    |

### Level 4 — Advanced Topics (Week 9-12)
| Topic                | Key Concepts                               | Status |
|---------------------|--------------------------------------------|--------|
| Binary Tree          | Inorder/Preorder/Postorder BFS/DFS        | [ ]    |
| Binary Search Tree   | Insert, Delete, Search, LCA              | [ ]    |
| Dynamic Programming  | 0/1 Knapsack, LCS, LIS, Coin Change      | [ ]    |
| Graphs               | BFS, DFS, Cycle Detection, Topo Sort     | [ ]    |

---

## FILE NAMING RULES (Keep it clean!)

To avoid clutter, follow this simple naming convention:

```
ClassName.java          ← Your main solution
ClassName_brute.java    ← Brute force version (if needed)
```

> Avoid having duplicate files like `merge2array.java` and `merge2array-wasimkhan.java`.
> Keep only your best and final version.

---

## CURRENT PROGRESS

- Total Files: ~100+
- Data Structures Covered: Arrays, Strings, LinkedList, Stack, Queue, Tree, HashMap, Bits
- Algorithms Covered: Sorting, Searching, Recursion, DP, Bit Manipulation
- Platforms: LeetCode, NeetCode, CodeChef


## 🔹 Key Features

### Data Structures Implemented
- ✅ **Arrays**: Rotations, sorting, searching, duplicates removal
- ✅ **Linked Lists**: Singly linked lists, merge operations, reversals
- ✅ **Stacks**: Custom implementations, expression evaluation, min stack
- ✅ **Queues**: Queue operations using arrays and collections
- ✅ **Trees**: Binary trees, BST, traversals (inorder, preorder, postorder)
- ✅ **HashMaps**: Frequency counters, anagram detection, two-sum problems
- ✅ **Strings**: Reversals, palindromes, pattern matching

### Algorithms Covered
- 🔸 **Sorting**: Bubble Sort, Selection Sort, Quick Sort, Merge Sort
- 🔸 **Searching**: Linear Search, Binary Search
- 🔸 **Bit Manipulation**: Power of two, count set bits, unique elements
- 🔸 **Dynamic Programming**: Stock prices, subsequences, Fibonacci
- 🔸 **Recursion**: Factorial, N-Queens, Sudoku solver, backtracking
- 🔸 **Matrix Operations**: Addition, multiplication, max element finding

### Design Patterns
- 🎨 Observer Pattern
- 🎨 Command Pattern
- 🎨 Adapter Pattern

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- VS Code or any Java IDE
- Git

### Clone the Repository
git clone https://github.com/wasim-builds/Data-Structures-using-java.git
cd Data-Structures-using-java



Or use VS Code's built-in Java runner.

## 📝 Problem Categories

### Arrays (40+ implementations)
- Find largest/smallest element
- Array rotations (left/right)
- Remove duplicates
- Majority element
- Merge sorted arrays
- Product of array except self
- Kadane's algorithm variants

### Strings (10+ implementations)
- Reverse strings and words
- Anagram detection
- String to integer conversion
- Vowel and consonant counting
- Lexicographically smallest string

### LinkedList (8+ implementations)
- Insert, delete, display operations
- Reverse linked list
- Merge two sorted lists
- Detect cycles
- User input-based list creation

### Stack (10+ implementations)
- Stack using arrays
- Min stack implementation
- Celebrity problem
- Reverse string using stack
- Balanced parentheses

### Tree (5+ implementations)
- Binary tree traversals
- BST operations
- Tree construction from arrays
- Stack-based traversals

### Dynamic Programming
- Best time to buy/sell stock
- Longest common subsequence
- Distinct subsequences
- Fibonacci sequences

### Bit Manipulation
- Check even/odd
- Count set bits (Kernighan's algorithm)
- Power of two check
- Unique element finder
- Toggle bits

## 🎓 Learning Path

1. **Beginner**: Start with `arrays/` and `ArrayList/`
2. **Intermediate**: Move to `LinkedList/`, `Stack/`, `Queue/`
3. **Advanced**: Explore `Tree/`, `Dynamic_Programming/`, `RecursionProb/`
4. **Interview Prep**: Practice `leetcode/` and `NeetCode/` problems

## 🛠️ Technologies Used

- **Language**: Java
- **Development Environment**: VS Code
- **Version Control**: Git & GitHub

## 📊 Problem Solving Stats

- **Total Files**: 164+
- **Array Problems**: 40+
- **String Problems**: 15+
- **LinkedList Problems**: 8+
- **Stack Problems**: 10+
- **Tree Problems**: 5+
- **LeetCode Solutions**: 10+
- **Design Patterns**: 3+

## 🤝 Contributing

Contributions are welcome! If you'd like to add new implementations or improve existing ones:

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/NewAlgorithm`)
3. Commit your changes (`git commit -m 'Add new sorting algorithm'`)
4. Push to the branch (`git push origin feature/NewAlgorithm`)
5. Open a Pull Request

## 📌 Code Style

- Use meaningful variable names
- Add comments for complex logic
- Follow Java naming conventions
- Include time and space complexity where applicable

## 🎯 Future Enhancements

- [ ] Add more graph algorithms
- [ ] Include detailed explanations for each algorithm
- [ ] Add unit tests
- [ ] Create complexity analysis documentation
- [ ] Add more LeetCode/NeetCode solutions
- [ ] Implement advanced data structures (Trie, Segment Tree, etc.)

## 📧 Contact

**Wasim Khan**
- GitHub: [@wasim-builds](https://github.com/wasim-builds)
- Repository: [Data-Structures-using-java](https://github.com/wasim-builds/Data-Structures-using-java)

## 📄 License

This project is open source and available for educational purposes.

---

### ⭐ If you find this repository helpful, please give it a star!

**Happy Coding! 🚀**
