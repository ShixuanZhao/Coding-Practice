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
        //divide and conquer
        divide: 4 2 | 1 3
                4 | 2
        conquer:merge two list(two pointers)
        2 4
          i       newList:1->2->3->4
        1 3
           j
           
       How to divide the list by half?
       4 2 | 1 3
         s        fast.next.next == null return s
             f

    */
    public ListNode sortList(ListNode head) {
        //corner case
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(newHead);
        return merge(left, right);
    }
    
    // private ListNode merge(ListNode left, ListNode right) {
    //     if (left == null) {
    //         return right;
    //     }
    //     if (right == null) {
    //         return left;
    //     }
    //     if (left.val < right.val) {
    //         left.next = merge(left.next, right);
    //         return left;
    //     } else {
    //         right.next = merge(left, right.next);
    //         return right;
    //     }        
    // }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left == null) {
            cur.next = right;
        }
        if (right == null) {
            cur.next = left;
        }
        return dummy.next;
    }
}