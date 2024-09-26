package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    /**
     * 题目: 二叉树的右视图
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

    private static List<Integer> ans = new ArrayList<>();

    public static List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0, ans);
        return ans;
    }

    public static void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (root == null) return;
        if (depth == ans.size()) {
            ans.add(root.val);
        }
        dfs(root.right, depth + 1, ans);
        dfs(root.left, depth + 1, ans);
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
        node1.left.right = new TreeNode(5);
        node1.right.right = new TreeNode(4);
        assertEqual(rightSideView(node1), List.of(1, 3, 4), "1");
    }
}
