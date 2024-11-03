package lc_contests.weekly_410;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class CountGoodNodesSolution {
    int ans = 0;

    public int countGoodNodes(int[][] edges) {
        this.ans = 0;
        HashMap<Integer, List<Integer>> graph = new HashMap();

        // make a directed graph.
        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }

            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        dfs(0, visited, graph);
        return ans;
    }

    // return number of nodes
    public int dfs(int curNode, HashSet<Integer> visited, HashMap<Integer, List<Integer>> graph) {
        int childNodes = 0;
        boolean validNode = true;
        int prevChildrenNodes = -1;
        int curChildrenNodes;

        visited.add(curNode);
        for (int i = 0; i < graph.get(curNode).size(); i++) {
            int neighbour = graph.get(curNode).get(i);
            if (visited.contains(neighbour)) {
                continue;
            }

            if (prevChildrenNodes == -1) {
                prevChildrenNodes = dfs(neighbour, visited, graph);
                childNodes += prevChildrenNodes;
                continue;
            }

            curChildrenNodes = dfs(neighbour, visited, graph);
            childNodes += curChildrenNodes;
            if (prevChildrenNodes != curChildrenNodes) {
                validNode = false;
            }
        }

        // count the current node as well.
        if (validNode) {
            // leaf node;
            ans++;
        }


        return childNodes + 1;
    }

}

public class CountGoodNodes {
    public static void main(String[] args) {
        CountGoodNodesSolution solution = new CountGoodNodesSolution();
        int[][] ut1 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}}; // 7
        System.out.println(solution.countGoodNodes(ut1));

        int[][] ut2 = {{0, 1}, {1, 2}, {1, 3}, {1, 4}, {0, 5}, {5, 6}, {6, 7}, {7, 8}, {0, 9}, {9, 10}, {9, 12}, {10, 11}}; //12
        System.out.println(solution.countGoodNodes(ut2));

        int[][] ut3 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {0, 5}, {1, 6}, {2, 7}, {3, 8}}; // 6
        System.out.println(solution.countGoodNodes(ut3));

        int[][] ut4 = {{6, 0}, {1, 0}, {5, 1}, {2, 5}, {3, 1}, {4, 3}}; // 6
        System.out.println(solution.countGoodNodes(ut4));
    }
}
