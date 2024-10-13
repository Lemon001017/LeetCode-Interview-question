package BinaryTree;

@SuppressWarnings("all")
public class LowestCommonAncestor {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(5);
        node1.right = new TreeNode(1);
        node1.left.left = new TreeNode(6);
        node1.left.right = new TreeNode(2);
        node1.right.left = new TreeNode(0);
        node1.right.right = new TreeNode(8);
        node1.left.right.left = new TreeNode(7);
        node1.left.right.right = new TreeNode(4);
        assertEqual(lowestCommonAncestor(node1, node1.left, node1.right).val, 3, "");
    }
}
