package Graph;

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
public class Djikstra {

}
