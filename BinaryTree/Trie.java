package BinaryTree;

public class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public Trie searchPrefix(String prefix) {
        Trie node = this;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        assertEqual(trie.search("apple"), true, "search apple");
        assertEqual(trie.search("app"), false, "search app");
        assertEqual(trie.startsWith("app"), true, "startsWith app");
        trie.insert("app");
        assertEqual(trie.search("app"), true, "search app");
        assertEqual(trie.startsWith("app"), true, "startsWith app");
        assertEqual(trie.search("ap"), false, "search ap");
        assertEqual(trie.startsWith("ap"), true, "startsWith ap");
        assertEqual(trie.search("appl"), false, "search appl");
    }
}
