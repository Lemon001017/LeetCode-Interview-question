package BinaryTree;

@SuppressWarnings("all")
public class BuildTree {
    /**
     * 题目: 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
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

    static int preIndex = 0;
    static int inIndex = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return doBuildTree(preorder, inorder, Integer.MAX_VALUE);
    }

    private static TreeNode doBuildTree(int[] preorder, int[] inorder, int stop) {
        if (preIndex == preorder.length) {
            // 构建完成整个树
            return null;
        }
        if (inorder[inIndex] == stop) {
            // stop代表当前左子树的父节点，==stop表示当前左子树构建完成，inIdx++表示开始处理右子树
            inIndex++;
            return null;
        }
        // preIdx表示之后进行左子树构建
        TreeNode root = new TreeNode(preorder[preIndex++]);
        root.left = doBuildTree(preorder, inorder, root.val);
        root.right = doBuildTree(preorder, inorder, stop);
        return root;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        assertEqual(root.val, 3, "");
        assertEqual(root.left.val, 9, "");
        assertEqual(root.right.val, 20, "");
        assertEqual(root.right.left.val, 15, "");
        assertEqual(root.right.right.val, 7, "");
    }
}
