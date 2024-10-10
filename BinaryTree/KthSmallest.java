package BinaryTree;

@SuppressWarnings("all")
public class KthSmallest {
    /**
     * 题目： 二叉搜索树中第K小的元素
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

    static int ans, k;

    public static int kthSmallest(TreeNode root, int k) {
        KthSmallest.k = k;
        dfs(root);
        return ans;
    }

    public static void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (k == 0) return;
        if (--k == 0) ans = root.val;
        dfs(root.right);
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(1);
        node1.right = new TreeNode(4);
        node1.left.right = new TreeNode(2);
        assertEqual(kthSmallest(node1, 1), 1, "1");
    }
}
