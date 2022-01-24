package pathcompressionandunionbyrank;
/**
 * = Optimized "disjoint set" with Path Compression and Union by rank
 * 
 * - This implementation of the "disjoint set" is optimized with both
 *   "path compression" and "union by rank".
 *   
 *   
 *   
 * Time complexity:
 * 
 * 1. Union-find constructor: O(N)
 * 
 * 2. find: O(£\(N))
 * 
 * 3. union: O(£\(N))
 * 
 * 4. connected: O(£\(N))
 * 
 * 
 * - Note: 
 *   - N is the number of vertices in the graph.
 *   - £\ refers to the inverse Ackermann function.
 *   - In practice, we assume it's a constant.
 *   - In other words, O(£\(N)) is regarded as O(1) on average.
 *   
 *   - For the union-function constructor, we need to create two arrays of size N each.
 *   - When using the combination of union by rank and path compression optimization,
 *     the find operation will take O(£\(N)) time on average.
 *   - Since union and connected both make calls to find and all other operations require constant time,
 *     union and connected functions will also take O(£\(N)) time on average.
 *     
 * Space complexity:
 * 
 *   - We need O(N) space to store the array of size N.
 * 
 *
 */

public class UnionFind {
	
	
	private int[] root;
	// Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
	private int[] rank;
	
	public UnionFind(int size) {
		root = new int[size];
		rank = new int[size];
		
		for(int i = 0; i< size; i++) {
			root[i] = i;
			rank[i] = 1; // The initial "rank" of each vertex is 1,
			             // because each of them is a standalone vertex with no connection to other vertices.
		}
	}
	
	
	// The find function here is the same as that in the disjoint set with path compression.
	public int find(int x) {
		if(x == root[x]) {
			return x;
		}
		
		return root[x] = find(root[x]);
	}
	
	// The union function with union by rank
	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX != rootY) {
			if(rank[rootX] > rank[rootY]) {
				root[rootY] = rootX;
			}else if(rank[rootX] < rank[rootY]) {
				root[rootX] = rootY;
			}else {
				root[rootX] = root[rootY];
				rank[rootX] += 1;
			}
		}
	}
	
	public boolean connected(int x, int y) {
		return find(x) == find(y);
	}
	
	
	
	

}
