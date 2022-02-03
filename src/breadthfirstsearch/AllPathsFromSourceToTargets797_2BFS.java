package breadthfirstsearch;

import java.lang.reflect.Array;
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
		
		path.add(0);
		queue.add(path);
		
		while(!queue.isEmpty()) {
			List<Integer> currentPath = queue.poll();
			
			int node = currentPath.get(currentPath.size()-1);
			
			for(int nextNode: graph[node]) {
				
				List<Integer> tmpPath = new ArrayList<>(currentPath);
				tmpPath.add(nextNode);
				
				if(nextNode == graph.length -1) {
					paths.add(new ArrayList<>(tmpPath));
				}else {
					queue.add(new ArrayList<>(tmpPath));
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



