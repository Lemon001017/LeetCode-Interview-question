package Stack;

import java.util.LinkedList;

public class SimplifyPath {
    /**
     * 题目: 给定一个字符串 path，其中包含字母 P，.，和 /，请你将其格式化，格式化规则如下：
     * 1. 始终以斜杠 '/' 开头。
     * 2. 两个目录名之间必须只有一个斜杠 '/' 。
     * 3. 最后一个目录名（如果存在）不能 以 '/' 结尾。
     * 4. 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
     */
    public static String simplifyPath(String path) {
        String[] names = path.split("/");
        LinkedList<String> stk = new LinkedList<>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stk.isEmpty()) {
                    stk.removeLast();
                }
            } else if (!name.isEmpty() && !".".equals(name)) {
                stk.addLast(name);
            }
        }

        StringBuilder ans = new StringBuilder();
        if (stk.isEmpty()) {
            ans.append('/');
        } else {
            while (!stk.isEmpty()) {
                ans.append('/');
                ans.append(stk.removeFirst());
            }
        }
        return ans.toString();
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        assertEqual(simplifyPath("/home//foo/"), "/home/foo", "3");

        assertEqual(simplifyPath("/home/"), "/home", "1");
        assertEqual(simplifyPath("/../"), "/", "2");
        assertEqual(simplifyPath("/a/./b/../../c/"), "/c", "4");
    }
}
