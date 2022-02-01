package depthfirstsearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * = Overview of Depth-First Search Algorithm =
 * 
 * - Previously, we learned how to check the connectivity between 2 vertices with the "disjoint set" data structure.
 * 
 * - Now let's switch gears and consider:
 *   - Given a graph, how can we find all of its vertices, and how can we find all paths between two vertices?
 *   
 *   - The depth-first search algorithm is ideal in solving these kinds of problems
 *     because it can explore all paths from the start vertex to all other vertices.
 *   - Let's start by considering an example.
 *   
 *   - In figure 7, there are five vertices [A, B, C, D, E].
 *   
 *   - Given two vertices A and B, there are 2 path between them.
 *   - One path is [A, C, D, B], and the other is [A, E , B]
 *   
 *       A-C-D
 *       \   /
 *        E-B
 *        
 *        - figure 7. An undirected graph
 *        
 * - In Graph theory, the depth-first search algorithm (abbreviated as DFS) is mainly used to:
 *   - 1. Traverse all vertices in a "graph";
 *   - 2. Traverse all paths between any two vertices in a "graph".
 *   
 *          
 * - Traversing all vertices -- Depth-First search algorithm
 * 
 *   - Complexity analysis:
 *   
 *     - Time complexity: O(V + E)
 *       - Here, V represents the number of vertices, and E represents the number of edges.
 *       - We need to check every vertex and traverse through every edge in the graph.
 *              
 *     - Space complexity: O(V)
 *       - Either the manually created stack or the recursive call stack can store up to V vertices.
 *       
 *       
 * - Traversing all paths between 2 vertices-- depth-first search algorithm
 * 
 * - Complexity Analysis:
 *   
 *   - Time complexity: O((V-1)!)
 *     - The above example is for an undirected graph.
 *     - The worst-case scenario, when trying to find all paths, is a complete graph.
 *       - A complete graph is a graph where every vertex is connected to every other vertex.
 *              
 *   - In complete graph,
 *     - there will be V-1 unique paths of length one that start at the source vertex;
 *       one of these paths will go to the target and end.
 *   - Each of the remaining paths will have V-2 unique paths that extend from it
 *     (since none of then will go back to the source vertex which was already visited).
 *   - This process will continue and lead to approximately (V-1)! total paths.
 *   - Remember, once a path reaches the target vertex, it ends, so the total number of path will be less than (V-1)!.
 *
 * worse-case scenario:
 * 
 * - The precise total number of paths in the worst-case scenario is equivalent to the Number of Arrangements of the subset of vertices
 *   excluding the source and target node, which equal e* (V-2)!.
 *   
 * - While finding all paths, at each iteration, we add all valid paths from the current vertex to the stack.
 * - Each time we add a path to the stack requires O(V) time to create a copy of the current path,
 *   append a vertex to it, and push it onto the stack.
 * - Since the path grows by one vertex each time, a path of length V must
 *   have been copied and pushed onto the stack V times before reaching its current length.
 * - Therefore, it is intuitive to think that each path should require O(V^2) time in total.  
 * 
 * - However, there is a flaw in our logic.
 * - Consider the example above; 
 * 
 *    - we add ADE to the stack.
 *    - Then we add ADEC, ADEB, and ADEF to the stack.
 *    - ADE is a subpath of ADEC, ADEB, and ADEF, but ADE was only created once.
 *    - So the time required for each path to create ADE can be thought of O(V) divided by the number of paths that stem from ADE.
 *    - With  this in mind, the time spent to create a path is V plus V-1 devide by the number of paths that stem from this subpath plus V-2 times...
 *    - For a complete graph with many nodes,
 *      this averages out to O(2*V) = O(V) time per path.
 *
 * - Thus, the time complexity to find all paths in an undirected graph in the worst-case scenario is equal to the number of paths found O((V-2)!) times
 *   the average time to find a path O(V) which simplifies to O((V-1)!).
 *   
 *   - Space complexity: O(V^3)
 *     - The space used is by the stack which will contain:
 *       - (V-1) paths after adding first V-1 paths to the stack.
 *       - (V-1) -1 + (V-2) paths after popping one path and adding second set of paths.
 *       - (V-1) -1 + (V-2) -1 + (V-3) -1 + ...
 *       - = V*(V-1)/2 + 1 paths will be at most in the stack, and each path added to the stack will take O(V) space.
 *       
 * 
 * - Therefore, in total, this solution will require O(V* (V-1)/2+1)*V = O(V^3) space.
 * - Note that the space used to store the result does not count towards the space complexity.
 * 
 *     
 *       
 * = Find if Path Exists in Graph =
 *  
 * Q:
 * 
 * - There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n-1(inclusive).
 * - The edges in the graph are represented as a 2D integer array edges,
 *   where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi.
 * - Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 * 
 * - You want to determine if there is a valid path that exists from vertex source to vertex destination.
 * 
 * - Given edges and the integers n, source, and destination,
 *   return true if there is a valid path from source to destination,
 *   or false otherwise.
 *   
 *   
 *   
 *   Example 1:
 *   
 *   0-1
 *    \/
 *     2
 *     
 *     Input: n = 3, edges = [[0,1], [1,2], [2,0]], source = 0, destination = 2
 *     Output: true
 *     Explanation: 
 *     - There are 2 paths from vertex 0 to vertex 2:
 *       - 1. 0 -> 1 -> 2
 *       - 2. 0 -> 2
 *       
 *   Example 2:
 *   
 *         1    3-5
 *        /     |/
 *        0     4 
 *        \
 *         2
 *     Input: n = 6, edges = [[0,1], [0,2], [3,5], [5,4], [4,3]], source = 0, destination = 5
 *     Output: false
 *     Explanation:
 *      - There is no path from vertex 0 to vertex 5.
 *       
 * Constrains:
 * 
 *   1 <= n <= 2*10^5
 *   0 <= edges.length <= 2*10^5
 *   edges[i].length == 2
 *   0 <= ui, vi <= n-1
 *   ui != vi
 *   0 <= source, destination <= n-1
 *   There are duplicate edges.
 *   There are no self edges.
 *    
 *       
 *       
 */

