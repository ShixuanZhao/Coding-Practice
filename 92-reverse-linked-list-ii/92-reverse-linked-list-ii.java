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
    /*
        1-(2-3-4)-5
        t c                 reverse in ()
                p c
        2-5  t.next.next = c   
        1-4 t.next = p
        
    */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        int cnt = 1;
        while (cnt < left) {
            prev = cur;
            cur = cur.next;
            cnt++;
        }
        ListNode temp = prev;
        //begin to reverse
        while (cnt <= right) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            cnt++;
        }
        temp.next.next = cur;
        temp.next = prev;
        return dummy.next;
    }
}