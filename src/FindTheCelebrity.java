import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
class Relation {
    boolean knows(int a, int b) {
        return false;
    }
}

public class FindTheCelebrity extends Relation {
    public int findCelebrity(int n) {
        // create the adjancey list.
        HashMap<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        Set<Integer> nodesWithNoIncomingEdges = new HashSet<>();

        for (int i = 0; i < n; i++) {
            boolean foundConnection = false;
            graph.put(i, new HashSet<>());

            for (int j = 0; j < n; j++) {
                if (i != j && knows(i, j)) {
                    // found a connection. This is not celebiry.
                    foundConnection = true;
                    graph.get(i).add(j);
                }
            }

            if (!foundConnection) {
                // found node with no incoming edge.
                nodesWithNoIncomingEdges.add(i);
            }

        }

        // Use the adjancey list now.
        for (int node : nodesWithNoIncomingEdges) {
            boolean presentInAll = true;
            for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
                if (entry.getKey() != node && !entry.getValue().contains(node)) {
                    presentInAll = false;
                    break;
                }
            }

            if (presentInAll) {
                return node;
            }
        }

        return -1;
    }
}