/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = getLen(head);
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        fast.next = head;
        slow.next = null;
        return newHead;
    }
    
    private int getLen(ListNode head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }
}