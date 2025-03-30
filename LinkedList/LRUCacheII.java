package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheII {
    /**
     * 带过期时间的LRU缓存
     */
    private static class Node {
        int key, value;
        long expiredTime;
        Node prev, next;

        Node(int k, int v, long expiredTime) {
            key = k;
            value = v;
            this.expiredTime = expiredTime;
        }
    }

    private final int capacity;
    private final Node dummy = new Node(0, 0, Integer.MAX_VALUE);
    private final Map<Integer, Node> keyToNode = new HashMap<>();

    public LRUCacheII(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    public void put(int key, int value, long expiredTime) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            node.expiredTime = expiredTime;
            return;
        }
        node = new Node(key, value, expiredTime);
        keyToNode.put(key, node);
        pushFront(node);
        if (keyToNode.size() > capacity) {
            Node backNode = dummy.prev;
            keyToNode.remove(backNode.key);
            remove(backNode);
        }
    }

    private Node getNode(int key) {
        if (!keyToNode.containsKey(key)) {
            return null;
        }
        Node node = keyToNode.get(key);
        if (node.expiredTime < System.currentTimeMillis()) {
            keyToNode.remove(node.key);
            remove(node);
            return null;
        }
        remove(node);
        pushFront(node);
        return node;
    }

    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    private void pushFront(Node x) {
        x.prev = dummy;
        x.next = dummy.next;
        x.prev.next = x;
        x.next.prev = x;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LRUCacheII cache = new LRUCacheII(2);
        cache.put(1, 1, System.currentTimeMillis() + 1000);
        cache.put(2, 2, System.currentTimeMillis() + 3000);
        assertEqual(cache.get(1), 1, "1");
        assertEqual(cache.get(2), 2, "2");

        Thread.sleep(1100);
        assertEqual(cache.get(1), -1, "3");
        assertEqual(cache.get(2), 2, "4");
    }
}
