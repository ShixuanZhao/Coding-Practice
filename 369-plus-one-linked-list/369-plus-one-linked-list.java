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
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = reverse(head);
        //System.out.println(tail.val);
        //ListNode dummy = new ListNode(0);
        ListNode cur = tail;
        //dummy.next = tail;
        int carry = 1;
        while (carry > 0 || cur != null) {
            if (cur.next != null) {
                if (cur.val != 9) {
                    cur.val = cur.val + 1;    
                    break;
                } else {
                    cur.val = 0;
                    carry = 1;
                }
                cur = cur.next;
            } else {
                if (cur.val != 9) {
                    cur.val = cur.val + 1;    
                    break;
                } else {
                    cur.val = 0;
                    ListNode newNode = new ListNode(carry);
                    cur.next = newNode;
                    break;
                }
            }
        }
        return reverse(tail);
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}