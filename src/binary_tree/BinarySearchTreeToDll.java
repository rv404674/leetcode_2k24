package binary_tree;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

// AC in one go -> 20min.
// Approach
// 1. Inordertraversal
// 2. while traversing add the node to the end.
// 3. Before returning you need to make it a circulare linkedin list -> fix the pointers accordingly and voila.
public class BinarySearchTreeToDll {
    Node head;
    Node tail;

    public BinarySearchTreeToDll() {
        head = new Node(-1);
        tail = new Node(-1);
        head.right = tail;
        tail.left = head;
    }


    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        inOrderTraversal(root);

        // final adjustments
        head.right.left = tail.left;
        tail.left.right = head.right;

        return head.right;
    }

    public void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inOrderTraversal(root.left);
        }

        appendNode(new Node(root.val));

        if (root.right != null) {
            inOrderTraversal(root.right);
        }
    }

    public void appendNode(Node node) {
        node.left = tail.left;
        node.right = tail;

        tail.left.right = node;
        tail.left = node;
    }


}
