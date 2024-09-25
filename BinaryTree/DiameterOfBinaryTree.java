package BinaryTree;

public class DiameterOfBinaryTree {
    /**
     * 题目: 二叉树的直径
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    static int ans;

    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    public static int depth(TreeNode root) {
        if (root == null) return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        ans = Math.max(ans, l + r);
        return 1 + Math.max(l, r);
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);
        node1.left.right = new TreeNode(5);
        assertEqual(diameterOfBinaryTree(node1), 3, "1");
    }
}
