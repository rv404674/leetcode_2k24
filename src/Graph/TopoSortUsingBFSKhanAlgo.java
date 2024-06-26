package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// See Striver Video
// Topo Sort (Khan algo) -> Has some catch to it.
// indegree - number of eges coming onto it.
public class TopoSortUsingBFSKhanAlgo {
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] inDegree = new int[V];
        int[] topoSort = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        int k = 0;

        for (ArrayList<Integer> neighbours : adj) {
            for (Integer neighbour : neighbours)
                inDegree[neighbour]++;
        }

        // Nodes that have 0 indegree, would be the starting point, as they dont have any dependencies on them. Hence can be placed first
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            Integer curNode = queue.poll();
            topoSort[k++] = curNode;

            for (int neighbour : adj.get(curNode)) {
                inDegree[neighbour] -= 1;
                if (inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return topoSort;
    }
}
