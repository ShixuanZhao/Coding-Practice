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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode(0);
        ListNode s = small;
        ListNode large = new ListNode(0);
        ListNode l = large;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                s.next = cur;
                s = s.next;
            } else {
                l.next = cur;
                l = l.next;
            }
            cur = cur.next;
        }
        s.next = large.next;
        l.next = null;
        return small.next;
    }
}