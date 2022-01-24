package unionbyrank;
/**
 * = Union by Rank =
 * 
 *  optimize the union function
 * 
 * - We have implemented 2 kinds of "disjoint sets" so far,
 *   but they both have a concerning inefficiency.
 * - Specifically, the quick find implementation will always spend O(n) time on the union operation
 *   
 *   and in the quick union implementation, as shown in figure 6,
 *   it is possible for all the vertices to form a line after connecting them using union,
 *   which results in the worst-case scenario for the find function.
 *   
 * - Is there any way to optimize these implementations?
 * 
 * 
 *    figure 6: A line graph
 *    
 *    0
 *    \
 *     2
 *     \
 *     3
 *     \ 
 *     4
 *     \
 *     5
 *    
 *    
 *    - Of course, there is; it is to union by rank.
 *    - The word "rank" means ordering by specific criteria.
 *    - Previously, for the union function, we always chose the root node of x
 *      and set it as the new root node for the other vertex.
 *    - However, by choosing the parent node based on certain criteria(by rank),
 *      we can limit the maximum height of each vertex.
 *    
 *        
 *   - To be specific, the "rank" refers to the height of each vertex.
 *   - When we union two vertices, instead of always picking the root of x
 *     (or y, it doesn't matter as long as we're consistent) as the new root node,
 *     we choose the root node of the vertex with a larger "rank".
 *   - We will merge the shorter tree under the taller tree and assign the root node
 *     of the taller tree as the root node for both vertices. 
 *   - In this way, we effectively avoid the possibility of connecting all vertices into a straight line.
 *   
 *   -> This optimization is called the "disjoint set" with union by rank.
 *   
 *     
 *     
 *     
 *     Quick union:
 *     (0, 1)
 *     (0, 2)
 *     (0, 3)
 *     (0, 4)
 *     (0, 5)
 *     
 *     5
 *     |
 *     4
 *     |
 *     3
 *     |
 *     2
 *     |
 *     1
 *     |
 *     0
 *     
 *    A line tree:
 *    find function: O(H) H is the height of the tree.=> the worst case , because the height of the tree will become all the vertices(O(N))
 *     
 *    another way to balance the tree:
 *    
 *          0                                   5
 *          /\                                 /
 *          1 2                               6
 *          |
 *          3
 *          |
 *          4
 *       The height of the tree: 4           The height of the tree: 2
 *          
 *      connect the node of 1 and 6:
 *      
 *      1. find the root node of 1 => 0
 *         find the root node of 6 => 5
 *     
 *      2. choose the root node 5 or choose the root node 0
 *      
 *        2.1 
 *          if we choose the 5 as root node
 *          
 *          5
 *          /\
 *          0 6
 *          /\
 *          1 2
 *          |
 *          4
 *          The height of the tree: 5
 *          
 *        2.2
 *         if we choose the root node as 0
 *        
 *            0
 *            /\  \
 *            1 2  5
 *            |     \
 *            3      6
 *            |
 *            4
 *            The height of the tree: 4  (more efficient)
 *    
 *    
 *      => So choose the root node of height of the tree is bigger(the taller tree)
 *     
 * 
 * if the height of 2 tree are equal
 * ex:
 * 
 *     1   3
 *     |   |
 *     2   4
 *     
 *     the height of tree plus 1
 *     
 *     1
 *     | \
 *     2  3
 *         \
 *         4
 *         
 *         
 *    Time complexity:
 *    
 *    Union-find Constructor: O(N)
 *    
 *    Find: O(log N)
 *    
 *    Union: O(log N)
 *    
 *    Connected: O(log N)
 *    
 *    
 *    - Note: N is the numbert of vertices in the graph.
 *    
 *      - For the union-find constructor, we need to create 2 array of size N each.
 *      
 *      - For the find operation, in the worst-case scenario, when we repeatedly union components of equal rank,
 *        the tree height will be at most log(N) + 1,
 *        so the find operation requires O(log N) time.
 *      
 *      - For the union and connected operations, we also need O(log N) time
 *        since these operations are dominated by the find operation.
 *      
 *  Space complexity:
 *  
 *    - We need O(N) space to store the array of size N.      
 *         
 * 
 * 
 *
 */

// the quick union code with few changing(union function).
public class UnionFind {
	private int [] root;
	private int [] rank; // to record the height of each vertex
	
	
	public UnionFind(int size) {
		root = new int[size];
		rank = new int[size];
		
		for(int i = 0; i<size; i++) {
			root[i] = i;
			rank[i] = 1;
		}
	}
	
	public int find(int x) {
		while(x != root[x]) {
			x = root[x];
		}
		return x;
	}
	
	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX != rootY) {
			if(rank[rootX] > rank[rootY]) { // compare the height of root node
				root[rootY] = rootX;
			}else if(rank[rootX] < rank[rootY]) {
				root[rootX] = rootY;
			}else {
				root[rootY] = rootX;  // the height is equal => can choose either node to be the root node, here choose the x as root node
				rank[rootX] += 1;    // add one to the height of the tree
			}
			
			
		}
	}
	
	public boolean connected(int x, int y) {
		return find(x) == find(y);
	}
	
	
	

}
