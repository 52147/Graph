package breadthfirstsearch;

/**
 * = Overview of Breadth-first search algorithm =
 * 
 * - Previously, we discussed the "depth-first search" algorithm.
 * - This section will talk about a closely related and equally popular algorithm called "breadth-first search".
 *   
 * - Similarly, the "breadth-first search" algorithm can traverse all vertices of a "graph" and traverse all paths between two vertices.
 * - However, the most advantageous use case of "breadth-first search" is to efficiently find the shortest path between two vertices in a "graph"
 *   where all edges have equal and positive weights.
 *   
 * - Although the "depth-first search" algorithm can find the shortest path between two vertices in a "graph"
 *   with equal and positive weights,
 *   it must traverse all paths between two vertices before finding the shortest one.
 * - The "breadth-first search" algorithm, in most cases, can find the shortest path without traversing all paths.
 * - This is because when using "breadth-first search", 
 *   as soon as a path between the source vertex and target vertex is found,
 *   it is guaranteed to be the shortest path between the two nodes.
 *       
 * 
 * - In figure 8, the vertices are [A, C, D, B, E].
 * - Given vertices A and B, there are two paths between them.
 * - One path is [A, C, D, B], and the other is [A, E, B].
 * - Obviously, [A, E, B] is the shortest path between A and B.
 * 
 *     A-C-D
 *      \  /
 *      E-B
 *      
 *      Figure 8. An undirected graph
 *      
 * - In Graph theory, the primary use cases of the "bread-first search" ("BFS") algorithm are:
 *   
 *   1. Traversing all vertices in the "graph"
 *   2. Finding the shortest path between two vertices in a graph 
 *      where all edges have equal and positive weights.
 *      
 * = Traversing all vertices - Breadth-first search =
 * 
 *  - Complexity analysis:
 *  
 *    - Time complexity: O(V+E).
 *      
 *      - Here, V represents the number of vertices, and E represents the number of edges.
 *      - We need to check every vertex and traverse through every edge in the graph.
 *      - The time complexity is the same as it was for the DFS approach.
 *      
 *   - Space complexity: O(V).
 *     
 *     - Generally, we will check if vertex has been visited before adding it to the queue,
 *       so the queue will use at most O(V) space.
 *     - Keeping track of which vertices have been visited will also require O(V) space.   
 *   
 *         
 *           
 *
 */

public class FindIfPathExistsInGraph1971_2BFS {

}
