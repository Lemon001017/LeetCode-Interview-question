package BinaryTree;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Flatten {
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

    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        dfs(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public static void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.right = new TreeNode(2);
        node1.right.right = new TreeNode(3);
        flatten(node1);
        assertEqual(node1.right.val, 2, "1");
        assertEqual(node1.right.right.val, 3, "2");
    }


}
