package lc_contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * O(V+E) * O(queries)
 */

class SolutionShortestPathAfterRemoval1 {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List[] graph = new ArrayList[n];
        int[] ans = new int[queries.length];

        for (int i = 0; i < n; i++) {
            if (graph[i] == null) {
                graph[i] = new ArrayList();
            }

            if (i != n - 1) {
                graph[i].add(i + 1);
            }

        }

        for (int i = 0; i < queries.length; i++) {
            graph[queries[i][0]].add(queries[i][1]);
            int shortestDist = bfs(0, n - 1, graph);

            ans[i] = shortestDist;
        }

        return ans;
    }

    public int bfs(int source, int dest, List[] graph) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        int[] distances = new int[graph.length];
        Arrays.fill(distances, Integer.MAX_VALUE);

        q.offer(0);
        distances[0] = 0;
        visited.add(0);

        int minDistance = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == dest) {
                return distances[node];
            }

            List<Integer> neighbours = graph[node];
            for (int neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    q.offer(neighbour);
                    distances[neighbour] = distances[node] + 1;
                    visited.add(neighbour);
                }
            }

        }

        return minDistance;
    }
}

public class ShortestPathAfterRemoval1 {
    public static void main(String[] args) {
        SolutionShortestPathAfterRemoval1 solution = new SolutionShortestPathAfterRemoval1();
        int n = 5;
        int[][] queries = {{2, 4}, {0, 2}, {0, 4}};

        System.out.println(Arrays.toString(solution.shortestDistanceAfterQueries(n, queries)));
    }
}
