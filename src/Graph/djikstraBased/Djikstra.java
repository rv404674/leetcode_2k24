package Graph.djikstraBased;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Beautiful explanation
 * https://www.youtube.com/watch?v=V6H1qAeB-l4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=33
 * <p>
 * NOTE: Intuition
 * 1. BFS + PQ
 * 2. Priority Queue (min heap) will have (distance, node) at the top.
 * 3. You will explore all paths and update the min path wrt to each node.
 * <p>
 * Constraints
 * 1. Doest work where there is a cylce or -ve edge.
 * Logically, in case of -ve edges, you can keep going back via that back and get a new shortest path - INF loop.
 * <p>
 * FIXME: Do a dry run.
 */
class Pair {
    int distance;
    int node;

    public Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }

}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return Integer.compare(o1.distance, o2.distance);
    }
}

/**
 * adj = {
 * // Node, distance
 * {{1, 1}, {2, 6}},
 * {{2, 3}, {0, 1}},
 * {{1, 3}, {0, 6}}
 * }
 */

// NOTE: TC - O((V+E)logV):

public class Djikstra {
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[S] = 0;
        // (dist, Node) Pair
        pq.offer(new Pair(0, S));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int curDistance = pair.distance;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNeighbour = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                if (curDistance + edgeWeight < distance[adjNeighbour]) {
                    distance[adjNeighbour] = curDistance + edgeWeight;
                    pq.offer(new Pair(distance[adjNeighbour], adjNeighbour));
                }

            }
        }

        return distance;
    }
}

