package leetcodegraph;
/**
 * Approach 3: Union-find
 * 
 * Algorithm:
 * 
 * - Another method that can be used to determine the number of connected components in a graph
 *   is the union find method.
 *   
 * - We make use of a parent array of size N.
 * - We traverse over all the nodes of the graph.
 * - For every node traversed,
 *   we traverse over all the nodes directly connected to it and
 *   assign them to a single group which is represent by their parent node.
 * - This process is called forming a union.
 * - Every group has a single parent node, whose own parent is given by -1.
 * 
 * - For every new pair of nodes found, we look for the parents of both the node.
 * - If the parents nodes are the same, it indicates that they have already been united into the same group.
 * 
 * - If the parent nodes differ, it means they are yet to be united.
 * - Thus, for the pair of nodes(x, y),
 *   while forming the union,
 *   we assign parent[parent[x]] = parent[y],
 *   which ultimately combines them into the same group.
 *
 */

public class NumberOfProvinces547_3_1 {

}
