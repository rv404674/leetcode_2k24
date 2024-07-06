package binary_tree;

// Appr1 - What I did. Ac in one go.
// Keep track of the string and when you encounter a leaf node, add the string to the list.
// At the end, iterate over the list and calculate the sum

// Appr2 - Use a bit more of your brain.
// Directly calculate values.

public class SumRoofToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        int ans = 0;

        if (root == null) {
            return ans;
        }

        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int curSum) {
        int newSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return newSum;
        }

        int leftSum = 0;
        int rightSum = 0;

        if (root.left != null) {
            leftSum = dfs(root.left, newSum);
        }

        if (root.right != null) {
            rightSum = dfs(root.right, newSum);
        }

        return leftSum + rightSum;
    }

}
