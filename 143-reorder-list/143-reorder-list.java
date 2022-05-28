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
    1-2-3-4
    1-2
    4-3
    
    1 split the list into two part
    2 reverse the second part
    3.use two pointers to reorder to a new list
    */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMid(head);
        //System.out.println(mid.val);
        ListNode next = mid.next;
        mid.next = null;
        ListNode newHead = reverse(next);
        //System.out.println(newHead.val);
        ListNode dummy = new ListNode(0);
        /*
        1-2
           i
        5-4-3
            j
        dummy-1-5-2-4-3
                    c
        */
        ListNode cur = dummy;
        while (head != null && newHead != null) {
            cur.next = head;
            head = head.next;
            cur = cur.next;
            
            cur.next = newHead;
            newHead = newHead.next;
            cur = cur.next;
        }
        //the second list is longer
        if (newHead != null) {
            cur.next = newHead;
        } 
        if (head != null) {
            cur.next = head;
        }
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}