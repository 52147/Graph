package depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. All paths from source to target
 * 
 * 
 * Approach 1: Backtracking (DFS)
 * 
 * Use DFS
 * 
 * Overview:
 * 
 * - If a hint is ever given on the problem description, that would be backtracking.
 * - Indeed, since the problem concerns about the path exploration in a graph data structure,
 *   it is a perfect scenario to apply the backtracking algorithm.
 *   
 *   - As a reminder, backtracking is a general algorithm that incrementally builds candidates to the solutions,
 *     and abandons a candidate ("backtrack") 
 *     as soon as it determines that the candidate cannot possibly lead to a valid solution.
 *     
 * Intuition:
 * 
 * - Specifically, for this problem, we could assume ourselves as an agent in a game,
 *   we can explore the graph one step at a time.
 *   
 * - At any given node, we try out each neighbor recursively until we reach the target or
 *   there is no more node to hop on.
 * - By trying out, we mark the choice before moving on,
 *   and later on we reverse the choice(i.e. backtrack) and start another exploration.
 *   
 *   
 * - To better demonstrate the above idea, we illustrate how an agent would explore the graph
 *   with the backtracking strategy,
 *   in the following image where we mark the order that each edge is visited.
 *   
 *   
 *               start
 *                 | 1
 *                 O
 *              2  /\ 4
 *                O  O
 *              3 \  / 5
 *                 end
 * 
 * Algorithm:
 * 
 * - The above idea might remind one of the Depth-first search (DFS) traversal algorithm.
 * - Indeed, often the backtracking algorithm assumes the form of DFS,
 *   but with the additional step of backtracking.
 *   
 *   
 * - And for the DFS traversal, we often adopt the recursion as its main form of implementation.
 * 
 *   - With recursion, we could implement a backtracking algorithm in a rather intuitive and concise way.
 *   
 *   - We break it down into the following steps:
 *     
 *     - Essentially, we want to implement a recursive function called backtrack(currNode, path)
 *       which continues the exploration,
 *       given the current node and the path traversed so far.
 *      
 *      1. base case: 
 *      - Within the recursive function, we first define its base case, i.e. the moment we should terminate the recursion.
 *      - Obviously, we should stop the exploration when we encounter our target node.
 *      - So the condition of the base case is currNode == target.
 *      
 *      2. recursive function:
 *      - As the body of our recursive function, we should enumerate through all the neighbor nodes of the current node.
 *  
 *      - For each iteration, we first mark the choice by appending the neighbor node to the path.
 *      - Then we recursively invoke our backtrack() function to explore deeper.
 *      
 *      return to the previous state :
 *      - At the end of the iteration, we should reverse the choice by popping out the neighbor node from the path,
 *        so that we could start all over for the next neighbor node.
 *        
 *  - Once we define our backtrack() function,
 *    it suffices to add the initial node (i.e. node with index 0) to the path,
 *    to kick off our backtracking exploration.      
 *        
 * 
 * 
 * return statement in the void method:
 * 
 * void method : no return value
 * but we can use
 *   
 *   return;
 *   
 *   to end the execution of the void method.
 *   Some programmers use this statement to end the method invocation early 
 *
 *
 */

public class AllPathsFromSourceToTargets797_1DFS {
	
	// DFS
	public List<List<Integer>> allPathsSourceTarget(int[][] graph){
		
		List<List<Integer>> paths = new ArrayList<>(); // create a array list to implement interface type paths
		
		if(graph == null || graph.length == 0) { // if the graph is null or empty
			return paths;
		}
		
		dfs(graph, 0, new ArrayList<>(), paths); // call the dfs method with the first node 0
		return paths;
	}
	
	void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths) {
		path.add(node); // add the node in the path
		   
		if(node == graph.length -1) { // if the node value is equal to the last node, it means we foud the path
			paths.add(new ArrayList<>(path));  // add this path in the paths
			return; // end the method
		}
		
		int [] nextNodes = graph[node]; // find the next node 
		
		for(int nextNode: nextNodes) { // try every next node to see whether there is a path between first node and lst node
			dfs(graph, nextNode, path, paths); // found out the path, return to the previous node 
			path.remove(path.size() - 1); // return to the previous node and try others paths
		}
	}

}

/**
 * Complexity analysis:
 * 
 *  - Time complexity: O(2^V * V).
 *    - Here, V represents the number of vertices.
 *    
 *      - For a directed acyclic graph (DAG) with V vertices, there could be at most 2^(V-1) - 1 possible to go
 *        from the starting vertex to the target vertex.
 *      - We need O(V) time to build each such path.
 *      - Therefore, a loose upper bound on the time complexity would be
 *        (2^(V-1) - 1)*O(V) = O(2^V*V)
 *      - Since we have overlap between the paths, the actual time spent on the traversal will be lower to some extent.
 *      
 *   - Space complexity: O(V)
 *     - The recursion depth can be no more than V,
 *       and we need O(V) space to store all the previously visited vertices while recursively
 *       traversing deeper with the current path.
 *     - Please note that we don't count the space usage for the output,
 *       i.e., to store all the paths we obtained.     
 */





