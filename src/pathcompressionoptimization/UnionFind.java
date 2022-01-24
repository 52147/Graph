package pathcompressionoptimization;
/**
 * = Path compression optimization =
 * 
 *  -> use recursion in find function
 *  
 * - In the previous implementation of the "disjoint set", notice that to find the root node,
 *   we need to traverse the parent nodes sequentially until we reach the root node.
 * - If we search the root node of the same element again,
 *   we repeat the same operations.
 * - Is there any way to optimize this process?
 * 
 * 
 * - The answer is yes.
 * - After finding the root node, we can update the parent node of all traversed elements to their root node.
 * - When we search for the root node of the same element again,
 *   we only need to traverse two elements to find its root node, which is highly efficient.
 * 
 * - So, how could we efficiently update the parent nodes of all traversed elements to the root node>
 * - The answer is to use "recursion".
 * - The optimization is called "path compression", which optimized the find function.  
 * 
 * 
 * 
 * Time complexity:
 * 
 * - Time complexities shown below are for the average case, since the worse-case scenario is rare in practice.
 * 
 * - Union-find constructor: O(N)
 * 
 * - Find: O(log N)
 * 
 * - Union: O(log N)
 * 
 * - Connected O(log N)
 * 
 * - Note: N is the number of vertices in the graph.
 * 
 *   - As before, we need O(N) time to create and fill the root array.
 *   
 *   
 *   - For the find, union, and connected operations
 *     (the latter two operations both depend on the find operation),
 *     we need O(1) time for the best case
 *     (when the parent node for some vertex is the root node itself).
 *   - In the worst case, it would be O(N) time when the tree is skewed.
 *   - However, on average, the time complexity will be O(log N).
 *     
 *      
 * Space complexity:
 * 
 * - We need O(N) space to store the array of size N. 
 * 
 * 
 *
 */

public class UnionFind {
	
	private int[] root;
	
	public UnionFind(int size) {
		root = new int[size];
		
		for(int i = 0; i< size; i++) {
			root[i] = i;
		}
	}
	
	// recursion find
	public int find(int x) {
		if(x == root[x]) { // if the parent node of x is equal to itself, we found the root of x
			return x;
		}
		return root[x] = find(root[x]); // if is not equal, we keep searching and using the find function
		                                // the same time, we will change their root node
	}
	
	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX != rootY) {
			root[rootY] = rootX;
		}
	}
	
	public boolean connected(int x, int y) {
		return find(x) == find(y);
	}
	

}
