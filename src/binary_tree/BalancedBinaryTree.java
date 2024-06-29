package binary_tree;

public class BalancedBinaryTree {
        boolean isBalanced = true;
        public boolean isBalanced(TreeNode root) {
            if(root == null){
                return true;
            }

            traverseTree(root);
            return this.isBalanced;
        }

        public int traverseTree(TreeNode root){
            if(root == null){
                return 1;
            }

            int left = traverseTree(root.left);
            int right = traverseTree(root.right);
            if(Math.abs(left - right) > 1){
                this.isBalanced = false;
            }

            return Math.max(left, right) + 1;
        }
}
