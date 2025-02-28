package LinkedList;

public class ReverseKGroup {
    /**
     * 题目：给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode prev = dum;
        ListNode end = dum;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = prev.next;
            ListNode next = end.next;
            end.next = null;
            prev.next = reverse(start);
            start.next = next;
            prev = start;
            end = prev;
        }
        return dum.next;
    }

    // 翻转链表，返回头节点
    public static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        ListNode res = reverseKGroup(node1, 2);
        assertEqual(res.val, 2, "1");
        assertEqual(res.next.val, 1, "2");
        assertEqual(res.next.next.val, 4, "3");
        assertEqual(res.next.next.next.val, 3, "4");
        assertEqual(res.next.next.next.next.val, 5, "5");
    }
}
