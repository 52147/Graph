package disjointsummary;

/**
 * 
 * = Summary of the "disjoint set" data structure = 
 * 
 * - The main idea of a "disjoint set" is to have all connected vertices 
 *   have the same parent node or root node,
 *   whether directly or indirectly connected.
 * - To check if 2 vertices are connected, we only need to check if they have the same root node.
 * 
 * - The 2 most important functions for the "disjoint set" data structure
 *   are the find function and the union function.
 *   
 *  1.
 *  - The find function locates the root node of a given vertex.
 *  2.
 *  - The union function connects 2 previously unconnected vertices
 *    by giving them the same root node.
 *  3.
 *  - There is another important function named connected,
 *    which checks the "connectivity" of 2 vertices.
 *  
 *  
 *  - The find and union functions are essential for any question that uses the "disjoint set" data structure.
 *  
 *  
 *  
 *  
 * Tips for using the "disjoint sets" data structure in solving LeetCode problems:
 * 
 * - The code for the disjoint set is highly modularized.
 * - You might want to become familiar with the implementation.
 * - I would highly recommend that you understand and memorize the implementation 
 *   of "disjoint set with path compression and union by rank".
 *   
 * 
 *  
 *   
 *   
 *   
 *
 */

// Implementation of the "disjoint set"
public class UnionFind {

	private int[] root;
	private int[] rank;

	// Constructor of Union-find.
	// The size of the length of the root array.
	public UnionFind(int size) {
	}

	// find function: to find the root node of a given vertex.
	public int find1(int x) {
		while (x != root[x]) {
			x = root[x];
		}
		return x;
	}

	// The find function-optimized with path compression:
	public int find2(int x) {
		if (x == root[x]) {
			return x;
		}
		return root[x] = find2(root[x]);
	}

	// union function: to connect 2 vertices, x and y, by equating their root node.
	public void union1(int x, int y) {
		int rootX = find1(x);
		int rootY = find1(y);
		if (rootX != rootY) {
			root[rootY] = rootX;
		}
	}

	// union function: optimized by union by rank
	public void union2(int x, int y) {
		int rootX = find1(x);
		int rootY = find1(y);

		if (rootX != rootY) {
			if (rank[rootX] > rank[rootY]) {
				root[rootY] = rootX;
			} else if (rank[rootX] < rank[rootY]) {
				root[rootX] = rootY;
			} else {
				root[rootY] = rootX;
				rank[rootX] += 1;
			}
		}
	}
	
	// connected function:
	// checks if 2 vertices, x and y, are connected by checking if they have the same root node.
	// if x and y have the same root node, they are connected.
	// Otherwise, they are not connected.
	public boolean connected(int x, int y) {
		return find1(x) == find1(y);
	}

}
