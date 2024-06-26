package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

// Standard approach - See striver Topo DFS video.
public class TopoSortUsingDFS {
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        int[] topoSort = new int[V];
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }

        int k = 0;
        while (!stack.isEmpty()) {
            topoSort[k++] = stack.pop();
        }

        return topoSort;
    }

    static void dfs(int v, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;

        // process the neighbours
        for (int neighbour : adj.get(v)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, stack, adj);
            }
        }

        stack.add(v);
    }
}
