package blind75.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NodeWithLevel {
    TreeNode node;
    int level;

    public NodeWithLevel(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class LevelOrderTraversal {
    // TC - O(N) + O(N) ~= 2 * O(N)
    // SC - O(N) + O(N) + O(N) = 3*O(N)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversalOrder = new LinkedList<>();
        int mxLevel = Integer.MIN_VALUE;

        if (root == null)
            return traversalOrder;

        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        Queue<NodeWithLevel> queue = new LinkedList<>();

        NodeWithLevel top = new NodeWithLevel(root, 0);
        queue.add(top);

        while (!queue.isEmpty()) {
            NodeWithLevel curNode = queue.poll();
            // update the hashmap
            List<Integer> list = hashMap.getOrDefault(curNode.level, new LinkedList<>());
            list.add(curNode.node.val);
            hashMap.put(curNode.level, list);

            mxLevel = Math.max(mxLevel, curNode.level);
            if (curNode.node.left != null) {
                queue.add(new NodeWithLevel(curNode.node.left, curNode.level + 1));
            }

            if (curNode.node.right != null) {
                queue.add(new NodeWithLevel(curNode.node.right, curNode.level + 1));
            }
        }

        for (int i = 0; i <= mxLevel; i++)
            traversalOrder.add(hashMap.get(i));

        return traversalOrder;
    }


    // TC - O(N)
    // SC - 2*O(N)
    public List<List<Integer>> levelOrderOptimized(TreeNode root) {
        // No need to maintain a hashmap or anything.
        // just directly add.
        List<List<Integer>> traversalList = new ArrayList<>();
        if (root == null)
            return traversalList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int curNodes = queue.size();
            List<Integer> nodesAtThisLevel = new ArrayList<>();

            for (int i = 0; i < curNodes; i++) {
                TreeNode node = queue.poll();
                nodesAtThisLevel.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            traversalList.add(nodesAtThisLevel);
        }

        return traversalList;
    }

}
