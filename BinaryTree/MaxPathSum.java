package BinaryTree;

public class MaxPathSum {
    /**
     * 题目: 二叉树最大路径和
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

    static int ans = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxSum(root);
        return ans;
    }

    public static int maxSum(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(maxSum(node.left), 0);
        int right = Math.max(maxSum(node.right), 0);

        ans = Math.max(node.val + left + right, ans);
        return node.val + Math.max(left, right);
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-10);
        node1.right = new TreeNode(-20);
        node1.right.left = new TreeNode(-30);
        node1.right.right = new TreeNode(-40);
        assertEqual(maxPathSum(node1), -10, "1");
    }
}
