# Graph Algorithms

This directory contains implementations of fundamental and advanced graph algorithms.

## 📁 Files

### Graph Representations
- **GraphAdjacencyList.java** - Graph using adjacency list (efficient for sparse graphs)
- **GraphAdjacencyMatrix.java** - Graph using adjacency matrix (efficient for dense graphs)

### Traversal Algorithms
- **BFS.java** - Breadth-First Search with shortest path finding
- **DFS.java** - Depth-First Search (recursive & iterative) with path finding

### Shortest Path
- **DijkstraShortestPath.java** - Single-source shortest path for weighted graphs

### Graph Properties
- **CycleDetection.java** - Detect cycles in directed and undirected graphs
- **TopologicalSort.java** - Topological ordering for DAGs (DFS & Kahn's algorithm)

## 🎯 Key Concepts

### Time Complexities
- **BFS/DFS**: O(V + E)
- **Dijkstra**: O((V + E) log V) with priority queue
- **Cycle Detection**: O(V + E)
- **Topological Sort**: O(V + E)

### Applications
- **BFS**: Shortest path in unweighted graphs, level-order traversal
- **DFS**: Cycle detection, topological sort, connected components
- **Dijkstra**: GPS navigation, network routing
- **Topological Sort**: Task scheduling, build systems, course prerequisites

## 🚀 Usage Examples

```java
// Create graph and perform BFS
Map<Integer, List<Integer>> graph = new HashMap<>();
graph.put(0, Arrays.asList(1, 2));
graph.put(1, Arrays.asList(3));
BFS.bfsTraversal(graph, 0);

// Find shortest path with Dijkstra
Map<Integer, List<DijkstraShortestPath.Edge>> weightedGraph = new HashMap<>();
Map<Integer, Integer> distances = DijkstraShortestPath.dijkstra(weightedGraph, 0);
```
