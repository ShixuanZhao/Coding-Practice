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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr;
        while(head != null) {
            ListNode newHead = head.next;
            curr = dummyHead;
            while(curr != null && curr.next != null && curr.next.val < head.val) {
                curr = curr.next;
            }
            // found a place
            head.next = curr.next;
            curr.next = head;
            head = newHead;
        }
        
        return dummyHead.next;
    }
}