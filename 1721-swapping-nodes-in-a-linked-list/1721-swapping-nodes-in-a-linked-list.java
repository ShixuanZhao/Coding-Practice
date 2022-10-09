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
/*
Important: The problem description specifically asks to swap values, not nodes themselves.

When we reach k-th node, we set n1 to the current node, and n2 - to the head.

We continue traversing the list, but now we also move n2. When we reach the end, n2 will points to k-th node from end.

*/
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode n1 = null, n2 = null;
        for (var p = head; p != null; p = p.next) {
            n2 = n2 == null ? null : n2.next;
            if (--k == 0) {
                n1 = p;
                n2 = head;
            }
        }
        // The problem description specifically asks to swap values, not nodes themselves. 
        var tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
        return head;
    }
}