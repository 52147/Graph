package leetcodegraph;

/**
 * 547. Number of Provinces
 * 
 * Q:
 * 
 * - There are n cities.
 * - Some of them are connected, while some are not.
 * - If city s is connected directly with city b, and city b is connected directly with city c,
 *   then city a is connected indirectly with city c.
 * 
 * - A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * 
 * - You are given an n*n matrix isConnected where isConnected[i][j] = 1
 *   if the i-th city and j-th city are directly connected,
 *   and isConnected[i][j] = 0 otherwise.
 *    
 * - Return the total number of provinces.
 * 
 * 
 * Approach #3 using union-find method 
 * 
 * 
 * Complexity Analysis:
 * 
 * - Time complexity: O(n^3)
 *   - We traverse over the complete matrix once.
 *   - Union and find operations take O(n) time in the worst case.
 *   
 * - Space complexity: O(n)
 *   - root array of size n is used.
 *   
 * 
 *    
 *   
 *   
 * 
 * 
 */

public class NumberOfProvinces547_3 {

	public int findCircleNum(int[][] isConnected) {

		// if the 2d array is null or the row of 2d array is 0 -> no cities connected ->
		// return 0
		if (isConnected == null || isConnected.length == 0) {
			return 0;
		}

		int n = isConnected.length;

		UnionFind uf = new UnionFind(n);

		// find the 1 in the 2d array => represent 2 cities connected
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (isConnected[i][j] == 1) {
					uf.union(i, j);
				}
			}
		}
		return uf.getCount();

	}

	class UnionFind {

		private int[] root;
		private int[] rank;
		private int count; // the number of provinces

		UnionFind(int size) {
			root = new int[size];
			rank = new int[size];

			count = size; // initial the size with the number of the city because at the start the cities
							// is independent

			for (int i = 0; i < size; i++) {
				root[i] = i;
				rank[i] = 1;
			}
		}

		// path compression: use recursion(find the root node and change the root node value of traversed vertices at the same time)
		int find(int x) {
			if (x == root[x]) {
				return x;
			}
			return root[x] = find(root[x]); // keep finding the root node, at the same time set their value of root node
		}                                   // after we found out the root node, set the root node value to all the vertex that traversed

		
		// union by rank: use rank array to compare the height of nodes
		void union(int x, int y) {

			int rootX = find(x);
			int rootY = find(y);

			if (rootX != rootY) {
				if (rank[rootX] > rank[rootY]) {
					root[rootY] = rootX;
				} else if (rank[rootX] < rank[rootY]) {
				root[rootX] = rootY;
				} else {
				root[rootY] = rootX;
				rank[rootX] += 1;
			}
			count--; // if 2 cities connected and become a province, the number of cities mimus 1
			}
		}

		int getCount() {
			return count;
		}
	}

}