public class FindIfPathExistsInGraphDFS1971_1 {
	
	public boolean validPath(int n, int[][] edges, int start, int end) {
		
		// create a array list to store the adjacency node
		List<List<Integer>> adjacency_list = new ArrayList<>();
		
		// add the all vertex in the adjacency list
		for(int i = 0; i < n; i++) {
			adjacency_list.add(new ArrayList<>());
		}
		
		// add the neighbor node to each node
		for(int[] edge : edges) {
			adjacency_list.get(edge[0]).add(edge[1]);
			adjacency_list.get(edge[1]).add(edge[0]);
		}
		
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(start);
		boolean seen[] = new boolean[n]; // need to give the length of the array
		
		Arrays.fill(seen, false); // At fist, initialize all nodes with false
		
		while(!stack.isEmpty()) {
			
			//Get the current node.
			int node = stack.pop();
			
			// Check is we have reached the target node.
			if(node == end) {
				return true;
			}
			
			// Check if we've already visited this node.
			if(seen[node]) {
				continue;
			}
			seen[node] = true;
			
			// Add all neighbors to the stack.
			for(int neighbor : adjacency_list.get(node)) {
				stack.push(neighbor);
			}
		}
		return false;
		
		
	}
	
	
	
	

}

/**
 * Complexity Analysis:
 * 
 *  - Time complexity: O(V+E)
 *  
 *    - Here, V represents the number of vertices, and E represents the number of edges.
 *      - To create the adjacency list, we must iterate over each of the E edges.
 *      - In the while loop, at most, we will visit vertex once.
 *      - The for loop inside the while loop will have cumulative sum at most E inerations
 *        since it will iterate over all of the node's neighbors for each node.
 *  
 *  - Space complexity: O(V+E)
 *  
 *    - The adjacency list will contain O(V+E) elements.
 *    - The stack will also contain O(E) elements.
 *      - However, this can be reduced to O(V) by checking whether a neighbor node has been seen before adding it to the stack.
 *    - The seen set will use O(V) space to store the visited nodes.  
 *      
 *          
 *  
 */




