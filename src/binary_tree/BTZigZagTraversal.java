package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Intution - Use a flag to toggle insertion from left to right , and right to left.
// Take an exmplae set it correctly.
public class BTZigZagTraversal {
    // TC - O(N)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = true;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int curNodes = queue.size();
            // NOTE: Use linkedList
            // AddLast and AddFirst on a linkedin list will take - O(1)
            LinkedList<Integer> nodesAtThisLevel = new LinkedList<>();

            for (int i = 1; i <= curNodes; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    nodesAtThisLevel.addLast(node.val);
                } else {
                    nodesAtThisLevel.addFirst(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            ans.add(nodesAtThisLevel);
            leftToRight = !leftToRight;
        }

        return ans;
    }
}

