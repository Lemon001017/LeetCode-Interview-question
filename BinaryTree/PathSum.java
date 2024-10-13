package BinaryTree;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class PathSum {
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

    static int ans;

    public static int pathSum(TreeNode root, int targetSum) {
        // key: 前缀和 val: 前缀和出现的次数
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L, 1);
        dfs(root, 0, targetSum, cnt);
        return ans;
    }

    public static void dfs(TreeNode node, long s, int targetSum, Map<Long, Integer> cnt) {
        if (node == null) return;
        s += node.val;
        ans += cnt.getOrDefault(s - targetSum, 0);
        cnt.put(s, cnt.getOrDefault(s, 0) + 1);
        dfs(node.left, s, targetSum, cnt);
        dfs(node.right, s, targetSum, cnt);
        cnt.put(s, cnt.getOrDefault(s, 0) - 1);
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        node1.left = new TreeNode(5);
        node1.right = new TreeNode(-3);
        node1.left.left = new TreeNode(3);
        node1.left.right = new TreeNode(2);
        node1.right.right = new TreeNode(11);
        node1.left.left.left = new TreeNode(3);
        node1.left.left.right = new TreeNode(-2);
        node1.left.right.right = new TreeNode(1);
        assertEqual(pathSum(node1, 8), 3, "1");
    }
}
