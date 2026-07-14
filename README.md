# 🚀 Data Structures & Algorithms in Java

![Java](https://img.shields.io/badge/Language-Java-orange.svg)
![License](https://img.shields.io/badge/License-MIT-blue.svg)
![Contributions](https://img.shields.io/badge/Contributions-Welcome-brightgreen.svg)
![Open Source](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)

Welcome to the **Data Structures and Algorithms in Java** repository! This project serves as a comprehensive, highly-organized, and robust library of computer science algorithms and data structures implemented entirely in Java.

Whether you are a university student, a coding bootcamp grad, preparing for technical interviews, or a competitive programmer—this repository is designed to be your ultimate reference guide.

---

## 📂 Repository Structure

The codebase is logically divided into two main categories: **Data Structures** and **Algorithms**.

### 🧱 Data Structures (`/DataStructures`)
Contains from-scratch implementations of fundamental and advanced data structures.
- **Linear**: `arrays`, `LinkedList`, `Stack`, `Queue`, `Deque`, `Matrix`
- **Trees**: `Tree` (Binary Tree, BST), `Trie`, `AdvancedDataStructures` (AVL Tree, Segment Tree, Fenwick Tree)
- **Graphs**: `Graph` (Directed, Undirected, Weighted)
- **Hashing & Sets**: `hashmap`, `Sets`, `DisjointSet`

### ⚙️ Algorithms (`/Algorithms`)
Contains highly-optimized algorithms categorized by their methodology.
- **Sorting & Searching**: `SortingAlgorithms` (Merge Sort, Heap Sort, Radix Sort, etc.)
- **String Manipulation**: `StringAlgorithms`
- **Optimization**: `GreedyAlgorithms`, `Dynamic_Programming`
- **Mathematics**: `NumberTheory`, `BitWise`
- **Exploration**: `Backtracking`

---

## 💻 How to Use (For Beginners & Developers)

This project uses **Maven**, the industry standard build tool for Java. This means you do not have to manually compile files one by one!

### 1. Prerequisites
- **Java 17** or higher installed on your machine.
- **Maven** installed (`mvn -version` to verify).

### 2. Clone the Repository
```bash
git clone https://github.com/wasim-builds/Data-Structures-using-java.git
cd DataStructures-using-java
```

### 3. Compile the Code
To compile all 80+ algorithms and data structures at once, simply run:
```bash
mvn clean compile
```

### 4. Run the Automated Tests
We have enterprise-grade unit tests built-in! To prove the algorithms work flawlessly, run:
```bash
mvn test
```

### 5. Running a Specific Algorithm
Because we use proper Java `package` structures, you should run individual files directly from the `src/main/java` root directory.
For example, to run the Tic-Tac-Toe Low-Level Design file:
```bash
cd src/main/java
javac OOps/LowLevelDesign/TicTacToe.java
java OOps.LowLevelDesign.TicTacToe
```

---

## 🤝 Contributing

We absolutely welcome contributions! This is an open-source project and we would love to have you help make it better. 

If you want to add a missing algorithm, optimize an existing one, or add unit tests:
1. Please read our [Contributing Guidelines](CONTRIBUTING.md).
2. Check the [Issues](https://github.com/wasim-builds/Data-Structures-using-java/issues) tab for open tasks or open a new Issue (we have templates for Bug Reports and Feature Requests).
3. Fork the project, create a branch, and submit a Pull Request!

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details. You are free to use, modify, and distribute this code as you see fit.

---
*Created and maintained by [Mohammed Wasim](https://github.com/wasim-builds).*
