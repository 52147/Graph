package singlesourceshortestpath;
/**
 * = Overview of single source shortest path =
 * 
 * - Previously, we used the "breadth-first search(BFS)" algorithm to find the "shortest path" between two vertices.
 * - However, the "breadth-fist search" algorithm can only solve the "shortest path" problem in "unweighted graphs".
 * - But in real life, we often need to find the "shortest path" in a "weighted graph".
 * 
 *    - For example, there may be many routes from your to a target location,
 *      such as a bus station,
 *      and the time needed for each route may be different.
 *    - The route with the shortest distance may not be the one that requires the least amount of time
 *      because of the speed limit and traffic jams.
 *    - So, if we want to find the route that takes the least time from home to a certain bus station,
 *      then the weights should be the time instead of distance.
 *    
 *    - With that in mind, how we solve the "shortest path" problem given two vertices in a "weighted graph"?
 *    
 * - The main focus of this chapter is to solve such "single source shortest path" problems.
 * - Given the starting vertex, find the "shortest path" to any of the vertices in a weighted graph.
 * - Once we solve this, we can easily acquire the shortest paths between the starting vertex and given target vertex.
 * 
 * 
 * = Edge relaxation =
 *          
 * - An alternative way to understand why this process is called "relaxation" is to imagine that each path is a rubber band of length 1.   
 * - The original path from A to D is of length 3, so the rubber band was stretch to 3 times its original length.
 * - When we relax the path to length 2, by visiting C first, the rubber band is now only stretched to twice its length,
 *   so you can imagine the rubber band being relaxed, hence the term edge relation.
 * 
 * 
 * - In this chapter, we will learn two "single source shortest path" algorithms:
 * 
 *   - 1. Dijkstra's algorithm
 *   - 2. Bellman-Ford algorithm
 *   
 * - "Dijkstra's algorithm" can only be used to solve the "single source shortest path" problem in a weighted directed graph with non-negative weights.
 * 
 * - "Bellman-Ford algorithm", on the other hand, can solve the "single-source shortest path" in a weighted directed graph with any weights,
 *    including any weights, including, of course, negative weights.
 *    
 * = Dijkstra's Algorithm =
 * 
 * The main idea:
 * - We take the starting point u as the center and gradually expand outward while
 *   updating the "shortest path" to reach other vertices.
 *   
 * - "Dijkstra's Algorithm" uses a "greedy approach".
 *   - Each step selects the "minimum weight" from the currently reached vertices to find the "shortest path" to other vertices.   
 *  
 * Proof of the algorithm:
 * 
 * - Now let's prove that Dijkstra's Algorithm actually leads to the correct answer.
 * 
 * - The "greedy approach" only guarantees that, at each step, it takes the optimal choice in the current state.
 * - It does not guarantee that the final result is optimal.
 * - So, how does "Dijkstra's Algorithm" ensure that its final result is optimal?
 * 
 * Limitation of the Algorithm:
 * 
 *  - "Dijkstra's Algorithm" can only be used on graph that satisfy the following condition:
 *    -> weight of all edges are non-negative.
 *    
 * Complexity Analysis:
 * 
 *  - V represents the number of vertices, and E represents the number of edges.
 *  
 *  - Time complexity: O(E + V log V) when a Fibonacci heap is used, or O(V + E log V) for a Binary heap.
 *    - If you use a Fibonacci heap to implement the "min-heap",
 *      extracting minimum element will take O(log V) time
 *      while key decreasing operation will take amortized O(1) time,
 *      therefore, the total time complexity would be O(E + V log V).
 *    - If you use a Binary heap, then the time complexity would be O(V + E log V)
 * 
 *  - Space complexity: O(V)
 *    - We need to store V vertices in our data structure.
 *    
 *    
 *  Approach 3: Dijkstra's Algorithm
 *  
 *  Intuition:
 *  
 *  - As mentioned earlier, our objective is to find the fastest path from node form node k to every other node.
 *  - This is a typical use case for the Single source shortest path algorithm.
 *  - Hence, in this approach, we will use Dijkstra's Algorithm to find the fastest path to every node from node k.
 *  
 *  - This approach is very similar to the previous BFS approach.
 *  - We will start with node k and then iterate over adjacent node neighborNode.
 *  - In the previous approach, we used a queue and hence broadcasted the signal from visited nodes in a FIFO mammer.
 *  
 *  - However, in this approach, we will use a priority queue to traverse the nodes in increasing order of the time required to reach them.
 *  - Therefore, in each iteration, we will visit the node with the shortest travel time.
 *  - This will help us in finding the fastest time path first.
 * 
 */
public class NightWorkDelayTime743_Dijkstra {

}
