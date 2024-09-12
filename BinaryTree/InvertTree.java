package BinaryTree;

public class InvertTree {
    /*
        题目: 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
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

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(7);
        node1.left.left = new TreeNode(1);
        node1.left.right = new TreeNode(3);
        node1.right.left = new TreeNode(6);
        node1.right.right = new TreeNode(9);
        assertEqual(invertTree(node1).val, 4, "");
    }
}
