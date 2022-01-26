package quickfind;

/**
 * 
 * = Disjoint Set =
 * 
 * - Given the vertices and edges between them, how could we quickly check two vertices are connected?
 *   - for example,
 *     - figure 5 shows the edges between vertices, so how can we efficiently check if 0 is connected to 3, 1 is connected to 5 or 7 is connected to 8?
 *     - We can do so by using the "disjoint set" data structure,
 *       also known as the "union-find" date structure.
 *  - Note that others might refer to is as an algorithm.
 *  - In this explore card, the term "disjoint set" refers to a data structure.
 *  
 *  - The primary use of disjoint sets is to address the connectivity between the components of a network.
 *  - The "network" here can be a computer network or a social network.
 *    - For instance, we can use a disjoint set to determine if two people share a common ancestor.
 *    
 *                  0        9   
 *                  /\      
 *                 1  2
 *                 /
 *                 3
 *                 
 *                4
 *                /
 *               8
 *               
 *                5
 *                /\
 *               6  7 
 *             
 *  Terminologies:
 *  
 *    - Parent node:
 *      - the direct parent node of a vertex.
 *        - for example:
 *          - in figure 5, the parent node of vertex 3 is 1,
 *            the parent node of vertex 2 is 0,
 *            and the parent node of vertex 9 is 9.
 *    
 *     - Root node:
 *       - a node without a parent node; it can be view as the parent node of iteself.
 *         - for example, in figure 5, the root node of vertices 3 and 2 is 0.
 *         - As for 0, it is its own root node and parent node.
 *         - Likewise, the root node and parent node of vertex 9 is 9 itself.
 *         - Sometimes the root node is referred to as the head node. 
 *         
 *               
 * Implementing "disjoint sets"        
 * 
 *  - 2 important functions of a "disjoint set":
 *  
 *  - The find function:
 *    - find the root node of a given vertex.
 *      - for example, in figure 5, the output of the find function for vertex 3 is 0.
 *   
 *  - The union function:
 *    - unions two vertices and makes their root nodes the same.
 *    - In figure 5, if we union vertex 4 and vertex 5,
 *      their root node will become the same,
 *      which means the union function will modify the root node of vertex 4 or vertex 5 to the same root node.
 *    
 * - There are 2 ways to implement a "disjoint set" 
 * 
 *   - Implementation with Quick find:
 *     - In this case, the time complexity of the find function will be O(1).
 *     - However, the union function will take more time with the time complexity of O(N).
 *     
 *   - Implementation with Quick Union:
 *     - compared with the Quick Find implementation,
 *       the time complexity of the union function is better.
 *     - Meanwhile, the find function will take more time in this case.  
 *  
 *  Time complexity:
 *  
 *  Union-find Constructor: O(N)
 *  
 *  Find: O(1)
 *  
 *  Union: O(N)
 *  
 *  Connected: O(1)
 *  
 *  Note: N is the number of veritced in the graph.
 *  
 *    - When initializing a union-find constructor,
 *      we need to create an array of size N with the values equal to the corresponding array indices;
 *      this requires linear time.
 *      
 *    - Each call to find will require O(1) time
 *      since we are just accessing an element of the array at the given index.
 *      
 *    - Each call to union will require O(N) time
 *      because we need to traverse through the entire array and update the root vertices for all the vertices of the set
 *      that is going to be merged into another set.
 *     
 *    - The connected operation takes O(1) time
 *      since it involves the two find calls and the equality check operation.
 * 
 * Space complexity:
 * 
 *  - We need O(N) space to store the array of size N.
 *  
 *  
 *  
 *  Root array:
 *  
 *
 */

// Quick find implementation
public class UnionFind {
	
	
	private int[] root; // a root array
	
	
	// O(N)
	// constructor: for initialize the root array value
	public UnionFind(int size) {
		root = new int[size];
		for(int i = 0 ; i < size; i++) { // initialize the array with element be the index itself because each vertex are isolate and independent at the beginning with no connection with other nodes.
			root[i] = i;
		}
	}
	
	// O(1)
	// find the root vertex of the x vertex
	public int find(int x) {
		return root[x];  // directly return the array value of corresponding index.
	}
	
	
	// O(N)
	// make the root node the same
	public void union(int x, int y) {
		int rootX = find(x); // the root of x vertex
		int rootY = find(y); // the root of y vertex
		
		
		if(rootX != rootY) {
			for(int i = 0; i< root.length; i++) { // traverse the root array and set the 2 set to the same root
				if(root [i] == rootY) {  // need to take more time because we store the root node in the array, 
					root[i] = rootX;    // so we need to traverse the all root to find the different root node value and change all the root node that it be merged.
				}
			}
		}
	}
	
	// O(1)
	// check the x and y vertex have the same root node
	public boolean connected(int x, int y) {
		return find(x) == find(y);
	}

}
