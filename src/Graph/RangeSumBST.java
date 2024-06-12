package Graph;

public class RangeSumBST {
    int ans = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root, low, high);
        return ans;
    }

    public void traverse(TreeNode root, int low, int high) {
        if (root == null)
            return;

        if (root.val >= low && root.val <= high) {
            ans += root.val;
        }

        traverse(root.left, low, high);
        traverse(root.right, low, high);
    }

    public void traverseOptimized(TreeNode root, int low, int high) {
        if (root == null)
            return;

        if (root.val >= low && root.val <= high) {
            ans += root.val;
        }

        if (root.val > high) {
            // move to the left
            traverseOptimized(root.left, low, high);
        } else if (root.val < low) {
            traverseOptimized(root.right, low, high);
        } else {
            // all good
            traverseOptimized(root.left, low, high);
            traverseOptimized(root.right, low, high);
        }

    }
}
