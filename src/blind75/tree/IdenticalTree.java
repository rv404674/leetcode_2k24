package blind75.tree;

public class IdenticalTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null || p.val != q.val)
            return false;

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        if (left == false || right == false)
            return false;

        return true;
    }
}
