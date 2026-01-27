# Competitive Programming Templates

Fast, reusable templates for competitive programming contests.

## 🚀 Quick Start Templates

### Fast I/O Template
```java
import java.io.*;
import java.util.*;

public class FastIO {
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

## 📚 Common Utilities

### Number Theory
- GCD, LCM
- Prime checking
- Sieve of Eratosthenes
- Modular arithmetic

### Graph Algorithms
- BFS, DFS templates
- Dijkstra's algorithm
- Union-Find (DSU)

### Data Structures
- Segment Tree
- Fenwick Tree (BIT)
- Trie

## 💡 Tips
1. **Use fast I/O** for large inputs
2. **Precompute** factorials, primes when needed
3. **Use appropriate data structures**
4. **Watch for integer overflow** - use `long`
5. **Test edge cases**: 0, 1, max values

## 🔗 Resources
- Practice on: Codeforces, AtCoder, LeetCode
- Time limits: Usually 1-2 seconds
- Memory limits: Usually 256 MB
