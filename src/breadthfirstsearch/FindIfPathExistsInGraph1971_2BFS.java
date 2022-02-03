package breadthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 * = Shortest path between two vertices - Breadth-First Search =
 * 
 * 
 *  Complexity analysis:
 *  
 *  - Time complexity: O(V + E)
 *    - Here, V represents the number of vertices, and E represents the number of edges.
 *    - In the worst case, when the distance between the starting vertex and the target vertex is the maximum possible,
 *      we need to check every vertex and traverse through every edge in the graph.
 *      
 *  - Space complexity: O(V)
 *    - The queue will take up to O(V) space to store all the graph vertices in the worst-case scenario.
 *    - We must also use O(V) space to keep track of which vertices have been visited.        
 *           
 *
 */

public class FindIfPathExistsInGraph1971_2BFS {
	
	public boolean validPath(int n, int[][] edges, int start, int end) {
		List<List<Integer>> adjacency_list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			adjacency_list.add(new ArrayList<>());
		}
		
		for(int[] edge : edges) {
			adjacency_list.get(edge[0]).add(edge[1]);
			adjacency_list.get(edge[1]).add(edge[0]);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		
		boolean[] seen = new boolean[n];
		
		Arrays.fill(seen, false);
		seen[start] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			if(node == end) {
				return true;
			}
			
			for(int neighbor : adjacency_list.get(node)) {
				if(!seen[neighbor]) { // check the neighbor nodes is been visited before
					seen[neighbor] = true;
					queue.add(neighbor); // if the neighbor node is not be visited, add neighbors in the queue
				}
			}
			
			
		}
		
		return false;
		
		
		
		
	}
	
	
	

}

/**
 * Complexity Analysis:
 * 
 *  - Time complexity: O(V+E)
 *    - Here, V represents the number of vertices and E represents the number of edges.
 *      - To create the adjacency list, we must iterate over each of the E edges.
 *      - In the while loop, at most we will visit vertex once.
 *      - The for loop inside the while loop will have a cumulative sum of at most E iterations 
 *        since it will iterate over all of the node's neighbors for each node.
 *        
 *  - Space complexity: O(V+E)
 *    - The adjacency list, will contain O(V+E) elements.
 *    - The queue will also contain O(V) elements.
 *    - The seen set will use O(V) space to store the visited nodes.
 *        
 */




