package Graph.djikstraBased;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Node {
    int distance;
    int val;
    int stops;

    public Node(int distance, int val, int stops) {
        this.distance = distance;
        this.val = val;
        this.stops = stops;
    }
}

class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        if (o1.stops != o2.stops) {
            return Integer.compare(o1.stops, o2.stops);
        }
        return Integer.compare(o1.distance, o2.distance);
    }
}

/**
 * NOTE: Had to sort on stops first. (DRY RUN on this)
 *   // [[0,1,5],[1,2,5],[0,3,2],[3,1,2],[1,4,1],[4,2,1]]
 *   // src = 0, dest = 2, k = 2
 *   // Ans should be - 7
 */
class CheapestFlightWithinKStopsSolution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Make a adjList
        // 0 -> [ (node, weight), (node, weight)]
        HashMap<Integer, List<List<Integer>>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] flight : flights) {
            List<Integer> edge = Arrays.asList(flight[1], flight[2]);
            adjList.get(flight[0]).add(edge);
        }

        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        // As the currentStops in any path becomes > k, stop.
        int allowedStopsOnPath = k + 2;
        // public Node(int distance, int val, int stops) {
        pq.offer(new Node(0, src, 1));
        distances[src] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curNode = node.val;
            int curStops = node.stops;
            int curDistance = node.distance;

            if (curNode == dst) {
                continue;
            }

            for (int i = 0; i < adjList.get(curNode).size(); i++) {
                int adjNode = adjList.get(curNode).get(i).get(0);
                int adjWeight = adjList.get(curNode).get(i).get(1);

                // Modify the check
                if (curDistance + adjWeight < distances[adjNode] && curStops + 1 <= allowedStopsOnPath) {
                    distances[adjNode] = curDistance + adjWeight;
                    pq.offer(new Node(distances[adjNode], adjNode, curStops + 1));
                }
            }
        }


        if (distances[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return distances[dst];
    }

    /**
     * Dont use distance array.
     * Getting TLE (as the number of states that are being computed are too much).
     */
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        // Make a adjList
        // 0 -> [ (node, weight), (node, weight)]
        HashMap<Integer, List<List<Integer>>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] flight : flights) {
            List<Integer> edge = Arrays.asList(flight[1], flight[2]);
            adjList.get(flight[0]).add(edge);
        }

        int ansDistance = Integer.MAX_VALUE;


        PriorityQueue<Node> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.distance, p2.distance));
        // As the currentStops in any path becomes > k, stop.
        int allowedStopsOnPath = k + 2;
        // public Node(int distance, int val, int stops) {
        pq.offer(new Node(0, src, 1));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curNode = node.val;
            int curStops = node.stops;
            int curDistance = node.distance;

            if (curNode == dst) {
                ansDistance = Math.min(ansDistance, curDistance);
                continue;
            }

            for (int i = 0; i < adjList.get(curNode).size(); i++) {
                int adjNode = adjList.get(curNode).get(i).get(0);
                int adjWeight = adjList.get(curNode).get(i).get(1);

                // Modify the check
                if (curStops + 1 <= allowedStopsOnPath) {
                    pq.offer(new Node(curDistance + adjWeight, adjNode, curStops + 1));
                }
            }
        }


        if (ansDistance == Integer.MAX_VALUE) {
            return -1;
        }

        return ansDistance;
    }
}


public class CheapestFlightWithinKStops {
    public static void main(String[] args) {
        CheapestFlightWithinKStopsSolution soln = new CheapestFlightWithinKStopsSolution();
        int[][] flights = {
                {4, 1, 1},
                {1, 2, 3},
                {0, 3, 2},
                {0, 4, 10},
                {3, 1, 1},
                {1, 4, 3}
        };

        System.out.println(soln.findCheapestPrice(5, flights, 2, 1, 1));

    }


}
