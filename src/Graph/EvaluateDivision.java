package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

class EvaluateDivisionNode {
    String value;
    double weight;

    public EvaluateDivisionNode(String value, double weight) {
        this.value = value;
        this.weight = weight;
    }
}

// TC - O(Q * O(V + E))
// SC -
class EvaluateDivisionSolution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<EvaluateDivisionNode>> graph = new HashMap();
        double[] ans = new double[queries.size()];

        int valueIndex = 0;
        // Create the graph.
        for (List<String> equation : equations) {
            String sourceNode = equation.get(0);
            String destNode = equation.get(1);
            double value = values[valueIndex++];
            if (!graph.containsKey(sourceNode)) {
                graph.put(sourceNode, new ArrayList());
            }

            if (!graph.containsKey(destNode)) {
                graph.put(destNode, new ArrayList());
            }

            graph.get(sourceNode).add(new EvaluateDivisionNode(destNode, value * 1.00000));
            graph.get(destNode).add(new EvaluateDivisionNode(sourceNode, 1.00000 / value));
        }

        // edge case
        int ansIndex = 0;
        for (List<String> query : queries) {
            String sourceNode = query.get(0);
            String destNode = query.get(1);

            if (!graph.containsKey(sourceNode) || !graph.containsKey(destNode)) {
                ans[ansIndex++] = -1.00000;
                continue;
            }

            double ansTraversal = bfs(sourceNode, destNode, graph);
            System.out.println(ansTraversal);
            ans[ansIndex++] = ansTraversal;
        }

        return ans;
    }

    double bfs(String sourceNode, String destNode, HashMap<String, List<EvaluateDivisionNode>> graph) {
        Queue<EvaluateDivisionNode> q = new LinkedList();
        Set<String> visited = new HashSet<>();
        q.offer(new EvaluateDivisionNode(sourceNode, 1.000000));
        visited.add(sourceNode);

        while (!q.isEmpty()) {
            EvaluateDivisionNode node = q.poll();
            if (Objects.equals(node.value, destNode)) {
                return node.weight;
            }

            List<EvaluateDivisionNode> neighbours = graph.get(node.value);
            for (EvaluateDivisionNode neighbour : neighbours) {
                if (!visited.contains(neighbour.value)) {
                    q.offer(new EvaluateDivisionNode(neighbour.value, node.weight * neighbour.weight));
                    visited.add(neighbour.value);
                }
            }

        }
        return -1;

    }


}

public class EvaluateDivision {
    public static void main(String[] args) {
        EvaluateDivisionSolution soln = new EvaluateDivisionSolution();
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("c", "d"));
        double[] values = {1.0, 1.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "d"), List.of("b", "a"), List.of("d", "c"));


        System.out.println(Arrays.toString(soln.calcEquation(equations, values, queries)));

    }
}

