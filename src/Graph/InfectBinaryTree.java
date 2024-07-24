package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class InfectBinaryTree {
    int mxDepth = 0;

    // BFS Version - Better.
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        populateGraph(root, graph);

        // Start DFS
        HashSet<Integer> visited = new HashSet<>();
        dfs(0, start, visited, graph);
        return mxDepth;
    }

    public void dfs(int level, int curNode, HashSet<Integer> visited, HashMap<Integer, List<Integer>> graph) {
        visited.add(curNode);
        mxDepth = Math.max(mxDepth, level);

        for (Integer neighbour : graph.getOrDefault(curNode, new ArrayList<>())) {
            if (!visited.contains(neighbour)) {
                dfs(level + 1, neighbour, visited, graph);
            }
        }

    }

    public void populateGraph(TreeNode root, HashMap<Integer, List<Integer>> graph) {
        if (root == null)
            return;

        if (root.left != null) {
            graph.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.left.val);
            graph.computeIfAbsent(root.left.val, k -> new ArrayList<>()).add(root.val);
            populateGraph(root.left, graph);
        }

        if (root.right != null) {
            graph.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.right.val);
            graph.computeIfAbsent(root.right.val, k -> new ArrayList<>()).add(root.val);
            populateGraph(root.right, graph);
        }
    }

//    public int amountOfTimeWithBFS(TreeNode root, int start) {
//        HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();
//        populateGraph(root, graph);
//
//        TreeNode rootForBfs = null;
//        for (Map.Entry<TreeNode, List<TreeNode>> entrySet : graph.entrySet()) {
//            if (entrySet.getKey().val == start) {
//                rootForBfs = entrySet.getKey();
//                break;
//            }
//        }
//
//        // Start DFS
//        Queue<TreeNode> queue = new LinkedList<>();
//        HashSet<TreeNode> visited = new HashSet<>();
//        int minutes = -1;
//        queue.offer(rootForBfs);
//        visited.add(rootForBfs);
//
//        while (!queue.isEmpty()) {
//            // process all
//            int curNodes = queue.size();
//            for (int i = 1; i <= curNodes; i++) {
//                TreeNode curNode = queue.poll();
//
//                for (TreeNode neighbour : graph.get(curNode)) {
//                    if (!visited.contains(neighbour)) {
//                        queue.offer(neighbour);
//                        visited.add(neighbour);
//                    }
//                }
//            }
//
//            minutes++;
//        }
//
//        return minutes;
//    }

    public void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node10 = new TreeNode(10);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2);

        // Manually link the nodes according to the given structure
        node1.left = node5;
        node1.right = node3;

        node5.right = node4;

        node3.left = node10;
        node3.right = node6;

        node10.left = node9;
        node10.right = node2;


        // The tree is now created, and you can use it as needed.
        System.out.println(amountOfTime(node1, 3));
    }
}
