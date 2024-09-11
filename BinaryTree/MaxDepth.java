package BinaryTree;

public class MaxDepth {
    /*
        题目: 二叉树的最大深度
     */
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

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(9);
        node1.right = new TreeNode(20);
        node1.right.left = new TreeNode(15);
        node1.right.right = new TreeNode(7);
        assertEqual(maxDepth(node1), 3, "1");
    }
}
