package pathcompressionoptimization;
/**
 * = Path compression optimization =
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
 */

public class UnionFind {
	
	private int[] root;
	
	public UnionFind(int size) {
		root = new int[size];
		
		for(int i = 0; i< size; i++) {
			root[i] = i;
		}
	}
	
	public int find(int x) {
		if(x == root[x]) {
			return x;
		}
		return root[x] = find(root[x]);
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
