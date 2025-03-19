package BinaryTree;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicateSubtrees {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static Map<String, TreeNode> map = new HashMap<>();
    private static Set<TreeNode> repeat = new HashSet<>();

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return repeat.stream().distinct().collect(Collectors.toList());
    }

    public static String dfs(TreeNode node) {
        if (node == null) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        s.append(node.val);
        s.append("(");
        s.append(dfs(node.left));
        s.append(")");
        s.append("(");
        s.append(dfs(node.right));
        s.append(")");

        String ans = s.toString();
        if (map.containsKey(ans)) {
            repeat.add(map.get(ans));
        } else {
            map.put(ans, node);
        }
        return ans;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        List<TreeNode> ans = findDuplicateSubtrees(root);
        ans.forEach(treeNode -> System.out.println(treeNode.val));
    }
}
