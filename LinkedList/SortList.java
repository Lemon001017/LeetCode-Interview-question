package LinkedList;

import java.util.*;

public class SortList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode dum = new ListNode(-1);
        ListNode ans = dum;
        while (left != null && right != null) {
            if (left.val < right.val) {
                dum.next = left;
                left = left.next;
            } else {
                dum.next = right;
                right = right.next;
            }
            dum = dum.next;
        }

        if (left != null) {
            dum.next = left;
        } else {
            dum.next = right;
        }

        return ans.next;
    }

    public static void assertEqual(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected + " " + message);
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode res = sortList(head);
        assertEqual(res.val, 1, "");
        assertEqual(res.next.val, 2, "");
        assertEqual(res.next.next.val, 3, "");
        assertEqual(res.next.next.next.val, 4, "");
    }
}
