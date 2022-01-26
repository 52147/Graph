package quickunion;
/**
 * = Quick Union =
 * 
 * Time complexity:
 * 
 * Union - find constructor: O(N)
 * 
 * find : O(N)
 * 
 * union: O(N)
 * 
 * connected: O(N)
 * 
 * Note:
 *   - N is the number of vertices in the graph.
 *   - In the worst-case scenario, the number of operations to get the root vertex will be H where H is the height of the tree.
 *   - Because this implementation does not always point the root of the shrter tree to the root of the taller tree,
 *     H can be at most N when the tree forms a linked list.
 *     
 *     
 *   - The same as in the quick find implementation, when initializing a union-find constructor,
 *     we need to create an array of size N with the values equal to the corresponding array indices;
 *     this requires linear time.
 *     
 *     
 *   - For the find operation, in the worst-case scenario, we need to traverse every vertex to find the root for the input vertex,
 *   - The maximum number of operations to get the root vertex would be no more than the tree's height, so it will take O(N) time.
 *   
 *   - The union operation consists of 2 find operations which (only in the worst-case)
 *     will take O(N) time,
 *     and 2 constant time operations, including the equality check updating the array value at a given index.
 *   - Therefore, the union operation also costs O(N) in the worst-case.
 *   
 *   - The connected operation also takes O(N) time in the worst-case since it involves 2 find calls.
 *   
 * 
 * Space complexity:
 * 
 *   - We need O(N) space to store the array of size N.
 *   
 *   
 *           0  
 *          /\\      4
 *         2 1 3     /\
 *                  5  6
 * 
 *   
 * 
 * Root array:
 * array value(parent vertex)   0 0 0 0 4 4 4
 * array index(vertex)          0 1 2 3 4 5 6
 * 
 * 
 * connect 1 and 5 vertex -> change the root node of 4 vertex to 0 vertex
 * 
 * 
 *             0  
 *          /\\  \   
 *         2 1 3  4
 *                /\
 *                5 6  
 *                  
 * Root array:                  
 * array value(parent vertex)   0 0 0 0 0 4 4
 * array index(vertex)          0 1 2 3 4 5 6
 *
 */

// quick union: directly connected the vertex with the root node, so the array value will be the root node(parent node)
public class UnionFind {
	
	private int[] root;
	
	// O(N)
	public UnionFind(int size) {
		root = new int[size];
		
		for(int i = 0; i<size; i++) {
			root[i] = i;
		}
	}
	
	// <= O(N), the worst case(a line tree)
	public int find(int x) {
		while(x != root[x]) // not the root node
			x = root[x]; // keep find the parent node of the vertex
		return x; // the parent node is vertex itself
	}
	
	// <= O(N), because use find method
	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX != rootY) {
			root[rootY] = rootX; // set the parent node of y and to x's parent node(rootX).
			
		}
	}
	
	
	// O(N)
	public boolean connected(int x, int y) {
		return find(x) == find(y);
	}
	
	

}
