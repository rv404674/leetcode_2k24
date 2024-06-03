package blind75.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedContainer = new ArrayList<>();
        findKthSmallest(root, k, sortedContainer);
        return sortedContainer.get(sortedContainer.size() - 1);
    }

    public boolean findKthSmallest(TreeNode node, int k, List<Integer> sortedContainer) {
        if (node == null)
            return false;

        // inorder traverl - gives sorted stuff.
        if (findKthSmallest(node.left, k, sortedContainer))
            return true;

        sortedContainer.add(node.val);
        if (sortedContainer.size() == k)
            return true;

        return findKthSmallest(node.right, k, sortedContainer);
    }
}
