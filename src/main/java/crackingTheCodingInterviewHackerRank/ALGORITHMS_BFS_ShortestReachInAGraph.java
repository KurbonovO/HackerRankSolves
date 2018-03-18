package crackingTheCodingInterviewHackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/*Sample Input:
2
4 2
1 2
1 3
1
3 1
2 3
2
Sample Output:
6 6 -1
-1 6
Explanation: We perform the following two queries:
where our start node, s, is node 1. The shortest distances from s to the other nodes are one edge to node 2, one edge to node 3,
and an infinite distance to node 4 (which it's not connected to). We then print node 1's distance to nodes 2, 3, and 4 (respectively)
as a single line of space-separated integers: 6 6 -1.
The given graph can be represented as: 
where our start node, s, is node 2. There is only one edge here, so node 1 is unreachable from node 2 and node 3 has one edge connecting 
it to node 2. We then print node 2's distance to nodes 1 and 3 (respectively) as a single line of space-separated integers: -1 6.*/

class Graph {
    /** Edge weight **/
    private static int EDGE_DISTANCE;
    
    /** Track distance to 'start' node **/
    public int[] distance;
    /** Graph where index is 0-indexed node ID and each element is the set of neighboring nodes. **/
    public ArrayList<HashSet<Integer>> graph;
    /** Starting node number for BFS, default Java initialization is to node 0 **/
    public int start;
    
    public Graph(int n, int edgeWeight) {
        Graph.EDGE_DISTANCE = edgeWeight;
        
        this.distance = new int[n];
        Arrays.fill(distance, -1);
        
        this.graph = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i < n; i++) {
            this.graph.add(new HashSet<Integer>());
        }
    }
    
    public void shortestReach(int s) {
        
        this.start = s;
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        distance[start] = 0;
        
        // BFS from start
        while (queue.size() > 0) {
            int u = queue.remove();
            
            // for each unvisited neighbor of the current node
            for (int v : graph.get(u)) {
                
                // Add unvisited neighboring nodes to queue to check its neighbors at next level of the search, set distance
                if (distance[v] == -1) {
                    queue.add(v);
                    distance[v] = distance[u] + EDGE_DISTANCE;
                }
            }
        }
        
        for (int i : distance) {
            if (i != 0) {
                System.out.print(i + " ");
            } 
        }
        
        System.out.println();
        
        // Just resets all distances to -1 in the event that this method is ever called multiple times for some different 's'.
        Arrays.fill(distance, -1);
    }
}

public class ALGORITHMS_BFS_ShortestReachInAGraph {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int queries = scanner.nextInt();
        
        for(int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph bfs = new Graph(scanner.nextInt(), 6);
            int m = scanner.nextInt();
            
            // read and set edges
            for(int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                bfs.graph.get(u).add(v);
                bfs.graph.get(v).add(u);
            }
            
            // Find shortest reach from node s
            bfs.shortestReach(scanner.nextInt() - 1);
        }
        
        scanner.close();
    }
}