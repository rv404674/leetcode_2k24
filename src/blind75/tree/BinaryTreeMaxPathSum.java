package blind75.tree;

public class BinaryTreeMaxPathSum {
    static int mxSum;

    public int maxPathSum(TreeNode root) {
        mxSum = Integer.MIN_VALUE;
        findMaxSum(root);
        return mxSum;
    }

    public int findMaxSum(TreeNode root) {
        // write base case
        if (root == null)
            return 0;

        int leftSum = Math.max(findMaxSum(root.left), 0);
        int rightSum = Math.max(findMaxSum(root.right), 0);

        int curPathSum = leftSum + rightSum + root.val;
        mxSum = Math.max(mxSum, curPathSum);

        return root.val + Math.max(leftSum, rightSum);
    }

}
