# Competitive Programming Templates

Fast, reusable templates for competitive programming contests (Codeforces, AtCoder, LeetCode contests).

## 📁 Templates Available

### 1. **FastIO.java** (in README)
Fast input/output for handling large test cases efficiently.

### 2. **[NumberTheoryTemplate.java](NumberTheoryTemplate.java)**
Complete number theory utilities:
- **GCD & LCM**: Euclidean algorithm, extended GCD
- **Prime Numbers**: Prime checking O(√n), Sieve of Eratosthenes
- **Modular Arithmetic**: Modular exponentiation, modular inverse, nCr calculations
- **Divisors**: Get all divisors, count divisors, sum of divisors
- **Prime Factorization**: O(√n) factorization
- **Euler's Totient**: φ(n) calculation

### 3. **[GraphTemplate.java](GraphTemplate.java)**
Essential graph algorithms:
- **Traversal**: BFS, DFS with applications
- **Shortest Paths**: Dijkstra O((V+E) log V), Bellman-Ford O(VE)
- **Topological Sort**: Kahn's algorithm
- **Cycle Detection**: For directed and undirected graphs
- **Connected Components**: DFS-based counting
- **Union-Find (DSU)**: With path compression and union by rank

### 4. **[CommonUtilities.java](CommonUtilities.java)**
Frequently used utility functions:
- **Array Operations**: Reverse, rotate, min/max, frequency counting
- **Binary Search**: Standard, lower bound, upper bound
- **String Utilities**: Palindrome check, permutations, frequency
- **Bit Manipulation**: Set/clear/toggle bits, count set bits, power of 2
- **Math**: Fast power, factorial, nCr, perfect square check
- **Quick Select**: Kth smallest element O(n) average
- **Coordinate Compression**: For large coordinate values

### 5. **[GeometryTemplate.java](GeometryTemplate.java)**
Basic computational geometry:
- **Point & Vector**: Distance, dot product, cross product
- **Distance Functions**: Point to point, point to line segment
- **Area Calculations**: Triangle, polygon (shoelace formula), circle
- **Line Operations**: Collinearity, segment intersection
- **Orientation**: Clockwise/counterclockwise detection
- **Convex Hull**: Graham scan algorithm

## 🚀 Quick Start

### Fast I/O Template
```java
import java.io.*;
import java.util.*;

public class Solution {
    static class Reader {
        BufferedReader br;
        StringTokenizer st;
        
        public Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    
    public static void main(String[] args) {
        Reader sc = new Reader();
        int t = sc.nextInt();
        while (t-- > 0) {
            // Your solution here
        }
    }
}
```

## 💡 Common Patterns & Tips

### Time Complexity Goals
- **n ≤ 10**: O(n!), O(2^n) - Brute force, backtracking
- **n ≤ 20**: O(2^n), O(n²) - Bitmask DP, meet in the middle
- **n ≤ 500**: O(n³) - Floyd-Warshall, DP
- **n ≤ 10⁴**: O(n²) - Nested loops, simple DP
- **n ≤ 10⁶**: O(n log n) - Sorting, segment tree, binary search
- **n ≤ 10⁸**: O(n) - Linear scan, prefix sums
- **n > 10⁸**: O(log n), O(1) - Math formulas, binary search

### Common Tricks
1. **Modular Arithmetic**: Always use `(a + b) % MOD` to avoid overflow
2. **Integer Overflow**: Use `long` for products and sums
3. **Precision**: Use `double` with epsilon (1e-9) for comparisons
4. **Edge Cases**: Test with n=1, n=2, empty input, max values
5. **Precomputation**: Factorials, primes, powers for multiple queries

### Problem-Solving Checklist
- [ ] Read problem carefully, note constraints
- [ ] Identify the pattern (DP, greedy, graph, etc.)
- [ ] Choose appropriate data structure
- [ ] Consider edge cases
- [ ] Estimate time complexity
- [ ] Code and test with sample inputs
- [ ] Check for overflow, array bounds

## 📊 Complexity Reference

| Operation | Time Complexity |
|-----------|----------------|
| GCD | O(log min(a,b)) |
| Sieve (primes up to n) | O(n log log n) |
| Modular Power | O(log n) |
| Dijkstra | O((V+E) log V) |
| Bellman-Ford | O(VE) |
| Topological Sort | O(V+E) |
| Union-Find | O(α(n)) ≈ O(1) |
| Convex Hull | O(n log n) |

## 🎯 Contest Strategy

1. **Read all problems** first (5-10 min)
2. **Solve easiest first** to secure points
3. **Skip if stuck** > 20 minutes, come back later
4. **Test thoroughly** before submitting
5. **Watch for TLE/MLE** - optimize if needed

## 🔗 Practice Platforms

- **Codeforces**: Rating-based contests, strong community
- **AtCoder**: High-quality problems, beginner contests
- **LeetCode**: Weekly contests, interview prep
- **CodeChef**: Long challenges, cook-offs
- **CSES Problem Set**: Excellent practice problems

## ⚠️ Common Mistakes

❌ Not using fast I/O for large inputs  
❌ Integer overflow (use `long`)  
❌ Off-by-one errors in loops  
❌ Not handling edge cases (n=0, n=1)  
❌ Wrong modulo operations  
❌ Array index out of bounds  

## 📚 Additional Resources

- **Algorithms**: CLRS, Competitive Programmer's Handbook
- **Practice**: Solve 500+ problems across difficulty levels
- **Upsolving**: Always solve problems you couldn't during contest

---

**Happy Coding! May your submissions be AC! ✅**
