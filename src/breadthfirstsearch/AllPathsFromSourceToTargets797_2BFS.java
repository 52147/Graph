package breadthfirstsearch;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsFromSourceToTargets797_2BFS {
	
	public List<List<Integer>> allPathsSourceTarget(int[][] graph){
		
		List<List<Integer>> paths = new ArrayList<>();
		
		if(graph == null || graph.length == 0)
			return paths;
		
		Queue<List<Integer>> queue = new LinkedList<>();
		
		List<Integer> path = new ArrayList<>();
		
		path.add(0); // the first node 0 do not need to be iterated because we need to start with the first node
		queue.add(path);
		
		
		
		// we need to create 2 variable to make sure we do not change the path and paths
		// until we find the final answer, we will add the path in the paths
		// 1. first variable is curretPath -> use this variable to find the last node in the path we poll(remove)
		// 2. second variable is tmpPath -> to find the next node is the destination node and add this path in the paths
		// (can not add the next node in the current path because the 1 will be stored in every path we iterate)
		while(!queue.isEmpty()) {
			List<Integer> currentPath = queue.poll(); // remove the fist list in the queue.
			
			int node = currentPath.get(currentPath.size()-1);
			
			// do not need to determine the current path last node is the destination node
			// because when we found out the next node is the destination node
			// we directly add the path in the paths
			// not add in the queue.
			
			
			for(int nextNode: graph[node]) {
				
				List<Integer> tmpPath = new ArrayList<>(currentPath);
				tmpPath.add(nextNode);
				
				if(nextNode == graph.length -1) {
					paths.add(new ArrayList<>(tmpPath));  // if the next node is the destination node, we add the path in the paths(not in the queue)
				}else {                                     
					queue.add(new ArrayList<>(tmpPath)); // if the next node is not the destination node, we add in the queue
				}
				
			}
			
		}
		return paths;
		
	}

}

/**
 * Complexity analysis:
 * 
 *  - Time complexity: O(2^V * V). Here, V represents the number of vertices.
 *    - For a graph with V vertices, there could be at most 2^(V-1) -1 possible paths
 *      to go from the starting vertex to the target vertex.
 *    - We need O(V) time to build each such path.
 *    - Therefore, a loose upper bound on the time complexity would be
 *      (2^(V-1)-1) * O(V) = O(2^V * V).
 *      
 *    - Since we have overlapping between the paths,
 *      the actual time spent on the traversal will be lower to some extent.  
 * 
 * 
 *  - Space complexity: O(2^V * V)
 *    - The queue can contain O(2^V) paths and each path will take O(V) space.
 *    - Therefore, the overall space complexity is O(2^V * V).
 *  
 * 
 */



