package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Approach 1 - That you wrote, no need to create a separate graph.
// NOTE: use the grid itself.
public class NumberOfProvinces {

    // Optimized One
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] visited = new boolean[V];
        int ans = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ans++;
                dfs(i, V, visited, isConnected);
            }

        }

        return ans;
    }

    void dfs(int node, int V, boolean[] visited, int[][] isConnected) {
        visited[node] = true;

        for (int neighbour = 0; neighbour < V; neighbour++) {
            if (isConnected[node][neighbour] == 1 && !visited[neighbour]) {
                dfs(neighbour, V, visited, isConnected);
            }
        }
    }

    public int findCircleNum1(int[][] isConnected) {
        int V = isConnected.length;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < V; i++)
            graph.put(i, new ArrayList<>());

        boolean[] visited = new boolean[V];
        int ans = 0;

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 0 || i == j)
                    continue;

                graph.get(i).add(j);
            }
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ans++;
                dfs2(i, visited, graph);
            }

        }

        return ans;
    }

    void dfs2(int node, boolean[] visited, HashMap<Integer, List<Integer>> graph) {
        visited[node] = true;

        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                dfs2(neighbour, visited, graph);
            }
        }
    }
}
